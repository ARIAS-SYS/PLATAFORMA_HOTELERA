package com.emergentes.bean;

import com.emergentes.entities.Oferta;
import com.emergentes.jpa.OfertaJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanOferta {
    private EntityManagerFactory emf;
    private OfertaJpaController jpaOferta;

    public BeanOferta () {
        this.emf = Persistence.createEntityManagerFactory("plataformaUP");
        this.jpaOferta = new OfertaJpaController(emf);
    }
    
    public List<Oferta> listarTodos(){
        return jpaOferta.findOfertaEntities();
    }
    
    public void insertar(Oferta es){
        jpaOferta.create(es);
    }
    
    public void editar(Oferta es){
        try {
            jpaOferta.edit(es);
        } catch (Exception e) {
            Logger.getLogger(BeanOferta.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void eliminar(Integer id){
        try {
            jpaOferta.destroy(id);
        } catch (NonexistentEntityException e) {
            Logger.getLogger(BeanOferta.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public Oferta buscar(Integer id){
        Oferta es = new Oferta();
        es=jpaOferta.findOferta(id);
        return es;
    } 
}
