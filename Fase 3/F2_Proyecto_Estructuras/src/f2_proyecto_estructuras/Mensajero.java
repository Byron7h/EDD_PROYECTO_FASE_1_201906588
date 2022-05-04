/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f2_proyecto_estructuras;

public class Mensajero {
    
    long DPI;
    String nombres, apellidos, tipo_licencia, direccion, genero;
    
    
    
    public Mensajero(String nombres, String apellidos, long DPI, 
            String tipo_licencia, String direccion, String genero){
        
        this.nombres  = nombres;
        this.apellidos = apellidos;
        this.DPI = DPI;
        this.tipo_licencia = tipo_licencia;
        this.direccion = direccion;
        this.genero = genero;
    }
    
    

    
}