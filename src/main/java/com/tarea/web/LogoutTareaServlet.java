
package com.tarea.web;

import com.tarea.servicios.LoginTareaService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "LogoutTareaServlet", urlPatterns = {"/logout-tarea"})
public class LogoutTareaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        LoginTareaService servicio = new LoginTareaService();
        servicio.logout(req.getSession());
        
        RequestDispatcher rd = req.getRequestDispatcher("loginTarea.jsp");
        rd.forward(req, resp); 
        
    }

   
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
       
    }

   
    protected void doProcess(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    }// </editor-fold>

}
