
package com.emergentes.controller;

import com.emergentes.bean.BeanOferta;
import com.emergentes.bean.BeanTipoHabitacion;
import com.emergentes.bean.BeanUsuario;
import com.emergentes.entities.Hotel;
import com.emergentes.entities.Oferta;
import com.emergentes.entities.TipoHabitacion;
import com.emergentes.entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "OfertaController", urlPatterns = {"/OfertaController"})
public class OfertaController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        BeanUsuario daoUsuario = new BeanUsuario();      
        usuario=daoUsuario.buscar(usuario.getId());
        session.setAttribute("usuario", usuario);
        
        List<Hotel> hotelesUser = usuario.getHotelList();
        Hotel hotelPro = null;


        for(Hotel hotel1: hotelesUser){
            System.out.println("item "+hotel1.getNombre());
            hotelPro=hotel1;
        }
        
        
        
        
        int id;
        BeanOferta daoOferta = new BeanOferta();
        Oferta elemento = new Oferta();
        
        
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        
        switch(action){
            case "add":
                request.setAttribute("oferta", elemento);
                request.getRequestDispatcher("propietario/oferta_update.jsp").forward(request, response);
                break;
            case "edit":
                id=Integer.parseInt(request.getParameter("id"));
                elemento=daoOferta.buscar(id);
                request.setAttribute("oferta", elemento);
                request.getRequestDispatcher("propietario/oferta_update.jsp").forward(request, response);
                break;
            case "delete":
                id=Integer.parseInt(request.getParameter("id"));
                daoOferta.eliminar(id);
                
                response.sendRedirect(request.getContextPath()+"/OfertaController");

                break;
            case "view":
                if(hotelPro==null){
                    request.getRequestDispatcher("propietario/nuevo_hotel.jsp").forward(request, response);
                }else{
                    request.setAttribute("hotel", hotelPro);
                    request.setAttribute("usuario", usuario);

                    request.getRequestDispatcher("propietario/ofertas_propietario.jsp").forward(request, response);
                }

                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        BeanUsuario daoUsuario = new BeanUsuario();      
        usuario=daoUsuario.buscar(usuario.getId());
        session.setAttribute("usuario", usuario);
        
        List<Hotel> hotelesUser = usuario.getHotelList();
        Hotel hotelPro = null;


        for(Hotel hotel1: hotelesUser){
            System.out.println("item "+hotel1.getNombre());
            hotelPro=hotel1;
        }
        
        BeanTipoHabitacion daoTipoHabitacion = new BeanTipoHabitacion();
        TipoHabitacion elemento = new TipoHabitacion();
        
        BeanOferta daoOferta = new BeanOferta();
        Oferta oferta = new Oferta();
        
        int id=Integer.parseInt(request.getParameter("id"));
        String nombre=request.getParameter("titulo");
        String descripcion = request.getParameter("descripcion");
        String fecha_inicio = request.getParameter("fecha_inicio");
        String fecha_fin = request.getParameter("fecha_fin");
        String foto = request.getParameter("foto");
        int descuento=Integer.parseInt(request.getParameter("descuento"));
        int tipo=Integer.parseInt(request.getParameter("tipo"));
        
        elemento=daoTipoHabitacion.buscar(tipo);
        
        
                    
        oferta.setId(id);
        oferta.setTitulo(nombre);
        oferta.setDescripcion(descripcion);
        oferta.setFoto(foto);
        oferta.setFechaInicio(convertirFecha(fecha_inicio));
        oferta.setFechaFin(convertirFecha(fecha_fin));
        oferta.setDescuento(descuento);
        oferta.setIdHotel(hotelPro);
        oferta.setIdTipoHabitacion(elemento);
        
        java.util.Date fechaActual = new java.util.Date();
        
        if (fechaActual.before(oferta.getFechaInicio())) {
            oferta.setEstado("Programado");

        } else if (fechaActual.after(oferta.getFechaFin())) {
            oferta.setEstado("Terminado");
        } else {
            oferta.setEstado("En Curso");
        }
            
        
        
        if(id==0){
            System.out.println("es nuevo");
            daoOferta.insertar(oferta);
        }else{
            
            System.out.println("es editar");
            daoOferta.editar(oferta);
        }
        
        
        
        
        response.sendRedirect(request.getContextPath()+"/OfertaController");

    }
    
    
    public Date convertirFecha(String fecha){
        Date fechaBD = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
        java.util.Date fechaTMP;
        try {
            fechaTMP = formato.parse(fecha);
            fechaBD = new Date(fechaTMP.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
              
        return fechaBD;
        
    }
    

}
