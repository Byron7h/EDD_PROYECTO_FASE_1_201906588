package f2_proyecto_estructuras;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

 
public class Lector_usuarios {
    String ruta;
    LinkedList<Usuario> usuarios;
    
    public Lector_usuarios(String ruta){
        this.ruta = ruta;
    }
    
    
    
    

    
    public void Lectura(LinkedList<Usuario> usuarios){
        this.usuarios = usuarios;
        

        
        JSONParser parser = new JSONParser();
        try {
            
            Object obj = parser.parse(new FileReader(ruta));
            System.out.println(obj);
            JSONArray jsonArray = (JSONArray) obj; //Convertimos el archivo a objeto JSON

            
            // ahora vamos usuario por usuario
            for(int i = 0 ; i < jsonArray.size() ; i++) { 
                
                Lista_simple lista = new Lista_simple();
                
                // convertimos el array a objeto json para poder sacar sus datos
                JSONObject objectx = (JSONObject) jsonArray.get(i);

                
                
                long dpi = Long.parseLong( ""+objectx.get("dpi")); 
                String nombre = ""+objectx.get("nombre"); 
                String user = ""+objectx.get("usuario");
                String correo = ""+objectx.get("correo");
                String contrasena = ""+objectx.get("contrasena");
                int telefono = Integer.parseInt(""+objectx.get("telefono"));
                String direccion = ""+objectx.get("direccion");
                int id_municipio = Integer.parseInt(""+objectx.get("id_municipio"));
                
                Usuario nuevo = new Usuario(nombre, user, dpi, contrasena, correo, telefono, direccion, id_municipio);
                System.out.println("SE AGREGÓ "+ nombre +" "+ dpi);
                usuarios.add(nuevo);
            }
            //this.usuarios  = usuarios;
        }
        catch(FileNotFoundException e){e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}
        catch (ParseException e){e.printStackTrace();}
    }
    
}

