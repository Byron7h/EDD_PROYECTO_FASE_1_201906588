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
public class Lista_Ventanillas {
    
    
        
    ventanilla cabecera = null;
    int tamano = 0;
    
    public Lista_Ventanillas(){
    }
    
    // Añadir al final
    public void Anadir(ventanilla nuevo){
        if(cabecera == null)
        {
            cabecera = nuevo;         
        }else{
            ventanilla actual = cabecera;
            while( actual != null){                        
                if(actual.get_siguiente() == null){ // es que llegamos al último
                    actual.set_siguiente(nuevo);               
                    break;
                }else{
                    actual = actual.get_siguiente();
                }               
            }
        }
        tamano++;
    }

    // Obteniendo sin sacar, recordemos que iniciamos desde 0
    public ventanilla Obtener(int index){
        
        int contador = 0;
        ventanilla actual = cabecera;
        while (contador < index){
            actual = actual.get_siguiente();
            contador ++;        
            }
        return actual;      
    }
     
    // obteniendo tamano
    public int tamano(){
        return tamano;
    }
    
    // Eliminando, recordemos que inciamos desde 0
    public void Eliminar(int index){
        
        int contador = 0;       
        if (index == 0){ //piden la cabecera vamos de una
            cabecera = cabecera.get_siguiente();
        }else{
            ventanilla actual = cabecera;
            ventanilla anterior = cabecera;
            while (contador < index){
                anterior = actual;
                actual = actual.get_siguiente();
                contador ++;        
            }
            //sale del while, acá lo eliminamos
            anterior.set_siguiente(actual.get_siguiente()); 
            tamano --;
        }  
    }
     
    //imprimir
    public void imprimir(){
        ventanilla actual = cabecera;       
        while( actual != null){
            System.out.print(actual.get_id());
            actual = actual.get_siguiente();
            }
        System.out.println("");
    }
    
    // La lista esta vacía?
    public boolean EstaVacia(){
        if(cabecera == null){
            return true;
        }else{
            return false;
        }
    
    
    }
    
}
