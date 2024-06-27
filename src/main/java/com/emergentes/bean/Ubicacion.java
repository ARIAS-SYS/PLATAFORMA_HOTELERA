/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.bean;

import java.util.Objects;

/**
 *
 * @author Ronaldo
 */
public class Ubicacion {
    
    private String ciudad;
    private String departamento;
    private String pais;

    public Ubicacion(String ciudad, String departamento, String pais) {
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
     // Sobrescribir equals y hashCode para asegurar que Ubicacion funcione correctamente en un Set
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ubicacion ubicacion = (Ubicacion) o;
        return Objects.equals(ciudad, ubicacion.ciudad) &&
                Objects.equals(departamento, ubicacion.departamento) &&
                Objects.equals(pais, ubicacion.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ciudad, departamento, pais);
    }
}
