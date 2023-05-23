package paquete1;
public class Calificacion{
    private double nota;
    private String nombreMateria;
    private Profesor profesor;
    public Calificacion(double n, String nombre) {
        nota = n;
        nombreMateria = nombre;
    }
    public void establecerNota(double n) {
        nota = n;
    }
    public void establecerNombreMateria(String n) {
        nombreMateria = n;
    }
    public void establecerProfesor(Profesor n) {
        profesor = n;
    }
    public double obtenerNota() {
        return nota;
    }
    public String obtenerNombreMateria() {
        return nombreMateria;
    }
    public Profesor obtenerProfesor() {
        return profesor;
    }
}
