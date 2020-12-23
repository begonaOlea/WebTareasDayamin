
package com.tarea.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import com.tarea.model.Estado;
import com.tarea.model.Tarea;
import com.tarea.model.Usuario;
import java.util.Set;


public class DBTarea {
   private static HashMap<Integer, Tarea> tarea;
    private static HashSet<Usuario> usuario;

    static {
        tarea = new HashMap<Integer, Tarea>();
        tarea.put(1, new Tarea(1,"Manejar y gestionar de redes sociales", Estado.DONE));
        tarea.put(2, new Tarea(2,"Asistencia en la medición y gestión KPI´s", Estado.DONE));
        tarea.put(3, new Tarea(3,"Medición de eficiencia productiva", Estado.IN_PROGRESS));
        tarea.put(4, new Tarea(4,"Apoyo en la elaboración de informes", Estado.IN_PROGRESS));
        tarea.put(5, new Tarea(5,"Análisis de los problemas complejos del negocio", Estado.IN_PROGRESS));
        tarea.put(6, new Tarea(6,"Búsqueda de aplicaciones orientadas a creación de valor", Estado.TO_DO));
        tarea.put(7, new Tarea(7,"Recopilar, analizar e interpretar grandes cantidades de datos", Estado.IN_PROGRESS));
        tarea.put(8, new Tarea(8,"proporcionar analisis predictivos relevante para la empresa", Estado.TO_DO));
        tarea.put(9, new Tarea(9,"Modelización, clasificación y predicción de los requerimientos del negocio", Estado.TO_DO));
        tarea.put(10, new Tarea(10,"Diseñar y comunicar informes que visualicen las conclusiones para tona de decisiones", Estado.TO_DO));
        
        
        usuario = new HashSet<Usuario>();
        usuario.add(new Usuario("aaaaa@gmail.com", "1234", "Ainara", "Artea"));
        usuario.add(new Usuario("bbbbb@gmail.com", "2345", "Begoña", "Bilbao"));
        usuario.add(new Usuario("ddddd@gmail.com", "3456", "Aduri", "Deusto"));
        usuario.add(new Usuario("eeeee@gmail.com", "4567", "Endika", "Enbeitia"));
        usuario.add(new Usuario("iiiiii@gmail.com", "5678", "Iker", "Etxauri"));
        usuario.add(new Usuario("llllll@gmail.com", "6789", "Leire", "Lezeaga"));
        
    }
private DBTarea() {
    }

    public synchronized static Collection<Tarea> getAllTarea() {
        return tarea.values();
    }

    public static Collection<Tarea> getTareaEstado() {
        Set<Tarea> estado = new HashSet<Tarea>();
        for (Tarea t : tarea.values()) {
            if (!t.getUsuario()==Estado.TO_DO) {
                estado.add(t);
            }
        }
        return estado;
    }
    
    public synchronized static void alquilar(int id) {
        //MEJORAR - LANZAR UNA EXCEPCION SI ID NO EXISTE
        // SINO  libros.get(id) returna null y 
        // null.setDiponible(fale) da NullPointerExcpetion        
        libros.get(id).setDisponible(false);
    }

    public synchronized static void altaNuevaTarea(Tarea tarea) throws DBException {
        if (libros.containsKey(libro.getId())) {
            throw new DBException("El libro ya existe con el id " + libro.getId());
        }
        libros.put(libro.getId(), libro);
    }

    public synchronized static Collection<Usuario> getUsuarios() {
        return usuarios;
    }

    public synchronized static void altaUsuario(Usuario u) throws DBException {
        boolean seAñade = usuarios.add(u);
        if (!seAñade) {
            throw new DBException("No ha sido añadido. Ya existe");
        }



        
    }

