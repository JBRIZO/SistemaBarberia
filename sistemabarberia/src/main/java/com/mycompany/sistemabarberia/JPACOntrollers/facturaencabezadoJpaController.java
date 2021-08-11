/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.NonexistentEntityException;
import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.PreexistingEntityException;
import com.mycompany.sistemabarberia.facturaencabezado;
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
public class facturaencabezadoJpaController implements Serializable {

    public facturaencabezadoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("servidorbd");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(facturaencabezado facturaencabezado) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(facturaencabezado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findfacturaencabezado(facturaencabezado.getIdfacturaencabezado()) != null) {
                throw new PreexistingEntityException("facturaencabezado " + facturaencabezado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(facturaencabezado facturaencabezado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            facturaencabezado = em.merge(facturaencabezado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = facturaencabezado.getIdfacturaencabezado();
                if (findfacturaencabezado(id) == null) {
                    throw new NonexistentEntityException("The facturaencabezado with id " + id + " no longer exists.");
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
            facturaencabezado facturaencabezado;
            try {
                facturaencabezado = em.getReference(facturaencabezado.class, id);
                facturaencabezado.getIdfacturaencabezado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The facturaencabezado with id " + id + " no longer exists.", enfe);
            }
            em.remove(facturaencabezado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<facturaencabezado> findfacturaencabezadoEntities() {
        return findfacturaencabezadoEntities(true, -1, -1);
    }

    public List<facturaencabezado> findfacturaencabezadoEntities(int maxResults, int firstResult) {
        return findfacturaencabezadoEntities(false, maxResults, firstResult);
    }

    private List<facturaencabezado> findfacturaencabezadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(facturaencabezado.class));
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

    public facturaencabezado findfacturaencabezado(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(facturaencabezado.class, id);
        } finally {
            em.close();
        }
    }

    public int getfacturaencabezadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<facturaencabezado> rt = cq.from(facturaencabezado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
