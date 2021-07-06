/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.NonexistentEntityException;
import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.PreexistingEntityException;
import com.mycompany.sistemabarberia.tipodeduccion;
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
public class tipodeduccionJpaController implements Serializable {

    public tipodeduccionJpaController() {
        this.emf = Persistence.createEntityManagerFactory("servidorbd");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(tipodeduccion tipodeduccion) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipodeduccion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findtipodeduccion(tipodeduccion.getIdtipodeduccion()) != null) {
                throw new PreexistingEntityException("tipodeduccion " + tipodeduccion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(tipodeduccion tipodeduccion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipodeduccion = em.merge(tipodeduccion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tipodeduccion.getIdtipodeduccion();
                if (findtipodeduccion(id) == null) {
                    throw new NonexistentEntityException("The tipodeduccion with id " + id + " no longer exists.");
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
            tipodeduccion tipodeduccion;
            try {
                tipodeduccion = em.getReference(tipodeduccion.class, id);
                tipodeduccion.getIdtipodeduccion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipodeduccion with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipodeduccion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<tipodeduccion> findtipodeduccionEntities() {
        return findtipodeduccionEntities(true, -1, -1);
    }

    public List<tipodeduccion> findtipodeduccionEntities(int maxResults, int firstResult) {
        return findtipodeduccionEntities(false, maxResults, firstResult);
    }

    private List<tipodeduccion> findtipodeduccionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(tipodeduccion.class));
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

    public tipodeduccion findtipodeduccion(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(tipodeduccion.class, id);
        } finally {
            em.close();
        }
    }

    public int gettipodeduccionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<tipodeduccion> rt = cq.from(tipodeduccion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
