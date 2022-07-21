/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabarberia.JPACOntrollers;

import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.NonexistentEntityException;
import com.mycompany.sistemabarberia.JPACOntrollers.exceptions.PreexistingEntityException;
import com.mycompany.sistemabarberia.salariohistoricoempleados;
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
public class salariohistoricoempleadosJpaController implements Serializable {

    public salariohistoricoempleadosJpaController(EntityManagerFactory emf) {
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
    
    public void create(salariohistoricoempleados salariohistoricoempleados) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(salariohistoricoempleados);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findsalariohistoricoempleados(salariohistoricoempleados.getIdsalario()) != null) {
                throw new PreexistingEntityException("salariohistoricoempleados " + salariohistoricoempleados + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(salariohistoricoempleados salariohistoricoempleados) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            salariohistoricoempleados = em.merge(salariohistoricoempleados);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = salariohistoricoempleados.getIdsalario();
                if (findsalariohistoricoempleados(id) == null) {
                    throw new NonexistentEntityException("The salariohistoricoempleados with id " + id + " no longer exists.");
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
            salariohistoricoempleados salariohistoricoempleados;
            try {
                salariohistoricoempleados = em.getReference(salariohistoricoempleados.class, id);
                salariohistoricoempleados.getIdsalario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The salariohistoricoempleados with id " + id + " no longer exists.", enfe);
            }
            em.remove(salariohistoricoempleados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<salariohistoricoempleados> findsalariohistoricoempleadosEntities() {
        return findsalariohistoricoempleadosEntities(true, -1, -1);
    }

    public List<salariohistoricoempleados> findsalariohistoricoempleadosEntities(int maxResults, int firstResult) {
        return findsalariohistoricoempleadosEntities(false, maxResults, firstResult);
    }

    private List<salariohistoricoempleados> findsalariohistoricoempleadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(salariohistoricoempleados.class));
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

    public salariohistoricoempleados findsalariohistoricoempleados(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(salariohistoricoempleados.class, id);
        } finally {
            em.close();
        }
    }

    public int getsalariohistoricoempleadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<salariohistoricoempleados> rt = cq.from(salariohistoricoempleados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
