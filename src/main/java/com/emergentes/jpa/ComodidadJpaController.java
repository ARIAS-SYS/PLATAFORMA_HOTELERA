/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.jpa;

import com.emergentes.entities.Comodidad;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.emergentes.entities.ComodidadHabitacion;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Ronaldo
 */
public class ComodidadJpaController implements Serializable {

    public ComodidadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Comodidad comodidad) {
        if (comodidad.getComodidadHabitacionList() == null) {
            comodidad.setComodidadHabitacionList(new ArrayList<ComodidadHabitacion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<ComodidadHabitacion> attachedComodidadHabitacionList = new ArrayList<ComodidadHabitacion>();
            for (ComodidadHabitacion comodidadHabitacionListComodidadHabitacionToAttach : comodidad.getComodidadHabitacionList()) {
                comodidadHabitacionListComodidadHabitacionToAttach = em.getReference(comodidadHabitacionListComodidadHabitacionToAttach.getClass(), comodidadHabitacionListComodidadHabitacionToAttach.getId());
                attachedComodidadHabitacionList.add(comodidadHabitacionListComodidadHabitacionToAttach);
            }
            comodidad.setComodidadHabitacionList(attachedComodidadHabitacionList);
            em.persist(comodidad);
            for (ComodidadHabitacion comodidadHabitacionListComodidadHabitacion : comodidad.getComodidadHabitacionList()) {
                Comodidad oldIdComodidadOfComodidadHabitacionListComodidadHabitacion = comodidadHabitacionListComodidadHabitacion.getIdComodidad();
                comodidadHabitacionListComodidadHabitacion.setIdComodidad(comodidad);
                comodidadHabitacionListComodidadHabitacion = em.merge(comodidadHabitacionListComodidadHabitacion);
                if (oldIdComodidadOfComodidadHabitacionListComodidadHabitacion != null) {
                    oldIdComodidadOfComodidadHabitacionListComodidadHabitacion.getComodidadHabitacionList().remove(comodidadHabitacionListComodidadHabitacion);
                    oldIdComodidadOfComodidadHabitacionListComodidadHabitacion = em.merge(oldIdComodidadOfComodidadHabitacionListComodidadHabitacion);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Comodidad comodidad) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Comodidad persistentComodidad = em.find(Comodidad.class, comodidad.getId());
            List<ComodidadHabitacion> comodidadHabitacionListOld = persistentComodidad.getComodidadHabitacionList();
            List<ComodidadHabitacion> comodidadHabitacionListNew = comodidad.getComodidadHabitacionList();
            List<ComodidadHabitacion> attachedComodidadHabitacionListNew = new ArrayList<ComodidadHabitacion>();
            for (ComodidadHabitacion comodidadHabitacionListNewComodidadHabitacionToAttach : comodidadHabitacionListNew) {
                comodidadHabitacionListNewComodidadHabitacionToAttach = em.getReference(comodidadHabitacionListNewComodidadHabitacionToAttach.getClass(), comodidadHabitacionListNewComodidadHabitacionToAttach.getId());
                attachedComodidadHabitacionListNew.add(comodidadHabitacionListNewComodidadHabitacionToAttach);
            }
            comodidadHabitacionListNew = attachedComodidadHabitacionListNew;
            comodidad.setComodidadHabitacionList(comodidadHabitacionListNew);
            comodidad = em.merge(comodidad);
            for (ComodidadHabitacion comodidadHabitacionListOldComodidadHabitacion : comodidadHabitacionListOld) {
                if (!comodidadHabitacionListNew.contains(comodidadHabitacionListOldComodidadHabitacion)) {
                    comodidadHabitacionListOldComodidadHabitacion.setIdComodidad(null);
                    comodidadHabitacionListOldComodidadHabitacion = em.merge(comodidadHabitacionListOldComodidadHabitacion);
                }
            }
            for (ComodidadHabitacion comodidadHabitacionListNewComodidadHabitacion : comodidadHabitacionListNew) {
                if (!comodidadHabitacionListOld.contains(comodidadHabitacionListNewComodidadHabitacion)) {
                    Comodidad oldIdComodidadOfComodidadHabitacionListNewComodidadHabitacion = comodidadHabitacionListNewComodidadHabitacion.getIdComodidad();
                    comodidadHabitacionListNewComodidadHabitacion.setIdComodidad(comodidad);
                    comodidadHabitacionListNewComodidadHabitacion = em.merge(comodidadHabitacionListNewComodidadHabitacion);
                    if (oldIdComodidadOfComodidadHabitacionListNewComodidadHabitacion != null && !oldIdComodidadOfComodidadHabitacionListNewComodidadHabitacion.equals(comodidad)) {
                        oldIdComodidadOfComodidadHabitacionListNewComodidadHabitacion.getComodidadHabitacionList().remove(comodidadHabitacionListNewComodidadHabitacion);
                        oldIdComodidadOfComodidadHabitacionListNewComodidadHabitacion = em.merge(oldIdComodidadOfComodidadHabitacionListNewComodidadHabitacion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = comodidad.getId();
                if (findComodidad(id) == null) {
                    throw new NonexistentEntityException("The comodidad with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Comodidad comodidad;
            try {
                comodidad = em.getReference(Comodidad.class, id);
                comodidad.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The comodidad with id " + id + " no longer exists.", enfe);
            }
            List<ComodidadHabitacion> comodidadHabitacionList = comodidad.getComodidadHabitacionList();
            for (ComodidadHabitacion comodidadHabitacionListComodidadHabitacion : comodidadHabitacionList) {
                comodidadHabitacionListComodidadHabitacion.setIdComodidad(null);
                comodidadHabitacionListComodidadHabitacion = em.merge(comodidadHabitacionListComodidadHabitacion);
            }
            em.remove(comodidad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Comodidad> findComodidadEntities() {
        return findComodidadEntities(true, -1, -1);
    }

    public List<Comodidad> findComodidadEntities(int maxResults, int firstResult) {
        return findComodidadEntities(false, maxResults, firstResult);
    }

    private List<Comodidad> findComodidadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Comodidad.class));
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

    public Comodidad findComodidad(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Comodidad.class, id);
        } finally {
            em.close();
        }
    }

    public int getComodidadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Comodidad> rt = cq.from(Comodidad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
