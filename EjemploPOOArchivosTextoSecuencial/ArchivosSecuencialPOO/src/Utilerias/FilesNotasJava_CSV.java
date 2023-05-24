package Utilerias;

import java.io.File;
import java.util.Formatter;
import java.util.Scanner;
import java.util.Locale;

public class FilesNotasJava_CSV {
    public static void main(String[] args) {
        try {
            //FLUJO DE SALIDA al archivo,
            //con Charset US-ASCII, para escribir . en lugar de ,
            Locale ingles = new Locale("en", "EN");
            Formatter outArchivo = new Formatter("notas.csv", "US-ASCII", ingles);
            outArchivo.format("%.2f;%d;%d;%n", 4.5, 20, 8);
            outArchivo.format("%d;%d;%.2f;%n", 15, 19, 16.4);
            outArchivo.close();

            //FLUJO DE ENTRADA del archivo.
            Scanner inArchivo = new Scanner(new File("notas.csv"));
            String contenido;
            int nroEst = 1;
            while (inArchivo.hasNext()) {
                System.out.println("NOTAS DEL ESTUDIANTE: " + nroEst);
                contenido = inArchivo.nextLine();
                String[] tokens = contenido.split(";");
                //System.out.println(tokens[0] + ", " + tokens[1] + ", " + tokens[2]);
                System.out.printf("%-5s%-5s%-5s%n", tokens[0], tokens[1], tokens[2]);
                int i = 1;
                for (String nota : tokens) {
                    System.out.println("Nota [" + i + "]: " + nota);
                    //Transforma la nota de string a double.
                    //double notaAux = Double.valueOf(nota);
                    //System.out.println("Nota [" + i + "]: " + notaAux);
                    i++;
                }
                nroEst++;
            }
            inArchivo.close();
        } catch (NumberFormatException numberFormatException) {
            System.err.println("Formato de numero invalido");
        } catch (Exception e) {
            System.err.println("Excepcion generada: " + e);
            System.exit(1); //Termina el programa.
        }
    }
}

