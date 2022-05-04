/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f2_proyecto_estructuras;

public class Mensajero {
    
    String nombres, apellidos, DPI, tipo_licencia, correo, direccion;
    int tel;
    
    public Mensajero(String nombres, String apellidos, String DPI, 
            String tipo_licencia ,String correo, String direccion, int tel){
        
        this.nombres  = nombres;
        this.apellidos = apellidos;
        this.DPI = DPI;
        this.tipo_licencia = tipo_licencia;
        this.correo = correo;
        this.direccion = direccion;
        this.tel = tel;
    }
    
    

    
}