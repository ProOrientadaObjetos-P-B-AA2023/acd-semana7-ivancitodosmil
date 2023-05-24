package Utilerias;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Scanner_VS_FileRead_Opcion1 {
    public static void main(String[] args) {
        String strNombArchivo = "miArchivoPrueba1.txt";
        File file = new File(strNombArchivo);
        Path path = Paths.get(strNombArchivo);
        try {
            //Apertura el flujo de entrada del archivo con Scanner.
            Scanner flujoEntrada_Scanner = new Scanner(file);
            //Apertura el flujo de entrada del archivo con FileReader.
            FileReader flujoEntrada_FileReader = new FileReader(file);

            // CON EL FLUJO DE ENTRADA Scanner
            //Lectura dato a dato   =>  //System.out.println(flujoEntrada_Scanner.next());
            //Lectura linea a linea =>  //System.out.println(flujoEntrada_Scanner.nextLine());
            //Lectura ciclica. Puede ser dato a dato o linea a linea.
            while (flujoEntrada_Scanner.hasNext()) {
                System.out.println(flujoEntrada_Scanner.nextLine());
            }

            // CON EL FLUJO DE ENTRADA FILEREADER
            BufferedReader leerFilesBuffer = new BufferedReader(flujoEntrada_FileReader);
            String strLinea;
            //Lectura caracter a caracter =>  //int caracter = leerFilesBuffer.read()
            /*while ( leerFilesBuffer.ready()){
                System.out.println(leerFilesBuffer.read());
            }*/
            while ( leerFilesBuffer.ready()){
                System.out.println(leerFilesBuffer.read());
            }

            flujoEntrada_Scanner.close();
            flujoEntrada_FileReader.close();

        } catch (IOException e) {
            System.err.println("Error al abrir el archivo");
        }
    }
}

