
package com.emergentes.controller;

import com.emergentes.bean.BeanFavorito;
import com.emergentes.bean.BeanHabitacion;
import com.emergentes.bean.BeanHotel;
import com.emergentes.bean.BeanOferta;
import com.emergentes.bean.BeanReserva;
import com.emergentes.bean.BeanUsuario;
import com.emergentes.entities.Favorito;
import com.emergentes.entities.Habitacion;
import com.emergentes.entities.Hotel;
import com.emergentes.entities.Oferta;
import com.emergentes.entities.Reserva;
import com.emergentes.entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        

        int id;
        
        BeanHotel daoHotel = new BeanHotel();
        Hotel hotel = new Hotel();
        
        BeanOferta daoOferta = new BeanOferta();
        Oferta oferta = new Oferta();
        
        BeanHabitacion daoHabitacion = new BeanHabitacion();
        Habitacion habitacion = new Habitacion();
        
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "index";
        
        switch(action){
            case "index":
                List<Hotel> hoteles = daoHotel.listarTodos();
                List<Oferta> ofertas = daoOferta.listarTodos();
                request.setAttribute("hoteles", hoteles);
                request.setAttribute("ofertas", ofertas);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "buscador":
                request.getRequestDispatcher("inicio/buscador.jsp").forward(request, response);
                break;
            case "hotel":
                id=Integer.parseInt(request.getParameter("id"));
                hotel = daoHotel.buscar(id);
                request.setAttribute("hotel", hotel);
                request.getRequestDispatcher("inicio/hotel.jsp").forward(request, response);
                break;
            case "cliente":
                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("cliente/perfil_cliente.jsp").forward(request, response);
                break;
            case "propietario":
                
                List<Hotel> hotelesUser = usuario.getHotelList();
                Hotel hotelPro = null;

                
                for(Hotel hotel1: hotelesUser){
                    System.out.println("item "+hotel1.getNombre());
                    hotelPro=hotel1;
                }
                if(hotelPro==null){
                    request.getRequestDispatcher("propietario/nuevo_hotel.jsp").forward(request, response);
                }else{
                    request.setAttribute("hotel", hotelPro);
                    request.getRequestDispatcher("propietario/perfil_propietario.jsp").forward(request, response);
                }
                break;
            case "confirmar":
                int idHabitacion=Integer.parseInt(request.getParameter("habitacion"));
                habitacion = daoHabitacion.buscar(idHabitacion);
                request.setAttribute("habitacion", habitacion);
                request.getRequestDispatcher("inicio/confirmacion.jsp").forward(request, response);
                break;
            case "success":
                request.getRequestDispatcher("inicio/success.jsp").forward(request, response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");
                
        switch(action){
            case "sessionExist":
                if (session.getAttribute("login") == "OK") {
                    
                    boolean isCliente = true;
                    Usuario usuario = (Usuario) session.getAttribute("usuario");
           
                    
                    if(usuario.getIdRol().getId()==2){
                        isCliente = false;
                    }

                    // Devolver respuesta JSON
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");

                    PrintWriter out = response.getWriter();
                    out.print("{\"sessionExists\": " + true + ", \"isCliente\": " + isCliente + "}");

                    out.flush();
                }else{
                    

                    // Devolver respuesta JSON
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");

                    PrintWriter out = response.getWriter();
                    out.print("{\"sessionExists\": " + false + "}");
                    out.flush();
                }
                break;
                
            case "favorito":
                int id;
                BeanFavorito daoFavorito = new BeanFavorito();
                BeanHotel daoHotel = new BeanHotel();
                Favorito elemento = new Favorito();

                Usuario usuario = (Usuario) session.getAttribute("usuario");
                

        
                int itemId = Integer.parseInt(request.getParameter("hotelId"));
                boolean isFavorite = Boolean.parseBoolean(request.getParameter("isFavorite"));

                Hotel hotel = daoHotel.buscar(itemId);

                boolean updated = false;

                elemento.setIdUsuario(usuario);
                elemento.setIdHotel(hotel);                                         
                if (!isFavorite) {
                    daoFavorito.insertar(elemento);
                    updated = true;
                } else{


                    List<Favorito> favoritos = daoFavorito.listarTodos();

                    for(Favorito fav: favoritos){
                        if(fav.getIdHotel().equals(hotel) && fav.getIdUsuario().equals(usuario)){
                            id=fav.getId();
                            daoFavorito.eliminar(id);
                            updated = true;
                            break;
                        }
                    }


                }

                // Devolver respuesta JSON
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                PrintWriter out = response.getWriter();
                out.print("{\"success\": " + updated + ", \"isFavorite\": " + !isFavorite + "}");
                out.flush();

                 
                
                break;
            case "reservar":
                
                System.out.println("reservar");               
                Usuario usuario1 = (Usuario) session.getAttribute("usuario");
                
         
                int habitacionId = Integer.parseInt(request.getParameter("habitacionId"));
                
                float precio = Float.parseFloat(request.getParameter("precio")) ;
                
                String fechaFin = request.getParameter("fechaFin");
                String fechaInicio = request.getParameter("fechaInicio");
                String fechaActual = request.getParameter("fechaActual");
                int cantidadDias = Integer.parseInt(request.getParameter("cantidadDias"));
                

                
                BeanReserva daoReserva = new BeanReserva();
                BeanHabitacion daoHabitacion = new BeanHabitacion();
                Habitacion habitacion = daoHabitacion.buscar(habitacionId);
                
                System.out.println("usuario "+ usuario1.getNombre());
                System.out.println("habitacionId "+ habitacion.getCodigo());
                System.out.println("precio "+ precio);
                System.out.println("fechaInicio "+ fechaInicio);
                System.out.println("fechaFin "+ fechaFin);
                System.out.println("fechaActual "+ fechaActual);
                System.out.println("cantidadDias "+ cantidadDias);
                
                float precioTotal = precio * cantidadDias;
                
                Reserva reserva = new Reserva();
                reserva.setTotalPrecio((long) precioTotal);
                reserva.setIdHabit(habitacion);
                reserva.setIdUsuario(usuario1);
                reserva.setEstado("Reservado");
                reserva.setFechaReserva(convertirFecha(fechaActual));
                reserva.setFechaInicio(convertirFecha(fechaInicio));
                reserva.setFechaFin(convertirFecha(fechaFin));

                System.out.println("antes");
                daoReserva.insertar(reserva);

                System.out.println("despues");
                
                // Devolver respuesta JSON
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                PrintWriter out1 = response.getWriter();
                out1.print("{\"success\": " + true + "}");
                out1.flush();

                
                break;
        }

    }
    
    public java.sql.Date convertirFecha(String fecha){
        java.sql.Date fechaBD = null;
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        
        java.util.Date fechaTMP;
        try {
            fechaTMP = formato.parse(fecha);
            fechaBD = new java.sql.Date(fechaTMP.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
              
        return fechaBD;
        
    }

}
