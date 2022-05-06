package f2_proyecto_estructuras;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

 
public class Lector_rutas {
    String ruta;
    Lista_Ad lista;
    String enlaces;
    
    public Lector_rutas(String ruta){
        this.ruta = ruta;
    }
    
    
    
    //LinkedList<Usuario> usuarios
    
    public void Lectura(Lista_Ad lista){
       

        
        JSONParser parser = new JSONParser();
        try {
            
            Object obj = parser.parse(new FileReader(ruta));
            System.out.println(obj);
            JSONObject json = (JSONObject) obj; //Convertimos el archivo a objeto JSON
            
            JSONArray jsonArray = (JSONArray) json.get("Grafo");
            

            
            // ahora vamos usuario por usuario
            for(int i = 0 ; i < jsonArray.size() ; i++) { 
                

                
                // convertimos el array a objeto json para poder sacar sus datos
                JSONObject objectx = (JSONObject) jsonArray.get(i);

                
                int inicio = Integer.parseInt(""+objectx.get("inicio"));
                int fin = Integer.parseInt(""+objectx.get("final"));
                int peso = Integer.parseInt(""+objectx.get("peso"));    
                
                //	0 -> 2 [label = "SS(B)"];
                enlaces += "	"+inicio+ " -> " + fin +" [label = \""+peso+"\"];\n";
                

                Ruta nueva = new Ruta(inicio, fin, peso);
                System.out.println("Ruta "+inicio +" "+ fin);
                lista.insertarRuta(nueva);
       
            }
            //usuario.albumes = albumes;
            lista.enlaces = enlaces;
            //lista.Grafo();
            lista.Grafo_2();
        }
        catch(FileNotFoundException e){e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}
        catch (ParseException e){e.printStackTrace();}
    }
    
}

