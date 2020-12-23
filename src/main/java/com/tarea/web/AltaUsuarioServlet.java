
package com.tarea.web;

import com.tarea.exception.DBTareaException;
import com.tarea.model.DBTarea;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.tarea.model.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "AltaUsuarioServlet", urlPatterns = {"/alta-usuario"})
public class AltaUsuarioServlet extends HttpServlet {

      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String paramEmail = request.getParameter("email");
        String paramPwd = request.getParameter("pwd");
        String paramNombre = request.getParameter("nombre");
        String paramApell = request.getParameter("apellidos");

        String msgErrorEmail = null;
        String msgErrorPwd = null;
        String msgErrorNombre = null;
        String msgErrorApellidos = null;
        String msgErrorAlta = null;

        boolean valido = true;
       
        if (paramEmail == null || paramEmail.trim().length() == 0) {
            msgErrorEmail = "Favor introducir el email";
            valido = false;
        }

        if (paramPwd == null || paramPwd.trim().length() == 0) {
            msgErrorPwd = "Favor introducir la clave";
            valido = false;
        }

        if (paramNombre == null || paramNombre.trim().length() == 0) {
            msgErrorNombre = "Favor introducir el nombre ";
            valido = false;
        }

        if (paramApell == null || paramApell.trim().length() == 0) {
            msgErrorApellidos = "Favor introducir  los apellidos ";
            valido = false;
        }

        if (valido) {
            Usuario usuario = new Usuario(paramEmail,paramPwd,paramNombre,paramApell);
            try {
                DBTarea.altaUsuario(usuario);
           HttpSession session = request.getSession();
           session.setAttribute("usuario",usuario);    
                
            } catch (DBTareaException e) {
                msgErrorAlta = e.getMessage();
                valido = false;               
            }
        }

        String jspAMostrar = "";
        if (valido) {
            jspAMostrar = "lista-usuarios.jsp";
        } else {
            jspAMostrar = "form-alta-usuario.jsp";
            request.setAttribute("msgErrorEmail", msgErrorEmail);
            request.setAttribute("msgErrorPwd", msgErrorPwd);
            request.setAttribute("msgErrorNombre", msgErrorNombre);
            request.setAttribute("msgErrorApellidos", msgErrorApellidos);
            request.setAttribute("msgErrorAlta", msgErrorAlta);
        }
        
        RequestDispatcher rd = request.getRequestDispatcher(jspAMostrar);
        rd.forward(request, response);

    }

}
