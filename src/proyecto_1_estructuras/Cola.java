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
public class Cola {
    
    //• ATRIBUTOS    
    nodo cabecera ;
    
    // • CONSTRUCTOR
    public Cola (){
        this.cabecera = null;   
    }
    
    
    //• METODOS
      
    public void insertar(nodo nuevo){ // inserta un nodo a la cola  al final de la cola  
        if (cabecera == null){ // insertamos el nodo como cabecera
            cabecera = nuevo;
        }else{                     
            nodo actual = cabecera;
            while( actual != null){                        
                if(actual.get_siguiente() == null){ // es que llegamos al último
                    actual.set_siguiente(nuevo);               
                    break;
                }else{
                    actual = actual.get_siguiente();
                }               
            }        
        }
    }
    
    public boolean vacia(){   
        boolean valor = false;
        if (cabecera == null){
            valor = true;
        }
        return valor;
    }
     
    public nodo avanzar(){   
        nodo devolver = null; // si devuelve null es que está vacia       
        if (vacia()){
            System.out.println("La cola está vacia");
        }else{
            devolver = cabecera;                 // si fuera el último guardará null
            cabecera = devolver.get_siguiente(); // volvería a su estado inicial                                           
        }
        return devolver;       
    } 
    
    public void imprimir(){
        nodo actual = cabecera;       
        while( actual != null){
            System.out.print(actual.get_id());
            actual = actual.get_siguiente();
            }
        System.out.println("");
    }

    
}
