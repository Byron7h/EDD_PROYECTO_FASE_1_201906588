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
public class nodo {
            
    //  • ETRIBUTOS
    int id;
    String nombre;
    int img_c;
    int img_bn;
    int pasos = 0; //Cantidad de pasos que tarda en imprimirse las imagenes, inicando en 0
    int ventanilla;
    nodo siguiente = null; //puntero de tipo nodo
    
    // • CONSTRUCTOR 1 
    public nodo (int id, String nombre, int img_c, int img_bn){
        this.id = id;
        this.nombre = nombre;
        this.img_c = img_c;
        this.img_bn = img_bn;       
    }
   
    
    // • METODOS 
    
    public void paso(){ //aumenta en 1 el # de paso
        this.pasos ++;
    } 
    
    public void set_siguiente(nodo nuevo){ //inserta el siguiente
        this.siguiente = nuevo;
    }
    
    public void hacer_null(){ //hace que el nodo apunte a null
        this.siguiente = null;
    }
    
    
    // •FUNCIONES

    public int get_id(){
        return id;
    }
    
    public String get_nombre(){
        return nombre;
    }
        
    public int get_img_c(){
        return img_c;
    }
    
    public int get_img_bn(){
        return img_bn;
    }
    
    public int get_ventanilla(){
        return ventanilla;
    }
    
    public int get_pasos(){
        return pasos;
    }

    public nodo get_siguiente(){
        return siguiente;
    }
}
    
