
package com.emergentes.controller;

import com.emergentes.bean.BeanTipoHabitacion;
import com.emergentes.bean.BeanUsuario;
import com.emergentes.entities.TipoHabitacion;
import com.emergentes.entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "TipoHabitacionController", urlPatterns = {"/TipoHabitacionController"})
public class TipoHabitacionController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        BeanUsuario daoUsuario = new BeanUsuario();      
        usuario=daoUsuario.buscar(usuario.getId());
        session.setAttribute("usuario", usuario);
        
        int id;
        BeanTipoHabitacion daoTipoHabitacion = new BeanTipoHabitacion();
        TipoHabitacion elemento = new TipoHabitacion();
        
        
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        
        switch(action){
            case "add":
                request.setAttribute("tipoHabitacion", elemento);
                request.getRequestDispatcher("propietario/tipo_habitacion_update.jsp").forward(request, response);
                break;
            case "edit":
                id=Integer.parseInt(request.getParameter("id"));
                elemento=daoTipoHabitacion.buscar(id);
                request.setAttribute("tipoHabitacion", elemento);
                request.getRequestDispatcher("propietario/tipo_habitacion_update.jsp").forward(request, response);
                break;
            case "delete":
                id=Integer.parseInt(request.getParameter("id"));
                daoTipoHabitacion.eliminar(id);
                
                response.sendRedirect(request.getContextPath()+"/TipoHabitacionController");

                break;
            case "view":
                response.sendRedirect(request.getContextPath()+"/PropietarioController?action=tipo_habitaciones");

                break;
        }
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        BeanTipoHabitacion daoTipoHabitacion = new BeanTipoHabitacion();
        TipoHabitacion elemento = new TipoHabitacion();
        
        int id=Integer.parseInt(request.getParameter("id"));
        String nombre=request.getParameter("nombre");
        String imagen = request.getParameter("imagen");
        
        System.out.println("id "+id);
        System.out.println("nombre "+nombre);
        System.out.println("imagen "+imagen);
        System.out.println("usuario "+usuario.getNombre());
                    
        elemento.setId(id);
        elemento.setTipo(nombre);
        elemento.setFoto(imagen);
        elemento.setIdUsuario(usuario);
        
        
        if(id==0){
            System.out.println("es nuevo");
            daoTipoHabitacion.insertar(elemento);
        }else{
            
            System.out.println("es editar");
            
            System.out.println("nombre "+elemento.getTipo());
            System.out.println("id "+elemento.getId());
            System.out.println("imagen "+elemento.getFoto());
            System.out.println("usuario"+elemento.getIdUsuario().getNombre());
            daoTipoHabitacion.editar(elemento);
        }
        
        
        
        
        response.sendRedirect(request.getContextPath()+"/TipoHabitacionController");

    }

}
