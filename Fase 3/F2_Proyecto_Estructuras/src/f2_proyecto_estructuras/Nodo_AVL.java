package f2_proyecto_estructuras;

public class Nodo_AVL {
    
    
    Nodo_AVL padre = null;
    Nodo_AVL hijo_derecha = null;
    Nodo_AVL hijo_izquierda = null;
    int valor, altura, fe;
    Imagen imagen;

    
    public Nodo_AVL(Imagen img){
        this.valor = img.id;
        this.fe = 0;
        this.imagen = img;
    }
    
    
    
    
}
