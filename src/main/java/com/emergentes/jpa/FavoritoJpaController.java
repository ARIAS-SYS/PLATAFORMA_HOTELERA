/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.jpa;

import com.emergentes.entities.Favorito;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.emergentes.entities.Usuario;
import com.emergentes.entities.Hotel;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Ronaldo
 */
public class FavoritoJpaController implements Serializable {

    public FavoritoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Favorito favorito) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario idUsuario = favorito.getIdUsuario();
            if (idUsuario != null) {
                idUsuario = em.getReference(idUsuario.getClass(), idUsuario.getId());
                favorito.setIdUsuario(idUsuario);
            }
            Hotel idHotel = favorito.getIdHotel();
            if (idHotel != null) {
                idHotel = em.getReference(idHotel.getClass(), idHotel.getId());
                favorito.setIdHotel(idHotel);
            }
            em.persist(favorito);
            if (idUsuario != null) {
                idUsuario.getFavoritoList().add(favorito);
                idUsuario = em.merge(idUsuario);
            }
            if (idHotel != null) {
                idHotel.getFavoritoList().add(favorito);
                idHotel = em.merge(idHotel);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Favorito favorito) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Favorito persistentFavorito = em.find(Favorito.class, favorito.getId());
            Usuario idUsuarioOld = persistentFavorito.getIdUsuario();
            Usuario idUsuarioNew = favorito.getIdUsuario();
            Hotel idHotelOld = persistentFavorito.getIdHotel();
            Hotel idHotelNew = favorito.getIdHotel();
            if (idUsuarioNew != null) {
                idUsuarioNew = em.getReference(idUsuarioNew.getClass(), idUsuarioNew.getId());
                favorito.setIdUsuario(idUsuarioNew);
            }
            if (idHotelNew != null) {
                idHotelNew = em.getReference(idHotelNew.getClass(), idHotelNew.getId());
                favorito.setIdHotel(idHotelNew);
            }
            favorito = em.merge(favorito);
            if (idUsuarioOld != null && !idUsuarioOld.equals(idUsuarioNew)) {
                idUsuarioOld.getFavoritoList().remove(favorito);
                idUsuarioOld = em.merge(idUsuarioOld);
            }
            if (idUsuarioNew != null && !idUsuarioNew.equals(idUsuarioOld)) {
                idUsuarioNew.getFavoritoList().add(favorito);
                idUsuarioNew = em.merge(idUsuarioNew);
            }
            if (idHotelOld != null && !idHotelOld.equals(idHotelNew)) {
                idHotelOld.getFavoritoList().remove(favorito);
                idHotelOld = em.merge(idHotelOld);
            }
            if (idHotelNew != null && !idHotelNew.equals(idHotelOld)) {
                idHotelNew.getFavoritoList().add(favorito);
                idHotelNew = em.merge(idHotelNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = favorito.getId();
                if (findFavorito(id) == null) {
                    throw new NonexistentEntityException("The favorito with id " + id + " no longer exists.");
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
            Favorito favorito;
            try {
                favorito = em.getReference(Favorito.class, id);
                favorito.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The favorito with id " + id + " no longer exists.", enfe);
            }
            Usuario idUsuario = favorito.getIdUsuario();
            if (idUsuario != null) {
                idUsuario.getFavoritoList().remove(favorito);
                idUsuario = em.merge(idUsuario);
            }
            Hotel idHotel = favorito.getIdHotel();
            if (idHotel != null) {
                idHotel.getFavoritoList().remove(favorito);
                idHotel = em.merge(idHotel);
            }
            em.remove(favorito);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Favorito> findFavoritoEntities() {
        return findFavoritoEntities(true, -1, -1);
    }

    public List<Favorito> findFavoritoEntities(int maxResults, int firstResult) {
        return findFavoritoEntities(false, maxResults, firstResult);
    }

    private List<Favorito> findFavoritoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Favorito.class));
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

    public Favorito findFavorito(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Favorito.class, id);
        } finally {
            em.close();
        }
    }

    public int getFavoritoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Favorito> rt = cq.from(Favorito.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
