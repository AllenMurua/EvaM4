package org.example.Interfaces;

import org.example.Modelos.Alumno;
import org.example.Modelos.Materia;

import java.util.List;
import java.util.Map;

public interface IntAlumnoServ {
    public void crearAlumno(Alumno alumno);
    public void agregarMateria(String rutAlumno, Materia materia);
    public List<Materia> materiasPorAlumnos(String rutAlumno) ;
    public Map<String, Alumno> listarAlumnos();
    public Alumno buscarAlumnoPorRut(String rut);

}
