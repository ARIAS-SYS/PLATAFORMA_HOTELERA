package com.emergentes.entities;

import com.emergentes.entities.Favorito;
import com.emergentes.entities.Habitacion;
import com.emergentes.entities.Ubicacion;
import com.emergentes.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-18T14:55:30")
@StaticMetamodel(Hotel.class)
public class Hotel_ { 

    public static volatile SingularAttribute<Hotel, String> descripcion;
    public static volatile SingularAttribute<Hotel, Long> calificacion;
    public static volatile SingularAttribute<Hotel, String> facebook;
    public static volatile SingularAttribute<Hotel, String> instagram;
    public static volatile SingularAttribute<Hotel, String> nombre;
    public static volatile SingularAttribute<Hotel, String> linkUbicacion;
    public static volatile SingularAttribute<Hotel, Usuario> idUser;
    public static volatile ListAttribute<Hotel, Habitacion> habitacionList;
    public static volatile SingularAttribute<Hotel, String> foto;
    public static volatile SingularAttribute<Hotel, Ubicacion> idUbi;
    public static volatile ListAttribute<Hotel, Favorito> favoritoList;
    public static volatile SingularAttribute<Hotel, Integer> celular;
    public static volatile SingularAttribute<Hotel, Integer> id;

}