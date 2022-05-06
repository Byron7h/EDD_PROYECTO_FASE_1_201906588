package f2_proyecto_estructuras;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

 
public class Lector_mensajeros{
    String ruta;
    TablaHash tabla;
    
    public Lector_mensajeros(String ruta){
        this.ruta = ruta;
    }
    
    
    
    //LinkedList<Usuario> usuarios
    
    public void Lectura(TablaHash tabla){
       this.tabla = tabla;

        
        JSONParser parser = new JSONParser();
        try {
            
            Object obj = parser.parse(new FileReader(ruta));
            System.out.println(obj);
            JSONArray jsonArray = (JSONArray) obj; //Convertimos el archivo a objeto JSON

            
            // ahora vamos mensajero por pensajero
            for(int i = 0 ; i < jsonArray.size() ; i++) { 
                

                
                // convertimos el array a objeto json para poder sacar sus datos
                JSONObject objectx = (JSONObject) jsonArray.get(i);

                
                
                long dpi = Long.parseLong( ""+objectx.get("dpi")); 
                String nombres = ""+objectx.get("nombres"); 
                String apellidos = ""+objectx.get("apellidos");
                String tipo_licencia = ""+objectx.get("tipo_licencia");
                String genero = ""+objectx.get("genero");
                String direccion = ""+objectx.get("direccion");

                System.out.println(dpi);
                Mensajero m = new Mensajero(nombres, apellidos, dpi, tipo_licencia, direccion, genero);
                tabla.insertar(m);
            }
            //tabla.imprimir();
        }
        catch(FileNotFoundException e){e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}
        catch (ParseException e){e.printStackTrace();}
    }
    
}
