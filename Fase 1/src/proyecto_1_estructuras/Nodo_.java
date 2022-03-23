/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_1_estructuras;

/**
 *
 * @author usuario
 */
public class Nodo_ {
    String nombre;
    int cantidad;
    Nodo_ siguiente;

    public Nodo_ (String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.siguiente = null;
    } 
    
}
