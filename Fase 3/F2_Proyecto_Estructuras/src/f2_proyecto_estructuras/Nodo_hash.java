package f2_proyecto_estructuras;

public class Nodo_hash {
    
    long cliente; // No cambiamos el nombre de esta variable por tiempo
    Mensajero valor;
    public Nodo_hash(Mensajero mensa){
        this.valor = mensa;
        cliente = mensa.DPI;
    }
    
}
