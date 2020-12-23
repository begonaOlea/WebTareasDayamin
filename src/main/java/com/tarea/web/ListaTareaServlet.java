
package com.tarea.web;

import com.tarea.model.DBTarea;
import com.tarea.model.Estado;
import com.tarea.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
               resp.sendRedirect("form-loging");   // URL del jsp donde quiero 
           }else{
               usr= (Usuario)s.getAttribute("usuario");
           }
          
//          List<tarea> listToDo = DBTarea.getListTareaPorUsuarioEstado();  analizar!!!!
           
//           List<tarea> listToDo = service.getListaporEstado(Estado.TO_DO);
//           List<tarea> listInProgress = service.getListaporEstado(Estado.IN_PROGRESS);
//           List<tarea> listaDone = service.getListaporEstado(Estado.DONE);
//            

  //          req.setAttribute((listaToDO, ), listToDo);
  
  
    }
//          RequestDispatcher rd = request.getRequestDispatcher(jspAMostrar);
//          rd.forward(request, response);
//    
    
    
    
}