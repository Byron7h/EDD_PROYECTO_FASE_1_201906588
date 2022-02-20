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
public class Impresora { //cola impresora
    
    
    //• ATRIBUTOS    
    img cabecera ;
    int contador = 0; // este es para los ids
    
    // • CONSTRUCTOR
    public Impresora (){
        this.cabecera = null;   
    }
    
    
    //• METODOS
      
    public void insertar(img  nuevo){ // inserta un nodo a la cola  al final de la cola  
        if (cabecera == null){ // insertamos el nodo como cabecera
            cabecera = nuevo;
            //System.out.println("Se ha agregado un nodo a la impreosara");
        }else{                     
            img actual = cabecera;
            while( actual != null){                        
                if(actual.get_siguiente() == null){ // es que llegamos al último
                    actual.set_siguiente(nuevo);
                    //System.out.println("Se ha agregado un nodo a la impreosara");
                    break;
                }else{
                    actual = actual.get_siguiente();
                }               
            }        
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
            System.out.println("La cola está vacia");
        }else{
            devolver = cabecera;                 // si fuera el último guardará null
            cabecera = devolver.get_siguiente(); // volvería a su estado inicial                                           
        }
        return devolver;       
    } 
    
    public void imprimir(){
        img actual = cabecera;       
        while( actual != null){
            System.out.print(actual.get_tipo());
            System.out.print(" - ");
            actual = actual.get_siguiente();
            }
        System.out.println("");
    }
    
    public int id_actual(){ //este nos servirá para bomrar a los nodos que creemos
        contador ++;
        return contador;
    }

    
}
