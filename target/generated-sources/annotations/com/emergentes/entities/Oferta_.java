package com.emergentes.entities;

import com.emergentes.entities.Hotel;
import com.emergentes.entities.TipoHabitacion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-26T13:53:12")
@StaticMetamodel(Oferta.class)
public class Oferta_ { 

    public static volatile SingularAttribute<Oferta, String> descripcion;
    public static volatile SingularAttribute<Oferta, String> estado;
    public static volatile SingularAttribute<Oferta, String> foto;
    public static volatile SingularAttribute<Oferta, Hotel> idHotel;
    public static volatile SingularAttribute<Oferta, Date> fechaInicio;
    public static volatile SingularAttribute<Oferta, Integer> descuento;
    public static volatile SingularAttribute<Oferta, String> titulo;
    public static volatile SingularAttribute<Oferta, Integer> id;
    public static volatile SingularAttribute<Oferta, Date> fechaFin;
    public static volatile SingularAttribute<Oferta, TipoHabitacion> idTipoHabitacion;

}