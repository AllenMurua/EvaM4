package org.example.Modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArchivoServicio {
    private List<Alumno> AlumnosACargar;
    private List<Double> Promedios;
    public ArchivoServicio() {
        AlumnosACargar = new ArrayList<Alumno>();
    }
    public void ExportarDatos(Map<String,Alumno> alumnos, String ruta){

    }

    public List<Alumno> getAlumnosACargar() {
        return AlumnosACargar;
    }

    public void setAlumnosACargar(List<Alumno> alumnosACargar) {
        AlumnosACargar = alumnosACargar;
    }

    public List<Double> getPromedios() {
        return Promedios;
    }

    public void setPromedios(List<Double> promedios) {
        Promedios = promedios;
    }
}
