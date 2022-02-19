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
public class img {
    
    int tipo;
    img siguiente;
    int id_propietario; //para ubicar a que propietario sacar de la lista de espera
    int numero; // para identificar cuando se hayan terminado las imagenes del cliente
                // como son para una pila, cuando salga el último con numero 0 esa será la señal
    
    public img(int num, int id, int numero){
        this.tipo = num; 
        this.id_propietario = id;
        this.numero = numero;
    }
    
    public int get_tipo(){
        return tipo;
    }
    
    public int get_id(){
        return id_propietario;
    }
    
    public int get_num(){
        return numero;
    }
    
    public img get_siguiente(){
        return siguiente;
    }
    
    public void set_siguiente(img nuevo){ //inserta el siguiente
        this.siguiente = nuevo;
    }
       
}
