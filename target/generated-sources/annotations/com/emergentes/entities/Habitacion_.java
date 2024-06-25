package com.emergentes.entities;

import com.emergentes.entities.ComodidadHabitacion;
import com.emergentes.entities.Hotel;
import com.emergentes.entities.Reserva;
import com.emergentes.entities.TipoHabitacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-25T11:58:53")
@StaticMetamodel(Habitacion.class)
public class Habitacion_ { 

    public static volatile SingularAttribute<Habitacion, String> descripcion;
    public static volatile SingularAttribute<Habitacion, String> codigo;
    public static volatile SingularAttribute<Habitacion, String> estado;
    public static volatile SingularAttribute<Habitacion, Long> precio;
    public static volatile ListAttribute<Habitacion, Reserva> reservaList;
    public static volatile SingularAttribute<Habitacion, Hotel> idHotelHab;
    public static volatile SingularAttribute<Habitacion, TipoHabitacion> idTipoHab;
    public static volatile SingularAttribute<Habitacion, Integer> id;
    public static volatile ListAttribute<Habitacion, ComodidadHabitacion> comodidadHabitacionList;
    public static volatile SingularAttribute<Habitacion, Integer> capacidad;

}