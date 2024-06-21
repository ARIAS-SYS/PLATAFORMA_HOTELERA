package com.emergentes.bean;

import com.emergentes.entities.Hotel;
import com.emergentes.jpa.HotelJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanHotel {
    private EntityManagerFactory emf;
    private HotelJpaController jpaHotel;

    public BeanHotel () {
        this.emf = Persistence.createEntityManagerFactory("plataformaUP");
        this.jpaHotel = new HotelJpaController(emf);
    }
    
    public List<Hotel> listarTodos(){
        return jpaHotel.findHotelEntities();
    }
    
    public void insertar(Hotel es){
        jpaHotel.create(es);
    }
    
    public void editar(Hotel es){
        try {
            jpaHotel.edit(es);
        } catch (Exception e) {
            Logger.getLogger(BeanHotel.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void eliminar(Integer id){
        try {
            jpaHotel.destroy(id);
        } catch (NonexistentEntityException e) {
            Logger.getLogger(BeanHotel.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public Hotel buscar(Integer id){
        Hotel es = new Hotel();
        es=jpaHotel.findHotel(id);
        return es;
    } 
}
