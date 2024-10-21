package org.example.Servicios;

import org.example.Modelos.Alumno;
import org.example.Modelos.Materia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArchivoServicio {
    private PromedioServicioImp promedioServicioImp;

    public ArchivoServicio() {
        this.promedioServicioImp = new PromedioServicioImp();

    }

    public List<Alumno> alumnosACargar() {
        return new ArrayList<>();

    }

    public void exportarDatos(Map<String, Alumno> alumnos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/org/example/Utilidad/Datos.txt"))) {
            for (Alumno alumno : alumnos.values()) {
                writer.write("Alumno : " + alumno.getRut() + " - " + alumno.getNombre() + "\n");
                for (Materia materia : alumno.getMaterias()) {
                    double promedio = promedioServicioImp.calcularPromedio(materia.getNotas());
                    writer.write("Materia : " + materia.getNombre() + " - Promedio : " + String.format("%.1f", promedio) + "\n");

                }
                writer.write("\n");

            }
            System.out.println("Datos exportados correctamente");

        } catch (IOException e) {
            System.out.println("Error al exportar los datos: " + e.getMessage());

        }
    }
}