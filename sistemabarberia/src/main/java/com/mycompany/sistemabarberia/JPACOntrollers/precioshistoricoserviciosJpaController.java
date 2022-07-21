/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.NonexistentEntityException;
import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.PreexistingEntityException;
import com.mycompany.sistemabarberia.precioshistoricoservicios;
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
public class precioshistoricoserviciosJpaController implements Serializable {

    public precioshistoricoserviciosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public void close()
    {
        this.emf.close();
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(precioshistoricoservicios precioshistoricoservicios) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(precioshistoricoservicios);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findprecioshistoricoservicios(precioshistoricoservicios.getNumprecioservicio()) != null) {
                throw new PreexistingEntityException("precioshistoricoservicios " + precioshistoricoservicios + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(precioshistoricoservicios precioshistoricoservicios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            precioshistoricoservicios = em.merge(precioshistoricoservicios);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = precioshistoricoservicios.getNumprecioservicio();
                if (findprecioshistoricoservicios(id) == null) {
                    throw new NonexistentEntityException("The precioshistoricoservicios with id " + id + " no longer exists.");
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
            precioshistoricoservicios precioshistoricoservicios;
            try {
                precioshistoricoservicios = em.getReference(precioshistoricoservicios.class, id);
                precioshistoricoservicios.getNumprecioservicio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The precioshistoricoservicios with id " + id + " no longer exists.", enfe);
            }
            em.remove(precioshistoricoservicios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<precioshistoricoservicios> findprecioshistoricoserviciosEntities() {
        return findprecioshistoricoserviciosEntities(true, -1, -1);
    }

    public List<precioshistoricoservicios> findprecioshistoricoserviciosEntities(int maxResults, int firstResult) {
        return findprecioshistoricoserviciosEntities(false, maxResults, firstResult);
    }

    private List<precioshistoricoservicios> findprecioshistoricoserviciosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(precioshistoricoservicios.class));
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

    public precioshistoricoservicios findprecioshistoricoservicios(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(precioshistoricoservicios.class, id);
        } finally {
            em.close();
        }
    }

    public int getprecioshistoricoserviciosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<precioshistoricoservicios> rt = cq.from(precioshistoricoservicios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
