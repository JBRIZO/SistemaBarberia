/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.NonexistentEntityException;
import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.PreexistingEntityException;
import com.mycompany.sistemabarberia.facturasanuladas;
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
public class facturasanuladasJpaController implements Serializable {

    public facturasanuladasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(facturasanuladas facturasanuladas) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(facturasanuladas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findfacturasanuladas(facturasanuladas.getIdfacturaanulada()) != null) {
                throw new PreexistingEntityException("facturasanuladas " + facturasanuladas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(facturasanuladas facturasanuladas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            facturasanuladas = em.merge(facturasanuladas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = facturasanuladas.getIdfacturaanulada();
                if (findfacturasanuladas(id) == null) {
                    throw new NonexistentEntityException("The facturasanuladas with id " + id + " no longer exists.");
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
            facturasanuladas facturasanuladas;
            try {
                facturasanuladas = em.getReference(facturasanuladas.class, id);
                facturasanuladas.getIdfacturaanulada();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The facturasanuladas with id " + id + " no longer exists.", enfe);
            }
            em.remove(facturasanuladas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<facturasanuladas> findfacturasanuladasEntities() {
        return findfacturasanuladasEntities(true, -1, -1);
    }

    public List<facturasanuladas> findfacturasanuladasEntities(int maxResults, int firstResult) {
        return findfacturasanuladasEntities(false, maxResults, firstResult);
    }

    private List<facturasanuladas> findfacturasanuladasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(facturasanuladas.class));
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

    public facturasanuladas findfacturasanuladas(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(facturasanuladas.class, id);
        } finally {
            em.close();
        }
    }

    public int getfacturasanuladasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<facturasanuladas> rt = cq.from(facturasanuladas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
