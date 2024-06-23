/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Ronaldo
 */
@Entity
@Table(name = "comodidad_habitacion")
@NamedQueries({
    @NamedQuery(name = "ComodidadHabitacion.findAll", query = "SELECT c FROM ComodidadHabitacion c"),
    @NamedQuery(name = "ComodidadHabitacion.findById", query = "SELECT c FROM ComodidadHabitacion c WHERE c.id = :id")})
public class ComodidadHabitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_habitacion", referencedColumnName = "id")
    @ManyToOne
    private Habitacion idHabitacion;
    @JoinColumn(name = "id_comodidad", referencedColumnName = "id")
    @ManyToOne
    private Comodidad idComodidad;

    public ComodidadHabitacion() {
    }

    public ComodidadHabitacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Habitacion getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Habitacion idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Comodidad getIdComodidad() {
        return idComodidad;
    }

    public void setIdComodidad(Comodidad idComodidad) {
        this.idComodidad = idComodidad;
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
        if (!(object instanceof ComodidadHabitacion)) {
            return false;
        }
        ComodidadHabitacion other = (ComodidadHabitacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emergentes.entities.ComodidadHabitacion[ id=" + id + " ]";
    }
    
}
