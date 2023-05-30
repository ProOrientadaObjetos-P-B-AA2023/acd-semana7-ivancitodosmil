package Utilerias;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class ReviewFiles {
    public static void main(String[] args) {
        try {
            Formatter flujoCaracteresSalida= new Formatter("archivoPrueba.csv");
            Formatter flujoCaracteresSalida2= new Formatter("archivoPrueba2.csv");
            for (int i = 0; i < 1000; i++) {
                flujoCaracteresSalida.format("Estudiante%d;%d;%d\n", i+1, (int)(Math.random()*10+1),(int)(Math.random()*10+1));
            }
            flujoCaracteresSalida.close();

            Scanner flujoCaracteresEntrada= new Scanner(new File("archivoPrueba.csv"));


            for (int i = 0; i < 1000; i++) {
                String datos= flujoCaracteresEntrada.nextLine();
                String dato[]= datos.split(";");
                double nota1= Double.parseDouble(dato[1]);
                double nota2= Double.parseDouble(dato[2]);
                double promedio= (nota1+nota2)/2;
                System.out.println(dato[0]+" "+ nota1+" "+ nota2+" "+promedio);
                flujoCaracteresSalida2.format("%s;%.2f;%.2f;%.2f\n",dato[0],nota1,nota2,promedio);
            }
            flujoCaracteresSalida.close();
             flujoCaracteresSalida2.close();




            /*
            //Flujo salida (escritura) basado en caracteres
            Formatter flujoCaracteresSalida = new Formatter("archivoPrueba.txt");
            flujoCaracteresSalida.format("%s, %s","Hola","mundo");
            flujoCaracteresSalida.close();
            */

            /*
            //Flujo de entrada(lectura) basado en caracteres
            Scanner flujoCaracteresEntrada= new Scanner(new File("archivoPrueba.txt"));
            //String dato=flujoCaracteresEntrada.next();
            System.out.println(flujoCaracteresEntrada.next());
            flujoCaracteresSalida.close();
            */
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}