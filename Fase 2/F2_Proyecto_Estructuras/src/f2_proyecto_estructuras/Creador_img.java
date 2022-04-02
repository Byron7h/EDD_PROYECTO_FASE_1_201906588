/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f2_proyecto_estructuras;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

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
    
    public Creador_img(String dto){
        //this.matriz = matriz;
        GenerarImagen(dto, 1);
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
        
        
        
        int contador2 = 0;
        while (fila_actual != null){ // recorriendo filas
            grafo += "<tr>\n";

            if(fila_actual.y == contador2){
                nodo_actual = fila_actual.siguiente;
                int contador = 0;
                while (nodo_actual != null){
                    if (nodo_actual.x == contador){
                        // agregamos el pixel, y avanzamos al siguiente
                        grafo += "  <td bgcolor=\""+nodo_actual.dato+"\" width=\"1\" height=\"1\"></td>\n";
                        nodo_actual = nodo_actual.siguiente;      
                    
                
                }else{
                    // agregamos nodos en blanco 
                    grafo += "  <td bgcolor=\"white\" width=\"1\" height=\"1\"></td>\n";
                }
                contador++;
                }
                grafo += "</tr>\n";
                fila_actual = fila_actual.abajo;
            
            
            
            }else{ 
                for (int i= 0; i<matriz.ancho ;i++){
                    // agregamos nodos en blanco 
                    grafo += "  <td bgcolor=\"white\" width=\"1\" height=\"1\"></td>\n";
                }
                grafo += "</tr>\n";
            
            }
            contador2++;
            
            
            /*
            
            
            nodo_actual = fila_actual.siguiente;
            int contador = 0;
            while (nodo_actual != null){
                if (nodo_actual.x == contador){
                    // agregamos el pixel, y avanzamos al siguiente
                    grafo += "  <td bgcolor=\""+nodo_actual.dato+"\" width=\"1\" height=\"1\"></td>\n";
                    nodo_actual = nodo_actual.siguiente;      
                    
                
                }else{
                    // agregamos nodos en blanco 
                    grafo += "  <td bgcolor=\"white\" width=\"1\" height=\"1\"></td>\n";
                }
                contador++;
            }
            grafo += "</tr>\n";
            fila_actual = fila_actual.abajo;
            
            
            */
        }
        
        grafo +=    "</table>>\n" +
                    "];\n" +
                    "}\n";
        //System.out.println(grafo);
        GenerarImagen(grafo,0);
    }
    
    
       public static void GenerarImagen(String txtDTO, int num) {
        try {
            // creamos un nuevo archivo txt
            String contenido = txtDTO;
            File file = new File("src/imagenes/"+num+".txt");

            if (!file.exists()) {
                file.createNewFile();
            }
            
            // Le escribimos nuestro codigo dto
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();

            //---------Compilar el dto
            
            // ruta de dot.exe, mi equipo -> archivos del programa -> graphviz -> bin ->dot

            String dotPath = "C:\\Program Files\\Graphviz\\bin\\dot.exe";
            String fileIn = file.getCanonicalPath(); //esto es para obtener la ruta
            String fileOU = fileIn.replace(".txt", ".jpg"); // salida de imagen
            String tParam = "-Tjpg";
            String tOparam = "-o";

            String[] cmd = new String[5]; // cadena de cadenas 
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileIn;
            cmd[3] = tOparam;
            cmd[4] = fileOU;

            Runtime rt = Runtime.getRuntime(); //herramienta para ejecutar comandos
            rt.exec(cmd);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
