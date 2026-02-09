/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea1;

import java.io.*;
import java.nio.file.*;
import java.util.*;


import tarea1.Operaciones.OperacionesAlumnos;
import tarea1.clases.Alumno;

/**
 *
 * @author Equipo 2
 */

public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Path rutaArchivo = Paths.get("ArchivoAlumnos", "alumnos.dat");
        List<Alumno> alumnos;

        try {

            alumnos = cargarAlumnosDesdeArchivo(rutaArchivo);

        } catch (IOException e) {

            System.err.println("No se pudo cargar el archivo de alumnos: " + e.getMessage());
            return;

        }

        OperacionesAlumnos operaciones = new OperacionesAlumnos(alumnos);

        try (Scanner scanner = new Scanner(System.in)) {

            int opcion = 0;

            do {

                mostrarMenu();

                String entrada = scanner.nextLine().trim();

                try {

                    opcion = Integer.parseInt(entrada);

                } catch (NumberFormatException e) {

                    System.out.println("Ingrese un numero valido.");
                    continue;

                }

                switch (opcion) {

                    case 1:

                        buscarAlumnoPorMatricula(scanner, operaciones);
                        break;

                    case 2:

                        buscarAlumnosPorLicenciatura(scanner, operaciones);
                        break;

                    case 3:

                        buscarAlumnosPorGenero(scanner, operaciones);
                        break;

                    case 4:

                        borrarAlumnoPorMatricula(scanner, operaciones);
                        break;

                    case 5:

                        System.out.println("Hasta pronto!");
                        break;

                    default:

                        System.out.println("Opcion no valida. Intente nuevamente.");


                }

                System.out.println();

            } while (opcion != 5);
        }
    }

    private static void mostrarMenu() {

        System.out.println("===== MENU PRINCIPAL =====");
        System.out.println("1. Buscar Alumno por Matricula");
        System.out.println("2. Buscar Alumnos por Licenciatura");
        System.out.println("3. Buscar Alumnos por Genero");
        System.out.println("4. Borrar un alumno por matrícula");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opcion: ");

    }

    private static void buscarAlumnoPorMatricula(Scanner scanner, OperacionesAlumnos operaciones) {
    System.out.println("-BUSQUEDA POR MATRICULA-");
    System.out.print("Ingresa la matricula del alumno: ");
    String matriculaCapturada = scanner.nextLine().trim();

    Alumno alumnoEncontrado = operaciones.buscarPorMatricula(matriculaCapturada);

    if (alumnoEncontrado != null) {
        System.out.println("¡Alumno encontrado!");
        System.out.println(alumnoEncontrado);
    } else {
        System.out.println("Error: No existe ningun alumno: " + matriculaCapturada);
    }    
    }

    //Busca alumnos por licenciatura, ignorando mayusculas y espacios
    private static void buscarAlumnosPorLicenciatura(Scanner scanner, OperacionesAlumnos operaciones) {

        // Se le solicita al usuario que ingrese la clave de licenciatura a buscar
        System.out.print("Ingrese la licenciatura a buscar: ");
        // Se lee la entrada del usuario y se eliminan espacios en blanco al inicio y al final
        String licenciatura = scanner.nextLine().trim();

        // Se valida que el usuario haya ingresado una clave de licenciatura
        if (licenciatura.isEmpty()) {

            System.out.println("Se requiere la clave de licenciatura para realizar la busqueda.");
            return;

        }

        // Se valida que la clave de licenciatura sea una de las opciones validas (LIC001 o LIC002)
        if (!licenciatura.equals("LIC001") && !licenciatura.equals("LIC002")) {

            System.out.println("Clave de licenciatura no valida.");
            System.out.println("La clave de licenciatura debe ser LIC001 o LIC002");
            return;

        }

        // Se llama al metodo buscarPorLicenciatura de la clase OperacionesAlumnos para obtener la lista de alumnos que pertenecen a la licenciatura ingresada por el usuario
        List<Alumno> encontrados = operaciones.buscarPorLicenciatura(licenciatura);

        if (encontrados.isEmpty()) {

            // Si no se encontraron alumnos para la licenciatura ingresada, se muestra un mensaje indicando que no se encontraron resultados
            System.out.println("No se encontraron alumnos para la licenciatura " + licenciatura + ".");
            return;

        }

        // Si se encontraron alumnos para la licenciatura ingresada, entonces se muestra la lista de alumnos encontrados
        System.out.println("Alumnos en la licenciatura " + licenciatura + ":");

        for (Alumno alumno : encontrados) {

            System.out.println(alumno);

        }
    }

    private static void buscarAlumnosPorGenero(Scanner scanner, OperacionesAlumnos operaciones) {
        System.out.print("Ingrese el género del alumno que deseé buscar (M o F): ");
        String entrada = scanner.next().toUpperCase();

        if (entrada.lenght() > 0){
            char genero = entrada.charAt(0);

            List<Alumno> encontrados = operaciones.buscarPorGenero(genero);

            if (encontrados.isEmpty()){
                System.out.println("No se encontraron alumnos con el género escrito.");
            }
            else {
                System.out.println("Alumnos encontrados");
                for (Alumno al : encontrados){
                    System.out.println(al.getMatricula() + " - " + al.getNombreCompleto);
                }
            }
        }
        else {
                System.out.println("Entrada no válida.");
            }
    }

    private static void borrarAlumnoPorMatricula(Scanner scanner, OperacionesAlumnos operaciones) {
        
    }

    private static List<Alumno> cargarAlumnosDesdeArchivo(Path rutaArchivo) throws IOException {

        if (!Files.exists(rutaArchivo)) {

            throw new IOException("No se encontro el archivo: " + rutaArchivo.toAbsolutePath());

        }

        List<Alumno> alumnos = new LinkedList<>();

        try (BufferedReader reader = Files.newBufferedReader(rutaArchivo)) {

            String linea;

            while ((linea = reader.readLine()) != null) {

                if (linea.isBlank()) {

                    continue;

                }

                String[] partes = linea.split(",");

                if (partes.length < 6) {

                    continue;

                }

                char genero = partes[5].trim().isEmpty()
                        ? ' '
                        : Character.toUpperCase(partes[5].trim().charAt(0));

                alumnos.add(new Alumno(
                        partes[0].trim(),
                        partes[1].trim(),
                        partes[2].trim(),
                        partes[3].trim(),
                        partes[4].trim().toUpperCase(),
                        genero
                ));
            }
        }

        return alumnos;
    }
    
}
