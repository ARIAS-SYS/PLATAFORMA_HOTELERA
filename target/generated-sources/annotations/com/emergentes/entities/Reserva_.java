package com.emergentes.entities;

import com.emergentes.entities.Habitacion;
import com.emergentes.entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-24T16:14:58")
@StaticMetamodel(Reserva.class)
public class Reserva_ { 

    public static volatile SingularAttribute<Reserva, String> estado;
    public static volatile SingularAttribute<Reserva, Date> fechaInicio;
    public static volatile SingularAttribute<Reserva, Usuario> idUsuario;
    public static volatile SingularAttribute<Reserva, Integer> id;
    public static volatile SingularAttribute<Reserva, Date> fechaFin;
    public static volatile SingularAttribute<Reserva, Long> totalPrecio;
    public static volatile SingularAttribute<Reserva, Habitacion> idHabit;
    public static volatile SingularAttribute<Reserva, Date> fechaReserva;

}