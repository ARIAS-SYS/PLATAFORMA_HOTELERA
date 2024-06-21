package com.emergentes.bean;

import com.emergentes.entities.Ubicacion;
import com.emergentes.jpa.UbicacionJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanUbicacion {
    private EntityManagerFactory emf;
    private UbicacionJpaController jpaUbicacion;

    public BeanUbicacion () {
        this.emf = Persistence.createEntityManagerFactory("plataformaUP");
        this.jpaUbicacion = new UbicacionJpaController(emf);
    }
    
    public List<Ubicacion> listarTodos(){
        return jpaUbicacion.findUbicacionEntities();
    }
    
    public void insertar(Ubicacion es){
        jpaUbicacion.create(es);
    }
    
    public void editar(Ubicacion es){
        try {
            jpaUbicacion.edit(es);
        } catch (Exception e) {
            Logger.getLogger(BeanUbicacion.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void eliminar(Integer id){
        try {
            jpaUbicacion.destroy(id);
        } catch (NonexistentEntityException e) {
            Logger.getLogger(BeanUbicacion.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public Ubicacion buscar(Integer id){
        Ubicacion es = new Ubicacion();
        es=jpaUbicacion.findUbicacion(id);
        return es;
    } 
}
