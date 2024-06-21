package com.emergentes.bean;

import com.emergentes.entities.Rol;
import com.emergentes.jpa.RolJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanRol {
    private EntityManagerFactory emf;
    private RolJpaController jpaRol;

    public BeanRol () {
        this.emf = Persistence.createEntityManagerFactory("plataformaUP");
        this.jpaRol = new RolJpaController(emf);
    }
    
    public List<Rol> listarTodos(){
        return jpaRol.findRolEntities();
    }
    
    public void insertar(Rol es){
        jpaRol.create(es);
    }
    
    public void editar(Rol es){
        try {
            jpaRol.edit(es);
        } catch (Exception e) {
            Logger.getLogger(BeanRol.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void eliminar(Integer id){
        try {
            jpaRol.destroy(id);
        } catch (NonexistentEntityException e) {
            Logger.getLogger(BeanRol.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public Rol buscar(Integer id){
        Rol es = new Rol();
        es=jpaRol.findRol(id);
        return es;
    } 
}
