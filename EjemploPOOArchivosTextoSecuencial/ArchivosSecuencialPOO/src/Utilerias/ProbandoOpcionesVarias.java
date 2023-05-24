package Utilerias;
import paquete1.Profesor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class ProbandoOpcionesVarias {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Profesor profes[] = {new Profesor("Daniel","Principal")
                            ,new Profesor("Carlos","Auxiliar")
                            ,new Profesor("Pedro","Titular")};
        /*Formatter archivoSalida = new Formatter("test1.txt");
        archivoSalida.format("%s;%s\n", profes[0].obtenerNombre(),profes[0].obtenerTipo());
        archivoSalida.format("%s;%s\n", profes[1].obtenerNombre(),profes[1].obtenerTipo());
        archivoSalida.close();
        
        Scanner archivoEntrada = new Scanner(new File("test1.txt"));
        System.out.println(archivoEntrada.next());*/
        
        Formatter fileOut = new Formatter(new FileWriter("test1.txt",true));
        fileOut.format("%s;%s\n", profes[0].obtenerNombre(),profes[0].obtenerTipo());
        fileOut.close();
        
        ArrayList <Profesor> profesores = new ArrayList();
        profesores.add(new Profesor("Daniel","Principal"));
        profesores.add(new Profesor("Carlos","Auxiliar"));
        profesores.remove(0);
        for (int i = 0; i < profesores.size(); i++) 
            System.out.println(profesores.get(i));
        for(Profesor profeAux : profesores)
            System.out.println(profeAux);
        
        ObjectOutputStream archivoSalidaObj = new ObjectOutputStream(new FileOutputStream("test2.ser"));
        archivoSalidaObj.writeObject(new Personita("Daniel","Principal"));
        archivoSalidaObj.close();
        ObjectInputStream archivoEntradaObj = new ObjectInputStream(new FileInputStream("test2.ser"));
        Personita personitaAux = (Personita) archivoEntradaObj.readObject();
        System.out.println(personitaAux);
    }
}

class Personita implements Serializable{
    private String nombre, tipo;
    public Personita(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }
    @Override
    public String toString() {
        return "Personita{" + "nombre=" + nombre + ", tipo=" + tipo + '}';
    }
}


