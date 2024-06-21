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
import com.emergentes.entities.Usuario;
import com.emergentes.entities.Habitacion;
import com.emergentes.entities.Reserva;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Ronaldo
 */
public class ReservaJpaController implements Serializable {

    public ReservaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Reserva reserva) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario idUsuario = reserva.getIdUsuario();
            if (idUsuario != null) {
                idUsuario = em.getReference(idUsuario.getClass(), idUsuario.getId());
                reserva.setIdUsuario(idUsuario);
            }
            Habitacion idHabit = reserva.getIdHabit();
            if (idHabit != null) {
                idHabit = em.getReference(idHabit.getClass(), idHabit.getId());
                reserva.setIdHabit(idHabit);
            }
            em.persist(reserva);
            if (idUsuario != null) {
                idUsuario.getReservaList().add(reserva);
                idUsuario = em.merge(idUsuario);
            }
            if (idHabit != null) {
                idHabit.getReservaList().add(reserva);
                idHabit = em.merge(idHabit);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reserva reserva) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reserva persistentReserva = em.find(Reserva.class, reserva.getId());
            Usuario idUsuarioOld = persistentReserva.getIdUsuario();
            Usuario idUsuarioNew = reserva.getIdUsuario();
            Habitacion idHabitOld = persistentReserva.getIdHabit();
            Habitacion idHabitNew = reserva.getIdHabit();
            if (idUsuarioNew != null) {
                idUsuarioNew = em.getReference(idUsuarioNew.getClass(), idUsuarioNew.getId());
                reserva.setIdUsuario(idUsuarioNew);
            }
            if (idHabitNew != null) {
                idHabitNew = em.getReference(idHabitNew.getClass(), idHabitNew.getId());
                reserva.setIdHabit(idHabitNew);
            }
            reserva = em.merge(reserva);
            if (idUsuarioOld != null && !idUsuarioOld.equals(idUsuarioNew)) {
                idUsuarioOld.getReservaList().remove(reserva);
                idUsuarioOld = em.merge(idUsuarioOld);
            }
            if (idUsuarioNew != null && !idUsuarioNew.equals(idUsuarioOld)) {
                idUsuarioNew.getReservaList().add(reserva);
                idUsuarioNew = em.merge(idUsuarioNew);
            }
            if (idHabitOld != null && !idHabitOld.equals(idHabitNew)) {
                idHabitOld.getReservaList().remove(reserva);
                idHabitOld = em.merge(idHabitOld);
            }
            if (idHabitNew != null && !idHabitNew.equals(idHabitOld)) {
                idHabitNew.getReservaList().add(reserva);
                idHabitNew = em.merge(idHabitNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = reserva.getId();
                if (findReserva(id) == null) {
                    throw new NonexistentEntityException("The reserva with id " + id + " no longer exists.");
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
            Reserva reserva;
            try {
                reserva = em.getReference(Reserva.class, id);
                reserva.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reserva with id " + id + " no longer exists.", enfe);
            }
            Usuario idUsuario = reserva.getIdUsuario();
            if (idUsuario != null) {
                idUsuario.getReservaList().remove(reserva);
                idUsuario = em.merge(idUsuario);
            }
            Habitacion idHabit = reserva.getIdHabit();
            if (idHabit != null) {
                idHabit.getReservaList().remove(reserva);
                idHabit = em.merge(idHabit);
            }
            em.remove(reserva);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reserva> findReservaEntities() {
        return findReservaEntities(true, -1, -1);
    }

    public List<Reserva> findReservaEntities(int maxResults, int firstResult) {
        return findReservaEntities(false, maxResults, firstResult);
    }

    private List<Reserva> findReservaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reserva.class));
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

    public Reserva findReserva(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reserva.class, id);
        } finally {
            em.close();
        }
    }

    public int getReservaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reserva> rt = cq.from(Reserva.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
