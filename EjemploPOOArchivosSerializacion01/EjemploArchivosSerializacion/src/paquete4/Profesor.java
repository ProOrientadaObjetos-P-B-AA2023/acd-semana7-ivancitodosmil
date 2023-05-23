/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete4;

import java.io.Serializable;

public class Profesor implements Serializable {
    private String nombre;
    private String tipo;
    private String cedula;
    
    public Profesor(String n, String t, String ced){
        nombre = n;
        tipo = t;
        cedula = ced;
    }
    
    public void establecerNombre(String n){
        nombre = n;
    }
    
    public void establecerTipo(String n){
        tipo = n;
    }
    
    public void establecerCedula(String n){
        cedula = n;
    }
    
    public String obtenerNombre(){
        return nombre;
    }
    
    public String obtenerTipo(){
        return tipo;
    }
    
    public String obtenerCedula(){
        return cedula;
    }
    
    
    @Override
    public String toString(){
        String valor = String.format("%s-%s-%s\n", obtenerNombre(), 
                obtenerTipo(),
                obtenerCedula());
        return valor;
    }
    
}
