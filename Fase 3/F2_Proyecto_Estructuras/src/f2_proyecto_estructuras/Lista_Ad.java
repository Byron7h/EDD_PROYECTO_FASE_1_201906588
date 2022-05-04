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
public class Lista_Ad {
    
    Nodo_lugar cabecera = null;
    
    
    public Lista_Ad(){
    }
    
    public void insertarLugar(Lugar lug){
        
        Nodo_lugar nuevo = new Nodo_lugar(lug);
        if (this.cabecera == null){
            cabecera = nuevo;
        }else{
            Nodo_lugar aux = cabecera;
            while (true) {
                if (aux.siguiente == null) {
                    aux.siguiente = nuevo;
                    break;
                }
                aux = aux.siguiente;
            }
        }
    }
    
    public void insertarRuta(Ruta ruta){
        // este método nos va a servir para insertar de ida y de regreso
        Nodo_lugar nodo = buscar_lugar(ruta.inicio);
        nodo.insertarRuta(ruta);
        
        Ruta nueva = new Ruta(ruta.fin, ruta.inicio,ruta.peso);
        Nodo_lugar nod = buscar_lugar(ruta.fin);
        nod.insertarRuta(nueva);
        
    
    }
    
    public Nodo_lugar buscar_lugar(int id){
        
        Nodo_lugar retorno = null;
        Nodo_lugar aux = this.cabecera;
        
        while (aux != null) {     
            if (aux.id == id) {
                retorno = aux;
                break;
            }       
            aux = aux.siguiente;
        }
        return retorno;
    }
    
    public void imprimir(){
        Nodo_lugar aux = this.cabecera;
        
        while(aux != null){ // recorriendo todos los lugares
            System.out.print("["+aux.id+"] ::: ");     
            Nodo_ruta actual = aux.cabecera;
            
            while(actual != null){
                System.out.print(" ->["+actual.ruta.fin+"] ");
                actual = actual.siguiente;
            }
            System.out.println("");
            aux = aux.siguiente;
        }
    }
}
