/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f2_proyecto_estructuras;

/**
 *
 * @author usuario
 */
public class F2_Proyecto_Estructuras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        /*
        System.out.println("----------------------------");
        Matriz_pixeles matriz = new Matriz_pixeles();
        matriz.insertarNodo(0,0,"hola");

        matriz.insertarNodo(1,3,"hola");
        matriz.insertarNodo(5,1,"hola");
        matriz.insertarNodo(3,3,"hola");
        matriz.insertarNodo(4,4,"hola");
        matriz.insertarNodo(1,2,"hola");
        
        matriz.insertarNodo(0,0,"hola");

        matriz.insertarNodo(1,3,"hola");
        matriz.insertarNodo(5,1,"hola");
        matriz.insertarNodo(3,3,"hola");
        matriz.insertarNodo(4,4,"hola");
        matriz.insertarNodo(1,2,"hola");
        
        
        
        System.out.println("----------------------------");
        */
        
        ABB arbol = new ABB();
        arbol.insertar(9);
        arbol.insertar(3);
        arbol.insertar(1);
        arbol.insertar(0);
        arbol.insertar(2);
        arbol.insertar(6);
        arbol.insertar(4);
        arbol.insertar(5);
        arbol.insertar(8);
        arbol.insertar(7);
        arbol.insertar(15);
        arbol.insertar(10);
        arbol.insertar(12);
        arbol.insertar(11);
        
        System.out.println(arbol.raiz.valor);
        //System.out.println(arbol.raiz.hijo_derecha.valor);
        //System.out.println(arbol.raiz.hijo_izquierda.valor);
        arbol.crear_grafo(arbol.raiz);
        arbol.imprimir();
        
        
        
    }
    
}
