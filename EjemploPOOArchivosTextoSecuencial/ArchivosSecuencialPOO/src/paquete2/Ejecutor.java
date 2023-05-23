package paquete2;
import paquete1.Profesor;
public class Ejecutor {
    public static void main(String[] args) {
        // nombre del archivo
        String nombreArchivo = "profesores2.txt";
        Profesor profesor1 = new Profesor("Tara Hernandez", "contratado");
        Profesor profesor2 = new Profesor("Gregory Walsh", "nombramiento");
        Profesor profesor3 = new Profesor("Kevin Page", "nombramiento");
        ArchivoEscritura archivo = new ArchivoEscritura(nombreArchivo);
        // establecer el valor del atributo registro
        archivo.establecerRegistro(profesor1);
        // establecer en el archivo el atributo del registro
        archivo.establecerSalida();
        // establecer el valor del atributo registro
        archivo.establecerRegistro(profesor2);
        // establecer en el archivo el atributo del registro
        archivo.establecerSalida();
        // establecer el valor del atributo registro
        archivo.establecerRegistro(profesor3);
        // establecer en el archivo el atributo del registro
        archivo.establecerSalida();
        // proceso para lectura del archivo
        ArchivoLectura lectura = new ArchivoLectura(nombreArchivo);
        lectura.establecerLista();
        // System.out.println(lectura.toString());
        System.out.println(lectura);
        lectura.cerrarArchivo();
    }
}
