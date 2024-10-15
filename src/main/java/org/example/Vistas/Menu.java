package org.example.Vistas;

import org.example.Modelos.Alumno;
import org.example.Modelos.AlumnoServicio;
import org.example.Modelos.ArchivoServicio;
import org.example.Modelos.MateriaEnum;
import org.example.instancias.MenuTemplate;

import java.util.Scanner;

public class Menu extends MenuTemplate {
    private AlumnoServicio alumnoServicio;
    private ArchivoServicio archivoServicio;

    public Scanner scanner;
    public Menu() {
        super();
        this.alumnoServicio = new AlumnoServicio();
        this.archivoServicio = new ArchivoServicio();
    }

    @Override
    public void exportarDatos() {
        System.out.println("--- Exportar Datos ---");
        System.out.print("Ingresa la ruta en donde se exportará el archivo: ");
        String ruta = scanner.nextLine();
        archivoServicio.exportarDatos(alumnoServicio.listarAlumnos(), ruta);
        System.out.println("Datos exportados correctamente.");
    }

    @Override
    public void crearAlumno() {
        System.out.println("--- Crear Alumno ---");
        System.out.print("Ingresa RUT: ");
        String rut = scanner.nextLine();
        System.out.print("Ingresa nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingresa dirección: ");
        String direccion = scanner.nextLine();

        Alumno alumno = new Alumno(rut, nombre, apellido, direccion);
        alumnoServicio.crearAlumno(alumno);
        System.out.println("--- ¡Alumno agregado! ---");
    }

    @Override
    public void agregarMateria() {
        System.out.println("--- Agregar Materia ---");
        System.out.print("Ingresa rut del Alumno: ");
        String rut = scanner.nextLine();

        System.out.println("1. MATEMATICAS");
        System.out.println("2. LENGUAJE");
        System.out.println("3. CIENCIA");
        System.out.println("4. HISTORIA");
        System.out.print("Selecciona una Materia: ");
        int opcionMateria = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        MateriaEnum materiaEnum;
        switch (opcionMateria) {
            case 1: materiaEnum = MateriaEnum.MATEMATICAS; break;
            case 2: materiaEnum = MateriaEnum.LENGUAJE; break;
            case 3: materiaEnum = MateriaEnum.CIENCIA; break;
            case 4: materiaEnum = MateriaEnum.HISTORIA; break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        Materia materia = new Materia(materiaEnum);
        alumnoServicio.agregarMateria(rut, materia);
        System.out.println("--- ¡Materia agregada! ---");
    }

    @Override
    public void agregarNotaPasoUno() {
        // Implementación similar a agregarMateria, pero para agregar notas
    }

    @Override
    public void listarAlumnos() {
        System.out.println("--- Listar Alumnos ---");
        for (Alumno alumno : alumnoServicio.listarAlumnos().values()) {
            System.out.println(alumno);
        }
    }

    @Override
    public void terminarPrograma() {
        System.out.println("Saliendo del programa...");
        System.exit(0);
    }
}
