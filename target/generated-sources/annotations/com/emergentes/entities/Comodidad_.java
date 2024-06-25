package com.emergentes.entities;

import com.emergentes.entities.ComodidadHabitacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-25T11:58:53")
@StaticMetamodel(Comodidad.class)
public class Comodidad_ { 

    public static volatile SingularAttribute<Comodidad, String> icono;
    public static volatile SingularAttribute<Comodidad, String> comodidad;
    public static volatile SingularAttribute<Comodidad, Integer> id;
    public static volatile ListAttribute<Comodidad, ComodidadHabitacion> comodidadHabitacionList;

}