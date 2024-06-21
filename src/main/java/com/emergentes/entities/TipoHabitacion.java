/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Ronaldo
 */
@Entity
@Table(name = "tipo_habitacion")
@NamedQueries({
    @NamedQuery(name = "TipoHabitacion.findAll", query = "SELECT t FROM TipoHabitacion t"),
    @NamedQuery(name = "TipoHabitacion.findById", query = "SELECT t FROM TipoHabitacion t WHERE t.id = :id"),
    @NamedQuery(name = "TipoHabitacion.findByTipo", query = "SELECT t FROM TipoHabitacion t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "TipoHabitacion.findByFoto", query = "SELECT t FROM TipoHabitacion t WHERE t.foto = :foto")})
public class TipoHabitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 30)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 100)
    @Column(name = "foto")
    private String foto;
    @OneToMany(mappedBy = "idTipoHabitacion")
    private List<Oferta> ofertaList;
    @OneToMany(mappedBy = "idTipoHab")
    private List<Habitacion> habitacionList;

    public TipoHabitacion() {
        this.id = 0;
        this.tipo = "";
        this.foto = "";
        this.ofertaList = new ArrayList<Oferta>();
        this.habitacionList = new ArrayList<Habitacion>();

    }

    public TipoHabitacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Oferta> getOfertaList() {
        return ofertaList;
    }

    public void setOfertaList(List<Oferta> ofertaList) {
        this.ofertaList = ofertaList;
    }

    public List<Habitacion> getHabitacionList() {
        return habitacionList;
    }

    public void setHabitacionList(List<Habitacion> habitacionList) {
        this.habitacionList = habitacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoHabitacion)) {
            return false;
        }
        TipoHabitacion other = (TipoHabitacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emergentes.entities.TipoHabitacion[ id=" + id + " ]";
    }
    
}
