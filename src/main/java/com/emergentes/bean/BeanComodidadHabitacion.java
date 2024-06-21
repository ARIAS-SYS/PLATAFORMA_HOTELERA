package com.emergentes.bean;

import com.emergentes.entities.ComodidadHabitacion;
import com.emergentes.jpa.ComodidadHabitacionJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanComodidadHabitacion {
    private EntityManagerFactory emf;
    private ComodidadHabitacionJpaController jpaComodidadHabitacion;

    public BeanComodidadHabitacion () {
        this.emf = Persistence.createEntityManagerFactory("plataformaUP");
        this.jpaComodidadHabitacion = new ComodidadHabitacionJpaController(emf);
    }
    
    public List<ComodidadHabitacion> listarTodos(){
        return jpaComodidadHabitacion.findComodidadHabitacionEntities();
    }
    
    public void insertar(ComodidadHabitacion es){
        jpaComodidadHabitacion.create(es);
    }
    
    public void editar(ComodidadHabitacion es){
        try {
            jpaComodidadHabitacion.edit(es);
        } catch (Exception e) {
            Logger.getLogger(BeanComodidadHabitacion.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void eliminar(Integer id){
        try {
            jpaComodidadHabitacion.destroy(id);
        } catch (NonexistentEntityException e) {
            Logger.getLogger(BeanComodidadHabitacion.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public ComodidadHabitacion buscar(Integer id){
        ComodidadHabitacion es = new ComodidadHabitacion();
        es=jpaComodidadHabitacion.findComodidadHabitacion(id);
        return es;
    } 
}
