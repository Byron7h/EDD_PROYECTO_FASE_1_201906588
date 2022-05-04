/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f2_proyecto_estructuras;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author usuario
 */
public class Arbol_Merkle {
    
    //va a recibir un arreglo de operaciones
    ArrayList<Operacion> operaciones = new ArrayList<Operacion>();
    Nodo_Merkle raiz = new  Nodo_Merkle("-1");
    Calc_hash calc = new Calc_hash();
    String grafo = "";
    
    public Arbol_Merkle(ArrayList<Operacion> operaciones){
        this.operaciones = operaciones;
        crear();
        
    }
    
    public void crear(){
        
        int n = 0;
        System.out.println(this.operaciones.size());
        while((Math.pow(2,n))<this.operaciones.size()){
            n++;
        }
        
        // crando el array de hashes
        ArrayList<Nodo_Merkle> hashes = new ArrayList<>();
        
        // creando e inicializando los nodos con un -1
        System.out.println(n);
        for (int i = 0; i<Math.pow(2,n); i++){
            Nodo_Merkle nuevo = new Nodo_Merkle("-1");  
            hashes.add(nuevo);
        }
        
        for (int i = 0; i<this.operaciones.size(); i++){
            Operacion actual = operaciones.get(i);
            String cadenita = actual.dir_sucursal + actual.fecha + Integer.toString(actual.municipio) 
                            + actual.cliente.nombre + actual.mens.nombres + actual.ruta.cadena() ;
            
            String hash_actual = calc.Hash(cadenita);
            hashes.get(i).hash = hash_actual;   
        }

        // Ya tenemos creado nuestros nodos hojas
        // ahora vamos a formar el ´rabol
        
        while(hashes.size()!=1){
            
            ArrayList<Nodo_Merkle> aux= new ArrayList<>();
            
            for (int i = 0; i<hashes.size(); i = i+2){ 
                
                Nodo_Merkle nuevo = new Nodo_Merkle(calc.Hash(hashes.get(i).hash + hashes.get(i+1)));  
                aux.add(nuevo);  
                hashes.get(i).padre = nuevo;
                hashes.get(i+1).padre = nuevo;
                nuevo.derecha= hashes.get(i+1);
                nuevo.izquierda = hashes.get(i);
            }
            hashes = aux;
        } 
        
        raiz = hashes.get(0);
    }
    
    public Nodo_Merkle getRaiz(){
        return this.raiz;
    
    }
    
    public void crear_grafo( Nodo_Merkle actual){

        
        if (actual.derecha != null){ 
            //creamos el nodo derecha enlazamos e implementamos recursividada
            grafo +=  "     "+ actual.derecha.hashCode()+"[label=\""+actual.derecha.hash+"\"];\n";
            grafo +=  "     "+ actual.hashCode()+ "->"+ actual.derecha.hashCode()+";\n";
            crear_grafo(actual.derecha);
        }
        if (actual.izquierda != null){ 
            grafo +=  "     "+ actual.izquierda.hashCode()+"[label=\""+actual.izquierda.hash+"\"];\n";
            grafo +=  "     "+ actual.hashCode()+ "->"+ actual.izquierda.hashCode()+";\n";
            crear_grafo(actual.izquierda);
        } 
        
        if(actual.derecha != null &&actual.izquierda != null){
            
        grafo +=  "     {rank=same; "+actual.izquierda.hashCode()+"; "+actual.derecha.hashCode()+";}\n";
        grafo += "     {edge[style=invis];\n" +
                 "     "+actual.izquierda.hashCode()+" ->"+actual.derecha.hashCode()+";\n" +
                 "     } ";
        }

    }
    
    public String imprimir(){
        
        // encabezado del grafo
        String aux = "digraph finite_state_machine {\n" +
"	fontname=\"Helvetica,Arial,sans-serif\"\n" +
"	node [fontname=\"Helvetica,Arial,sans-serif\"]\n" +
"	node [shape = box];\n";
        aux +=  "     "+ raiz.hashCode()+"[label=\""+raiz.hash+"\"];\n";
        
        crear_grafo(raiz);
        
        // contenido y final del grafo
        grafo += "}";
        
        aux = aux + grafo;
        System.out.println(aux);
        
        // volviendo al estado original
        grafo = "";
        return aux;
    }
    
     
    
    
}
