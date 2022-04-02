/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f2_proyecto_estructuras;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

 
public class Lector_albumes {
    String ruta;
    
    
    public Lector_albumes(String ruta){
        this.ruta = ruta;
    }
    
    
    
    public void Lectura(Usuario usuario){
       
        AVL arbol = usuario.imagenes;
        Lista_doble albumes = usuario.albumes;
        
        JSONParser parser = new JSONParser();
        try {
            
            Object obj = parser.parse(new FileReader(ruta));
            System.out.println(obj);
            JSONArray jsonArray = (JSONArray) obj; //Convertimos el archivo a objeto JSON
            //System.out.println(jsonArray);
            //System.out.println(jsonArray.size());
            
            // ahora vamos album por album
            for(int i = 0 ; i < jsonArray.size() ; i++) { 
                
                Lista_simple lista = new Lista_simple();    
                JSONObject objectx = (JSONObject) jsonArray.get(i);

                
                String nombre = ""+objectx.get("nombre_album"); //id de la imagen
                
                
                JSONArray array = (JSONArray) objectx.get("imgs");
                
                // ahora vamos IMG por IMG
                for( Object fe : array){
                    // tenemos el id de la capa
                    int dato = Integer.parseInt(""+fe);
                    
                    // buscamos dicho id en las capas del usuario
                    Nodo_AVL nodo = arbol.buscar(dato);
                    
                    if (nodo != null){
                        
                        lista.insertar(dato);             
                    }
                }
                
                Album nuevo = new Album(nombre, lista);
                albumes.insertar(nuevo);         

            }
            
            usuario.albumes = albumes;

        }
        catch(FileNotFoundException e){e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}
        catch (ParseException e){e.printStackTrace();}
    }
    
    
    
    
    
    
    
    
    
}
