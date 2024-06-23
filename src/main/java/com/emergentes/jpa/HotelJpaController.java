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
import com.emergentes.entities.Favorito;
import java.util.ArrayList;
import java.util.List;
import com.emergentes.entities.Oferta;
import com.emergentes.entities.Habitacion;
import com.emergentes.entities.Hotel;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Ronaldo
 */
public class HotelJpaController implements Serializable {

    public HotelJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Hotel hotel) {
        if (hotel.getFavoritoList() == null) {
            hotel.setFavoritoList(new ArrayList<Favorito>());
        }
        if (hotel.getOfertaList() == null) {
            hotel.setOfertaList(new ArrayList<Oferta>());
        }
        if (hotel.getHabitacionList() == null) {
            hotel.setHabitacionList(new ArrayList<Habitacion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario idUser = hotel.getIdUser();
            if (idUser != null) {
                idUser = em.getReference(idUser.getClass(), idUser.getId());
                hotel.setIdUser(idUser);
            }
            List<Favorito> attachedFavoritoList = new ArrayList<Favorito>();
            for (Favorito favoritoListFavoritoToAttach : hotel.getFavoritoList()) {
                favoritoListFavoritoToAttach = em.getReference(favoritoListFavoritoToAttach.getClass(), favoritoListFavoritoToAttach.getId());
                attachedFavoritoList.add(favoritoListFavoritoToAttach);
            }
            hotel.setFavoritoList(attachedFavoritoList);
            List<Oferta> attachedOfertaList = new ArrayList<Oferta>();
            for (Oferta ofertaListOfertaToAttach : hotel.getOfertaList()) {
                ofertaListOfertaToAttach = em.getReference(ofertaListOfertaToAttach.getClass(), ofertaListOfertaToAttach.getId());
                attachedOfertaList.add(ofertaListOfertaToAttach);
            }
            hotel.setOfertaList(attachedOfertaList);
            List<Habitacion> attachedHabitacionList = new ArrayList<Habitacion>();
            for (Habitacion habitacionListHabitacionToAttach : hotel.getHabitacionList()) {
                habitacionListHabitacionToAttach = em.getReference(habitacionListHabitacionToAttach.getClass(), habitacionListHabitacionToAttach.getId());
                attachedHabitacionList.add(habitacionListHabitacionToAttach);
            }
            hotel.setHabitacionList(attachedHabitacionList);
            em.persist(hotel);
            if (idUser != null) {
                idUser.getHotelList().add(hotel);
                idUser = em.merge(idUser);
            }
            for (Favorito favoritoListFavorito : hotel.getFavoritoList()) {
                Hotel oldIdHotelOfFavoritoListFavorito = favoritoListFavorito.getIdHotel();
                favoritoListFavorito.setIdHotel(hotel);
                favoritoListFavorito = em.merge(favoritoListFavorito);
                if (oldIdHotelOfFavoritoListFavorito != null) {
                    oldIdHotelOfFavoritoListFavorito.getFavoritoList().remove(favoritoListFavorito);
                    oldIdHotelOfFavoritoListFavorito = em.merge(oldIdHotelOfFavoritoListFavorito);
                }
            }
            for (Oferta ofertaListOferta : hotel.getOfertaList()) {
                Hotel oldIdHotelOfOfertaListOferta = ofertaListOferta.getIdHotel();
                ofertaListOferta.setIdHotel(hotel);
                ofertaListOferta = em.merge(ofertaListOferta);
                if (oldIdHotelOfOfertaListOferta != null) {
                    oldIdHotelOfOfertaListOferta.getOfertaList().remove(ofertaListOferta);
                    oldIdHotelOfOfertaListOferta = em.merge(oldIdHotelOfOfertaListOferta);
                }
            }
            for (Habitacion habitacionListHabitacion : hotel.getHabitacionList()) {
                Hotel oldIdHotelHabOfHabitacionListHabitacion = habitacionListHabitacion.getIdHotelHab();
                habitacionListHabitacion.setIdHotelHab(hotel);
                habitacionListHabitacion = em.merge(habitacionListHabitacion);
                if (oldIdHotelHabOfHabitacionListHabitacion != null) {
                    oldIdHotelHabOfHabitacionListHabitacion.getHabitacionList().remove(habitacionListHabitacion);
                    oldIdHotelHabOfHabitacionListHabitacion = em.merge(oldIdHotelHabOfHabitacionListHabitacion);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Hotel hotel) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Hotel persistentHotel = em.find(Hotel.class, hotel.getId());
            Usuario idUserOld = persistentHotel.getIdUser();
            Usuario idUserNew = hotel.getIdUser();
            List<Favorito> favoritoListOld = persistentHotel.getFavoritoList();
            List<Favorito> favoritoListNew = hotel.getFavoritoList();
            List<Oferta> ofertaListOld = persistentHotel.getOfertaList();
            List<Oferta> ofertaListNew = hotel.getOfertaList();
            List<Habitacion> habitacionListOld = persistentHotel.getHabitacionList();
            List<Habitacion> habitacionListNew = hotel.getHabitacionList();
            if (idUserNew != null) {
                idUserNew = em.getReference(idUserNew.getClass(), idUserNew.getId());
                hotel.setIdUser(idUserNew);
            }
            List<Favorito> attachedFavoritoListNew = new ArrayList<Favorito>();
            for (Favorito favoritoListNewFavoritoToAttach : favoritoListNew) {
                favoritoListNewFavoritoToAttach = em.getReference(favoritoListNewFavoritoToAttach.getClass(), favoritoListNewFavoritoToAttach.getId());
                attachedFavoritoListNew.add(favoritoListNewFavoritoToAttach);
            }
            favoritoListNew = attachedFavoritoListNew;
            hotel.setFavoritoList(favoritoListNew);
            List<Oferta> attachedOfertaListNew = new ArrayList<Oferta>();
            for (Oferta ofertaListNewOfertaToAttach : ofertaListNew) {
                ofertaListNewOfertaToAttach = em.getReference(ofertaListNewOfertaToAttach.getClass(), ofertaListNewOfertaToAttach.getId());
                attachedOfertaListNew.add(ofertaListNewOfertaToAttach);
            }
            ofertaListNew = attachedOfertaListNew;
            hotel.setOfertaList(ofertaListNew);
            List<Habitacion> attachedHabitacionListNew = new ArrayList<Habitacion>();
            for (Habitacion habitacionListNewHabitacionToAttach : habitacionListNew) {
                habitacionListNewHabitacionToAttach = em.getReference(habitacionListNewHabitacionToAttach.getClass(), habitacionListNewHabitacionToAttach.getId());
                attachedHabitacionListNew.add(habitacionListNewHabitacionToAttach);
            }
            habitacionListNew = attachedHabitacionListNew;
            hotel.setHabitacionList(habitacionListNew);
            hotel = em.merge(hotel);
            if (idUserOld != null && !idUserOld.equals(idUserNew)) {
                idUserOld.getHotelList().remove(hotel);
                idUserOld = em.merge(idUserOld);
            }
            if (idUserNew != null && !idUserNew.equals(idUserOld)) {
                idUserNew.getHotelList().add(hotel);
                idUserNew = em.merge(idUserNew);
            }
            for (Favorito favoritoListOldFavorito : favoritoListOld) {
                if (!favoritoListNew.contains(favoritoListOldFavorito)) {
                    favoritoListOldFavorito.setIdHotel(null);
                    favoritoListOldFavorito = em.merge(favoritoListOldFavorito);
                }
            }
            for (Favorito favoritoListNewFavorito : favoritoListNew) {
                if (!favoritoListOld.contains(favoritoListNewFavorito)) {
                    Hotel oldIdHotelOfFavoritoListNewFavorito = favoritoListNewFavorito.getIdHotel();
                    favoritoListNewFavorito.setIdHotel(hotel);
                    favoritoListNewFavorito = em.merge(favoritoListNewFavorito);
                    if (oldIdHotelOfFavoritoListNewFavorito != null && !oldIdHotelOfFavoritoListNewFavorito.equals(hotel)) {
                        oldIdHotelOfFavoritoListNewFavorito.getFavoritoList().remove(favoritoListNewFavorito);
                        oldIdHotelOfFavoritoListNewFavorito = em.merge(oldIdHotelOfFavoritoListNewFavorito);
                    }
                }
            }
            for (Oferta ofertaListOldOferta : ofertaListOld) {
                if (!ofertaListNew.contains(ofertaListOldOferta)) {
                    ofertaListOldOferta.setIdHotel(null);
                    ofertaListOldOferta = em.merge(ofertaListOldOferta);
                }
            }
            for (Oferta ofertaListNewOferta : ofertaListNew) {
                if (!ofertaListOld.contains(ofertaListNewOferta)) {
                    Hotel oldIdHotelOfOfertaListNewOferta = ofertaListNewOferta.getIdHotel();
                    ofertaListNewOferta.setIdHotel(hotel);
                    ofertaListNewOferta = em.merge(ofertaListNewOferta);
                    if (oldIdHotelOfOfertaListNewOferta != null && !oldIdHotelOfOfertaListNewOferta.equals(hotel)) {
                        oldIdHotelOfOfertaListNewOferta.getOfertaList().remove(ofertaListNewOferta);
                        oldIdHotelOfOfertaListNewOferta = em.merge(oldIdHotelOfOfertaListNewOferta);
                    }
                }
            }
            for (Habitacion habitacionListOldHabitacion : habitacionListOld) {
                if (!habitacionListNew.contains(habitacionListOldHabitacion)) {
                    habitacionListOldHabitacion.setIdHotelHab(null);
                    habitacionListOldHabitacion = em.merge(habitacionListOldHabitacion);
                }
            }
            for (Habitacion habitacionListNewHabitacion : habitacionListNew) {
                if (!habitacionListOld.contains(habitacionListNewHabitacion)) {
                    Hotel oldIdHotelHabOfHabitacionListNewHabitacion = habitacionListNewHabitacion.getIdHotelHab();
                    habitacionListNewHabitacion.setIdHotelHab(hotel);
                    habitacionListNewHabitacion = em.merge(habitacionListNewHabitacion);
                    if (oldIdHotelHabOfHabitacionListNewHabitacion != null && !oldIdHotelHabOfHabitacionListNewHabitacion.equals(hotel)) {
                        oldIdHotelHabOfHabitacionListNewHabitacion.getHabitacionList().remove(habitacionListNewHabitacion);
                        oldIdHotelHabOfHabitacionListNewHabitacion = em.merge(oldIdHotelHabOfHabitacionListNewHabitacion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = hotel.getId();
                if (findHotel(id) == null) {
                    throw new NonexistentEntityException("The hotel with id " + id + " no longer exists.");
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
            Hotel hotel;
            try {
                hotel = em.getReference(Hotel.class, id);
                hotel.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The hotel with id " + id + " no longer exists.", enfe);
            }
            Usuario idUser = hotel.getIdUser();
            if (idUser != null) {
                idUser.getHotelList().remove(hotel);
                idUser = em.merge(idUser);
            }
            List<Favorito> favoritoList = hotel.getFavoritoList();
            for (Favorito favoritoListFavorito : favoritoList) {
                favoritoListFavorito.setIdHotel(null);
                favoritoListFavorito = em.merge(favoritoListFavorito);
            }
            List<Oferta> ofertaList = hotel.getOfertaList();
            for (Oferta ofertaListOferta : ofertaList) {
                ofertaListOferta.setIdHotel(null);
                ofertaListOferta = em.merge(ofertaListOferta);
            }
            List<Habitacion> habitacionList = hotel.getHabitacionList();
            for (Habitacion habitacionListHabitacion : habitacionList) {
                habitacionListHabitacion.setIdHotelHab(null);
                habitacionListHabitacion = em.merge(habitacionListHabitacion);
            }
            em.remove(hotel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Hotel> findHotelEntities() {
        return findHotelEntities(true, -1, -1);
    }

    public List<Hotel> findHotelEntities(int maxResults, int firstResult) {
        return findHotelEntities(false, maxResults, firstResult);
    }

    private List<Hotel> findHotelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Hotel.class));
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

    public Hotel findHotel(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Hotel.class, id);
        } finally {
            em.close();
        }
    }

    public int getHotelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Hotel> rt = cq.from(Hotel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
