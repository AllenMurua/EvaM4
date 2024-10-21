package org.example.Servicios;

import java.util.List;

public class PromedioServicioImp {

    public double calcularPromedio(List<Double> notas) {
        try {
            if (notas == null || notas.isEmpty()) {
                return 0.0;
            }

            double suma = 0.0;
            for (Double nota : notas) {
                suma += nota;
            }
            return suma / notas.size();
        }catch (Exception e) {
            return 0.0;
        }
    }
}