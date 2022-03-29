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
