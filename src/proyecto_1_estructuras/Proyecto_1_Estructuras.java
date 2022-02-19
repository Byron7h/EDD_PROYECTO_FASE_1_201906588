/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_1_estructuras;

/**
 *
 * @author usuario
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class Proyecto_1_Estructuras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String ruta = "C:\\Users\\usuario\\Documents\\Byron\\7mo semestre\\Estructuras\\EDD_PROYECTO_FASE_1_201906588\\Entrada.json";
        int tamano = 50;  
        
        Lector lectura = new Lector(ruta, tamano);
        Cola colita = lectura.Lectura();
        colita.imprimir();

        

    }
    
}
