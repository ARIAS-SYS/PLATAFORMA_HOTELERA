
package com.emergentes.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PropietarioController", urlPatterns = {"/PropietarioController"})
public class PropietarioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "index";
        
        switch(action){
            case "home":
                request.getRequestDispatcher("propietario/home_propietario.jsp").forward(request, response);
                break;
            case "reservas":
                request.getRequestDispatcher("propietario/reservas_propietario.jsp").forward(request, response);
                break;
            case "habitaciones":
                request.getRequestDispatcher("propietario/habitaciones_propietario.jsp").forward(request, response);
                break;
            case "tipo_habitaciones":
                request.getRequestDispatcher("propietario/tipo_habitaciones_propietario.jsp").forward(request, response);
                break;
            case "ofertas":
                request.getRequestDispatcher("propietario/ofertas_propietario.jsp").forward(request, response);
                break;
            case "detalle":
                request.getRequestDispatcher("propietario/detalle_propietario.jsp").forward(request, response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }

}
