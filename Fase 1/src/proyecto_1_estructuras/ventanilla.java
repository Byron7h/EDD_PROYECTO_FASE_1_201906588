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
    nodo n_evaluado = null;
    Pila pila = new Pila(); // pila que contendra todas las imágenes
    int contador = 0;
    
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
    
    public nodo get_nodo_evaluado(){ //Para ver si está ccupado o no
        return n_evaluado;
    }
    
    public void set_nodo_evaluado(nodo evaluado){ // //ingresa un nodo a la ventanilla
        this.n_evaluado = evaluado;
        disponible = false;
        System.out.println("    El cliente " + evaluado.get_nombre()+ " ingresa a la ventanilla " + id);
    }
    
    
    //idea hacer este metodo con un return pila, para que cuando sea null no pase nada
    //y cuando envie una pila el menú la agregue a la cola de las impresoras
    
    
    
    public Pila tratar_img (){ // metodo interno para trabajar la pila  de imágenes tipo bn->1 color ->2
     
        int nc = n_evaluado.get_img_c();
        int nbn = n_evaluado.get_img_bn();
        Pila pila_imagenes = null;

         
        if ( img_c != nc){ //imagenes a color
            img_c ++;
            
            // int tipo, int id, int numero
            img nueva_img = new img(2, n_evaluado.get_id(), contador);
            contador++;
            pila.insertar(nueva_img);
            
            System.out.println("        Ventanilla " + id+" recibe una imagen COLOR");   

        }else if(img_bn != nbn){// imagenes a blanco y negro
            img_bn ++;
            
            img nueva_img = new img(1, n_evaluado.get_id(), contador);
            contador++;
            pila.insertar(nueva_img);
            System.out.println("        Ventanilla " + id+" recibe una imagen B/N");  
            
        }else{
            System.out.println("        El cliente " + n_evaluado.get_nombre()+ " avanza a la listra de espera");
            System.out.println("        Sus imágenes se han trasladado a las impresoras");
            
            //volviendo a las condiciones iniciales
            disponible = true;
            pila_imagenes = pila;
            pila = new Pila();
            img_c = 0;
            img_bn = 0;
            n_evaluado = null;
            contador = 0;                  
        }       
        return pila_imagenes;    
    }
    

    
    
    
    
    
}
