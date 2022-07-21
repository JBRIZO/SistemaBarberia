/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.NonexistentEntityException;
import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.PreexistingEntityException;
import com.mycompany.sistemabarberia.permisosusuario;
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
public class permisosusuarioJpaController implements Serializable {

    public permisosusuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(permisosusuario permisosusuario) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(permisosusuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findpermisosusuario(permisosusuario.getIdpermisousuario()) != null) {
                throw new PreexistingEntityException("permisosusuario " + permisosusuario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(permisosusuario permisosusuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            permisosusuario = em.merge(permisosusuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = permisosusuario.getIdpermisousuario();
                if (findpermisosusuario(id) == null) {
                    throw new NonexistentEntityException("The permisosusuario with id " + id + " no longer exists.");
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
            permisosusuario permisosusuario;
            try {
                permisosusuario = em.getReference(permisosusuario.class, id);
                permisosusuario.getIdpermisousuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The permisosusuario with id " + id + " no longer exists.", enfe);
            }
            em.remove(permisosusuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<permisosusuario> findpermisosusuarioEntities() {
        return findpermisosusuarioEntities(true, -1, -1);
    }

    public List<permisosusuario> findpermisosusuarioEntities(int maxResults, int firstResult) {
        return findpermisosusuarioEntities(false, maxResults, firstResult);
    }

    private List<permisosusuario> findpermisosusuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(permisosusuario.class));
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

    public permisosusuario findpermisosusuario(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(permisosusuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getpermisosusuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<permisosusuario> rt = cq.from(permisosusuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
