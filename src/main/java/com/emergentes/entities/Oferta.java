/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Ronaldo
 */
@Entity
@Table(name = "oferta")
@NamedQueries({
    @NamedQuery(name = "Oferta.findAll", query = "SELECT o FROM Oferta o"),
    @NamedQuery(name = "Oferta.findById", query = "SELECT o FROM Oferta o WHERE o.id = :id"),
    @NamedQuery(name = "Oferta.findByTitulo", query = "SELECT o FROM Oferta o WHERE o.titulo = :titulo"),
    @NamedQuery(name = "Oferta.findByFechaInicio", query = "SELECT o FROM Oferta o WHERE o.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Oferta.findByFechaFin", query = "SELECT o FROM Oferta o WHERE o.fechaFin = :fechaFin"),
    @NamedQuery(name = "Oferta.findByEstado", query = "SELECT o FROM Oferta o WHERE o.estado = :estado"),
    @NamedQuery(name = "Oferta.findByFoto", query = "SELECT o FROM Oferta o WHERE o.foto = :foto"),
    @NamedQuery(name = "Oferta.findByDescuento", query = "SELECT o FROM Oferta o WHERE o.descuento = :descuento")})
public class Oferta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 30)
    @Column(name = "estado")
    private String estado;
    @Size(max = 100)
    @Column(name = "foto")
    private String foto;
    @Column(name = "descuento")
    private Integer descuento;
    @JoinColumn(name = "id_hotel", referencedColumnName = "id")
    @ManyToOne
    private Hotel idHotel;
    @JoinColumn(name = "id_tipo_habitacion", referencedColumnName = "id")
    @ManyToOne
    private TipoHabitacion idTipoHabitacion;

    public Oferta() {
        this.id = 0;
        this.titulo = "";
        this.fechaInicio = new Date();
        this.fechaFin = new Date();
        this.descripcion = "";
        this.estado = "";
        this.foto = "";
        this.descuento = 0;
        this.idHotel = new Hotel();
        this.idTipoHabitacion = new TipoHabitacion();
    }

    public Oferta(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public Hotel getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Hotel idHotel) {
        this.idHotel = idHotel;
    }

    public TipoHabitacion getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(TipoHabitacion idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
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
        if (!(object instanceof Oferta)) {
            return false;
        }
        Oferta other = (Oferta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emergentes.entities.Oferta[ id=" + id + " ]";
    }
    
}
