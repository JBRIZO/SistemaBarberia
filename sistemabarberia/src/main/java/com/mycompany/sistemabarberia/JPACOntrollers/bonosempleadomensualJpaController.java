/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.NonexistentEntityException;
import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.PreexistingEntityException;
import com.mycompany.sistemabarberia.bonosempleadomensual;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Jonathan Laux
 */
public class bonosempleadomensualJpaController implements Serializable {

    public bonosempleadomensualJpaController(EntityManagerFactory emf) {
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

    public void create(bonosempleadomensual bonosempleadomensual) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bonosempleadomensual);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findbonosempleadomensual(bonosempleadomensual.getNumbono()) != null) {
                throw new PreexistingEntityException("bonosempleadomensual " + bonosempleadomensual + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(bonosempleadomensual bonosempleadomensual) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bonosempleadomensual = em.merge(bonosempleadomensual);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = bonosempleadomensual.getNumbono();
                if (findbonosempleadomensual(id) == null) {
                    throw new NonexistentEntityException("The bonosempleadomensual with id " + id + " no longer exists.");
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
            bonosempleadomensual bonosempleadomensual;
            try {
                bonosempleadomensual = em.getReference(bonosempleadomensual.class, id);
                bonosempleadomensual.getNumbono();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bonosempleadomensual with id " + id + " no longer exists.", enfe);
            }
            em.remove(bonosempleadomensual);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<bonosempleadomensual> findbonosempleadomensualEntities() {
        return findbonosempleadomensualEntities(true, -1, -1);
    }

    public List<bonosempleadomensual> findbonosempleadomensualEntities(int maxResults, int firstResult) {
        return findbonosempleadomensualEntities(false, maxResults, firstResult);
    }

    private List<bonosempleadomensual> findbonosempleadomensualEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(bonosempleadomensual.class));
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

    public bonosempleadomensual findbonosempleadomensual(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(bonosempleadomensual.class, id);
        } finally {
            em.close();
        }
    }

    public int getbonosempleadomensualCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<bonosempleadomensual> rt = cq.from(bonosempleadomensual.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
