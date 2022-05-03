/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f2_proyecto_estructuras;



public class Nodo_lista_doble {
    Nodo_lista_doble anterior = null;
    Nodo_lista_doble siguiente = null;
    Album album;
    
    public Nodo_lista_doble(Album al) {
        this.album = al;
    }

}
