/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.NonexistentEntityException;
import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.PreexistingEntityException;
import com.mycompany.sistemabarberia.tipodescuento;
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
public class tipodescuentoJpaController implements Serializable {

    public tipodescuentoJpaController() {
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

    public void create(tipodescuento tipodescuento) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipodescuento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findtipodescuento(tipodescuento.getIdtipodescuento()) != null) {
                throw new PreexistingEntityException("tipodescuento " + tipodescuento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(tipodescuento tipodescuento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipodescuento = em.merge(tipodescuento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tipodescuento.getIdtipodescuento();
                if (findtipodescuento(id) == null) {
                    throw new NonexistentEntityException("The tipodescuento with id " + id + " no longer exists.");
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
            tipodescuento tipodescuento;
            try {
                tipodescuento = em.getReference(tipodescuento.class, id);
                tipodescuento.getIdtipodescuento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipodescuento with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipodescuento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<tipodescuento> findtipodescuentoEntities() {
        return findtipodescuentoEntities(true, -1, -1);
    }

    public List<tipodescuento> findtipodescuentoEntities(int maxResults, int firstResult) {
        return findtipodescuentoEntities(false, maxResults, firstResult);
    }

    private List<tipodescuento> findtipodescuentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(tipodescuento.class));
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

    public tipodescuento findtipodescuento(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(tipodescuento.class, id);
        } finally {
            em.close();
        }
    }

    public int gettipodescuentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<tipodescuento> rt = cq.from(tipodescuento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
