/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.NonexistentEntityException;
import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.PreexistingEntityException;
import com.mycompany.sistemabarberia.deduccionesempleadomensual;
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
public class deduccionesempleadomensualJpaController implements Serializable {

    public deduccionesempleadomensualJpaController() {
        this.emf = Persistence.createEntityManagerFactory("servidorbd");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(deduccionesempleadomensual deduccionesempleadomensual) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(deduccionesempleadomensual);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (finddeduccionesempleadomensual(deduccionesempleadomensual.getNumdeduccion()) != null) {
                throw new PreexistingEntityException("deduccionesempleadomensual " + deduccionesempleadomensual + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(deduccionesempleadomensual deduccionesempleadomensual) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            deduccionesempleadomensual = em.merge(deduccionesempleadomensual);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = deduccionesempleadomensual.getNumdeduccion();
                if (finddeduccionesempleadomensual(id) == null) {
                    throw new NonexistentEntityException("The deduccionesempleadomensual with id " + id + " no longer exists.");
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
            deduccionesempleadomensual deduccionesempleadomensual;
            try {
                deduccionesempleadomensual = em.getReference(deduccionesempleadomensual.class, id);
                deduccionesempleadomensual.getNumdeduccion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The deduccionesempleadomensual with id " + id + " no longer exists.", enfe);
            }
            em.remove(deduccionesempleadomensual);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<deduccionesempleadomensual> finddeduccionesempleadomensualEntities() {
        return finddeduccionesempleadomensualEntities(true, -1, -1);
    }

    public List<deduccionesempleadomensual> finddeduccionesempleadomensualEntities(int maxResults, int firstResult) {
        return finddeduccionesempleadomensualEntities(false, maxResults, firstResult);
    }

    private List<deduccionesempleadomensual> finddeduccionesempleadomensualEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(deduccionesempleadomensual.class));
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

    public deduccionesempleadomensual finddeduccionesempleadomensual(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(deduccionesempleadomensual.class, id);
        } finally {
            em.close();
        }
    }

    public int getdeduccionesempleadomensualCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<deduccionesempleadomensual> rt = cq.from(deduccionesempleadomensual.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
