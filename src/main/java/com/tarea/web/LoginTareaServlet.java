
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
import javax.servlet.http.HttpSession;


@WebServlet(name = "LoginTareaServlet", urlPatterns = {"/login-tarea"})
public class LoginTareaServlet extends HttpServlet {

     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
      
        String paramEmail = req.getParameter("email");
        String paramPwd = req.getParameter("pwd");

        String msgErrorEmail = null;
        String msgErrorPwd = null;
        String msgErrorLogin = null;

        boolean valido = true;

        if (paramEmail == null || paramEmail.trim().length() == 0) {
            msgErrorEmail = "Favor introducir el email del usuario";
            valido = false;
        }

        if (paramPwd == null || paramPwd.trim().length() == 0) {
            msgErrorPwd = "Favor introducir la clave";
            valido = false;
        }
        if (valido) {
            try {
                HttpSession sesion = req.getSession();
                LoginTareaService servicio = new LoginTareaService();
                servicio.login(paramEmail, paramPwd, sesion);
                } catch (javax.security.auth.login.LoginException ex) {
            
            }
        }

        String jspAMostrar = "";
        if (valido) {
            jspAMostrar = "index.jsp";
        } else {
            jspAMostrar = "login.jsp";
            req.setAttribute("msgErrorEmail", msgErrorEmail);
            req.setAttribute("msgErrorPwd", msgErrorPwd);
            req.setAttribute("msgErrorLogin", msgErrorLogin);
        }

        RequestDispatcher rd = req.getRequestDispatcher(jspAMostrar);
        rd.forward(req, resp);
    }//fin post

}
