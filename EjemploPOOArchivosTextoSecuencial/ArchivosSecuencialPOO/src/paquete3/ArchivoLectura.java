package paquete3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import paquete1.Calificacion;
import paquete1.Profesor;
public class ArchivoLectura {
    private Scanner entrada;
    private String nombreArchivo;
    private String rutaArchivo;
    private ArrayList<Calificacion> lista;
    public ArchivoLectura(String n) {
        nombreArchivo = n;
        rutaArchivo = String.format("data/%s",
                obtenerNombreArchivo());
        File f = new File(rutaArchivo);
        if (f.exists()) {
            try {
                entrada = new Scanner(new File(rutaArchivo));
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
                // la línea en el archivo tiene la siguiente
                // estructura
                // "%s;%.2f;%s|%s"
                // Computación;10,00;Tara Hernandez|contratado
                ArrayList<String> linea_partes = new ArrayList<>(
                        Arrays.asList(linea.split(";")));
                // ["Computación", "10,00", "Tara Hernandez|contratado"]
                //       0             1                2
                // los dos primeros parametros se los relaciona
                // con materia y nota
                String materia = linea_partes.get(0);
                double nota = Double.parseDouble(linea_partes.
                        get(1).replace(",", "."));
                String profesor = linea_partes.get(2);
                ArrayList<String> cadenaProfesor = new ArrayList<>(
                        Arrays.asList(profesor.split("\\|")));
                // ["Tara Hernandez", "contratado"]
                //        0                 1
                Profesor p = new Profesor(cadenaProfesor.get(0), 
                        cadenaProfesor.get(1));
                Calificacion cal = new Calificacion(nota, materia);
                cal.establecerProfesor(p);
                lista.add(cal);
            } // fin de while
       }
    }
    public ArrayList<Calificacion> obtenerLista() {
        return lista;
    }
    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close();
        } // cierra el archivo
    }
    @Override
    public String toString(){
        String cadena = "Lista Calificaciones\n";
        for (int i = 0; i < obtenerLista().size(); i++) {
            cadena = String.format("%s(%d) %s %.2f (%s %s)\n", cadena,
                    i+1,
                    obtenerLista().get(i).obtenerNombreMateria(),
                    obtenerLista().get(i).obtenerNota(),
                    obtenerLista().get(i).obtenerProfesor().obtenerNombre(),
                    obtenerLista().get(i).obtenerProfesor().obtenerTipo());
        }
        return cadena;
    }
}
