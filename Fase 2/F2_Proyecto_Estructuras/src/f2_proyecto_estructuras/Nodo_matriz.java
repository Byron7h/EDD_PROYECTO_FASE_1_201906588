/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f2_proyecto_estructuras;

/**
 *
 * @author usuario
 */
public class Nodo_matriz {
        
    // Nuestros 4 apuntadores
    // los inicializamos en null para poner hacer validaciones
    Nodo_matriz siguiente = null;
    Nodo_matriz anterior = null;
    Nodo_matriz arriba = null;
    Nodo_matriz abajo = null;
    
    // información del nodo
    String dato;
    int x;
    int y;
    //constructor
    public Nodo_matriz(int x,int y, String dato){
        this.dato = dato;
        this.x = x;
        this.y = y;
    
    }
    
    public String valor_nodo(){
        return " "+ dato + "  "+ x +" "+ y;
    }
    
}
