package tarea1.Operaciones;

import java.util.*;

import tarea1.clases.Alumno;

public class OperacionesAlumnos {

    private final LinkedList<Alumno> alumnos;

    public OperacionesAlumnos(List<Alumno> alumnosIniciales) {

        this.alumnos = new LinkedList<>(alumnosIniciales);

    }

    // Busca un alumno por su matrícula y devuelve el objeto Alumno si se encuentra, o null si no se encuentra
    public Alumno buscarPorMatricula(String matricula) {
    for (Alumno al : this.alumnos) {
        
        if (al.getMatricula().equals(matricula)) {
            
            return al; 
        }
    }
    
    return null;     
    }

    //Busca alumnos por licenciatura
    public List<Alumno> buscarPorLicenciatura(String licenciatura) {

        String criterio = licenciatura;

        List<Alumno> encontrados = new LinkedList<>();

        // Se recorre la lista de alumnos y se compara la licenciatura de cada alumno con el criterio
        for (Alumno alumno : alumnos) {

            if (alumno.getLicenciatura().equalsIgnoreCase(criterio)) {

                encontrados.add(alumno);

            }
        }

        return encontrados;
    }

    //Busca alumnos por genero, ignorando mayusculas
    public List<Alumno> buscarPorGenero(char genero) {
        List<Alumno> resultados = new ArrayList<>();

        char generoBuscado = Character.toUpperCase(genero);

        for (Alumno al : this.alumnos){
            if (Character.toUpperCase(al.getGenero()) == generoBuscado){
                resultados.add(al);
            }
        }

        return resultados;
    }

    // Elimina un alumno por su matrícula, devuelve true si se eliminó correctamente o false si no se encontró ningún alumno con esa matrícula
    public boolean eliminarPorMatricula(String matricula) {

    Iterator<Alumno> it = alumnos.iterator();
    
    // Se recorre la lista de alumnos utilizando un iterador para poder eliminar elementos de la lista mientras se itera
    while (it.hasNext()) {
        Alumno al = it.next();

        // Si se encuentra un alumno con la matrícula especificada, se elimina de la lista y se devuelve true
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
