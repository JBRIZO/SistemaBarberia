/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.NonexistentEntityException;
import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.PreexistingEntityException;
import com.mycompany.sistemabarberia.puestohistoricoempleado;
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
public class puestohistoricoempleadoJpaController implements Serializable {

    public puestohistoricoempleadoJpaController(EntityManagerFactory emf) {
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
    
    

    public void create(puestohistoricoempleado puestohistoricoempleado) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(puestohistoricoempleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(puestohistoricoempleado puestohistoricoempleado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            puestohistoricoempleado = em.merge(puestohistoricoempleado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = puestohistoricoempleado.getNumpuesto();
                if (findpuestohistoricoempleado(id) == null) {
                    throw new NonexistentEntityException("The puestohistoricoempleado with id " + id + " no longer exists.");
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
            puestohistoricoempleado puestohistoricoempleado;
            try {
                puestohistoricoempleado = em.getReference(puestohistoricoempleado.class, id);
                puestohistoricoempleado.getNumpuesto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The puestohistoricoempleado with id " + id + " no longer exists.", enfe);
            }
            em.remove(puestohistoricoempleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<puestohistoricoempleado> findpuestohistoricoempleadoEntities() {
        return findpuestohistoricoempleadoEntities(true, -1, -1);
    }

    public List<puestohistoricoempleado> findpuestohistoricoempleadoEntities(int maxResults, int firstResult) {
        return findpuestohistoricoempleadoEntities(false, maxResults, firstResult);
    }

    private List<puestohistoricoempleado> findpuestohistoricoempleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(puestohistoricoempleado.class));
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

    public puestohistoricoempleado findpuestohistoricoempleado(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(puestohistoricoempleado.class, id);
        } finally {
            em.close();
        }
    }

    public int getpuestohistoricoempleadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<puestohistoricoempleado> rt = cq.from(puestohistoricoempleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
