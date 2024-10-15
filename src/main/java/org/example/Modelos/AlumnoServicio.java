package org.example.Modelos;

import java.util.Map;

public class AlumnoServicio {
    private Map<String, Alumno> listaAlumnos;

    public AlumnoServicio(Map<String, Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }
    public void crearAlumno(Alumno alumno){
    }

    public void agregarMateria(String rutAlumno, Materia materia){

    }

    public void materiasPorAlumnos(String rutAlumno){  }

    public void listarAlumnos() {
        Map<String, Alumno> alumnos = listaAlumnos;
        for (Alumno alumno : alumnos.values()) {
            System.out.println(alumno);
        }
    }

}
