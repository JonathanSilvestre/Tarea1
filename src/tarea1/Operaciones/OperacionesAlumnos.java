package tarea1.Operaciones;

import java.util.*;

import tarea1.clases.Alumno;

public class OperacionesAlumnos {

    private final LinkedList<Alumno> alumnos;

    public OperacionesAlumnos(List<Alumno> alumnosIniciales) {
        this.alumnos = new LinkedList<>(alumnosIniciales);
    }

    // public Alumno buscarPorMatricula(String matricula) {
        
    // }

    // public List<Alumno> buscarPorLicenciatura(String licenciatura) {
        
    // }

    // public List<Alumno> buscarPorGenero(char genero) {
        
    // }

    // public boolean eliminarPorMatricula(String matricula) {
        
    // }

    public boolean estaVacia() {
        return alumnos.isEmpty();
    }
}
