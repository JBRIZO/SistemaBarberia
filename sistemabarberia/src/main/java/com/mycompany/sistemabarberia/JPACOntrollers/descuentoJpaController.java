
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.NonexistentEntityException;
import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.PreexistingEntityException;
import com.mycompany.sistemabarberia.descuentos;
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
public class descuentoJpaController implements Serializable {

    public descuentoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("servidorbd");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(descuentos descuento) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(descuento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (finddescuento(descuento.getIddescuento()) != null) {
                throw new PreexistingEntityException("descuento " + descuento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(descuentos descuento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            descuento = em.merge(descuento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = descuento.getIddescuento();
                if (finddescuento(id) == null) {
                    throw new NonexistentEntityException("The descuento with id " + id + " no longer exists.");
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
            descuentos descuento;
            try {
                descuento = em.getReference(descuentos.class, id);
                descuento.getIddescuento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The descuento with id " + id + " no longer exists.", enfe);
            }
            em.remove(descuento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<descuentos> finddescuentoEntities() {
        return finddescuentoEntities(true, -1, -1);
    }

    public List<descuentos> finddescuentoEntities(int maxResults, int firstResult) {
        return finddescuentoEntities(false, maxResults, firstResult);
    }

    private List<descuentos> finddescuentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(descuentos.class));
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

    public descuentos finddescuento(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(descuentos.class, id);
        } finally {
            em.close();
        }
    }

    public int getdescuentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<descuentos> rt = cq.from(descuentos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

