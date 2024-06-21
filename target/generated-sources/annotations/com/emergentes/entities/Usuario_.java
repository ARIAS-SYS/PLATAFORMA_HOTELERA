package com.emergentes.entities;

import com.emergentes.entities.Favorito;
import com.emergentes.entities.Hotel;
import com.emergentes.entities.Reserva;
import com.emergentes.entities.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-18T14:55:30")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile SingularAttribute<Usuario, Rol> idRol;
    public static volatile ListAttribute<Usuario, Hotel> hotelList;
    public static volatile ListAttribute<Usuario, Reserva> reservaList;
    public static volatile ListAttribute<Usuario, Favorito> favoritoList;
    public static volatile SingularAttribute<Usuario, Integer> id;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, String> email;
    public static volatile SingularAttribute<Usuario, Integer> activo;

}