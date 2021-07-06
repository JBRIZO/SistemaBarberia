/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.GUI.exceptions.NonexistentEntityException;
import com.mycompany.GUI.exceptions.PreexistingEntityException;
import com.mycompany.sistemabarberia.estadofactura;
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
 * @author Kesil
 */
public class estadofacturaJpaController implements Serializable {

    public estadofacturaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("servidorbd");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(estadofactura estadofactura) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(estadofactura);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findestadofactura(estadofactura.getIdestado()) != null) {
                throw new PreexistingEntityException("estadofactura " + estadofactura + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(estadofactura estadofactura) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            estadofactura = em.merge(estadofactura);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = estadofactura.getIdestado();
                if (findestadofactura(id) == null) {
                    throw new NonexistentEntityException("The estadofactura with id " + id + " no longer exists.");
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
            estadofactura estadofactura;
            try {
                estadofactura = em.getReference(estadofactura.class, id);
                estadofactura.getIdestado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estadofactura with id " + id + " no longer exists.", enfe);
            }
            em.remove(estadofactura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<estadofactura> findestadofacturaEntities() {
        return findestadofacturaEntities(true, -1, -1);
    }

    public List<estadofactura> findestadofacturaEntities(int maxResults, int firstResult) {
        return findestadofacturaEntities(false, maxResults, firstResult);
    }

    private List<estadofactura> findestadofacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(estadofactura.class));
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

    public estadofactura findestadofactura(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(estadofactura.class, id);
        } finally {
            em.close();
        }
    }

    public int getestadofacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<estadofactura> rt = cq.from(estadofactura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
