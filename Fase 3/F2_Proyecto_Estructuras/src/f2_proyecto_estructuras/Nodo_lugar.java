/*
    --------------- NODO VECTOR PRINCIPAL ------------------
    Esta es para los datos (A, B, C, D)
 */
package f2_proyecto_estructuras;

/**
 *
 * @author usuario
 */
public class Nodo_lugar {

    int id ;//posicion del nodo conectado
    Lugar valor;
    Nodo_lugar siguiente = null;//nodo siguiete en la sublista
    Nodo_ruta cabecera = null; //cabecera de la lista de rutas
    
    Nodo_lugar anterior = null;
    int distancia = Integer.MAX_VALUE;
    boolean etiquetado = false;
    
    //constructor de la clase
    public Nodo_lugar(Lugar lug) {
        this.valor = lug;
        this.id = lug.id;
    }
    
    /*
            ENodo nuevo = new ENodo(ivex);
            if (inicio == null) {
                inicio = nuevo;
            } else {
                ENodo aux = inicio;
                while (true) {
                    if (aux.siguiente == null) {
                        aux.siguiente = nuevo;
                        break;
                    }
                    aux = aux.siguiente;
                }
            }*/
    
    public void insertarRuta( Ruta ru){
        Nodo_ruta nuevo = new Nodo_ruta(ru);
        if (this.cabecera == null){
            cabecera = nuevo;
        }else{
            Nodo_ruta aux = cabecera;
            while (true) {
                if (aux.siguiente == null) {
                    aux.siguiente = nuevo;
                    break;
                }
                aux = aux.siguiente;
            }
        }
    }
    
    
    
}