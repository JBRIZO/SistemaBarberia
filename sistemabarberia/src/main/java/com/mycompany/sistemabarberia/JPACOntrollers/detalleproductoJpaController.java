/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.NonexistentEntityException;
import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.PreexistingEntityException;
import com.mycompany.sistemabarberia.detalleproducto;
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
public class detalleproductoJpaController implements Serializable {

    public detalleproductoJpaController() {
       this.emf = Persistence.createEntityManagerFactory("servidorbd");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(detalleproducto detalleproducto) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(detalleproducto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (finddetalleproducto(detalleproducto.getNumdetalle()) != null) {
                throw new PreexistingEntityException("detalleproducto " + detalleproducto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(detalleproducto detalleproducto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            detalleproducto = em.merge(detalleproducto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = detalleproducto.getNumdetalle();
                if (finddetalleproducto(id) == null) {
                    throw new NonexistentEntityException("The detalleproducto with id " + id + " no longer exists.");
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
            detalleproducto detalleproducto;
            try {
                detalleproducto = em.getReference(detalleproducto.class, id);
                detalleproducto.getNumdetalle();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detalleproducto with id " + id + " no longer exists.", enfe);
            }
            em.remove(detalleproducto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<detalleproducto> finddetalleproductoEntities() {
        return finddetalleproductoEntities(true, -1, -1);
    }

    public List<detalleproducto> finddetalleproductoEntities(int maxResults, int firstResult) {
        return finddetalleproductoEntities(false, maxResults, firstResult);
    }

    private List<detalleproducto> finddetalleproductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(detalleproducto.class));
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

    public detalleproducto finddetalleproducto(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(detalleproducto.class, id);
        } finally {
            em.close();
        }
    }

    public int getdetalleproductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<detalleproducto> rt = cq.from(detalleproducto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
