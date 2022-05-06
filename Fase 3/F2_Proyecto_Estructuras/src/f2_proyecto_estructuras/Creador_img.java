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
    
    public Creador_img(Matriz_pixeles matriz, int o){
        this.matriz = matriz;
        Generar_img2();
    }
    
    public Creador_img(String t){
        GenerarImagenDTO(t);
    }
    
    
    public Creador_img(Lista_doble lista_d){
        Generar_img3(lista_d);
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
        GenerarImagen( grafo);
    }
    
    
       public static void GenerarImagen(String txtDTO) {
        try {
            // creamos un nuevo archivo txt
            String contenido = txtDTO;
            File file = new File("C:\\Users\\usuario\\Desktop\\provisional\\imagenes\\0.txt");

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
       
    public static void GenerarImagenDTO(String txtDTO) {
        try {
            // creamos un nuevo archivo txt
            String contenido = txtDTO;
            File file = new File("C:\\Users\\usuario\\Desktop\\provisional\\imagenes\\0.txt");

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
        //imagen de las matrices como 
        
       public void Generar_img2(){
        
        String grafo = "digraph G {\n" +
                        "node [shape=plaintext];\n" +
                        "some_node [\n" +
                        "label=<\n" +
                        "<table border=\"0\" cellborder=\"1\" cellspacing=\"2\" width=\"100%\" height=\"100%\">\n";
        
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
                        grafo += "  <td>"+nodo_actual.dato+"</td>\n";
                        nodo_actual = nodo_actual.siguiente;      
                    
                
                }else{
                    // agregamos nodos en blanco 
                    grafo += "  <td>white</td>\n";
                }
                //contador++;
                if( nodo_actual == null && contador<matriz.ancho){
                    for (int i= contador; i<matriz.ancho+1 ;i++){
                    // agregamos nodos en blanco 
                        grafo += "  <td>white</td>\n";
                    }
                
                }
                    
                contador++;
                }
                grafo += "</tr>\n";
                fila_actual = fila_actual.abajo;
            
            
            
            }else{ 
                for (int i= 0; i<matriz.ancho+1 ;i++){
                    // agregamos nodos en blanco 
                    grafo += "  <td>white</td>\n";
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
        GenerarImagen(grafo);
    }
        
        
        public void Generar_img3(Lista_doble lista_d){
        
        String grafo = "digraph L{\n" +
                        "    node[shape=box  style= filled]\n";
        
        String aux ="";
        // extraemos la cabecera
        
        
        Nodo_lista_doble actual = lista_d.cabecera;
        
        while(actual!= null){
            
            String nombre = actual.album.id;
            Lista_simple lista_s = actual.album.lista;
            Nodo_Lista act = lista_s.cabecera;
            
            aux += ";"+actual.hashCode();
            
            
            
            // Agregamos un label principal
            grafo += "        "+actual.hashCode()+"[label=\""+nombre+"\"];\n";
            
            // enlazamos
            
            grafo += "";
            if(actual.anterior!= null){
                
                grafo += "        edge[dir=\"rigth\" color=\"blue\"]\n" +
                         "        "+actual.hashCode()+" -> "+actual.anterior.hashCode()+"\n";
            }
            if(actual.siguiente!= null){
                
                grafo += "        edge[dir=\"left\" color=\"red\"]\n" +
                         "        "+actual.hashCode()+" -> "+actual.siguiente.hashCode()+"\n";
            
            }
            
            boolean primero = true;
            while(act != null){
                
                grafo+="        "+act.hashCode()+"[label="+act.id+"];\n";
                
                if(primero){
                    grafo += "        edge[dir=\"left\" color=\"black\"]\n" +
                         "        "+actual.hashCode()+" -> "+act.hashCode()+";\n";
                    primero = false;

                }
                
                if(act.siguiente != null){
                    grafo+=  act.hashCode()+"->"+act.siguiente.hashCode()+";\n";
                }
                act = act.siguiente;
            } 
            actual = actual.siguiente;
        }
        grafo += "        {rank = same"+aux+"}";
        grafo += "}";
        
        System.out.println(grafo);
        GenerarImagen(grafo);
    }
        
        
        
        
        
        
        
        
  
    
}
