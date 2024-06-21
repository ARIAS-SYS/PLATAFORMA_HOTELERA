package com.emergentes.bean;

import com.emergentes.entities.TipoHabitacion;
import com.emergentes.jpa.TipoHabitacionJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanTipoHabitacion {
    private EntityManagerFactory emf;
    private TipoHabitacionJpaController jpaTipoHabitacion;

    public BeanTipoHabitacion () {
        this.emf = Persistence.createEntityManagerFactory("plataformaUP");
        this.jpaTipoHabitacion = new TipoHabitacionJpaController(emf);
    }
    
    public List<TipoHabitacion> listarTodos(){
        return jpaTipoHabitacion.findTipoHabitacionEntities();
    }
    
    public void insertar(TipoHabitacion es){
        jpaTipoHabitacion.create(es);
    }
    
    public void editar(TipoHabitacion es){
        try {
            jpaTipoHabitacion.edit(es);
        } catch (Exception e) {
            Logger.getLogger(BeanTipoHabitacion.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void eliminar(Integer id){
        try {
            jpaTipoHabitacion.destroy(id);
        } catch (NonexistentEntityException e) {
            Logger.getLogger(BeanTipoHabitacion.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public TipoHabitacion buscar(Integer id){
        TipoHabitacion es = new TipoHabitacion();
        es=jpaTipoHabitacion.findTipoHabitacion(id);
        return es;
    } 
}
