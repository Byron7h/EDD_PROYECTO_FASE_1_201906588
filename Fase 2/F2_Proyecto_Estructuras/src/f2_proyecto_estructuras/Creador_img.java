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
public class Creador_img {
    
    Matriz_pixeles matriz; 
    
    public Creador_img(Matriz_pixeles matriz){
        this.matriz = matriz;
        Generar_img();
    }
    
    public void Generar_img(){
        
        String grafo = "digraph G {\n" +
                        "node [shape=plaintext];\n" +
                        "some_node [\n" +
                        "label=<\n" +
                        "<table border=\"0\" cellborder=\"0\" cellspacing=\"0\" width=\"100%\" height=\"100%\">\n";
        
        // extraemos la cabecera
        
        Nodo_matriz nodo_actual = matriz.cabecera;
        Nodo_matriz fila_actual = matriz.cabecera.abajo;
        
        while (fila_actual != null){ // recorriendo filas
            grafo += "<tr>\n";
            nodo_actual = fila_actual.siguiente;
            int contador = 0;
            
            while (nodo_actual != null){
                if (nodo_actual.x == contador){
                    // agregamos el pixel, y avanzamos al siguiente
                    grafo += "  <td bgcolor=\""+nodo_actual.dato+"\" width=\"1\" height=\"1\"></td>\n";
                    nodo_actual = nodo_actual.siguiente;      
                    contador++;
                
                }else{
                    // agregamos nodos en blanco 
                    grafo += "  <td bgcolor=\"white\" width=\"1\" height=\"1\"></td>\n";
                    contador++;
                
                }
            }
            grafo += "</tr>\n";
            fila_actual = fila_actual.abajo;
        }
        
        grafo +=    "</table>>\n" +
                    "];\n" +
                    "}\n";
        System.out.println(grafo);
    }
    
}
