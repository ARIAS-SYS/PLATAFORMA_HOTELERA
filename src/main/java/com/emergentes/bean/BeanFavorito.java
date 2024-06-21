package com.emergentes.bean;

import com.emergentes.entities.Favorito;
import com.emergentes.jpa.FavoritoJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanFavorito {
    private EntityManagerFactory emf;
    private FavoritoJpaController jpaFavorito;

    public BeanFavorito () {
        this.emf = Persistence.createEntityManagerFactory("plataformaUP");
        this.jpaFavorito = new FavoritoJpaController(emf);
    }
    
    public List<Favorito> listarTodos(){
        return jpaFavorito.findFavoritoEntities();
    }
    
    public void insertar(Favorito es){
        jpaFavorito.create(es);
    }
    
    public void editar(Favorito es){
        try {
            jpaFavorito.edit(es);
        } catch (Exception e) {
            Logger.getLogger(BeanFavorito.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void eliminar(Integer id){
        try {
            jpaFavorito.destroy(id);
        } catch (NonexistentEntityException e) {
            Logger.getLogger(BeanFavorito.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public Favorito buscar(Integer id){
        Favorito es = new Favorito();
        es=jpaFavorito.findFavorito(id);
        return es;
    } 
}
