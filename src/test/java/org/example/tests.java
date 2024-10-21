package org.example;

import org.example.Modelos.Alumno;
import org.example.Modelos.Materia;
import org.example.Modelos.MateriaEnum;
import org.example.Servicios.AlumnoServicio;
import org.example.Servicios.PromedioServicioImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AlumnoServicioTest {
    private AlumnoServicio alumnoServicio;

    @Mock
    private AlumnoServicio alumnoServicioMock;

    private Materia matematicas;
    private Materia lenguaje;
    private Alumno mapu;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        alumnoServicio = new AlumnoServicio();
        matematicas = new Materia(MateriaEnum.MATEMATICAS);
        lenguaje = new Materia(MateriaEnum.LENGUAJE);
        mapu = new Alumno("12345678-9", "Mapu", "Apellido", "Dirección");
        promedioServicio = new PromedioServicioImp();
    }

    @Test
    void crearAlumnoTest() {
        alumnoServicio.crearAlumno(mapu);
        assertNotNull(alumnoServicio.buscarAlumnoPorRut("12345678-9"));
        assertEquals(mapu, alumnoServicio.buscarAlumnoPorRut("12345678-9"));
    }

    @Test
    void agregarMateriaTest() {
        alumnoServicio.crearAlumno(mapu);
        alumnoServicio.agregarMateria("12345678-9", matematicas);
        Alumno alumnoRecuperado = alumnoServicio.buscarAlumnoPorRut("12345678-9");
        assertTrue(alumnoRecuperado.getMaterias().contains(matematicas));
    }

    @Test
    void materiasPorAlumnosTest() {
        when(alumnoServicioMock.materiasPorAlumnos("12345678-9")).thenReturn(Arrays.asList(matematicas, lenguaje));

        List<Materia> materias = alumnoServicioMock.materiasPorAlumnos("12345678-9");
        assertEquals(2, materias.size());
        assertTrue(materias.contains(matematicas));
        assertTrue(materias.contains(lenguaje));
    }

    @Test
    void listarAlumnosTest() {
        alumnoServicio.crearAlumno(mapu);
        Map<String, Alumno> alumnos = alumnoServicio.listarAlumnos();
        assertFalse(alumnos.isEmpty());
        assertTrue(alumnos.containsKey("12345678-9"));
        assertEquals(mapu, alumnos.get("12345678-9"));
    }

    private PromedioServicioImp promedioServicio;


    @Test
    void calcularPromedioTest() {
        assertEquals(3.0, promedioServicio.calcularPromedio(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0)));
        assertEquals(0.0, promedioServicio.calcularPromedio(Collections.emptyList()));
        assertEquals(0.0, promedioServicio.calcularPromedio(null));
        assertEquals(4.5, promedioServicio.calcularPromedio(Arrays.asList(4.0, 5.0)));
    }
}