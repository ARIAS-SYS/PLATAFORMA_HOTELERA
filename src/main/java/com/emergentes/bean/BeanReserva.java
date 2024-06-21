package com.emergentes.bean;

import com.emergentes.entities.Reserva;
import com.emergentes.jpa.ReservaJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanReserva {
    private EntityManagerFactory emf;
    private ReservaJpaController jpaReserva;

    public BeanReserva () {
        this.emf = Persistence.createEntityManagerFactory("plataformaUP");
        this.jpaReserva = new ReservaJpaController(emf);
    }
    
    public List<Reserva> listarTodos(){
        return jpaReserva.findReservaEntities();
    }
    
    public void insertar(Reserva es){
        jpaReserva.create(es);
    }
    
    public void editar(Reserva es){
        try {
            jpaReserva.edit(es);
        } catch (Exception e) {
            Logger.getLogger(BeanReserva.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void eliminar(Integer id){
        try {
            jpaReserva.destroy(id);
        } catch (NonexistentEntityException e) {
            Logger.getLogger(BeanReserva.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public Reserva buscar(Integer id){
        Reserva es = new Reserva();
        es=jpaReserva.findReserva(id);
        return es;
    } 
}
