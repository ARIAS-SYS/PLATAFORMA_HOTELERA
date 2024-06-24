
package com.emergentes.controller;

import com.emergentes.entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ClienteController", urlPatterns = {"/ClienteController"})
public class ClienteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "index";
        
        switch(action){
            case "reservas":
                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("cliente/reservas_cliente.jsp").forward(request, response);
                break;
            case "favoritos":
                request.getRequestDispatcher("cliente/favoritos_cliente.jsp").forward(request, response);
                break;
            case "ofertas":
                request.getRequestDispatcher("cliente/ofertas_cliente.jsp").forward(request, response);
                break;
        }

    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }

}
