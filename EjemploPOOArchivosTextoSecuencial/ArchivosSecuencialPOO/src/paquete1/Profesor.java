package paquete1;
public class Profesor{
    private String nombre;
    private String tipo;
    public Profesor(String n, String t){
        nombre = n;
        tipo = t;
    }
    public void establecerNombre(String n){
        nombre = n;
    }
    public void establecerTipo(String n){
        tipo = n;
    }
    public String obtenerNombre(){
        return nombre;
    }
    public String obtenerTipo(){
        return tipo;
    }
}
