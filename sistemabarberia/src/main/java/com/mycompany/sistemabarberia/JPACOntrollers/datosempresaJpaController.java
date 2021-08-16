/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.NonexistentEntityException;
import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.PreexistingEntityException;
import com.mycompany.sistemabarberia.datosempresa;
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
public class datosempresaJpaController implements Serializable {

    public datosempresaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("servidorbd");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(datosempresa datosempresa) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(datosempresa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (finddatosempresa(datosempresa.getIddato()) != null) {
                throw new PreexistingEntityException("datosempresa " + datosempresa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(datosempresa datosempresa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            datosempresa = em.merge(datosempresa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = datosempresa.getIddato();
                if (finddatosempresa(id) == null) {
                    throw new NonexistentEntityException("The datosempresa with id " + id + " no longer exists.");
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
            datosempresa datosempresa;
            try {
                datosempresa = em.getReference(datosempresa.class, id);
                datosempresa.getIddato();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The datosempresa with id " + id + " no longer exists.", enfe);
            }
            em.remove(datosempresa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<datosempresa> finddatosempresaEntities() {
        return finddatosempresaEntities(true, -1, -1);
    }

    public List<datosempresa> finddatosempresaEntities(int maxResults, int firstResult) {
        return finddatosempresaEntities(false, maxResults, firstResult);
    }

    private List<datosempresa> finddatosempresaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(datosempresa.class));
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

    public datosempresa finddatosempresa(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(datosempresa.class, id);
        } finally {
            em.close();
        }
    }

    public int getdatosempresaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<datosempresa> rt = cq.from(datosempresa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
