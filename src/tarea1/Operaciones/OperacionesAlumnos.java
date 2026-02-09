package tarea1.Operaciones;

import java.util.*;

import tarea1.clases.Alumno;

public class OperacionesAlumnos {

    private final LinkedList<Alumno> alumnos;

    public OperacionesAlumnos(List<Alumno> alumnosIniciales) {
        this.alumnos = new LinkedList<>(alumnosIniciales);
    }

    public Alumno buscarPorMatricula(String matricula) {
    for (Alumno al : this.alumnos) {
        
        if (al.getMatricula().equals(matricula)) {
            
            return al; 
        }
    }
    
    return null;     
    }

    // public List<Alumno> buscarPorLicenciatura(String licenciatura) {
        
    // }

    // public List<Alumno> buscarPorGenero(char genero) {
        
    // }

    public boolean eliminarPorMatricula(String matricula) {

    Iterator<Alumno> it = alumnos.iterator();

    while (it.hasNext()) {
        Alumno al = it.next();

        if (al.getMatricula().equals(matricula)) {
            it.remove(); // elimina de la LinkedList
            return true;
        }
    }

    return false; // no se encontró
    }

    public boolean estaVacia() {
        return alumnos.isEmpty();
    }
}
