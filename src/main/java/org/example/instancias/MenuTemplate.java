package org.example.instancias;

import java.util.Scanner;

public interface MenuTemplate {
    public Scanner scanner();
    public void ExportarDatos();
    public void CrearAlumno();
    public void AgregarMateria();
    public void AgregarNota();
    public void ListarAlumnos();
    public void TerminarPrograma();
    public void IniciarMenu(Scanner sc);

}
