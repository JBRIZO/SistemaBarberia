/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.NonexistentEntityException;
import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.PreexistingEntityException;
import com.mycompany.sistemabarberia.tiposbono;
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
public class tiposbonoJpaController implements Serializable {

    public tiposbonoJpaController() {
       this.emf = Persistence.createEntityManagerFactory("servidorbd");
    }
    private EntityManagerFactory emf = null;
    
    public void close()
    {
        this.emf.close();
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(tiposbono tiposbono) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tiposbono);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findtiposbono(tiposbono.getIdtipobono()) != null) {
                throw new PreexistingEntityException("tiposbono " + tiposbono + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(tiposbono tiposbono) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tiposbono = em.merge(tiposbono);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tiposbono.getIdtipobono();
                if (findtiposbono(id) == null) {
                    throw new NonexistentEntityException("The tiposbono with id " + id + " no longer exists.");
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
            tiposbono tiposbono;
            try {
                tiposbono = em.getReference(tiposbono.class, id);
                tiposbono.getIdtipobono();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tiposbono with id " + id + " no longer exists.", enfe);
            }
            em.remove(tiposbono);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<tiposbono> findtiposbonoEntities() {
        return findtiposbonoEntities(true, -1, -1);
    }

    public List<tiposbono> findtiposbonoEntities(int maxResults, int firstResult) {
        return findtiposbonoEntities(false, maxResults, firstResult);
    }

    private List<tiposbono> findtiposbonoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(tiposbono.class));
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

    public tiposbono findtiposbono(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(tiposbono.class, id);
        } finally {
            em.close();
        }
    }

    public int gettiposbonoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<tiposbono> rt = cq.from(tiposbono.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
