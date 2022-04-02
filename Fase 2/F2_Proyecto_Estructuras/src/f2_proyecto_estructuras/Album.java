package f2_proyecto_estructuras;

public class Album {
    
    String id ;
    Lista_simple lista = new Lista_simple();
    
    public Album( String id, Lista_simple lista){
        this.id = id;
        this.lista = lista;
    }
    
    public void insertar (int nuevo){
        lista.insertar(nuevo);
    
    }
    
    
}
