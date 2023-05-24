package Utilerias;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SerializacionObjetos {
    public static void main(String[] args) throws IOException {
        ArrayList<Persona> personas = new ArrayList<Persona>();
        personas.add(new Persona(1, "Juan", "Carrion"));
        personas.add(new Persona(2, "Luis", "Ruiz"));
        personas.add(new Persona(3, "Maria", "Santos"));
        //ESCRITURA DEL ARCHIVO SERIALIZABLE
        ObjectOutputStream flujoSalida =
                new ObjectOutputStream(Files.newOutputStream(Paths.get("filePersonas.ser")));
        for (Persona persona : personas) {
            flujoSalida.writeObject(persona);
        }
        flujoSalida.close();

        //LECTURA DEL ARCHIVO DESERIALIZABLE
        try {
            ObjectInputStream flujoEntrada =
                    new ObjectInputStream(Files.newInputStream(Paths.get("filePersonas.ser")));
            while (true) {
                Persona persona = (Persona) flujoEntrada.readObject();
                System.out.println(persona);
            }
        } catch (EOFException endOfFileException) {
            System.out.printf("%nNo hay mas registros%n");
        } catch (ClassNotFoundException classNotFoundException) {
            System.err.println("Tipo de objeto invalido. Finalizar programa");
        }
    }
}

class Persona implements Serializable {
    public int id;
    public String nombre;
    public String apellido;
    public Persona(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    @Override
    public String toString() {
        return String.format("Id: %d%nNombre: %s%nApellido: %s%n",
                this.id, this.nombre, this.apellido);
    }
}