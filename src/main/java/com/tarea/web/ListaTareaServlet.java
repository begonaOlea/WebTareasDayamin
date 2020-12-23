
package com.tarea.web;

import com.tarea.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ListaTareaServlet", urlPatterns = {"/lista-tarea"})
public class ListaTareaServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
           
           HttpSession s = req.getSession();
           Usuario usr;
           if (s.getAttribute("usuario") ==null){
               resp.sendRedirect("form-loging");
           }
            
//           lista<tareas> listaToDo = servioce.getLista
            
    }

    
    
    
    
}