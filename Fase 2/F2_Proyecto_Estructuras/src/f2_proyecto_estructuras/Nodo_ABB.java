package f2_proyecto_estructuras;

public class Nodo_ABB {
    
    Nodo_ABB padre = null;
    Nodo_ABB hijo_derecha = null;
    Nodo_ABB hijo_izquierda = null;
    Capa_img valor;
    int altura;
    int id;

    
    public Nodo_ABB(Capa_img valor){
        this.valor = valor;
        this.id = valor.id;
    }
}
