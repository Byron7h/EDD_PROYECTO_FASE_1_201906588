package f2_proyecto_estructuras;

public class ABB {

    Nodo_ABB raiz;
    
    public ABB(){
        this.raiz = null;
    }
    
    
    public void insertar(int dato){
        insertar(dato, raiz);
    }

    public void insertar(int dato, Nodo_ABB actual ){

        if (actual == null){ //se inserta
            Nodo_ABB nuevo = new Nodo_ABB(dato);
            return;    
        }
        if (dato<actual.valor){
            insertar(dato, actual.hijo_izquierda);
        }
        else if (dato>=actual.valor){
            insertar(dato, actual.hijo_derecha);
        }
    }
  
}
