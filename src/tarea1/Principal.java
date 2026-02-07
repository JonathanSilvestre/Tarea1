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
        
    }

    private static void buscarAlumnosPorLicenciatura(Scanner scanner, OperacionesAlumnos operaciones) {
        
    }

    private static void buscarAlumnosPorGenero(Scanner scanner, OperacionesAlumnos operaciones) {
        


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
