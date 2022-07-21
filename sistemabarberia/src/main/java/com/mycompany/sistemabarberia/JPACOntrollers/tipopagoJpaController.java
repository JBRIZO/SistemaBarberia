/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.NonexistentEntityException;
import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.PreexistingEntityException;
import com.mycompany.sistemabarberia.tipopago;
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
public class tipopagoJpaController implements Serializable {

    public tipopagoJpaController(EntityManagerFactory emf) {
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

    public void create(tipopago tipopago) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipopago);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findtipopago(tipopago.getIdtipopago()) != null) {
                throw new PreexistingEntityException("tipopago " + tipopago + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(tipopago tipopago) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipopago = em.merge(tipopago);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tipopago.getIdtipopago();
                if (findtipopago(id) == null) {
                    throw new NonexistentEntityException("The tipopago with id " + id + " no longer exists.");
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
            tipopago tipopago;
            try {
                tipopago = em.getReference(tipopago.class, id);
                tipopago.getIdtipopago();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipopago with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipopago);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<tipopago> findtipopagoEntities() {
        return findtipopagoEntities(true, -1, -1);
    }

    public List<tipopago> findtipopagoEntities(int maxResults, int firstResult) {
        return findtipopagoEntities(false, maxResults, firstResult);
    }

    private List<tipopago> findtipopagoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(tipopago.class));
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

    public tipopago findtipopago(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(tipopago.class, id);
        } finally {
            em.close();
        }
    }

    public int gettipopagoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<tipopago> rt = cq.from(tipopago.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
