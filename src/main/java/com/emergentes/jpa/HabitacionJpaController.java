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
import com.emergentes.entities.TipoHabitacion;
import com.emergentes.entities.ComodidadHabitacion;
import com.emergentes.entities.Habitacion;
import java.util.ArrayList;
import java.util.List;
import com.emergentes.entities.Reserva;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Ronaldo
 */
public class HabitacionJpaController implements Serializable {

    public HabitacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Habitacion habitacion) {
        if (habitacion.getComodidadHabitacionList() == null) {
            habitacion.setComodidadHabitacionList(new ArrayList<ComodidadHabitacion>());
        }
        if (habitacion.getReservaList() == null) {
            habitacion.setReservaList(new ArrayList<Reserva>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Hotel idHotelHab = habitacion.getIdHotelHab();
            if (idHotelHab != null) {
                idHotelHab = em.getReference(idHotelHab.getClass(), idHotelHab.getId());
                habitacion.setIdHotelHab(idHotelHab);
            }
            TipoHabitacion idTipoHab = habitacion.getIdTipoHab();
            if (idTipoHab != null) {
                idTipoHab = em.getReference(idTipoHab.getClass(), idTipoHab.getId());
                habitacion.setIdTipoHab(idTipoHab);
            }
            List<ComodidadHabitacion> attachedComodidadHabitacionList = new ArrayList<ComodidadHabitacion>();
            for (ComodidadHabitacion comodidadHabitacionListComodidadHabitacionToAttach : habitacion.getComodidadHabitacionList()) {
                comodidadHabitacionListComodidadHabitacionToAttach = em.getReference(comodidadHabitacionListComodidadHabitacionToAttach.getClass(), comodidadHabitacionListComodidadHabitacionToAttach.getId());
                attachedComodidadHabitacionList.add(comodidadHabitacionListComodidadHabitacionToAttach);
            }
            habitacion.setComodidadHabitacionList(attachedComodidadHabitacionList);
            List<Reserva> attachedReservaList = new ArrayList<Reserva>();
            for (Reserva reservaListReservaToAttach : habitacion.getReservaList()) {
                reservaListReservaToAttach = em.getReference(reservaListReservaToAttach.getClass(), reservaListReservaToAttach.getId());
                attachedReservaList.add(reservaListReservaToAttach);
            }
            habitacion.setReservaList(attachedReservaList);
            em.persist(habitacion);
            if (idHotelHab != null) {
                idHotelHab.getHabitacionList().add(habitacion);
                idHotelHab = em.merge(idHotelHab);
            }
            if (idTipoHab != null) {
                idTipoHab.getHabitacionList().add(habitacion);
                idTipoHab = em.merge(idTipoHab);
            }
            for (ComodidadHabitacion comodidadHabitacionListComodidadHabitacion : habitacion.getComodidadHabitacionList()) {
                Habitacion oldIdHabitacionOfComodidadHabitacionListComodidadHabitacion = comodidadHabitacionListComodidadHabitacion.getIdHabitacion();
                comodidadHabitacionListComodidadHabitacion.setIdHabitacion(habitacion);
                comodidadHabitacionListComodidadHabitacion = em.merge(comodidadHabitacionListComodidadHabitacion);
                if (oldIdHabitacionOfComodidadHabitacionListComodidadHabitacion != null) {
                    oldIdHabitacionOfComodidadHabitacionListComodidadHabitacion.getComodidadHabitacionList().remove(comodidadHabitacionListComodidadHabitacion);
                    oldIdHabitacionOfComodidadHabitacionListComodidadHabitacion = em.merge(oldIdHabitacionOfComodidadHabitacionListComodidadHabitacion);
                }
            }
            for (Reserva reservaListReserva : habitacion.getReservaList()) {
                Habitacion oldIdHabitOfReservaListReserva = reservaListReserva.getIdHabit();
                reservaListReserva.setIdHabit(habitacion);
                reservaListReserva = em.merge(reservaListReserva);
                if (oldIdHabitOfReservaListReserva != null) {
                    oldIdHabitOfReservaListReserva.getReservaList().remove(reservaListReserva);
                    oldIdHabitOfReservaListReserva = em.merge(oldIdHabitOfReservaListReserva);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Habitacion habitacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Habitacion persistentHabitacion = em.find(Habitacion.class, habitacion.getId());
            Hotel idHotelHabOld = persistentHabitacion.getIdHotelHab();
            Hotel idHotelHabNew = habitacion.getIdHotelHab();
            TipoHabitacion idTipoHabOld = persistentHabitacion.getIdTipoHab();
            TipoHabitacion idTipoHabNew = habitacion.getIdTipoHab();
            List<ComodidadHabitacion> comodidadHabitacionListOld = persistentHabitacion.getComodidadHabitacionList();
            List<ComodidadHabitacion> comodidadHabitacionListNew = habitacion.getComodidadHabitacionList();
            List<Reserva> reservaListOld = persistentHabitacion.getReservaList();
            List<Reserva> reservaListNew = habitacion.getReservaList();
            if (idHotelHabNew != null) {
                idHotelHabNew = em.getReference(idHotelHabNew.getClass(), idHotelHabNew.getId());
                habitacion.setIdHotelHab(idHotelHabNew);
            }
            if (idTipoHabNew != null) {
                idTipoHabNew = em.getReference(idTipoHabNew.getClass(), idTipoHabNew.getId());
                habitacion.setIdTipoHab(idTipoHabNew);
            }
            List<ComodidadHabitacion> attachedComodidadHabitacionListNew = new ArrayList<ComodidadHabitacion>();
            for (ComodidadHabitacion comodidadHabitacionListNewComodidadHabitacionToAttach : comodidadHabitacionListNew) {
                comodidadHabitacionListNewComodidadHabitacionToAttach = em.getReference(comodidadHabitacionListNewComodidadHabitacionToAttach.getClass(), comodidadHabitacionListNewComodidadHabitacionToAttach.getId());
                attachedComodidadHabitacionListNew.add(comodidadHabitacionListNewComodidadHabitacionToAttach);
            }
            comodidadHabitacionListNew = attachedComodidadHabitacionListNew;
            habitacion.setComodidadHabitacionList(comodidadHabitacionListNew);
            List<Reserva> attachedReservaListNew = new ArrayList<Reserva>();
            for (Reserva reservaListNewReservaToAttach : reservaListNew) {
                reservaListNewReservaToAttach = em.getReference(reservaListNewReservaToAttach.getClass(), reservaListNewReservaToAttach.getId());
                attachedReservaListNew.add(reservaListNewReservaToAttach);
            }
            reservaListNew = attachedReservaListNew;
            habitacion.setReservaList(reservaListNew);
            habitacion = em.merge(habitacion);
            if (idHotelHabOld != null && !idHotelHabOld.equals(idHotelHabNew)) {
                idHotelHabOld.getHabitacionList().remove(habitacion);
                idHotelHabOld = em.merge(idHotelHabOld);
            }
            if (idHotelHabNew != null && !idHotelHabNew.equals(idHotelHabOld)) {
                idHotelHabNew.getHabitacionList().add(habitacion);
                idHotelHabNew = em.merge(idHotelHabNew);
            }
            if (idTipoHabOld != null && !idTipoHabOld.equals(idTipoHabNew)) {
                idTipoHabOld.getHabitacionList().remove(habitacion);
                idTipoHabOld = em.merge(idTipoHabOld);
            }
            if (idTipoHabNew != null && !idTipoHabNew.equals(idTipoHabOld)) {
                idTipoHabNew.getHabitacionList().add(habitacion);
                idTipoHabNew = em.merge(idTipoHabNew);
            }
            for (ComodidadHabitacion comodidadHabitacionListOldComodidadHabitacion : comodidadHabitacionListOld) {
                if (!comodidadHabitacionListNew.contains(comodidadHabitacionListOldComodidadHabitacion)) {
                    comodidadHabitacionListOldComodidadHabitacion.setIdHabitacion(null);
                    comodidadHabitacionListOldComodidadHabitacion = em.merge(comodidadHabitacionListOldComodidadHabitacion);
                }
            }
            for (ComodidadHabitacion comodidadHabitacionListNewComodidadHabitacion : comodidadHabitacionListNew) {
                if (!comodidadHabitacionListOld.contains(comodidadHabitacionListNewComodidadHabitacion)) {
                    Habitacion oldIdHabitacionOfComodidadHabitacionListNewComodidadHabitacion = comodidadHabitacionListNewComodidadHabitacion.getIdHabitacion();
                    comodidadHabitacionListNewComodidadHabitacion.setIdHabitacion(habitacion);
                    comodidadHabitacionListNewComodidadHabitacion = em.merge(comodidadHabitacionListNewComodidadHabitacion);
                    if (oldIdHabitacionOfComodidadHabitacionListNewComodidadHabitacion != null && !oldIdHabitacionOfComodidadHabitacionListNewComodidadHabitacion.equals(habitacion)) {
                        oldIdHabitacionOfComodidadHabitacionListNewComodidadHabitacion.getComodidadHabitacionList().remove(comodidadHabitacionListNewComodidadHabitacion);
                        oldIdHabitacionOfComodidadHabitacionListNewComodidadHabitacion = em.merge(oldIdHabitacionOfComodidadHabitacionListNewComodidadHabitacion);
                    }
                }
            }
            for (Reserva reservaListOldReserva : reservaListOld) {
                if (!reservaListNew.contains(reservaListOldReserva)) {
                    reservaListOldReserva.setIdHabit(null);
                    reservaListOldReserva = em.merge(reservaListOldReserva);
                }
            }
            for (Reserva reservaListNewReserva : reservaListNew) {
                if (!reservaListOld.contains(reservaListNewReserva)) {
                    Habitacion oldIdHabitOfReservaListNewReserva = reservaListNewReserva.getIdHabit();
                    reservaListNewReserva.setIdHabit(habitacion);
                    reservaListNewReserva = em.merge(reservaListNewReserva);
                    if (oldIdHabitOfReservaListNewReserva != null && !oldIdHabitOfReservaListNewReserva.equals(habitacion)) {
                        oldIdHabitOfReservaListNewReserva.getReservaList().remove(reservaListNewReserva);
                        oldIdHabitOfReservaListNewReserva = em.merge(oldIdHabitOfReservaListNewReserva);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = habitacion.getId();
                if (findHabitacion(id) == null) {
                    throw new NonexistentEntityException("The habitacion with id " + id + " no longer exists.");
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
            Habitacion habitacion;
            try {
                habitacion = em.getReference(Habitacion.class, id);
                habitacion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The habitacion with id " + id + " no longer exists.", enfe);
            }
            Hotel idHotelHab = habitacion.getIdHotelHab();
            if (idHotelHab != null) {
                idHotelHab.getHabitacionList().remove(habitacion);
                idHotelHab = em.merge(idHotelHab);
            }
            TipoHabitacion idTipoHab = habitacion.getIdTipoHab();
            if (idTipoHab != null) {
                idTipoHab.getHabitacionList().remove(habitacion);
                idTipoHab = em.merge(idTipoHab);
            }
            List<ComodidadHabitacion> comodidadHabitacionList = habitacion.getComodidadHabitacionList();
            for (ComodidadHabitacion comodidadHabitacionListComodidadHabitacion : comodidadHabitacionList) {
                comodidadHabitacionListComodidadHabitacion.setIdHabitacion(null);
                comodidadHabitacionListComodidadHabitacion = em.merge(comodidadHabitacionListComodidadHabitacion);
            }
            List<Reserva> reservaList = habitacion.getReservaList();
            for (Reserva reservaListReserva : reservaList) {
                reservaListReserva.setIdHabit(null);
                reservaListReserva = em.merge(reservaListReserva);
            }
            em.remove(habitacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Habitacion> findHabitacionEntities() {
        return findHabitacionEntities(true, -1, -1);
    }

    public List<Habitacion> findHabitacionEntities(int maxResults, int firstResult) {
        return findHabitacionEntities(false, maxResults, firstResult);
    }

    private List<Habitacion> findHabitacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Habitacion.class));
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

    public Habitacion findHabitacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Habitacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getHabitacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Habitacion> rt = cq.from(Habitacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
