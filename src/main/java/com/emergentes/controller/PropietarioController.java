
package com.emergentes.controller;

import com.emergentes.bean.BeanHotel;
import com.emergentes.bean.BeanReserva;
import com.emergentes.bean.BeanTipoHabitacion;
import com.emergentes.bean.BeanUsuario;
import com.emergentes.entities.Hotel;
import com.emergentes.entities.Reserva;
import com.emergentes.entities.TipoHabitacion;
import com.emergentes.entities.Usuario;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet(name = "PropietarioController", urlPatterns = {"/PropietarioController"})
@MultipartConfig
public class PropietarioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        BeanUsuario daoUsuario = new BeanUsuario();      
        usuario=daoUsuario.buscar(usuario.getId());
        session.setAttribute("usuario", usuario);
        
        usuario = (Usuario) session.getAttribute("usuario");

        
        BeanTipoHabitacion daoTipoHabitacion = new BeanTipoHabitacion();
        List<TipoHabitacion> tipoHabitaciones = daoTipoHabitacion.listarTodos();
        
        BeanReserva daoReserva = new BeanReserva();
        List<Reserva> reservas = daoReserva.listarTodos();

        
        
        List<Hotel> hotelesUser = usuario.getHotelList();
        Hotel hotelPro = null;


        for(Hotel hotel1: hotelesUser){
            System.out.println("item "+hotel1.getNombre());
            hotelPro=hotel1;
        }

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "index";
        
        switch(action){
            case "home":
                
                if(hotelPro==null){
                    request.getRequestDispatcher("propietario/nuevo_hotel.jsp").forward(request, response);
                }else{
                    
                    request.setAttribute("reservas", reservas);
                    request.setAttribute("hotel", hotelPro);
                    request.setAttribute("usuario", usuario);
                    request.setAttribute("tipoHabitaciones", tipoHabitaciones);
                    
                    request.getRequestDispatcher("propietario/home_propietario.jsp").forward(request, response);
                }
                break;
            case "reservas":
                if(hotelPro==null){
                    request.getRequestDispatcher("propietario/nuevo_hotel.jsp").forward(request, response);
                }else{
                    
                    request.setAttribute("reservas", reservas);
                    request.setAttribute("hotel", hotelPro);
                    request.setAttribute("usuario", usuario);
                    
                    request.getRequestDispatcher("propietario/reservas_propietario.jsp").forward(request, response);
                }
                break;
            case "reservasEstadia":
                if(hotelPro==null){
                    request.getRequestDispatcher("propietario/nuevo_hotel.jsp").forward(request, response);
                }else{
                    request.setAttribute("reservas", reservas);

                    request.setAttribute("hotel", hotelPro);
                    request.setAttribute("usuario", usuario);
                    
                    request.getRequestDispatcher("propietario/reservas_estadia.jsp").forward(request, response);
                }
                break;
            case "reservasCompleto":
                if(hotelPro==null){
                    request.getRequestDispatcher("propietario/nuevo_hotel.jsp").forward(request, response);
                }else{
                    request.setAttribute("reservas", reservas);

                    request.setAttribute("hotel", hotelPro);
                    request.setAttribute("usuario", usuario);
                    
                    request.getRequestDispatcher("propietario/reservas_completado.jsp").forward(request, response);
                }
                break;
            case "reservasTodos":
                if(hotelPro==null){
                    request.getRequestDispatcher("propietario/nuevo_hotel.jsp").forward(request, response);
                }else{
                    request.setAttribute("reservas", reservas);

                    request.setAttribute("hotel", hotelPro);
                    request.setAttribute("usuario", usuario);
                    
                    request.getRequestDispatcher("propietario/reservas_todos.jsp").forward(request, response);
                }
                break;
            case "habitaciones":
                if(hotelPro==null){
                    request.getRequestDispatcher("propietario/nuevo_hotel.jsp").forward(request, response);
                }else{
                    request.setAttribute("hotel", hotelPro);
                    request.setAttribute("usuario", usuario);
                    request.setAttribute("tipoHabitaciones", tipoHabitaciones);

                    request.getRequestDispatcher("propietario/habitaciones_propietario.jsp").forward(request, response);
                }
                break;
            case "tipo_habitaciones":
                
                if(hotelPro==null){
                    request.getRequestDispatcher("propietario/nuevo_hotel.jsp").forward(request, response);
                }else{
                    request.setAttribute("hotel", hotelPro);
                    request.setAttribute("usuario", usuario);
                    request.setAttribute("tipoHabitaciones", tipoHabitaciones);

                    request.getRequestDispatcher("propietario/tipo_habitaciones_propietario.jsp").forward(request, response);
                }
                break;
            case "ofertas":
                if(hotelPro==null){
                    request.getRequestDispatcher("propietario/nuevo_hotel.jsp").forward(request, response);
                }else{
                    usuario=daoUsuario.buscar(usuario.getId());
                    session.setAttribute("usuario", usuario);
                    
                    usuario = (Usuario) session.getAttribute("usuario");

                    request.setAttribute("hotel", hotelPro);
                    request.setAttribute("usuario", usuario);

                    request.getRequestDispatcher("propietario/ofertas_propietario.jsp").forward(request, response);
                }
                break;
            case "detalle":
                
                if(hotelPro==null){
                    request.getRequestDispatcher("propietario/nuevo_hotel.jsp").forward(request, response);
                }else{
                    request.setAttribute("hotel", hotelPro);
                    request.setAttribute("usuario", usuario);

                    request.getRequestDispatcher("propietario/detalle_propietario.jsp").forward(request, response);
                }
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        
        BeanHotel daoHotel = new BeanHotel();
        Hotel hotel = new Hotel();

        // Obtener parámetros del formulario
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String ciudad = request.getParameter("ciudad");
        String departamento = request.getParameter("departamento");
        String pais = request.getParameter("pais");
        String descripcionUbicacion = request.getParameter("descripcionUbicacion");
        String urlUbicacion = request.getParameter("urlUbicacion");
        String urlInstagram = request.getParameter("urlInstagram");
        int celular = Integer.parseInt(request.getParameter("celular")) ;
        String urlFacebook = request.getParameter("urlFacebook");
        
        System.out.println("Nombre: " + nombre);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Ciudad: " + ciudad);
        System.out.println("Departamento: " + departamento);
        System.out.println("País: " + pais);
        System.out.println("Descripción de la Ubicación: " + descripcionUbicacion);
        System.out.println("URL Ubicación: " + urlUbicacion);
        System.out.println("URL Instagram: " + urlInstagram);
        System.out.println("Celular: " + celular);
        System.out.println("URL Facebook: " + urlFacebook);

        // Obtener archivo subido
        Part filePart = request.getPart("foto"); // Debe coincidir con el nombre del input file
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // Obtener el nombre del archivo

        //String uploadDir = getServletContext().getRealPath("") + File.separator + "images";
        String uploadDir = getServletContext().getRealPath("")+ File.separator + "images"; // Cambia el directorio aquí

        File uploadDirFile = new File(uploadDir);
        if (!uploadDirFile.exists()) {
            uploadDirFile.mkdirs(); // Crear directorio si no existe
        }
        File file = new File(uploadDir, fileName);
        filePart.write(file.getAbsolutePath()); // Guardar archivo en el servidor
        
        System.out.println("coorecto listo");

        
        hotel.setNombre(nombre);
        hotel.setDescripcion(descripcion);
        hotel.setCelular(celular);
        hotel.setFacebook(urlFacebook);
        hotel.setInstagram(urlInstagram);
        hotel.setFoto(fileName);
        hotel.setLinkUbicacion(urlUbicacion);
        hotel.setCalificacion(5L);
        hotel.setPais(pais);
        hotel.setDepartamento(departamento);
        hotel.setCiudad(ciudad);
        hotel.setDescripcionUbi(descripcionUbicacion);
        hotel.setIdUser(usuario);
        
        
        daoHotel.insertar(hotel);

        System.out.println("guardado correctamente");
        
        BeanUsuario daoUsuario = new BeanUsuario();      
        usuario=daoUsuario.buscar(usuario.getId());
        session.setAttribute("usuario", usuario);
        
        response.sendRedirect(request.getContextPath() + "/MainController?action=propietario");


    }

}
