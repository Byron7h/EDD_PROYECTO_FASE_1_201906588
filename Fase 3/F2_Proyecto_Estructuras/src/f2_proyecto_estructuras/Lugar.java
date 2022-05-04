package f2_proyecto_estructuras;

/**
    Estos serán los nodos de nuestro grafo
 */
public class Lugar {
    
    int id;
    String departamento, nombre;
    boolean sn_sucursal;
    
    public Lugar(int id, String departamento, String nombre, boolean sn_sucursal){
        
        this.id = id;
        this.departamento = departamento;
        this.nombre = nombre;
        this.sn_sucursal = sn_sucursal;
        
    }
}
