package f2_proyecto_estructuras;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

 
public class Lector_lugares {
    String ruta;
    Lista_Ad lista;
    
    public Lector_lugares(String ruta){
        this.ruta = ruta;
    }
    
    
    
    //LinkedList<Usuario> usuarios
    
    public void Lectura(Lista_Ad lista){
       this.lista = lista;

        
        JSONParser parser = new JSONParser();
        try {
            
            Object obj = parser.parse(new FileReader(ruta));
            System.out.println(obj);
            JSONObject json = (JSONObject) obj; //Convertimos el archivo a objeto JSON
            
            JSONArray jsonArray = (JSONArray) json.get("Lugares");
            

            
            // ahora vamos usuario por usuario
            for(int i = 0 ; i < jsonArray.size() ; i++) { 
                

                
                // convertimos el array a objeto json para poder sacar sus datos
                JSONObject objectx = (JSONObject) jsonArray.get(i);

                
                int id = Integer.parseInt(""+objectx.get("id"));
                String departamento = ""+objectx.get("departamento");
                String nombre = ""+objectx.get("nombre");
                String sucu = ""+objectx.get("sn_sucursal");
                
                boolean sucursal = false;
                
                if ("si".equals(sucu)){
                    sucursal = true;
                
                }
                
                

                Lugar nuevo = new Lugar(id, departamento, nombre, sucursal);
                System.out.println("Lugar "+nombre);
                lista.insertarLugar(nuevo);
       
            }
            //usuario.albumes = albumes;
        }
        catch(FileNotFoundException e){e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}
        catch (ParseException e){e.printStackTrace();}
    }
    
}

