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
public class Lista_ordenada_2 {
        Nodo_ inicio;
        int tamano = 0;

    //• contructor
    public Lista_ordenada_2() {
        inicio = null;
    }

    public void insertar(String txt, int id) {
        Nodo_ nuevo = new Nodo_(txt, id);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo_ actualAux = inicio;
            while (actualAux != null) {
                if (actualAux.siguiente == null) {
                    actualAux.siguiente = nuevo;
                    break;
                }
                actualAux = actualAux.siguiente;
            }
        }
        tamano++;
    }

    public void imprimir() {
        Nodo_ actualAux = inicio;
        while (actualAux != null) {
            if (actualAux.siguiente == null) {
                System.out.print("[" + actualAux.cantidad + "]");
            } else {
                System.out.print("[" + actualAux.cantidad + "]-");
            }
            actualAux = actualAux.siguiente;
        }
        System.out.println("");
    }
    
    public void reporte_c() {
        
        if (tamano>4){ 
            int margen = 0;
            Nodo_ actualAux = inicio;
            System.out.println("Top 5 de clientes con mayor cantidad de imágenes a color");
            while (margen < 5) {
                if (actualAux.siguiente == null) {
                    
                    System.out.println( margen+1+ ". Cantidad: "+actualAux.cantidad+" Nombre: "+ actualAux.nombre);
                    margen++;
                } else {
                    System.out.println( margen+1+ ". Cantidad: "+actualAux.cantidad+" Nombre: "+ actualAux.nombre);
                    margen++;
                }
                actualAux = actualAux.siguiente;
            }
            System.out.println("");
        }
    }

    public void ordernarById() {
        Nodo_ aux_i;
        Nodo_ aux_j;
        Nodo_ auxValor;
        Nodo_ auxAnterior_i = null;
        Nodo_ auxAnterior_j = null;

        //recorrer la lista, iniciando en el primer nodo
        aux_i = inicio;
        while (aux_i != null) {
            //recorrer la lista iniciando en el nodo siguiente
            aux_j = aux_i.siguiente;
            while (aux_j != null) {
                if (aux_i.cantidad < aux_j.cantidad) {

                    //guardamos el nodo siguiente de [i]
                    auxValor = aux_i.siguiente;

                    //cambiar los apuntadores de nodos siguientes
                    if (auxValor.hashCode() != aux_j.hashCode()) { //si el nodo siguiente de [i]!=[j]
                        //hay nodos intermedios entre [i] y [j]
                        aux_i.siguiente = aux_j.siguiente;
                        aux_j.siguiente = auxValor;
                        auxAnterior_j.siguiente = aux_i;//el nodo anterior de [j] debe apuntar a [i] ya que se intercambiaran
                    } else {//si el nodo siguiente de [i]==[j]
                        //no hay nodos intermedios entre [i] y [j]
                        aux_i.siguiente = aux_j.siguiente;
                        aux_j.siguiente = aux_i;

                    }

                    //intercambiar las posiciones de los nodos [i],[j]
                    auxValor = aux_i;
                    aux_i = aux_j;
                    aux_j = auxValor;

                    ///Al cambiar la posicion de un nodo el nodo anterior de [i] debe apuntar al nuevo [i]
                    if (auxAnterior_i != null) {
                        auxAnterior_i.siguiente = aux_i;
                    }

                    //si cambiamos la posicion del primer nodo de la lista, debemos cambiar el nodo inicial.
                    if (aux_j.hashCode() == inicio.hashCode()) {
                        inicio = aux_i;
                    }
                }
                auxAnterior_j = aux_j;
                aux_j = aux_j.siguiente;
            }
            auxAnterior_i = aux_i;
            aux_i = aux_i.siguiente;
        }
    }  
    
}
