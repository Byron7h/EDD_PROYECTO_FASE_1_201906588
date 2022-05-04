/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f2_proyecto_estructuras;

import java.util.LinkedList;
import java.security.MessageDigest;
import java.util.ArrayList;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author usuario
 */
public class F2_Proyecto_Estructuras {

    /**
     * @param args the command line arguments
     */
    
    public static int cantidad_ceros = 4;
    public static void main(String[] args) {

        
        
        Lugar uno = new Lugar(1, "Guatemala", "nombre", true);
        Lugar dos = new Lugar(2, "Guatemala", "nombre", true);
        Lugar tres = new Lugar(3, "Guatemala", "nombre", true);
        Ruta  ru = new Ruta(1,2,3);
        Ruta  r = new Ruta(3,2,8);
        
        Lista_Ad lista = new Lista_Ad();
        lista.insertarLugar(uno);
        lista.insertarLugar(dos);
        lista.insertarLugar(tres);
        lista.insertarRuta(ru);
        lista.insertarRuta(r);
        lista.imprimir();
        
        
       
        /*
        Busca_caminos graph = new Busca_caminos(5);
        graph.addVertax("A");
        graph.addVertax("B");
        graph.addVertax("C");
        graph.addVertax("D");
        graph.addVertax("E");


        graph.addEdges(0,1,1);
        graph.addEdges(0,2,5);
        graph.addEdges(1,2,2);
        graph.addEdges(1,3,8);
        graph.addEdges(1,4,12);
        graph.addEdges(2,3,10);
        graph.addEdges(3,4,2);

        graph.showEdges();
        graph.dijkStra(0);

*/

        
        
        /*
        
        // lISTA DE USUARIOS
        LinkedList<Usuario> usuarios = new LinkedList<>();
        Usuario provisional = new Usuario("x", "x", "x");
        usuarios.add(provisional);
        
        
        
        
        
        
        // interfaz grafica
        
        Pantalla_login login = new Pantalla_login(usuarios);
        login.setVisible(true);
        login.setLocationRelativeTo(null); // Acá le decimos que nos la coloque en el centro
        
        
        */

        
        
        
        
        
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
        
        /*
        
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
        
        
        */
        
        //arbol.recorrido_Inorden();
        
        //arbol.inOrden(arbol.raiz);
        
        //System.out.println(arbol.raiz.valor);
        //System.out.println(arbol.raiz.hijo_derecha.valor);
        //System.out.println(arbol.raiz.hijo_izquierda.valor);
        //arbol.crear_grafo(arbol.raiz);
        //arbol.imprimir();
        
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
        
         /*
        String dato = "cadena cadenita";
        System.out.println(getHASH(dato.getBytes()));
        dato = "cadena cadenite";
        System.out.println(getHASH(dato.getBytes()));
         */
         
         
         
         //probando operaciones 
         
         
         
         /*
         ArrayList<Operacion> operaciones = new ArrayList<>();
         
         Usuario n = new Usuario("DPI","nombre","user","correo","password",2222,2);
         Mensajero b = new Mensajero("nombre", "apellido","DPI","A","Correo", "dir",2);
         Lista_simple w = new Lista_simple();
         w.insertar(2);
         w.insertar(2);
         w.insertar(2);
         w.insertar(2);
         w.insertar(2);
         
         Operacion nueva = new Operacion("direccion","03/05/2022",1,n,b,w);
         operaciones.add(nueva);
         nueva = new Operacion("direccion","04/05/2022",1,n,b,w);
         operaciones.add(nueva);

         

         
         
         
         
         Arbol_Merkle arbol = new Arbol_Merkle(operaciones);
         arbol.imprimir();
         
         
         */
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
        
    }
    
    /*
    public static String getHASH( byte[] imput){
        
        String hash = "";
        
        try{
            MessageDigest mensaje = MessageDigest.getInstance("SHA-256");
            mensaje.update(imput);
            byte[] bytes = mensaje.digest();
            hash = DatatypeConverter.printHexBinary(bytes).toLowerCase();
        
        }catch( Exception e){
            System.out.println(e);
        }
        return hash;
    
    }
*/
    
    
}
 