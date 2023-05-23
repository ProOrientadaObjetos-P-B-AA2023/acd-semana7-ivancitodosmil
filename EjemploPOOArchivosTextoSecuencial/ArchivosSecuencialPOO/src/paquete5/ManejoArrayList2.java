package paquete5;
import java.util.ArrayList;
import paquete1.Profesor;
public class ManejoArrayList2 {
    public static void main(String[] args) {
        Profesor prof1 = new Profesor("Joseph Jimenez", "facturado");
        Profesor prof2 = new Profesor("David Jones", "nombramiento");
        // Arreglo
        Profesor [] profesores = new Profesor[2];
        profesores[0] = prof1;
        profesores[1] = prof2;
        for (int i = 0; i < profesores.length; i++) {
        //    System.out.printf("%s - %s\n", profesores[i].obtenerNombre(),
        //            profesores[i].obtenerTipo());
        }
        System.out.println("-----------------------------");
        // ArrayList
        ArrayList <Profesor> profesores2 = new ArrayList<>();
        profesores2.add(prof1); // 0
        profesores2.add(prof2); // 1
        // System.out.println(profesores2.get(1).obtenerTipo());
        Profesor temporal = profesores2.get(0);
        System.out.println(temporal.obtenerTipo());
        /*
        for (int i = 0; i < profesores2.size(); i++) {
            System.out.printf("%s - %s\n", profesores2.get(i).obtenerNombre(),
                    profesores2.get(i).obtenerTipo());
        }
        */
        System.out.println("-----------------------------");
        Profesor prof3 = new Profesor("Melissa Gilbert", "contratado");
        Profesor prof4 = new Profesor("Melissa J", "desconocido");
        Profesor prof5 = new Profesor("Melissa M", "contratado");
        profesores2.add(prof3);
        profesores2.add(prof4);
        profesores2.add(prof5);
        for (int i = 0; i < profesores2.size(); i++) {
            System.out.printf("%s - %s\n", profesores2.get(i).obtenerNombre(),
                    profesores2.get(i).obtenerTipo());
        }
    }
}
