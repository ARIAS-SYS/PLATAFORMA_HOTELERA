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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ronaldo
 */
@Entity
@Table(name = "hotel")
@NamedQueries({
    @NamedQuery(name = "Hotel.findAll", query = "SELECT h FROM Hotel h"),
    @NamedQuery(name = "Hotel.findById", query = "SELECT h FROM Hotel h WHERE h.id = :id"),
    @NamedQuery(name = "Hotel.findByNombre", query = "SELECT h FROM Hotel h WHERE h.nombre = :nombre"),
    @NamedQuery(name = "Hotel.findByCelular", query = "SELECT h FROM Hotel h WHERE h.celular = :celular"),
    @NamedQuery(name = "Hotel.findByFacebook", query = "SELECT h FROM Hotel h WHERE h.facebook = :facebook"),
    @NamedQuery(name = "Hotel.findByInstagram", query = "SELECT h FROM Hotel h WHERE h.instagram = :instagram"),
    @NamedQuery(name = "Hotel.findByFoto", query = "SELECT h FROM Hotel h WHERE h.foto = :foto"),
    @NamedQuery(name = "Hotel.findByLinkUbicacion", query = "SELECT h FROM Hotel h WHERE h.linkUbicacion = :linkUbicacion"),
    @NamedQuery(name = "Hotel.findByCalificacion", query = "SELECT h FROM Hotel h WHERE h.calificacion = :calificacion")})
public class Hotel implements Serializable {

    @OneToMany(mappedBy = "idHotel")
    private List<Oferta> ofertaList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "celular")
    private Integer celular;
    @Size(max = 100)
    @Column(name = "facebook")
    private String facebook;
    @Size(max = 100)
    @Column(name = "instagram")
    private String instagram;
    @Size(max = 30)
    @Column(name = "foto")
    private String foto;
    @Size(max = 100)
    @Column(name = "link_ubicacion")
    private String linkUbicacion;
    @Column(name = "calificacion")
    private Long calificacion;
    @OneToMany(mappedBy = "idHotel")
    private List<Favorito> favoritoList;
    @JoinColumn(name = "id_ubi", referencedColumnName = "id")
    @ManyToOne
    private Ubicacion idUbi;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne
    private Usuario idUser;
    @OneToMany(mappedBy = "idHotelHab")
    private List<Habitacion> habitacionList;

    public Hotel() {
        this.id = 0;
        this.nombre = "";
        this.descripcion = "";
        this.celular = 0;
        this.facebook = "";
        this.instagram = "";
        this.foto = "";
        this.linkUbicacion = "";
        this.calificacion = 0L;
        this.favoritoList = new ArrayList<Favorito>();
        this.idUbi = new Ubicacion();
        this.idUser = new Usuario();
        this.habitacionList = new ArrayList<Habitacion>();


    }

    public Hotel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getLinkUbicacion() {
        return linkUbicacion;
    }

    public void setLinkUbicacion(String linkUbicacion) {
        this.linkUbicacion = linkUbicacion;
    }

    public Long getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Long calificacion) {
        this.calificacion = calificacion;
    }

    public List<Favorito> getFavoritoList() {
        return favoritoList;
    }

    public void setFavoritoList(List<Favorito> favoritoList) {
        this.favoritoList = favoritoList;
    }

    public Ubicacion getIdUbi() {
        return idUbi;
    }

    public void setIdUbi(Ubicacion idUbi) {
        this.idUbi = idUbi;
    }

    public Usuario getIdUser() {
        return idUser;
    }

    public void setIdUser(Usuario idUser) {
        this.idUser = idUser;
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
        if (!(object instanceof Hotel)) {
            return false;
        }
        Hotel other = (Hotel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emergentes.entities.Hotel[ id=" + id + " ]";
    }

    @XmlTransient
    public List<Oferta> getOfertaList() {
        return ofertaList;
    }

    public void setOfertaList(List<Oferta> ofertaList) {
        this.ofertaList = ofertaList;
    }
    
}
