package Utilerias;

import java.io.*;
import java.util.Formatter;
import java.util.Scanner;

import paquete1.Profesor;

public class ProbandoArchivos {
    public static void main(String[] args) throws FileNotFoundException {
        Profesor profesores[] ={new Profesor ("Ivan","Auxiliar")
                                ,new Profesor("David","Principal")
                                ,new Profesor("Augusto","Estrella")
                                ,new Profesor("Pablo","Principal")};
        Formatter flujoSalida = new Formatter("Mi prueba.txt"); //Flujo salida desde el programa hacia el archivo
        for (Profesor profeAux : profesores){
            flujoSalida.format("%s %s\n", profeAux.obtenerNombre(),profeAux.obtenerTipo());
        }
        flujoSalida.close();
        Scanner flujoEntrada = new Scanner (new File("Mi prueba.txt"));//Flujo de entrada desde el archivia hacia el programa
        Profesor profesor1 = new Profesor(flujoEntrada.next(), flujoEntrada.next());
        Profesor profesor2 = new Profesor(flujoEntrada.next(), flujoEntrada.next());
        System.out.println(profesor1);
        System.out.println(profesor2);

        try {
            //Flujo de salidas basadas en Bytes, para escribir objetos en archivos
            ObjectOutputStream flujoSalida2 = new ObjectOutputStream(new FileOutputStream("Profes.prof"));
            Profes p1 = new Profes("Isaac","Principal");
            Profes p2 = new Profes("Saul","Estrella");
            flujoSalida2.writeObject(p1);
            flujoSalida2.writeObject(p2);
            flujoSalida2.close();
            //Flujo de entradas basadas en Bytes, para escribir objetos en archivos
            ObjectInputStream flujoEntrada2=new ObjectInputStream(new FileInputStream("Profes.prof"));
            Profes prof1 = (Profes) flujoEntrada2.readObject();
            Profes prof2 = (Profes) flujoEntrada2.readObject();
            System.out.println(prof1);
            System.out.println(prof2);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

class Profes implements Serializable {
    private String nombre;
    private String tipo;

    public Profes(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Profes{" +
                "nombre='" + nombre + '\'' +
                 ", tipo='" + tipo + '\'' +
                '}';
    }
}