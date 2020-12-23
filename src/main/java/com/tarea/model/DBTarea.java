package com.tarea.model;

import com.tarea.exception.DBTareaException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import com.tarea.model.Estado;
import com.tarea.model.Tarea;
import com.tarea.model.Usuario;
import java.util.Set;

public class DBTarea {

    private static HashMap<Integer, Tarea>mapTareas;
    private static HashSet<Usuario> usuarios;

    static {
        mapTareas = new HashMap<Integer, Tarea>();
        mapTareas.put(1, new Tarea(1, "Manejar y gestionar de redes sociales", Estado.DONE));
        mapTareas.put(2, new Tarea(2, "Asistencia en la medición y gestión KPI´s", Estado.DONE));
        mapTareas.put(3, new Tarea(3, "Medición de eficiencia productiva", Estado.IN_PROGRESS));
        mapTareas.put(4, new Tarea(4, "Apoyo en la elaboración de informes", Estado.IN_PROGRESS));
        mapTareas.put(5, new Tarea(5, "Análisis de los problemas complejos del negocio", Estado.IN_PROGRESS));
        mapTareas.put(6, new Tarea(6, "Búsqueda de aplicaciones orientadas a creación de valor", Estado.TO_DO));
        mapTareas.put(7, new Tarea(7, "Recopilar, analizar e interpretar grandes cantidades de datos", Estado.IN_PROGRESS));
        mapTareas.put(8, new Tarea(8, "proporcionar analisis predictivos relevante para la empresa", Estado.TO_DO));
        mapTareas.put(9, new Tarea(9, "Modelización, clasificación y predicción de los requerimientos del negocio", Estado.TO_DO));
        mapTareas.put(10, new Tarea(10, "Diseñar y comunicar informes que visualicen las conclusiones para tona de decisiones", Estado.TO_DO));

        usuarios = new HashSet<>();
        usuarios.add(new Usuario("aaaaa@gmail.com", "1234", "Ainara", "Artea"));
        usuarios.add(new Usuario("bbbbb@gmail.com", "2345", "Begoña", "Bilbao"));
        usuarios.add(new Usuario("ddddd@gmail.com", "3456", "Aduri", "Deusto"));
        usuarios.add(new Usuario("eeeee@gmail.com", "4567", "Endika", "Enbeitia"));
        usuarios.add(new Usuario("iiiiii@gmail.com", "5678", "Iker", "Etxauri"));
        usuarios.add(new Usuario("llllll@gmail.com", "6789", "Leire", "Lezeaga"));

    }

    private DBTarea() {
    }

    public synchronized static Collection<Tarea> getAllTarea() {
        return mapTareas.values();
    }

    public static Collection<Tarea> getTareaEstado( Estado e) {
        Set<Tarea> estado = new HashSet<Tarea>();
        for (Tarea t : mapTareas.values()) {
            if (t.getEstado()==e) {
                estado.add(t);
            }
        }
        return estado;
    }

    public synchronized static void CambiarEstado(int id) {
        mapTareas.get(id).setEstado(Estado.TO_DO);
    }

    public synchronized static void AltaTarea(Tarea tarea) throws DBTareaException {
        if (mapTareas.containsKey(tarea.getIdTarea())) {
            throw new DBTareaException("La tarea ya existe con el id " + tarea.getIdTarea());
        } else {
            mapTareas.put(tarea.getIdTarea(), tarea);
        }
       
    }

    public synchronized static Collection<Usuario> getUsuarios() {
        return usuarios;
    }

    public synchronized static void altaUsuario(Usuario u) throws DBTareaException {
        boolean seAgrega = usuarios.add(u);
        if (!seAgrega) {
            throw new DBTareaException("No ha sido agregado porque el usuario existe");
        }

    }
}
