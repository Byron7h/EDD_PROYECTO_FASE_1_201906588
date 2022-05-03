package f2_proyecto_estructuras;

public class Lista_doble {
    
    Nodo_lista_doble cabecera;
    
    public Lista_doble(){
        this.cabecera = null;
    }
    
    public void insertar(Album al){
        
        Nodo_lista_doble nuevo = new Nodo_lista_doble(al);
        
        if (cabecera == null){
            cabecera = nuevo;
        }else{
            Nodo_lista_doble actual = cabecera;
            while (actual.siguiente != null){
                actual = actual.siguiente;
            }
            nuevo.anterior= actual;
            actual.siguiente = nuevo;
        }
    }
    
    
    public Nodo_lista_doble get_cabecera(){
        return cabecera;
    }
}
