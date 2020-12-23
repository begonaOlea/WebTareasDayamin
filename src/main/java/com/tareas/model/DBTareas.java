
package com.tareas.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import com.tareas.model.Estado;
import com.tareas.model.Tarea;


public class DBTareas {
   private static HashMap<Integer, Tarea> tareas;
    private static HashSet<Usuario> usuarios;

    static {
        tareas = new HashMap<Integer, Tarea>();
        tareas.put(1, new Tarea(1,"Manejar y gestionar de redes sociales", Estado.DONE));
        tareas.put(2, new Tarea(2,"Asistencia en la medición y gestión KPI´s", Estado.DONE));
        tareas.put(3, new Tarea(3,"Medición de eficiencia productiva", Estado.IN_PROGRESS));
        tareas.put(4, new Tarea(4,"Apoyo en la elaboración de informes", Estado.IN_PROGRESS));
        tareas.put(5, new Tarea(5,"Análisis de los problemas complejos del negocio", Estado.IN_PROGRESS));
        tareas.put(6, new Tarea(6,"Búsqueda de aplicaciones orientadas a creación de valor", Estado.TO_DO));
        tareas.put(7, new Tarea(7,"Recopilar, analizar e interpretar grandes cantidades de datos", Estado.IN_PROGRESS));
        tareas.put(8, new Tarea(8,"proporcionar analisis predictivos relevante para la empresa", Estado.TO_DO));
        tareas.put(9, new Tarea(9,"Modelización, clasificación y predicción de los requerimientos del negocio", Estado.TO_DO));
        tareas.put(10, new Tarea(10,"Diseñar y comunicar informes que visualicen las conclusiones para tona de decisiones", Estado.TO_DO));
    }
}
