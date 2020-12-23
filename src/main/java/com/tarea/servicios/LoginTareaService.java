
package com.tarea.servicios;

import com.tarea.model.DBTarea;
import com.tarea.model.Usuario;
import java.util.Collection;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpSession;



public class LoginTareaService {
    public void login(String email, String password, HttpSession session) throws LoginException {
       
        Collection <Usuario> usuarios = DBTarea.getUsuarios();
        Usuario usrEncontrado = null;
        usuarios.contains(this);
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email)) {
                usrEncontrado = u;
                break;
            }
        }
       
        if (usrEncontrado == null) {
            throw new LoginException("El usuario no existe. Debe registrarse");
        } else {
            if (usrEncontrado.getPassword().equals(password)) {
                 session.setAttribute("usuario", usrEncontrado);
            } else {
                throw new LoginException("Clave no válida");
            }
        }

    }//fin login

    public void logout(HttpSession session) {
        session.invalidate();
    }

    public void setAttribute() {
    }
    
}
