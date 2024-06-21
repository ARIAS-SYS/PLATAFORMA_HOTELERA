package com.emergentes.bean;

import com.emergentes.entities.Usuario;
import com.emergentes.jpa.UsuarioJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanUsuario {
    private EntityManagerFactory emf;
    private UsuarioJpaController jpaUsuario;

    public BeanUsuario () {
        this.emf = Persistence.createEntityManagerFactory("plataformaUP");
        this.jpaUsuario = new UsuarioJpaController(emf);
    }
    
    public List<Usuario> listarTodos(){
        return jpaUsuario.findUsuarioEntities();
    }
    
    public void insertar(Usuario es){
        jpaUsuario.create(es);
    }
    
    public void editar(Usuario es){
        try {
            jpaUsuario.edit(es);
        } catch (Exception e) {
            Logger.getLogger(BeanUsuario.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void eliminar(Integer id){
        try {
            jpaUsuario.destroy(id);
        } catch (NonexistentEntityException e) {
            Logger.getLogger(BeanUsuario.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public Usuario buscar(Integer id){
        Usuario es = new Usuario();
        es=jpaUsuario.findUsuario(id);
        return es;
    } 
}
