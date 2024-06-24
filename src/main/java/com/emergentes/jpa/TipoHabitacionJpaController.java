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
import com.emergentes.entities.Oferta;
import java.util.ArrayList;
import java.util.List;
import com.emergentes.entities.Habitacion;
import com.emergentes.entities.TipoHabitacion;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Ronaldo
 */
public class TipoHabitacionJpaController implements Serializable {

    public TipoHabitacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoHabitacion tipoHabitacion) {
        if (tipoHabitacion.getOfertaList() == null) {
            tipoHabitacion.setOfertaList(new ArrayList<Oferta>());
        }
        if (tipoHabitacion.getHabitacionList() == null) {
            tipoHabitacion.setHabitacionList(new ArrayList<Habitacion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario idUsuario = tipoHabitacion.getIdUsuario();
            if (idUsuario != null) {
                idUsuario = em.getReference(idUsuario.getClass(), idUsuario.getId());
                tipoHabitacion.setIdUsuario(idUsuario);
            }
            List<Oferta> attachedOfertaList = new ArrayList<Oferta>();
            for (Oferta ofertaListOfertaToAttach : tipoHabitacion.getOfertaList()) {
                ofertaListOfertaToAttach = em.getReference(ofertaListOfertaToAttach.getClass(), ofertaListOfertaToAttach.getId());
                attachedOfertaList.add(ofertaListOfertaToAttach);
            }
            tipoHabitacion.setOfertaList(attachedOfertaList);
            List<Habitacion> attachedHabitacionList = new ArrayList<Habitacion>();
            for (Habitacion habitacionListHabitacionToAttach : tipoHabitacion.getHabitacionList()) {
                habitacionListHabitacionToAttach = em.getReference(habitacionListHabitacionToAttach.getClass(), habitacionListHabitacionToAttach.getId());
                attachedHabitacionList.add(habitacionListHabitacionToAttach);
            }
            tipoHabitacion.setHabitacionList(attachedHabitacionList);
            em.persist(tipoHabitacion);
            if (idUsuario != null) {
                idUsuario.getTipoHabitacionList().add(tipoHabitacion);
                idUsuario = em.merge(idUsuario);
            }
            for (Oferta ofertaListOferta : tipoHabitacion.getOfertaList()) {
                TipoHabitacion oldIdTipoHabitacionOfOfertaListOferta = ofertaListOferta.getIdTipoHabitacion();
                ofertaListOferta.setIdTipoHabitacion(tipoHabitacion);
                ofertaListOferta = em.merge(ofertaListOferta);
                if (oldIdTipoHabitacionOfOfertaListOferta != null) {
                    oldIdTipoHabitacionOfOfertaListOferta.getOfertaList().remove(ofertaListOferta);
                    oldIdTipoHabitacionOfOfertaListOferta = em.merge(oldIdTipoHabitacionOfOfertaListOferta);
                }
            }
            for (Habitacion habitacionListHabitacion : tipoHabitacion.getHabitacionList()) {
                TipoHabitacion oldIdTipoHabOfHabitacionListHabitacion = habitacionListHabitacion.getIdTipoHab();
                habitacionListHabitacion.setIdTipoHab(tipoHabitacion);
                habitacionListHabitacion = em.merge(habitacionListHabitacion);
                if (oldIdTipoHabOfHabitacionListHabitacion != null) {
                    oldIdTipoHabOfHabitacionListHabitacion.getHabitacionList().remove(habitacionListHabitacion);
                    oldIdTipoHabOfHabitacionListHabitacion = em.merge(oldIdTipoHabOfHabitacionListHabitacion);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoHabitacion tipoHabitacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoHabitacion persistentTipoHabitacion = em.find(TipoHabitacion.class, tipoHabitacion.getId());
            Usuario idUsuarioOld = persistentTipoHabitacion.getIdUsuario();
            Usuario idUsuarioNew = tipoHabitacion.getIdUsuario();
            List<Oferta> ofertaListOld = persistentTipoHabitacion.getOfertaList();
            List<Oferta> ofertaListNew = tipoHabitacion.getOfertaList();
            List<Habitacion> habitacionListOld = persistentTipoHabitacion.getHabitacionList();
            List<Habitacion> habitacionListNew = tipoHabitacion.getHabitacionList();
            if (idUsuarioNew != null) {
                idUsuarioNew = em.getReference(idUsuarioNew.getClass(), idUsuarioNew.getId());
                tipoHabitacion.setIdUsuario(idUsuarioNew);
            }
            List<Oferta> attachedOfertaListNew = new ArrayList<Oferta>();
            for (Oferta ofertaListNewOfertaToAttach : ofertaListNew) {
                ofertaListNewOfertaToAttach = em.getReference(ofertaListNewOfertaToAttach.getClass(), ofertaListNewOfertaToAttach.getId());
                attachedOfertaListNew.add(ofertaListNewOfertaToAttach);
            }
            ofertaListNew = attachedOfertaListNew;
            tipoHabitacion.setOfertaList(ofertaListNew);
            List<Habitacion> attachedHabitacionListNew = new ArrayList<Habitacion>();
            for (Habitacion habitacionListNewHabitacionToAttach : habitacionListNew) {
                habitacionListNewHabitacionToAttach = em.getReference(habitacionListNewHabitacionToAttach.getClass(), habitacionListNewHabitacionToAttach.getId());
                attachedHabitacionListNew.add(habitacionListNewHabitacionToAttach);
            }
            habitacionListNew = attachedHabitacionListNew;
            tipoHabitacion.setHabitacionList(habitacionListNew);
            tipoHabitacion = em.merge(tipoHabitacion);
            if (idUsuarioOld != null && !idUsuarioOld.equals(idUsuarioNew)) {
                idUsuarioOld.getTipoHabitacionList().remove(tipoHabitacion);
                idUsuarioOld = em.merge(idUsuarioOld);
            }
            if (idUsuarioNew != null && !idUsuarioNew.equals(idUsuarioOld)) {
                idUsuarioNew.getTipoHabitacionList().add(tipoHabitacion);
                idUsuarioNew = em.merge(idUsuarioNew);
            }
            for (Oferta ofertaListOldOferta : ofertaListOld) {
                if (!ofertaListNew.contains(ofertaListOldOferta)) {
                    ofertaListOldOferta.setIdTipoHabitacion(null);
                    ofertaListOldOferta = em.merge(ofertaListOldOferta);
                }
            }
            for (Oferta ofertaListNewOferta : ofertaListNew) {
                if (!ofertaListOld.contains(ofertaListNewOferta)) {
                    TipoHabitacion oldIdTipoHabitacionOfOfertaListNewOferta = ofertaListNewOferta.getIdTipoHabitacion();
                    ofertaListNewOferta.setIdTipoHabitacion(tipoHabitacion);
                    ofertaListNewOferta = em.merge(ofertaListNewOferta);
                    if (oldIdTipoHabitacionOfOfertaListNewOferta != null && !oldIdTipoHabitacionOfOfertaListNewOferta.equals(tipoHabitacion)) {
                        oldIdTipoHabitacionOfOfertaListNewOferta.getOfertaList().remove(ofertaListNewOferta);
                        oldIdTipoHabitacionOfOfertaListNewOferta = em.merge(oldIdTipoHabitacionOfOfertaListNewOferta);
                    }
                }
            }
            for (Habitacion habitacionListOldHabitacion : habitacionListOld) {
                if (!habitacionListNew.contains(habitacionListOldHabitacion)) {
                    habitacionListOldHabitacion.setIdTipoHab(null);
                    habitacionListOldHabitacion = em.merge(habitacionListOldHabitacion);
                }
            }
            for (Habitacion habitacionListNewHabitacion : habitacionListNew) {
                if (!habitacionListOld.contains(habitacionListNewHabitacion)) {
                    TipoHabitacion oldIdTipoHabOfHabitacionListNewHabitacion = habitacionListNewHabitacion.getIdTipoHab();
                    habitacionListNewHabitacion.setIdTipoHab(tipoHabitacion);
                    habitacionListNewHabitacion = em.merge(habitacionListNewHabitacion);
                    if (oldIdTipoHabOfHabitacionListNewHabitacion != null && !oldIdTipoHabOfHabitacionListNewHabitacion.equals(tipoHabitacion)) {
                        oldIdTipoHabOfHabitacionListNewHabitacion.getHabitacionList().remove(habitacionListNewHabitacion);
                        oldIdTipoHabOfHabitacionListNewHabitacion = em.merge(oldIdTipoHabOfHabitacionListNewHabitacion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tipoHabitacion.getId();
                if (findTipoHabitacion(id) == null) {
                    throw new NonexistentEntityException("The tipoHabitacion with id " + id + " no longer exists.");
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
            TipoHabitacion tipoHabitacion;
            try {
                tipoHabitacion = em.getReference(TipoHabitacion.class, id);
                tipoHabitacion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoHabitacion with id " + id + " no longer exists.", enfe);
            }
            Usuario idUsuario = tipoHabitacion.getIdUsuario();
            if (idUsuario != null) {
                idUsuario.getTipoHabitacionList().remove(tipoHabitacion);
                idUsuario = em.merge(idUsuario);
            }
            List<Oferta> ofertaList = tipoHabitacion.getOfertaList();
            for (Oferta ofertaListOferta : ofertaList) {
                ofertaListOferta.setIdTipoHabitacion(null);
                ofertaListOferta = em.merge(ofertaListOferta);
            }
            List<Habitacion> habitacionList = tipoHabitacion.getHabitacionList();
            for (Habitacion habitacionListHabitacion : habitacionList) {
                habitacionListHabitacion.setIdTipoHab(null);
                habitacionListHabitacion = em.merge(habitacionListHabitacion);
            }
            em.remove(tipoHabitacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoHabitacion> findTipoHabitacionEntities() {
        return findTipoHabitacionEntities(true, -1, -1);
    }

    public List<TipoHabitacion> findTipoHabitacionEntities(int maxResults, int firstResult) {
        return findTipoHabitacionEntities(false, maxResults, firstResult);
    }

    private List<TipoHabitacion> findTipoHabitacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoHabitacion.class));
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

    public TipoHabitacion findTipoHabitacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoHabitacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoHabitacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoHabitacion> rt = cq.from(TipoHabitacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
