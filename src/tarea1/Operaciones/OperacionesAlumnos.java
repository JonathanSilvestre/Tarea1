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

    //Busca alumnos por licenciatura, ignorando mayusculas y espacios
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

    // public boolean eliminarPorMatricula(String matricula) {
        
    // }

    public boolean estaVacia() {
        return alumnos.isEmpty();
    }
}
