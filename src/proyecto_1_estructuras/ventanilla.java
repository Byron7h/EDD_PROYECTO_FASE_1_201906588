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
public class ventanilla {
    // Atributos
    int id;
    boolean disponible = true; // a la hora de su creación todas están disponibles
    int img_c = 0;
    int img_bn = 0;
    ventanilla siguiente = null;
    
    public ventanilla(int num){
        this.id = num;
    }
    
    public boolean disponible(){
        return disponible;
    }
    
    public ventanilla get_siguiente(){
        return siguiente;
    }
    
    public int get_id(){
        return id;
    }
    
    public void set_siguiente(ventanilla nueva){
        this.siguiente = nueva;
    }
    
    public void recibir_img (nodo evaluado){ // debolberá true cuando deje la ventanilla vacia, es la señal para pasar al siguiente nodo
     
        int nc = evaluado.get_img_c();
        int nbn = evaluado.get_img_bn();

        // Valuando primero las de color 
        if (disponible){
            disponible = false;
            System.out.println("El cliente " + evaluado.get_nombre()+ "ingresa a la ventanilla");
        }
        else if ( img_c != nc){
            img_c ++;
            System.out.println("se agregó una a color a la ventanilla" + id);               
        }else if(img_bn != nbn){
            img_bn ++;
            System.out.println("se agregó una a blanco y negro a la ventanilla" + id); 
        }else{
            System.out.println("El cliente " + evaluado.get_nombre()+ "avanza a la listra de espera");
            disponible = true;
                    
        }  
       
        // desde acá creo que vamos a imprimir, antes de colocarle que la caja ahora está disponible
        
    }
    
    
    // hasta que la respuesta sea un true va a seguir itrando 
    // manda como parámetro un nodo
    
    
    
    
    
}
