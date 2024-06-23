
package com.emergentes.controller;

import com.emergentes.bean.BeanHotel;
import com.emergentes.bean.BeanOferta;
import com.emergentes.entities.Hotel;
import com.emergentes.entities.Oferta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        BeanHotel daoHotel = new BeanHotel();
        BeanOferta daoOferta = new BeanOferta();
                
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "index";
        
        switch(action){
            case "index":
                
                List<Hotel> hoteles = daoHotel.listarTodos();
                List<Oferta> ofertas = daoOferta.listarTodos();
                                
                request.setAttribute("hoteles", hoteles);
                request.setAttribute("ofertas", ofertas);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }

}
