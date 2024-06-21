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
import com.emergentes.entities.Hotel;
import com.emergentes.entities.Oferta;
import com.emergentes.entities.TipoHabitacion;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Ronaldo
 */
public class OfertaJpaController implements Serializable {

    public OfertaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Oferta oferta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Hotel idHotel = oferta.getIdHotel();
            if (idHotel != null) {
                idHotel = em.getReference(idHotel.getClass(), idHotel.getId());
                oferta.setIdHotel(idHotel);
            }
            TipoHabitacion idTipoHabitacion = oferta.getIdTipoHabitacion();
            if (idTipoHabitacion != null) {
                idTipoHabitacion = em.getReference(idTipoHabitacion.getClass(), idTipoHabitacion.getId());
                oferta.setIdTipoHabitacion(idTipoHabitacion);
            }
            em.persist(oferta);
            if (idHotel != null) {
                idHotel.getOfertaList().add(oferta);
                idHotel = em.merge(idHotel);
            }
            if (idTipoHabitacion != null) {
                idTipoHabitacion.getOfertaList().add(oferta);
                idTipoHabitacion = em.merge(idTipoHabitacion);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Oferta oferta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Oferta persistentOferta = em.find(Oferta.class, oferta.getId());
            Hotel idHotelOld = persistentOferta.getIdHotel();
            Hotel idHotelNew = oferta.getIdHotel();
            TipoHabitacion idTipoHabitacionOld = persistentOferta.getIdTipoHabitacion();
            TipoHabitacion idTipoHabitacionNew = oferta.getIdTipoHabitacion();
            if (idHotelNew != null) {
                idHotelNew = em.getReference(idHotelNew.getClass(), idHotelNew.getId());
                oferta.setIdHotel(idHotelNew);
            }
            if (idTipoHabitacionNew != null) {
                idTipoHabitacionNew = em.getReference(idTipoHabitacionNew.getClass(), idTipoHabitacionNew.getId());
                oferta.setIdTipoHabitacion(idTipoHabitacionNew);
            }
            oferta = em.merge(oferta);
            if (idHotelOld != null && !idHotelOld.equals(idHotelNew)) {
                idHotelOld.getOfertaList().remove(oferta);
                idHotelOld = em.merge(idHotelOld);
            }
            if (idHotelNew != null && !idHotelNew.equals(idHotelOld)) {
                idHotelNew.getOfertaList().add(oferta);
                idHotelNew = em.merge(idHotelNew);
            }
            if (idTipoHabitacionOld != null && !idTipoHabitacionOld.equals(idTipoHabitacionNew)) {
                idTipoHabitacionOld.getOfertaList().remove(oferta);
                idTipoHabitacionOld = em.merge(idTipoHabitacionOld);
            }
            if (idTipoHabitacionNew != null && !idTipoHabitacionNew.equals(idTipoHabitacionOld)) {
                idTipoHabitacionNew.getOfertaList().add(oferta);
                idTipoHabitacionNew = em.merge(idTipoHabitacionNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = oferta.getId();
                if (findOferta(id) == null) {
                    throw new NonexistentEntityException("The oferta with id " + id + " no longer exists.");
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
            Oferta oferta;
            try {
                oferta = em.getReference(Oferta.class, id);
                oferta.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The oferta with id " + id + " no longer exists.", enfe);
            }
            Hotel idHotel = oferta.getIdHotel();
            if (idHotel != null) {
                idHotel.getOfertaList().remove(oferta);
                idHotel = em.merge(idHotel);
            }
            TipoHabitacion idTipoHabitacion = oferta.getIdTipoHabitacion();
            if (idTipoHabitacion != null) {
                idTipoHabitacion.getOfertaList().remove(oferta);
                idTipoHabitacion = em.merge(idTipoHabitacion);
            }
            em.remove(oferta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Oferta> findOfertaEntities() {
        return findOfertaEntities(true, -1, -1);
    }

    public List<Oferta> findOfertaEntities(int maxResults, int firstResult) {
        return findOfertaEntities(false, maxResults, firstResult);
    }

    private List<Oferta> findOfertaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Oferta.class));
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

    public Oferta findOferta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Oferta.class, id);
        } finally {
            em.close();
        }
    }

    public int getOfertaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Oferta> rt = cq.from(Oferta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
