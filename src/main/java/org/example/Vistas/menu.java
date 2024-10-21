package org.example.Vistas;

import org.example.Modelos.*;
import org.example.Servicios.AlumnoServicio;
import org.example.Servicios.ArchivoServicio;

public class menu extends MenuTemplate {
    private AlumnoServicio alumnoServicio;
    private ArchivoServicio archivoServicio;

    public menu() {
        super();
        this.alumnoServicio = new AlumnoServicio();
        this.archivoServicio = new ArchivoServicio();
    }

    @Override
    public void exportarDatos() {
        System.out.println("--- Exportar Datos ---");
        archivoServicio.exportarDatos(alumnoServicio.listarAlumnos());
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

        while (true) {
            String rut = scanner.nextLine();
            Alumno alumno = alumnoServicio.buscarAlumnoPorRut(rut);

            if (alumno != null) {
                System.out.println("1. MATEMATICAS");
                System.out.println("2. LENGUAJE");
                System.out.println("3. CIENCIA");
                System.out.println("4. HISTORIA");
                System.out.print("Selecciona una Materia: ");

                int opcionMateria;
                while (true) {
                    try {
                        opcionMateria = Integer.parseInt(scanner.nextLine());
                        if (opcionMateria >= 1 && opcionMateria <= 4) {
                            break;
                        } else {
                            System.out.print("Opción no válida. Por favor, selecciona un número entre 1 y 4: ");
                        }
                    } catch (NumberFormatException e) {
                        System.out.print("Por favor, ingresa un número válido: ");
                    }
                }

                MateriaEnum materiaEnum;
                switch (opcionMateria) {
                    case 1:
                        materiaEnum = MateriaEnum.MATEMATICAS;
                        break;
                    case 2:
                        materiaEnum = MateriaEnum.LENGUAJE;
                        break;
                    case 3:
                        materiaEnum = MateriaEnum.CIENCIA;
                        break;
                    case 4:
                        materiaEnum = MateriaEnum.HISTORIA;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        return;
                }

                Materia materia = new Materia(materiaEnum);
                alumnoServicio.agregarMateria(rut, materia);
                System.out.println("--- ¡Materia agregada! ---");
                break;
            } else {
                System.out.print("Alumno no encontrado. Por favor, introduce un RUT válido: ");
            }
        }
    }

    @Override
    public void agregarNotaPasoUno() {
        System.out.println("--- Agregar Nota ---");
        System.out.print("Ingresa rut del Alumno: ");
        String rut = scanner.nextLine();

        Alumno alumno = alumnoServicio.buscarAlumnoPorRut(rut);
        if (alumno == null) {
            System.out.println("Alumno no encontrado.");
            return;
        }

        System.out.println("Alumno tiene las siguientes materias agregadas:");
        for (int i = 0; i < alumno.getMaterias().size(); i++) {
            System.out.println((i + 1) + ". " + alumno.getMaterias().get(i).getNombre());
        }

        System.out.print("Seleccionar materia: ");
        int opcionMateria = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (opcionMateria < 1 || opcionMateria > alumno.getMaterias().size()) {
            System.out.println("Opción no válida.");
            return;
        }

        Materia materia = alumno.getMaterias().get(opcionMateria - 1);

        System.out.print("Ingresar nota: ");
        double nota = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        materia.agregarNota(nota);
        System.out.println("--- ¡Nota agregada a " + materia.getNombre() + "! ---");
    }

    @Override
    public void listarAlumnos() {
        System.out.println("--- Listar Alumnos ---");
        for (Alumno alumno : alumnoServicio.listarAlumnos().values()) {
            System.out.println("Datos Alumno");
            System.out.println("RUT: " + alumno.getRut());
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Apellido: " + alumno.getApellido());
            System.out.println("Dirección: " + alumno.getDireccion());
            System.out.println("Materias:");
            for (Materia materia : alumno.getMaterias()) {
                System.out.println(materia.getNombre());
                System.out.println("Notas: " + materia.getNotas());
            }
            System.out.println();
        }
    }

    @Override
    public void terminarPrograma() {
        System.out.println("Saliendo del programa...");
        System.exit(0);
    }
}