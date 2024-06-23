
package com.emergentes.controller;

import com.emergentes.bean.BeanFavorito;
import com.emergentes.bean.BeanHotel;
import com.emergentes.bean.BeanOferta;
import com.emergentes.entities.Favorito;
import com.emergentes.entities.Hotel;
import com.emergentes.entities.Oferta;
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
                    
                    // Devolver respuesta JSON
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");

                    PrintWriter out = response.getWriter();
                    out.print("{\"sessionExists\": " + true + "}");
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
        }

    }

}
