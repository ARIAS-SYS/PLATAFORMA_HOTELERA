/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.entities;

import java.io.Serializable;
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
@Table(name = "comodidad")
@NamedQueries({
    @NamedQuery(name = "Comodidad.findAll", query = "SELECT c FROM Comodidad c"),
    @NamedQuery(name = "Comodidad.findById", query = "SELECT c FROM Comodidad c WHERE c.id = :id"),
    @NamedQuery(name = "Comodidad.findByComodidad", query = "SELECT c FROM Comodidad c WHERE c.comodidad = :comodidad"),
    @NamedQuery(name = "Comodidad.findByIcono", query = "SELECT c FROM Comodidad c WHERE c.icono = :icono")})
public class Comodidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 30)
    @Column(name = "comodidad")
    private String comodidad;
    @Size(max = 30)
    @Column(name = "icono")
    private String icono;
    @OneToMany(mappedBy = "idComodidad")
    private List<ComodidadHabitacion> comodidadHabitacionList;

    public Comodidad() {
    }

    public Comodidad(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComodidad() {
        return comodidad;
    }

    public void setComodidad(String comodidad) {
        this.comodidad = comodidad;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public List<ComodidadHabitacion> getComodidadHabitacionList() {
        return comodidadHabitacionList;
    }

    public void setComodidadHabitacionList(List<ComodidadHabitacion> comodidadHabitacionList) {
        this.comodidadHabitacionList = comodidadHabitacionList;
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
        if (!(object instanceof Comodidad)) {
            return false;
        }
        Comodidad other = (Comodidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emergentes.entities.Comodidad[ id=" + id + " ]";
    }
    
}
