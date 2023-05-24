package Utilerias;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;

public class Formatter_VS_FileWrite_Opcion1 {
    public static void main(String[] args) {
        //Rutas del archivo
        String strNombArchivo = "miArchivoPrueba1.txt";
        File file = new File(strNombArchivo);
        Path path = Paths.get(strNombArchivo);
        try {
            //Apertura el flujo de salida al archivo.
            //Si el archivo existe, se trunca y se escribe desde el inicio
            Formatter flujoOUT_Formatter = new Formatter(file);
            //IF TERNARIO valida si existe o no el archivo,
            //para iniciar/continuar (false/true) su escritura al inicio/final (false/true).
            FileWriter flujoOUT_FileWriter = Files.exists(path) ?
                    new FileWriter(file, true) : new FileWriter(file);

            flujoOUT_Formatter.format("Nombre: %s \t Sueldo: %.2f%n", "Daniel", 900.500);
            flujoOUT_FileWriter.write("Nombre: Juan \t Sueldo: 1000.560 \n");

            flujoOUT_Formatter.close();
            flujoOUT_FileWriter.close();

        } catch (SecurityException securityException) {
            System.err.println("Permisos de escritura negados. Terminar el programa");
            System.exit(1); //Termina el programa.
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error para abrir el archivo. Terminar el programa.");
            System.exit(1); //Termina el programa.
        } catch (IOException e) {
            System.err.println("Error en el archivo");
        }
    }
}
