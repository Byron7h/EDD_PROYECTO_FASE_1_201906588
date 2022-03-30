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
        
        
        
        AVL arbol = new AVL();
        arbol.insertarAVL(9);
        arbol.crear_grafo(arbol.raiz);
        arbol.imprimir();
        arbol.insertarAVL(3);
        arbol.crear_grafo(arbol.raiz);
        arbol.imprimir();
        arbol.insertarAVL(1);
        arbol.crear_grafo(arbol.raiz);
        arbol.imprimir();
        arbol.insertarAVL(0);
        arbol.crear_grafo(arbol.raiz);
        arbol.imprimir();
        arbol.insertarAVL(2);
        arbol.crear_grafo(arbol.raiz);
        arbol.imprimir();
        arbol.insertarAVL(6);
        arbol.crear_grafo(arbol.raiz);
        arbol.imprimir();
        arbol.insertarAVL(4);
        arbol.crear_grafo(arbol.raiz);
        arbol.imprimir();
        arbol.insertarAVL(5);
        arbol.crear_grafo(arbol.raiz);
        arbol.imprimir();
        arbol.insertarAVL(8);
        arbol.crear_grafo(arbol.raiz);
        arbol.imprimir();
        arbol.insertarAVL(7);
        arbol.crear_grafo(arbol.raiz);
        arbol.imprimir();
        arbol.insertarAVL(15);
        arbol.crear_grafo(arbol.raiz);
        arbol.imprimir();
        arbol.insertarAVL(10);
        arbol.crear_grafo(arbol.raiz);
        arbol.imprimir();
        arbol.insertarAVL(12);
        arbol.crear_grafo(arbol.raiz);
        arbol.imprimir();
        arbol.insertarAVL(11);
        
        
        //arbol.recorrido_Inorden();
        
        //arbol.inOrden(arbol.raiz);
        
        //System.out.println(arbol.raiz.valor);
        //System.out.println(arbol.raiz.hijo_derecha.valor);
        //System.out.println(arbol.raiz.hijo_izquierda.valor);
        arbol.crear_grafo(arbol.raiz);
        arbol.imprimir();
        
       /*
        System.out.println("Existe 8 " + arbol.buscar(8));
        
        System.out.println("------- recorridos--------");
        
        System.out.println("Preorden");
        arbol.recorrido_Preorden();
        System.out.println("Inorden");
        arbol.recorrido_Inorden();
        System.out.println("Postorden");
        arbol.recorrido_Postorden();
        System.out.println("Amplitud");
        arbol.recorrido_Amplitud();
        
        */
         /*
        //arbol.srecorrido_Inorden(15);
        
        arbol.eliminar(3);
        arbol.crear_grafo(arbol.raiz);
        arbol.imprimir();
        /*
        
        Lector_capas lector = new Lector_capas("C:\\Users\\usuario\\Documents\\Byron\\7mo semestre\\Estructuras\\Lab\\Ejemplos aux\\EDD_1S_2022-main\\EntradasFase2\\ImagenMario\\ImagenMario.json");
        lector.Lectura();
    
        */
        
        
        
    }
    
}
