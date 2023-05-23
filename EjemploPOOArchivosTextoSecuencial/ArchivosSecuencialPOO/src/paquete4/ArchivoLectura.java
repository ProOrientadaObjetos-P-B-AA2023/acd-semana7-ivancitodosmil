package paquete4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import paquete1.Empresa;
public class ArchivoLectura {
    private Scanner entrada;
    private String nombreArchivo;
    private String rutaArchivo;
    private ArrayList<Empresa> lista;
    public ArchivoLectura(String n) {
        nombreArchivo = n;
        rutaArchivo = String.format("data/%s",
                obtenerNombreArchivo());
        File f = new File(rutaArchivo);
        if (f.exists()) {
            try {
                entrada = new Scanner(new File(rutaArchivo));
                // entrada = new Scanner(f);
            } // fin de try
            catch (FileNotFoundException e) {
                System.err.println("Error al leer del archivo: " + e);
            } // fin de catch
        }
    }
    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }
    public void establecerRutaArchivo() {
        rutaArchivo = String.format("data/%s.txt",
                obtenerNombreArchivo());;
    }
    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    public String obtenerRutaArchivo() {
        return rutaArchivo;
    }
    // establecer valores de cada línea
    // en la lista de tipo Profesor
    public void establecerLista() {
        lista = new ArrayList<>();
        File f = new File(rutaArchivo);
        if (f.exists()) {
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                ArrayList<String> linea_partes = new ArrayList<>(
                        Arrays.asList(linea.split(";"))
                );
                Empresa p = new Empresa(linea_partes.get(0),
                        linea_partes.get(1));
                lista.add(p);
            } // fin de while
        }
    }
    public ArrayList<Empresa> obtenerLista() {
        return lista;
    }
    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close();
        } // cierra el archivo
    }
    @Override
    public String toString() {
        String cadena = "Lista Empresas\n";
        for (int i = 0; i < obtenerLista().size(); i++) {
            cadena = String.format("%s(%d) %s %s\n", cadena,
                    i + 1,
                    obtenerLista().get(i).obtenerNombre(),
                    obtenerLista().get(i).obtenerCiudad());
        }
        return cadena;
    }
}
