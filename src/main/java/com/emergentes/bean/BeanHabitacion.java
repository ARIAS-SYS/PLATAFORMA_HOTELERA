package com.emergentes.bean;

import com.emergentes.entities.Habitacion;
import com.emergentes.jpa.HabitacionJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanHabitacion {
    private EntityManagerFactory emf;
    private HabitacionJpaController jpaHabitacion;

    public BeanHabitacion () {
        this.emf = Persistence.createEntityManagerFactory("plataformaUP");
        this.jpaHabitacion = new HabitacionJpaController(emf);
    }
    
    public List<Habitacion> listarTodos(){
        return jpaHabitacion.findHabitacionEntities();
    }
    
    public void insertar(Habitacion es){
        jpaHabitacion.create(es);
    }
    
    public void editar(Habitacion es){
        try {
            jpaHabitacion.edit(es);
        } catch (Exception e) {
            Logger.getLogger(BeanHabitacion.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void eliminar(Integer id){
        try {
            jpaHabitacion.destroy(id);
        } catch (NonexistentEntityException e) {
            Logger.getLogger(BeanHabitacion.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public Habitacion buscar(Integer id){
        Habitacion es = new Habitacion();
        es=jpaHabitacion.findHabitacion(id);
        return es;
    } 
}
