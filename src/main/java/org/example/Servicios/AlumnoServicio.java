package org.example.Servicios;

import org.example.Interfaces.IntAlumnoServ;
import org.example.Modelos.Alumno;
import org.example.Modelos.Materia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlumnoServicio implements IntAlumnoServ {
    private Map<String, Alumno> listaAlumnos;

    public AlumnoServicio() {
        this.listaAlumnos = new HashMap<>();

    }

    public void crearAlumno(Alumno alumno) {
        listaAlumnos.put(alumno.getRut(), alumno);

    }

    public void agregarMateria(String rutAlumno, Materia materia) {
        Alumno alumno = listaAlumnos.get(rutAlumno);
        if (alumno != null) {
            alumno.getMaterias().add(materia);
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }

    public List<Materia> materiasPorAlumnos(String rutAlumno) {
        Alumno alumno = listaAlumnos.get(rutAlumno);
        if (alumno != null) {
            return alumno.getMaterias();
        } else {
            System.out.println("Alumno no encontrado.");
            return null;
        }

    }

    public Map<String, Alumno> listarAlumnos() {
        return listaAlumnos;

    }

    public Alumno buscarAlumnoPorRut(String rut) {
        return listaAlumnos.get(rut);

    }
}