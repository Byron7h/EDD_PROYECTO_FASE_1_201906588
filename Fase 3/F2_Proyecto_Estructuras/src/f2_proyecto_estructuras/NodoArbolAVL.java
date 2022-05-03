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
public class NodoArbolAVL {
   int dato, fe;
    NodoArbolAVL hijoIzquierdo, hijoDerecho;

    public NodoArbolAVL(int d) {
        this.dato = d;
        this.fe = 0;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }
}
