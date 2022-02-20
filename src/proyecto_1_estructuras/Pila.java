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
public class Pila { // Ultimo que entre Primero que sale
    
        //• ATRIBUTOS    
    img cabecera ;
    int contador = 0; // este es EL TAMAÑO DE LA PILA
    
    // • CONSTRUCTOR
    public Pila (){
        this.cabecera = null;   
    }
    
    
    //• METODOS
      
    public void insertar(img nuevo){ // inserta un nodo a la cola  al inicio de la pila 
        if (cabecera == null){ // insertamos el nodo como cabecera
            cabecera = nuevo;
        }else{
            img auxiliar = cabecera;
            nuevo.set_siguiente(auxiliar);
            cabecera = nuevo;      
        } contador ++;
    }
    
    public boolean vacia(){   
        boolean valor = false;
        if (cabecera == null){
            valor = true;
        }
        return valor;
    }
     
    
    public img avanzar(){   
        img devolver = null; // si devuelve null es que está vacia       
        if (vacia()){
            System.out.println("La Pila está vacia");
        }else{
            devolver = cabecera;                 // si fuera el último guardará null
            cabecera = devolver.get_siguiente(); // volvería a su estado inicial  
            //contador --;
        }
        
        return devolver;       
    } 
    
    public int tamano(){
        return contador;
    }
    
    public void imprimir(){
        img actual = cabecera;       
        while( actual != null){
            System.out.print(actual.get_tipo());
            actual = actual.get_siguiente();
            }
        System.out.println("");
    }
    
    
}
