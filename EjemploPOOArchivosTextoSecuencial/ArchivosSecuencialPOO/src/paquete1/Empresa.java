package paquete1;
public class Empresa {
    String nombre;
    String ciudad;
    public Empresa(String n, String c){
        nombre = n;
        ciudad = c;
    }
    public void establecerNombre(String n){
        nombre = n;
    }
    public void establecerCiudad(String c){
        ciudad = c;
    }
    public String obtenerNombre(){
        return nombre;
    }
    public String obtenerCiudad(){
        return ciudad;
    }
}
