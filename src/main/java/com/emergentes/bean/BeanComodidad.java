package com.emergentes.bean;

import com.emergentes.entities.Comodidad;
import com.emergentes.jpa.ComodidadJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanComodidad {
    private EntityManagerFactory emf;
    private ComodidadJpaController jpaComodidad;

    public BeanComodidad () {
        this.emf = Persistence.createEntityManagerFactory("plataformaUP");
        this.jpaComodidad = new ComodidadJpaController(emf);
    }
    
    public List<Comodidad> listarTodos(){
        return jpaComodidad.findComodidadEntities();
    }
    
    public void insertar(Comodidad es){
        jpaComodidad.create(es);
    }
    
    public void editar(Comodidad es){
        try {
            jpaComodidad.edit(es);
        } catch (Exception e) {
            Logger.getLogger(BeanComodidad.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void eliminar(Integer id){
        try {
            jpaComodidad.destroy(id);
        } catch (NonexistentEntityException e) {
            Logger.getLogger(BeanComodidad.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public Comodidad buscar(Integer id){
        Comodidad es = new Comodidad();
        es=jpaComodidad.findComodidad(id);
        return es;
    } 
}
