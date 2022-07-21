/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.NonexistentEntityException;
import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.PreexistingEntityException;
import com.mycompany.sistemabarberia.precioshistoricosproductos;
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
public class precioshistoricosproductosJpaController implements Serializable {

    public precioshistoricosproductosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void close()
    {
        this.emf.close();
    }

    public void create(precioshistoricosproductos precioshistoricosproductos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(precioshistoricosproductos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findprecioshistoricosproductos(precioshistoricosproductos.getNumprecio()) != null) {
                throw new PreexistingEntityException("precioshistoricosproductos " + precioshistoricosproductos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(precioshistoricosproductos precioshistoricosproductos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            precioshistoricosproductos = em.merge(precioshistoricosproductos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = precioshistoricosproductos.getNumprecio();
                if (findprecioshistoricosproductos(id) == null) {
                    throw new NonexistentEntityException("The precioshistoricosproductos with id " + id + " no longer exists.");
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
            precioshistoricosproductos precioshistoricosproductos;
            try {
                precioshistoricosproductos = em.getReference(precioshistoricosproductos.class, id);
                precioshistoricosproductos.getNumprecio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The precioshistoricosproductos with id " + id + " no longer exists.", enfe);
            }
            em.remove(precioshistoricosproductos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<precioshistoricosproductos> findprecioshistoricosproductosEntities() {
        return findprecioshistoricosproductosEntities(true, -1, -1);
    }

    public List<precioshistoricosproductos> findprecioshistoricosproductosEntities(int maxResults, int firstResult) {
        return findprecioshistoricosproductosEntities(false, maxResults, firstResult);
    }

    private List<precioshistoricosproductos> findprecioshistoricosproductosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(precioshistoricosproductos.class));
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

    public precioshistoricosproductos findprecioshistoricosproductos(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(precioshistoricosproductos.class, id);
        } finally {
            em.close();
        }
    }

    public int getprecioshistoricosproductosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<precioshistoricosproductos> rt = cq.from(precioshistoricosproductos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
