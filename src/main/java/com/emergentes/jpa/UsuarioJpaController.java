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
import com.emergentes.entities.Rol;
import com.emergentes.entities.TipoHabitacion;
import java.util.ArrayList;
import java.util.List;
import com.emergentes.entities.Favorito;
import com.emergentes.entities.Hotel;
import com.emergentes.entities.Reserva;
import com.emergentes.entities.Usuario;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Ronaldo
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        if (usuario.getTipoHabitacionList() == null) {
            usuario.setTipoHabitacionList(new ArrayList<TipoHabitacion>());
        }
        if (usuario.getFavoritoList() == null) {
            usuario.setFavoritoList(new ArrayList<Favorito>());
        }
        if (usuario.getHotelList() == null) {
            usuario.setHotelList(new ArrayList<Hotel>());
        }
        if (usuario.getReservaList() == null) {
            usuario.setReservaList(new ArrayList<Reserva>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rol idRol = usuario.getIdRol();
            if (idRol != null) {
                idRol = em.getReference(idRol.getClass(), idRol.getId());
                usuario.setIdRol(idRol);
            }
            List<TipoHabitacion> attachedTipoHabitacionList = new ArrayList<TipoHabitacion>();
            for (TipoHabitacion tipoHabitacionListTipoHabitacionToAttach : usuario.getTipoHabitacionList()) {
                tipoHabitacionListTipoHabitacionToAttach = em.getReference(tipoHabitacionListTipoHabitacionToAttach.getClass(), tipoHabitacionListTipoHabitacionToAttach.getId());
                attachedTipoHabitacionList.add(tipoHabitacionListTipoHabitacionToAttach);
            }
            usuario.setTipoHabitacionList(attachedTipoHabitacionList);
            List<Favorito> attachedFavoritoList = new ArrayList<Favorito>();
            for (Favorito favoritoListFavoritoToAttach : usuario.getFavoritoList()) {
                favoritoListFavoritoToAttach = em.getReference(favoritoListFavoritoToAttach.getClass(), favoritoListFavoritoToAttach.getId());
                attachedFavoritoList.add(favoritoListFavoritoToAttach);
            }
            usuario.setFavoritoList(attachedFavoritoList);
            List<Hotel> attachedHotelList = new ArrayList<Hotel>();
            for (Hotel hotelListHotelToAttach : usuario.getHotelList()) {
                hotelListHotelToAttach = em.getReference(hotelListHotelToAttach.getClass(), hotelListHotelToAttach.getId());
                attachedHotelList.add(hotelListHotelToAttach);
            }
            usuario.setHotelList(attachedHotelList);
            List<Reserva> attachedReservaList = new ArrayList<Reserva>();
            for (Reserva reservaListReservaToAttach : usuario.getReservaList()) {
                reservaListReservaToAttach = em.getReference(reservaListReservaToAttach.getClass(), reservaListReservaToAttach.getId());
                attachedReservaList.add(reservaListReservaToAttach);
            }
            usuario.setReservaList(attachedReservaList);
            em.persist(usuario);
            if (idRol != null) {
                idRol.getUsuarioList().add(usuario);
                idRol = em.merge(idRol);
            }
            for (TipoHabitacion tipoHabitacionListTipoHabitacion : usuario.getTipoHabitacionList()) {
                Usuario oldIdUsuarioOfTipoHabitacionListTipoHabitacion = tipoHabitacionListTipoHabitacion.getIdUsuario();
                tipoHabitacionListTipoHabitacion.setIdUsuario(usuario);
                tipoHabitacionListTipoHabitacion = em.merge(tipoHabitacionListTipoHabitacion);
                if (oldIdUsuarioOfTipoHabitacionListTipoHabitacion != null) {
                    oldIdUsuarioOfTipoHabitacionListTipoHabitacion.getTipoHabitacionList().remove(tipoHabitacionListTipoHabitacion);
                    oldIdUsuarioOfTipoHabitacionListTipoHabitacion = em.merge(oldIdUsuarioOfTipoHabitacionListTipoHabitacion);
                }
            }
            for (Favorito favoritoListFavorito : usuario.getFavoritoList()) {
                Usuario oldIdUsuarioOfFavoritoListFavorito = favoritoListFavorito.getIdUsuario();
                favoritoListFavorito.setIdUsuario(usuario);
                favoritoListFavorito = em.merge(favoritoListFavorito);
                if (oldIdUsuarioOfFavoritoListFavorito != null) {
                    oldIdUsuarioOfFavoritoListFavorito.getFavoritoList().remove(favoritoListFavorito);
                    oldIdUsuarioOfFavoritoListFavorito = em.merge(oldIdUsuarioOfFavoritoListFavorito);
                }
            }
            for (Hotel hotelListHotel : usuario.getHotelList()) {
                Usuario oldIdUserOfHotelListHotel = hotelListHotel.getIdUser();
                hotelListHotel.setIdUser(usuario);
                hotelListHotel = em.merge(hotelListHotel);
                if (oldIdUserOfHotelListHotel != null) {
                    oldIdUserOfHotelListHotel.getHotelList().remove(hotelListHotel);
                    oldIdUserOfHotelListHotel = em.merge(oldIdUserOfHotelListHotel);
                }
            }
            for (Reserva reservaListReserva : usuario.getReservaList()) {
                Usuario oldIdUsuarioOfReservaListReserva = reservaListReserva.getIdUsuario();
                reservaListReserva.setIdUsuario(usuario);
                reservaListReserva = em.merge(reservaListReserva);
                if (oldIdUsuarioOfReservaListReserva != null) {
                    oldIdUsuarioOfReservaListReserva.getReservaList().remove(reservaListReserva);
                    oldIdUsuarioOfReservaListReserva = em.merge(oldIdUsuarioOfReservaListReserva);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getId());
            Rol idRolOld = persistentUsuario.getIdRol();
            Rol idRolNew = usuario.getIdRol();
            List<TipoHabitacion> tipoHabitacionListOld = persistentUsuario.getTipoHabitacionList();
            List<TipoHabitacion> tipoHabitacionListNew = usuario.getTipoHabitacionList();
            List<Favorito> favoritoListOld = persistentUsuario.getFavoritoList();
            List<Favorito> favoritoListNew = usuario.getFavoritoList();
            List<Hotel> hotelListOld = persistentUsuario.getHotelList();
            List<Hotel> hotelListNew = usuario.getHotelList();
            List<Reserva> reservaListOld = persistentUsuario.getReservaList();
            List<Reserva> reservaListNew = usuario.getReservaList();
            if (idRolNew != null) {
                idRolNew = em.getReference(idRolNew.getClass(), idRolNew.getId());
                usuario.setIdRol(idRolNew);
            }
            List<TipoHabitacion> attachedTipoHabitacionListNew = new ArrayList<TipoHabitacion>();
            for (TipoHabitacion tipoHabitacionListNewTipoHabitacionToAttach : tipoHabitacionListNew) {
                tipoHabitacionListNewTipoHabitacionToAttach = em.getReference(tipoHabitacionListNewTipoHabitacionToAttach.getClass(), tipoHabitacionListNewTipoHabitacionToAttach.getId());
                attachedTipoHabitacionListNew.add(tipoHabitacionListNewTipoHabitacionToAttach);
            }
            tipoHabitacionListNew = attachedTipoHabitacionListNew;
            usuario.setTipoHabitacionList(tipoHabitacionListNew);
            List<Favorito> attachedFavoritoListNew = new ArrayList<Favorito>();
            for (Favorito favoritoListNewFavoritoToAttach : favoritoListNew) {
                favoritoListNewFavoritoToAttach = em.getReference(favoritoListNewFavoritoToAttach.getClass(), favoritoListNewFavoritoToAttach.getId());
                attachedFavoritoListNew.add(favoritoListNewFavoritoToAttach);
            }
            favoritoListNew = attachedFavoritoListNew;
            usuario.setFavoritoList(favoritoListNew);
            List<Hotel> attachedHotelListNew = new ArrayList<Hotel>();
            for (Hotel hotelListNewHotelToAttach : hotelListNew) {
                hotelListNewHotelToAttach = em.getReference(hotelListNewHotelToAttach.getClass(), hotelListNewHotelToAttach.getId());
                attachedHotelListNew.add(hotelListNewHotelToAttach);
            }
            hotelListNew = attachedHotelListNew;
            usuario.setHotelList(hotelListNew);
            List<Reserva> attachedReservaListNew = new ArrayList<Reserva>();
            for (Reserva reservaListNewReservaToAttach : reservaListNew) {
                reservaListNewReservaToAttach = em.getReference(reservaListNewReservaToAttach.getClass(), reservaListNewReservaToAttach.getId());
                attachedReservaListNew.add(reservaListNewReservaToAttach);
            }
            reservaListNew = attachedReservaListNew;
            usuario.setReservaList(reservaListNew);
            usuario = em.merge(usuario);
            if (idRolOld != null && !idRolOld.equals(idRolNew)) {
                idRolOld.getUsuarioList().remove(usuario);
                idRolOld = em.merge(idRolOld);
            }
            if (idRolNew != null && !idRolNew.equals(idRolOld)) {
                idRolNew.getUsuarioList().add(usuario);
                idRolNew = em.merge(idRolNew);
            }
            for (TipoHabitacion tipoHabitacionListOldTipoHabitacion : tipoHabitacionListOld) {
                if (!tipoHabitacionListNew.contains(tipoHabitacionListOldTipoHabitacion)) {
                    tipoHabitacionListOldTipoHabitacion.setIdUsuario(null);
                    tipoHabitacionListOldTipoHabitacion = em.merge(tipoHabitacionListOldTipoHabitacion);
                }
            }
            for (TipoHabitacion tipoHabitacionListNewTipoHabitacion : tipoHabitacionListNew) {
                if (!tipoHabitacionListOld.contains(tipoHabitacionListNewTipoHabitacion)) {
                    Usuario oldIdUsuarioOfTipoHabitacionListNewTipoHabitacion = tipoHabitacionListNewTipoHabitacion.getIdUsuario();
                    tipoHabitacionListNewTipoHabitacion.setIdUsuario(usuario);
                    tipoHabitacionListNewTipoHabitacion = em.merge(tipoHabitacionListNewTipoHabitacion);
                    if (oldIdUsuarioOfTipoHabitacionListNewTipoHabitacion != null && !oldIdUsuarioOfTipoHabitacionListNewTipoHabitacion.equals(usuario)) {
                        oldIdUsuarioOfTipoHabitacionListNewTipoHabitacion.getTipoHabitacionList().remove(tipoHabitacionListNewTipoHabitacion);
                        oldIdUsuarioOfTipoHabitacionListNewTipoHabitacion = em.merge(oldIdUsuarioOfTipoHabitacionListNewTipoHabitacion);
                    }
                }
            }
            for (Favorito favoritoListOldFavorito : favoritoListOld) {
                if (!favoritoListNew.contains(favoritoListOldFavorito)) {
                    favoritoListOldFavorito.setIdUsuario(null);
                    favoritoListOldFavorito = em.merge(favoritoListOldFavorito);
                }
            }
            for (Favorito favoritoListNewFavorito : favoritoListNew) {
                if (!favoritoListOld.contains(favoritoListNewFavorito)) {
                    Usuario oldIdUsuarioOfFavoritoListNewFavorito = favoritoListNewFavorito.getIdUsuario();
                    favoritoListNewFavorito.setIdUsuario(usuario);
                    favoritoListNewFavorito = em.merge(favoritoListNewFavorito);
                    if (oldIdUsuarioOfFavoritoListNewFavorito != null && !oldIdUsuarioOfFavoritoListNewFavorito.equals(usuario)) {
                        oldIdUsuarioOfFavoritoListNewFavorito.getFavoritoList().remove(favoritoListNewFavorito);
                        oldIdUsuarioOfFavoritoListNewFavorito = em.merge(oldIdUsuarioOfFavoritoListNewFavorito);
                    }
                }
            }
            for (Hotel hotelListOldHotel : hotelListOld) {
                if (!hotelListNew.contains(hotelListOldHotel)) {
                    hotelListOldHotel.setIdUser(null);
                    hotelListOldHotel = em.merge(hotelListOldHotel);
                }
            }
            for (Hotel hotelListNewHotel : hotelListNew) {
                if (!hotelListOld.contains(hotelListNewHotel)) {
                    Usuario oldIdUserOfHotelListNewHotel = hotelListNewHotel.getIdUser();
                    hotelListNewHotel.setIdUser(usuario);
                    hotelListNewHotel = em.merge(hotelListNewHotel);
                    if (oldIdUserOfHotelListNewHotel != null && !oldIdUserOfHotelListNewHotel.equals(usuario)) {
                        oldIdUserOfHotelListNewHotel.getHotelList().remove(hotelListNewHotel);
                        oldIdUserOfHotelListNewHotel = em.merge(oldIdUserOfHotelListNewHotel);
                    }
                }
            }
            for (Reserva reservaListOldReserva : reservaListOld) {
                if (!reservaListNew.contains(reservaListOldReserva)) {
                    reservaListOldReserva.setIdUsuario(null);
                    reservaListOldReserva = em.merge(reservaListOldReserva);
                }
            }
            for (Reserva reservaListNewReserva : reservaListNew) {
                if (!reservaListOld.contains(reservaListNewReserva)) {
                    Usuario oldIdUsuarioOfReservaListNewReserva = reservaListNewReserva.getIdUsuario();
                    reservaListNewReserva.setIdUsuario(usuario);
                    reservaListNewReserva = em.merge(reservaListNewReserva);
                    if (oldIdUsuarioOfReservaListNewReserva != null && !oldIdUsuarioOfReservaListNewReserva.equals(usuario)) {
                        oldIdUsuarioOfReservaListNewReserva.getReservaList().remove(reservaListNewReserva);
                        oldIdUsuarioOfReservaListNewReserva = em.merge(oldIdUsuarioOfReservaListNewReserva);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuario.getId();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            Rol idRol = usuario.getIdRol();
            if (idRol != null) {
                idRol.getUsuarioList().remove(usuario);
                idRol = em.merge(idRol);
            }
            List<TipoHabitacion> tipoHabitacionList = usuario.getTipoHabitacionList();
            for (TipoHabitacion tipoHabitacionListTipoHabitacion : tipoHabitacionList) {
                tipoHabitacionListTipoHabitacion.setIdUsuario(null);
                tipoHabitacionListTipoHabitacion = em.merge(tipoHabitacionListTipoHabitacion);
            }
            List<Favorito> favoritoList = usuario.getFavoritoList();
            for (Favorito favoritoListFavorito : favoritoList) {
                favoritoListFavorito.setIdUsuario(null);
                favoritoListFavorito = em.merge(favoritoListFavorito);
            }
            List<Hotel> hotelList = usuario.getHotelList();
            for (Hotel hotelListHotel : hotelList) {
                hotelListHotel.setIdUser(null);
                hotelListHotel = em.merge(hotelListHotel);
            }
            List<Reserva> reservaList = usuario.getReservaList();
            for (Reserva reservaListReserva : reservaList) {
                reservaListReserva.setIdUsuario(null);
                reservaListReserva = em.merge(reservaListReserva);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
