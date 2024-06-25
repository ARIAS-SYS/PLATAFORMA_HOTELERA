
package com.emergentes.controller;

import com.emergentes.bean.BeanHabitacion;
import com.emergentes.bean.BeanOferta;
import com.emergentes.bean.BeanReserva;
import com.emergentes.bean.BeanTipoHabitacion;
import com.emergentes.bean.BeanUsuario;
import com.emergentes.entities.Habitacion;
import com.emergentes.entities.Oferta;
import com.emergentes.entities.Reserva;
import com.emergentes.entities.TipoHabitacion;
import com.emergentes.entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ReservasController", urlPatterns = {"/ReservasController"})
public class ReservasController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        BeanUsuario daoUsuario = new BeanUsuario();      
        usuario=daoUsuario.buscar(usuario.getId());
        session.setAttribute("usuario", usuario);
        
        int id;
        
        BeanReserva daoReserva = new BeanReserva();
        Reserva elemento = new Reserva();
        
        BeanHabitacion daoHabitacion = new BeanHabitacion();
        Habitacion habitacion = new Habitacion();
        
        
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        
        switch(action){
            case "cambiarEstado":
                String opcion=request.getParameter("opcion");
                id=Integer.parseInt(request.getParameter("id"));
                elemento=daoReserva.buscar(id);
                
                habitacion=daoHabitacion.buscar(elemento.getIdHabit().getId());
                
                if(opcion.equals("reservado")){
                    elemento.setEstado("Reservado");
                }else if(opcion.equals("estadia")){
                    elemento.setEstado("En Estancia");
                    habitacion.setEstado("Ocupado");
                }else if(opcion.equals("completado")){
                    elemento.setEstado("Completado");
                }
                daoReserva.editar(elemento);
                daoHabitacion.editar(habitacion);
                response.sendRedirect(request.getContextPath()+"/PropietarioController?action=reservas");
                break;
            
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }

}
