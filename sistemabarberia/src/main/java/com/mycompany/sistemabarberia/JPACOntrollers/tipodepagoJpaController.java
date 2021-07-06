/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.GUI.exceptions.NonexistentEntityException;
import com.mycompany.GUI.exceptions.PreexistingEntityException;
import com.mycompany.sistemabarberia.tipodepago;
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
 * @author flore
 */
public class tipodepagoJpaController implements Serializable {

    public tipodepagoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("servidorbd");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(tipodepago tipodepago) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipodepago);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findtipodepago(tipodepago.getIdtipopago()) != null) {
                throw new PreexistingEntityException("tipodepago " + tipodepago + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(tipodepago tipodepago) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipodepago = em.merge(tipodepago);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tipodepago.getIdtipopago();
                if (findtipodepago(id) == null) {
                    throw new NonexistentEntityException("The tipodepago with id " + id + " no longer exists.");
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
            tipodepago tipodepago;
            try {
                tipodepago = em.getReference(tipodepago.class, id);
                tipodepago.getIdtipopago();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipodepago with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipodepago);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<tipodepago> findtipodepagoEntities() {
        return findtipodepagoEntities(true, -1, -1);
    }

    public List<tipodepago> findtipodepagoEntities(int maxResults, int firstResult) {
        return findtipodepagoEntities(false, maxResults, firstResult);
    }

    private List<tipodepago> findtipodepagoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(tipodepago.class));
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

    public tipodepago findtipodepago(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(tipodepago.class, id);
        } finally {
            em.close();
        }
    }

    public int gettipodepagoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<tipodepago> rt = cq.from(tipodepago.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
