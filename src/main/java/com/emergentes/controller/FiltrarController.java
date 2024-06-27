
package com.emergentes.controller;

import com.emergentes.bean.BeanHotel;
import com.emergentes.bean.Ubicacion;
import com.emergentes.entities.Hotel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FiltrarController", urlPatterns = {"/FiltrarController"})
public class FiltrarController extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener el parámetro de búsqueda
        String searchText = request.getParameter("searchText").toLowerCase();

        
        System.out.println("bus: "+searchText);
        

        
        BeanHotel daoHotel = new BeanHotel();
        List<Hotel> hoteles = daoHotel.listarTodos();
        
        
        
        
        // Utilizar un Set para evitar duplicados
        Set<Ubicacion> ubicacionesSet = new HashSet<>();
        for (Hotel ele : hoteles) {
            String compa = ele.getCiudad() + ", " + ele.getDepartamento() + ", " + ele.getPais();
            if (compa.toLowerCase().contains(searchText)) {
                System.out.println("item: " + ele.getCiudad());
                ubicacionesSet.add(new Ubicacion(ele.getCiudad(), ele.getDepartamento(), ele.getPais()));
            }
        }
        
        List<Ubicacion> ubicaciones = new ArrayList<>(ubicacionesSet);

        

        // Convertir la lista a JSON manualmente
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < ubicaciones.size(); i++) {
            Ubicacion ubicacion = ubicaciones.get(i);
            json.append("{")
                .append("\"ciudad\":\"").append(ubicacion.getCiudad()).append("\",")
                .append("\"departamento\":\"").append(ubicacion.getDepartamento()).append("\",")
                .append("\"pais\":\"").append(ubicacion.getPais()).append("\"")
                .append("}");
            if (i < ubicaciones.size() - 1) {
                json.append(",");
            }
        }
        json.append("]");

        // Establecer el tipo de contenido y escribir la respuesta
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json.toString());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
    

}
