
package com.emergentes.controller;

import com.emergentes.bean.BeanRol;
import com.emergentes.bean.BeanUsuario;
import com.emergentes.entities.Rol;
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

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession ses = request.getSession();
        ses.invalidate();

        response.sendRedirect(request.getContextPath()+"/MainController");



    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        BeanUsuario daoUsuario = new BeanUsuario();
        BeanRol daoRol = new BeanRol();
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        String action = request.getParameter("action");
        
        
        int estado=0;

        if (action.equals("sesion")) {
                        
            List<Usuario> usuarios = daoUsuario.listarTodos();
            
            for(Usuario usuario: usuarios){
                if(usuario.getEmail().equals(email) && usuario.getPassword().equals(password)){
                    estado=1;
                    HttpSession ses = request.getSession();
                    ses.setAttribute("usuario", usuario);
                    ses.setAttribute("login", "OK");

                }
            }
            if(estado==1){
                System.out.println("contrase correcta condicion de" );
            }else{
                System.out.println("contrase incorrecta");
            }
            response.sendRedirect(request.getContextPath() + "/MainController");

        } else {
            
            Usuario user = new Usuario();
            String nombre = request.getParameter("nombre");
            int id=Integer.parseInt(request.getParameter("rol"));
            
            Rol rol = daoRol.buscar(id);
            
            user.setNombre(nombre);
            user.setEmail(email);
            user.setPassword(password);
            user.setIdRol(rol);

            response.sendRedirect(request.getContextPath() + "/MainController");
        }
        
        
        
    }

}
