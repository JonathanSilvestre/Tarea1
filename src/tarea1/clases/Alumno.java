package tarea1.clases;

public class Alumno {

    private final String matricula;
    private final String nombre;
    private final String primerApellido;
    private final String segundoApellido;
    private final String licenciatura;
    private final char genero;

    public Alumno(String matricula, String nombre, String primerApellido, String segundoApellido, String licenciatura, char genero) {

        this.matricula = matricula;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.licenciatura = licenciatura;
        this.genero = Character.toUpperCase(genero);

    }

    public String getMatricula() {

        return matricula;

    }

    public String getNombre() {

        return nombre;

    }

    public String getPrimerApellido() {

        return primerApellido;

    }

    public String getSegundoApellido() {

        return segundoApellido;

    }

    public String getLicenciatura() {

        return licenciatura;

    }

    public char getGenero() {

        return genero;

    }

    public String getNombreCompleto() {

        return nombre + " " + primerApellido + " " + segundoApellido;

    }

    @Override
    public String toString() {

        return "Matricula: " + matricula + ", Nombre: " + getNombreCompleto() + ", Licenciatura: " + licenciatura + ", Genero: " + genero;

    }
}
