/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete4;


public class Ejecutor2 {

    public static void main(String[] args) {

        // nombre del archivo
        String nombreArchivo = "data/profesores.data";
        String cedula_buscar = "11112";
        Profesor profesor_buscar;
        LecturaArchivoSecuencial lectura = 
                new LecturaArchivoSecuencial(nombreArchivo);
        lectura.establecerIdentificador(cedula_buscar);
        lectura.establecerProfesorBuscado();
        profesor_buscar = lectura.obtenerProfesorBuscado();
        if(profesor_buscar!=null){
            System.out.println(profesor_buscar);
        }else{
            System.out.println("Profesor no encontrado");
        }
        
    }
}
