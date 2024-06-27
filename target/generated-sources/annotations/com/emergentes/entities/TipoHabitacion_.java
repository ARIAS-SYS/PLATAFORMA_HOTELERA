package com.emergentes.entities;

import com.emergentes.entities.Habitacion;
import com.emergentes.entities.Oferta;
import com.emergentes.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-26T13:53:12")
@StaticMetamodel(TipoHabitacion.class)
public class TipoHabitacion_ { 

    public static volatile SingularAttribute<TipoHabitacion, String> tipo;
    public static volatile ListAttribute<TipoHabitacion, Habitacion> habitacionList;
    public static volatile SingularAttribute<TipoHabitacion, String> foto;
    public static volatile SingularAttribute<TipoHabitacion, Usuario> idUsuario;
    public static volatile ListAttribute<TipoHabitacion, Oferta> ofertaList;
    public static volatile SingularAttribute<TipoHabitacion, Integer> id;

}