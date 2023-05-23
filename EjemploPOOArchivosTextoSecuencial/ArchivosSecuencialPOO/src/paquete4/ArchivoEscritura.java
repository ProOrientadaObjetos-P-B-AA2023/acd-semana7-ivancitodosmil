package paquete4;
// Uso de la clase Formatter para escribir datos en un archivo de texto.
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import paquete1.Empresa;
public class ArchivoEscritura {
    private String nombreArchivo;
    private String rutaArchivo;
    private Empresa registro;
    private Formatter salidaArchivo;
    public ArchivoEscritura(String n) {
        nombreArchivo = n;
        rutaArchivo = String.format("data/%s",
                obtenerNombreArchivo());
    }
    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }
    public void establecerRutaArchivo() {
        rutaArchivo = String.format("data/%s.txt",
                obtenerNombreArchivo());;
    }
    public void establecerRegistro(Empresa n) {
        registro = n;
    }
    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    public String obtenerRutaArchivo() {
        return rutaArchivo;
    }
    public Empresa obtenerRegistro() {
        return registro;
    }
    // agrega registros al archivo
    public void establecerSalida() {
        try {
            salidaArchivo = new Formatter(new FileWriter(rutaArchivo, true));
            Empresa p = obtenerRegistro();
            String cadenaRegistro = String.format("%s;%s",
                    p.obtenerNombre(), p.obtenerCiudad());
            salidaArchivo.format("%s\n", cadenaRegistro);
            salidaArchivo.close();
        } catch (Exception e) {
            System.err.println("Error al crear el archivo.");
            System.err.println(e);
        }
    }
    public void cerrarArchivo() {
        if (salidaArchivo != null) {
            salidaArchivo.close();
        } // cierra el archivo
    }
}
