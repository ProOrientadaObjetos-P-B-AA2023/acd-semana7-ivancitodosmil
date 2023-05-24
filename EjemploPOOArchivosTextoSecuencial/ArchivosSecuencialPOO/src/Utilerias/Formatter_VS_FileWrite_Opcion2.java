package Utilerias;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Formatter_VS_FileWrite_Opcion2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        //Rutas del archivo
        String strNombArchivo = "miArchivoPrueba1.txt";
        File file = new File(strNombArchivo);
        Path path = Paths.get(strNombArchivo);
        try {
            Formatter flujoOUT_Formatter = new Formatter(file);
            System.out.printf("%s%n%s%n? ", "Ingrese su nombre.", "Ingrese su sueldo.");
            //Bucle hasta encontrar la combinacion de teclas de fin de archivo
            while (teclado.hasNext()) {
                try {
                    flujoOUT_Formatter.format("Nombre: %s \t Sueldo: %.2f%n",
                            teclado.next(), teclado.nextDouble());
                } catch (FormatterClosedException formatterClosedException) {
                    System.err.println("Error al escribir en el archivo");
                    break;
                } catch (NoSuchElementException elementException) {
                    System.err.println("Entrada invalida. Intente de nuevo");
                    teclado.nextLine(); //Descarta la entrada, puede intenter otra vez.
                }
                System.out.print("? ");
            }
            flujoOUT_Formatter.close();
        } catch (SecurityException securityException) {
            System.err.println("Permisos de escritura negados. Terminar el programa");
            System.exit(1); //Termina el programa.
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error para abrir el archivo. Terminar el programa.");
            System.exit(1); //Termina el programa.
        }
    }
}
