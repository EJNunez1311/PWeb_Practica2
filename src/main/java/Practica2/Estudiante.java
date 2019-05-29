package Practica2;

public class Estudiante {

    private int matricula;
    private  String nombre;
    private  String carrera;
    private  String telefono;

    public Estudiante() {

    }

    @Override
    public String toString() {
        return String.format("matricula: %d, Nombre: %s, Carrera: %s, Telefono: %s", matricula, nombre, carrera, telefono);
    }

    public Estudiante(int matricula, String nombre, String carrera, String telefono) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.carrera = carrera;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getMatricula() {
        return matricula;

    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getTelefono() {
        return telefono;

    }

    public void setMatricula(String telefono) {
        this.telefono = telefono;
    }
}
