package f2_proyecto_estructuras;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// on este objeto 
public class Lector_capas {

    String ruta;
    
    public Lector_capas(String ruta){
        this.ruta = ruta;
    }
    public void Lectura(){
        
        JSONParser parser = new JSONParser();
        try {
            
            Object obj = parser.parse(new FileReader(ruta));
            System.out.println(obj);
            JSONArray jsonArray = (JSONArray) obj; //Convertimos el archivo a objeto JSON
            System.out.println(jsonArray);
            System.out.println(jsonArray.size());
            
            for(int i = 0 ; i < jsonArray.size() ; i++) {  
                
                JSONObject objectx = (JSONObject) jsonArray.get(i);
                System.out.println("--------------------");
                System.out.println(objectx.get("id_capa"));
                //System.out.println(objectx.get("pixeles"));
                JSONArray arra = (JSONArray) objectx.get("pixeles");
                
                for(int w = 0 ; w < arra.size() ; w++) {  
                    System.out.println(arra.get(w));
                    JSONObject pixel = (JSONObject) arra.get(w);
                    System.out.println("    Columna" + pixel.get("columna"));
                    System.out.println("    Fila" + pixel.get("fila"));
                    System.out.println("    Color" + pixel.get("color"));
                    System.out.println("");
                
                }
                //System.out.println(arra);

            }
            
            


        }
        catch(FileNotFoundException e){e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}
        catch (ParseException e){e.printStackTrace();}
  
        




    }
    
    
    
    
}
