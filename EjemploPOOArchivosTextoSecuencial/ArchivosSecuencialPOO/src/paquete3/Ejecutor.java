package paquete3;
import paquete1.Calificacion;
import paquete1.Profesor;
public class Ejecutor {
    public static void main(String[] args) {
        // nombre del archivo
        String nombreArchivo = "calificaciones2.txt";
        Calificacion c1 = new Calificacion(10, "Computación");
        Calificacion c2 = new Calificacion(9, "Lógica");
        Calificacion c3 = new Calificacion(8, "Literatura");
        Profesor profesor1 = new Profesor("Tara Hernandez", "contratado");
        Profesor profesor2 = new Profesor("Gregory Walsh", "nombramiento");
        Profesor profesor3 = new Profesor("Kevin Page", "nombramiento");
        c1.establecerProfesor(profesor1);
        c2.establecerProfesor(profesor2);
        c3.establecerProfesor(profesor3);
        Calificacion[] lista = {c1, c2, c3};
        ArchivoEscritura archivo = new ArchivoEscritura(nombreArchivo);
        for (int i = 0; i < lista.length; i++) {
            // establecer el valor del atributo registro
            archivo.establecerRegistro(lista[i]);
            // establecer en el archivo el atributo del registro
            archivo.establecerSalida();
        }
        ArchivoLectura lectura = new ArchivoLectura(nombreArchivo);
        lectura.establecerLista();
        System.out.println(lectura);
    }
}
