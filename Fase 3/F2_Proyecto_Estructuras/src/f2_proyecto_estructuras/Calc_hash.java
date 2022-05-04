 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f2_proyecto_estructuras;


import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author usuario
 */
public class Calc_hash {
    
    public Calc_hash (){
    }
    
    public String Hash(String data){
        byte[] imput = data.getBytes();
        
        
       String hash = "";
        
        try{
            MessageDigest mensaje = MessageDigest.getInstance("SHA-256");
            mensaje.update(imput);
            byte[] bytes = mensaje.digest();
            hash = DatatypeConverter.printHexBinary(bytes).toLowerCase();
        
        }catch( Exception e){
            System.out.println(e);
        }
        return hash;
        
        
        
    
    }
    
}
