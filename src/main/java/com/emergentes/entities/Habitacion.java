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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "habitacion")
@NamedQueries({
    @NamedQuery(name = "Habitacion.findAll", query = "SELECT h FROM Habitacion h"),
    @NamedQuery(name = "Habitacion.findById", query = "SELECT h FROM Habitacion h WHERE h.id = :id"),
    @NamedQuery(name = "Habitacion.findByCodigo", query = "SELECT h FROM Habitacion h WHERE h.codigo = :codigo"),
    @NamedQuery(name = "Habitacion.findByEstado", query = "SELECT h FROM Habitacion h WHERE h.estado = :estado"),
    @NamedQuery(name = "Habitacion.findByCapacidad", query = "SELECT h FROM Habitacion h WHERE h.capacidad = :capacidad"),
    @NamedQuery(name = "Habitacion.findByPrecio", query = "SELECT h FROM Habitacion h WHERE h.precio = :precio")})
public class Habitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 20)
    @Column(name = "estado")
    private String estado;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "capacidad")
    private Integer capacidad;
    @Column(name = "precio")
    private Long precio;
    @OneToMany(mappedBy = "idHabitacion")
    private List<ComodidadHabitacion> comodidadHabitacionList;
    @OneToMany(mappedBy = "idHabit")
    private List<Reserva> reservaList;
    @JoinColumn(name = "id_hotel_hab", referencedColumnName = "id")
    @ManyToOne
    private Hotel idHotelHab;
    @JoinColumn(name = "id_tipo_hab", referencedColumnName = "id")
    @ManyToOne
    private TipoHabitacion idTipoHab;

    public Habitacion() {
        this.id = 0;
        this.codigo = "";
        this.estado = "";
        this.descripcion = "";
        this.capacidad = 0;
        this.precio = 0L;
        this.comodidadHabitacionList = new ArrayList<ComodidadHabitacion>();
        this.reservaList = new ArrayList<Reserva>();
        this.idHotelHab = new Hotel();
        this.idTipoHab = new TipoHabitacion();
    }

    public Habitacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public List<ComodidadHabitacion> getComodidadHabitacionList() {
        return comodidadHabitacionList;
    }

    public void setComodidadHabitacionList(List<ComodidadHabitacion> comodidadHabitacionList) {
        this.comodidadHabitacionList = comodidadHabitacionList;
    }

    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    public Hotel getIdHotelHab() {
        return idHotelHab;
    }

    public void setIdHotelHab(Hotel idHotelHab) {
        this.idHotelHab = idHotelHab;
    }

    public TipoHabitacion getIdTipoHab() {
        return idTipoHab;
    }

    public void setIdTipoHab(TipoHabitacion idTipoHab) {
        this.idTipoHab = idTipoHab;
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
        if (!(object instanceof Habitacion)) {
            return false;
        }
        Habitacion other = (Habitacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emergentes.entities.Habitacion[ id=" + id + " ]";
    }
    
}
