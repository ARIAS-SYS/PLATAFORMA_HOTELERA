package com.emergentes.entities;

import com.emergentes.entities.Hotel;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-18T14:55:30")
@StaticMetamodel(Ubicacion.class)
public class Ubicacion_ { 

    public static volatile SingularAttribute<Ubicacion, String> descripcion;
    public static volatile ListAttribute<Ubicacion, Hotel> hotelList;
    public static volatile SingularAttribute<Ubicacion, String> ciudad;
    public static volatile SingularAttribute<Ubicacion, String> departamento;
    public static volatile SingularAttribute<Ubicacion, Integer> id;
    public static volatile SingularAttribute<Ubicacion, String> pais;

}