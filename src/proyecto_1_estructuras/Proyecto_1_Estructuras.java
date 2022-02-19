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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class Proyecto_1_Estructuras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Menu menu = new Menu();
        menu.LlamarMenu();
        
        
        
        // Prueba Pila e imagen
        //imagenes tipo(bn->1 c->2)
        // tipo id_propietario num_de_impresion
        /*
        img uno = new img(1,2,3);
        img dos = new img(2,2,3);
        img tres = new img(3,2,3);
        
        Pila pila = new Pila();
        pila.insertar(uno);
        pila.imprimir();
        pila.insertar(dos);
        pila.imprimir();
        pila.insertar(tres);
        pila.imprimir();
        pila.avanzar();
        pila.imprimir();
        pila.avanzar();
        pila.imprimir();
        
        */
        
             
        // • Prueba funcionamiento ventanilla
        /*
        ventanilla uno = new ventanilla(1);
        System.out.println(uno.disponible());
        
        nodo n1 = new nodo(1,"w",0,9);
        
        uno.recibir_img(n1);      
        boolean var = false;
        while(var != true){
            
            uno.recibir_img(n1);
            var = uno.disponible();
   
        }

       */ 
        

        
        // •Prueba funcionamiento Cola-JSON
        /*
        String ruta = "C:\\Users\\usuario\\Documents\\Byron\\7mo semestre\\Estructuras\\EDD_PROYECTO_FASE_1_201906588\\Entrada.json";
        int tamano = 50;  
        
        Lector lectura = new Lector(ruta, tamano);
        Cola colita = lectura.Lectura();
        colita.imprimir();
        */
        
        // •Prueba funcionamiento lista
        /*
        Lista lista = new Lista();
        nodo n1 = new nodo(1,"w",1,1);
        nodo n2 = new nodo(2,"w",2,2);
        nodo n3 = new nodo(3,"w",1,1);
        nodo n4 = new nodo(4,"w",1,1);
        nodo n5 = new nodo(5,"w",1,1);
        System.out.println("Tamaño "+ lista.tamano());
        
        lista.Anadir(n1);
        lista.Anadir(n2);
        lista.Anadir(n3);
        System.out.println("Tamaño "+ lista.tamano());
        lista.Anadir(n4);
        lista.Anadir(n5);
        lista.imprimir();
        int num = lista.tamano();
        lista.Eliminar(num-2);
        lista.imprimir();
        System.out.println("Tamaño "+ lista.tamano());

        
        //lista.Eliminar(0);
        //lista.imprimir();
        */

    }
    
}
