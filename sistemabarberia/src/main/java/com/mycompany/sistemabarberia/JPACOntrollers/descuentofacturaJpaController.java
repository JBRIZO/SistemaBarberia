/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.NonexistentEntityException;
import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.PreexistingEntityException;
import com.mycompany.sistemabarberia.descuentofactura;
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
public class descuentofacturaJpaController implements Serializable {

    public descuentofacturaJpaController() {
         this.emf = Persistence.createEntityManagerFactory("servidorbd");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(descuentofactura descuentofactura) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(descuentofactura);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (finddescuentofactura(descuentofactura.getNumdescuento()) != null) {
                throw new PreexistingEntityException("descuentofactura " + descuentofactura + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(descuentofactura descuentofactura) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            descuentofactura = em.merge(descuentofactura);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = descuentofactura.getNumdescuento();
                if (finddescuentofactura(id) == null) {
                    throw new NonexistentEntityException("The descuentofactura with id " + id + " no longer exists.");
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
            descuentofactura descuentofactura;
            try {
                descuentofactura = em.getReference(descuentofactura.class, id);
                descuentofactura.getNumdescuento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The descuentofactura with id " + id + " no longer exists.", enfe);
            }
            em.remove(descuentofactura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<descuentofactura> finddescuentofacturaEntities() {
        return finddescuentofacturaEntities(true, -1, -1);
    }

    public List<descuentofactura> finddescuentofacturaEntities(int maxResults, int firstResult) {
        return finddescuentofacturaEntities(false, maxResults, firstResult);
    }

    private List<descuentofactura> finddescuentofacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(descuentofactura.class));
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

    public descuentofactura finddescuentofactura(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(descuentofactura.class, id);
        } finally {
            em.close();
        }
    }

    public int getdescuentofacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<descuentofactura> rt = cq.from(descuentofactura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
