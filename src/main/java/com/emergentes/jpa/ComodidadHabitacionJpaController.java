/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.jpa;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.emergentes.entities.Habitacion;
import com.emergentes.entities.Comodidad;
import com.emergentes.entities.ComodidadHabitacion;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Ronaldo
 */
public class ComodidadHabitacionJpaController implements Serializable {

    public ComodidadHabitacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ComodidadHabitacion comodidadHabitacion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Habitacion idHabitacion = comodidadHabitacion.getIdHabitacion();
            if (idHabitacion != null) {
                idHabitacion = em.getReference(idHabitacion.getClass(), idHabitacion.getId());
                comodidadHabitacion.setIdHabitacion(idHabitacion);
            }
            Comodidad idComodidad = comodidadHabitacion.getIdComodidad();
            if (idComodidad != null) {
                idComodidad = em.getReference(idComodidad.getClass(), idComodidad.getId());
                comodidadHabitacion.setIdComodidad(idComodidad);
            }
            em.persist(comodidadHabitacion);
            if (idHabitacion != null) {
                idHabitacion.getComodidadHabitacionList().add(comodidadHabitacion);
                idHabitacion = em.merge(idHabitacion);
            }
            if (idComodidad != null) {
                idComodidad.getComodidadHabitacionList().add(comodidadHabitacion);
                idComodidad = em.merge(idComodidad);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ComodidadHabitacion comodidadHabitacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ComodidadHabitacion persistentComodidadHabitacion = em.find(ComodidadHabitacion.class, comodidadHabitacion.getId());
            Habitacion idHabitacionOld = persistentComodidadHabitacion.getIdHabitacion();
            Habitacion idHabitacionNew = comodidadHabitacion.getIdHabitacion();
            Comodidad idComodidadOld = persistentComodidadHabitacion.getIdComodidad();
            Comodidad idComodidadNew = comodidadHabitacion.getIdComodidad();
            if (idHabitacionNew != null) {
                idHabitacionNew = em.getReference(idHabitacionNew.getClass(), idHabitacionNew.getId());
                comodidadHabitacion.setIdHabitacion(idHabitacionNew);
            }
            if (idComodidadNew != null) {
                idComodidadNew = em.getReference(idComodidadNew.getClass(), idComodidadNew.getId());
                comodidadHabitacion.setIdComodidad(idComodidadNew);
            }
            comodidadHabitacion = em.merge(comodidadHabitacion);
            if (idHabitacionOld != null && !idHabitacionOld.equals(idHabitacionNew)) {
                idHabitacionOld.getComodidadHabitacionList().remove(comodidadHabitacion);
                idHabitacionOld = em.merge(idHabitacionOld);
            }
            if (idHabitacionNew != null && !idHabitacionNew.equals(idHabitacionOld)) {
                idHabitacionNew.getComodidadHabitacionList().add(comodidadHabitacion);
                idHabitacionNew = em.merge(idHabitacionNew);
            }
            if (idComodidadOld != null && !idComodidadOld.equals(idComodidadNew)) {
                idComodidadOld.getComodidadHabitacionList().remove(comodidadHabitacion);
                idComodidadOld = em.merge(idComodidadOld);
            }
            if (idComodidadNew != null && !idComodidadNew.equals(idComodidadOld)) {
                idComodidadNew.getComodidadHabitacionList().add(comodidadHabitacion);
                idComodidadNew = em.merge(idComodidadNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = comodidadHabitacion.getId();
                if (findComodidadHabitacion(id) == null) {
                    throw new NonexistentEntityException("The comodidadHabitacion with id " + id + " no longer exists.");
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
            ComodidadHabitacion comodidadHabitacion;
            try {
                comodidadHabitacion = em.getReference(ComodidadHabitacion.class, id);
                comodidadHabitacion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The comodidadHabitacion with id " + id + " no longer exists.", enfe);
            }
            Habitacion idHabitacion = comodidadHabitacion.getIdHabitacion();
            if (idHabitacion != null) {
                idHabitacion.getComodidadHabitacionList().remove(comodidadHabitacion);
                idHabitacion = em.merge(idHabitacion);
            }
            Comodidad idComodidad = comodidadHabitacion.getIdComodidad();
            if (idComodidad != null) {
                idComodidad.getComodidadHabitacionList().remove(comodidadHabitacion);
                idComodidad = em.merge(idComodidad);
            }
            em.remove(comodidadHabitacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ComodidadHabitacion> findComodidadHabitacionEntities() {
        return findComodidadHabitacionEntities(true, -1, -1);
    }

    public List<ComodidadHabitacion> findComodidadHabitacionEntities(int maxResults, int firstResult) {
        return findComodidadHabitacionEntities(false, maxResults, firstResult);
    }

    private List<ComodidadHabitacion> findComodidadHabitacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ComodidadHabitacion.class));
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

    public ComodidadHabitacion findComodidadHabitacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ComodidadHabitacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getComodidadHabitacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ComodidadHabitacion> rt = cq.from(ComodidadHabitacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
