/*
    Esta clase nos va a servir para registrar las entregas de impresiones
 */
package f2_proyecto_estructuras;

public class Operacion {
    /*
● impresión (dirección de la sucursal) //string
● Fecha de solicitud //string
● Lugar de destino(Id municipio del cliente) //int
● Cliente (Apuntador a árbol B) // cliente
● Mensajero (apuntador a tabla hash) // mensajero
● Ruta seleccionada (Lista simplemente enlazada) //lista_simple
    
    */
    String dir_sucursal, fecha;
    int municipio;
    Usuario cliente;
    Mensajero mens;
    Lista_simple ruta;
    
    public Operacion(String dir_sucursal, String fecha, int mun, Usuario cliente, 
            Mensajero mens, Lista_simple ruta){
        
        this.dir_sucursal = dir_sucursal;
        this.fecha = fecha;
        this.municipio = mun;
        this.cliente = cliente;
        this.mens = mens;
        this.ruta = ruta;
         
    }
    
    
    
}
