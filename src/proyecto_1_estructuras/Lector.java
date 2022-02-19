/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_1_estructuras;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Lector {
    
    Cola Cola_inicial = new Cola();
    String ruta;
    int tamano = 0; //este parámetro lo vamos a usar para los ids de los nodos extras
    
    public Lector(String ruta, int Cantidad){
        this.ruta = ruta;
        this.tamano= Cantidad;
    }
    
    
    public Cola Lectura(){    
        
        JSONParser parser = new JSONParser();
        try {
            
            Object obj = parser.parse(new FileReader(ruta));
            JSONObject jsonObject = (JSONObject) obj; //Convertimos el archivo a objeto JSON
            System.out.println("JSON LEIDO: " + jsonObject);
            
            
            for(int i = 1 ; i < tamano+1 ; i++) {
                
                
                // Creando nodos               
                JSONObject jsonObject1 = (JSONObject) jsonObject.get("Cliente"+i);                  
                int id = Integer.parseInt(""+jsonObject1.get("id_cliente"));
                String nombre = ""+jsonObject1.get("nombre_cliente");
                int img_c = Integer.parseInt(""+jsonObject1.get("img_color"));
                int img_bn = Integer.parseInt(""+jsonObject1.get("img_bw"));
                
                nodo nuevo = new nodo(id, nombre, img_c, img_bn);
                Cola_inicial.insertar(nuevo);
                System.out.println(i);
                
                
                
                
                
            }

        }
        catch(FileNotFoundException e){e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}
        catch (ParseException e){e.printStackTrace();}
        catch (Exception e){e.printStackTrace();}
        
        
        return Cola_inicial;
        
    }
    
    
    
    
    
}
