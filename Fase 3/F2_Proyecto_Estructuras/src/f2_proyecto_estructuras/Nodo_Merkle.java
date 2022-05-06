/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f2_proyecto_estructuras;

/**
 *
 * @author usuario
 */
public class Nodo_Merkle {
    
    Nodo_Merkle izquierda, derecha, padre;
    String hash;
    String descripcion = "";
    
    
    public Nodo_Merkle(String hash){
            this.hash = hash;
    }
    
}
