
package com.emergentes.controller;

import com.emergentes.bean.BeanComodidad;
import com.emergentes.bean.BeanComodidadHabitacion;
import com.emergentes.bean.BeanHabitacion;
import com.emergentes.bean.BeanTipoHabitacion;
import com.emergentes.bean.BeanUsuario;
import com.emergentes.entities.Comodidad;
import com.emergentes.entities.ComodidadHabitacion;
import com.emergentes.entities.Habitacion;
import com.emergentes.entities.Hotel;
import com.emergentes.entities.TipoHabitacion;
import com.emergentes.entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "HabitacionController", urlPatterns = {"/HabitacionController"})
public class HabitacionController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        BeanUsuario daoUsuario = new BeanUsuario();      
        usuario=daoUsuario.buscar(usuario.getId());
        session.setAttribute("usuario", usuario);
        
        int id;
        BeanHabitacion daoHabitacion = new BeanHabitacion();
        Habitacion elemento = new Habitacion();
        
        BeanComodidad daoComodidad = new BeanComodidad();
        List<Comodidad> comodidades = daoComodidad.listarTodos();
        
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        
        switch(action){
            case "add":
                request.setAttribute("habitacion", elemento);
                request.setAttribute("comodidades", comodidades);
                request.getRequestDispatcher("propietario/habitacion_update.jsp").forward(request, response);
                break;
            case "edit":
                id=Integer.parseInt(request.getParameter("id"));
                elemento=daoHabitacion.buscar(id);
                request.setAttribute("habitacion", elemento);
                request.setAttribute("comodidades", comodidades);
                request.getRequestDispatcher("propietario/habitacion_update.jsp").forward(request, response);
                break;
            case "delete":
                id=Integer.parseInt(request.getParameter("id"));
                daoHabitacion.eliminar(id);
                
                response.sendRedirect(request.getContextPath()+"/HabitacionController");

                break;
            case "view":
                response.sendRedirect(request.getContextPath()+"/PropietarioController?action=habitaciones");

                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        List<Hotel> hotelesUser = usuario.getHotelList();
        Hotel hotelPro = null;


        for(Hotel hotel1: hotelesUser){
            System.out.println("item "+hotel1.getNombre());
            hotelPro=hotel1;
        }
        
        BeanHabitacion daoHabitacion = new BeanHabitacion();
        Habitacion elemento = new Habitacion();
        
        BeanTipoHabitacion daoTipoHabitacion = new BeanTipoHabitacion();
        
        BeanComodidad daoComodidad = new BeanComodidad();
        
        BeanComodidadHabitacion daoComodidadHabitacion = new BeanComodidadHabitacion();
        
        int id=Integer.parseInt(request.getParameter("id"));
        int tipo=Integer.parseInt(request.getParameter("tipo"));
        TipoHabitacion tipoHab = daoTipoHabitacion.buscar(tipo);

        
        int capacidad=Integer.parseInt(request.getParameter("capacidad"));
        String precio=request.getParameter("precio");
        String codigo=request.getParameter("codigo");
        String[] selectedAmenities = request.getParameterValues("selectedAmenities[]");
        
        System.out.println("id "+id);
        System.out.println("usuario "+usuario.getNombre());
                    
        elemento.setId(id);
        elemento.setCodigo(codigo);
        elemento.setEstado("Libre");
        elemento.setCapacidad(capacidad);
        elemento.setPrecio(Long.parseLong(precio));
        elemento.setIdTipoHab(tipoHab);
        elemento.setIdHotelHab(hotelPro);
        
        if(id==0){
            System.out.println("es nuevo");
            daoHabitacion.insertar(elemento);
            
            List<Habitacion> listaHabitacion = daoHabitacion.listarTodos();
            Habitacion hab  = listaHabitacion.get(listaHabitacion.size() - 1);
            
            // Verificar si selectedAmenitiesArray no es nulo antes de agregarlo a la lista
            if (selectedAmenities != null) {
                
                for (String amenity : selectedAmenities) {
                    Comodidad como = daoComodidad.buscar(Integer.parseInt(amenity));
                    ComodidadHabitacion comoHab = new ComodidadHabitacion();
                    comoHab.setIdComodidad(como);
                    comoHab.setIdHabitacion(hab);
                    daoComodidadHabitacion.insertar(comoHab);
                }

            }

            
        }else{
            System.out.println("es editar");
            daoHabitacion.editar(elemento);
            
            Habitacion hab  = daoHabitacion.buscar(id);

            for(ComodidadHabitacion comH: hab.getComodidadHabitacionList()){
                daoComodidadHabitacion.eliminar(comH.getId());
            }

            hab  = daoHabitacion.buscar(id);   

            // Verificar si selectedAmenitiesArray no es nulo antes de agregarlo a la lista
            if (selectedAmenities != null) {

                for (String amenity : selectedAmenities) {
                    Comodidad como = daoComodidad.buscar(Integer.parseInt(amenity));
                    ComodidadHabitacion comoHab = new ComodidadHabitacion();
                    comoHab.setIdComodidad(como);
                    comoHab.setIdHabitacion(hab);
                    daoComodidadHabitacion.insertar(comoHab);
                }

            }
            
            
        }
        

        
        response.sendRedirect(request.getContextPath()+"/HabitacionController");
        
    }

}
