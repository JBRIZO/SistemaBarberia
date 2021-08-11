/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.NonexistentEntityException;
import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.PreexistingEntityException;
import com.mycompany.sistemabarberia.detalleservicio;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Jonathan Laux
 */
public class detalleservicioJpaController implements Serializable {

    public detalleservicioJpaController() {
        this.emf = Persistence.createEntityManagerFactory("servidorbd");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(detalleservicio detalleservicio) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(detalleservicio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (finddetalleservicio(detalleservicio.getNumdetalleservicio()) != null) {
                throw new PreexistingEntityException("detalleservicio " + detalleservicio + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(detalleservicio detalleservicio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            detalleservicio = em.merge(detalleservicio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = detalleservicio.getNumdetalleservicio();
                if (finddetalleservicio(id) == null) {
                    throw new NonexistentEntityException("The detalleservicio with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            detalleservicio detalleservicio;
            try {
                detalleservicio = em.getReference(detalleservicio.class, id);
                detalleservicio.getNumdetalleservicio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detalleservicio with id " + id + " no longer exists.", enfe);
            }
            em.remove(detalleservicio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<detalleservicio> finddetalleservicioEntities() {
        return finddetalleservicioEntities(true, -1, -1);
    }

    public List<detalleservicio> finddetalleservicioEntities(int maxResults, int firstResult) {
        return finddetalleservicioEntities(false, maxResults, firstResult);
    }

    private List<detalleservicio> finddetalleservicioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(detalleservicio.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public detalleservicio finddetalleservicio(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(detalleservicio.class, id);
        } finally {
            em.close();
        }
    }

    public int getdetalleservicioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<detalleservicio> rt = cq.from(detalleservicio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
