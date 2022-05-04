package f2_proyecto_estructuras;

public class Lista_simple {
    
    Nodo_Lista cabecera;
    
    public Lista_simple(){
        this.cabecera = null;
    }
    
    public void insertar(int al){
        
        Nodo_Lista nuevo = new Nodo_Lista(al);
        
        if (cabecera == null){
            cabecera = nuevo;
        }else{
            Nodo_Lista  actual = cabecera;
            while (actual.siguiente != null){
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }
    public Nodo_Lista get_cabecera(){
        return cabecera;
    }
    
    
    public String cadena(){
        
        String result = "";
        Nodo_Lista  actual = cabecera;
        while (actual.siguiente != null){
            result += Integer.toString(actual.id);
            actual = actual.siguiente;
        }

        return result;
    }
    
    
}
