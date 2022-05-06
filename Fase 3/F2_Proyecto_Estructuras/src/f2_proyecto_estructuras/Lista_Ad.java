/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f2_proyecto_estructuras;

/**
 *
 * @author usuario
 */
public class Lista_Ad {
    
    Nodo_lugar cabecera = null;
    String nodos = "";
    String enlaces = "";
    
    
    String nodos_2 = "";
    String enlaces_2 = "";
    
    public Lista_Ad(){
    }
    
    public void insertarLugar(Lugar lug){
        
        Nodo_lugar nuevo = new Nodo_lugar(lug);
        if (this.cabecera == null){
            cabecera = nuevo;
        }else{
            Nodo_lugar aux = cabecera;
            while (true) {
                if (aux.siguiente == null) {
                    aux.siguiente = nuevo;
                    break;
                }
                aux = aux.siguiente;
            }
        }
    }
    
    public void insertarRuta(Ruta ruta){
        // este método nos va a servir para insertar de ida y de regreso
        Nodo_lugar nodo = buscar_lugar(ruta.inicio);
        nodo.insertarRuta(ruta);
        
        Ruta nueva = new Ruta(ruta.fin, ruta.inicio,ruta.peso);
        Nodo_lugar nod = buscar_lugar(ruta.fin);
        nod.insertarRuta(nueva);
        
    
    }
    
    public Nodo_lugar buscar_lugar(int id){
        
        Nodo_lugar retorno = null;
        Nodo_lugar aux = this.cabecera;
        
        while (aux != null) {     
            if (aux.id == id) {
                retorno = aux;
                break;
            }       
            aux = aux.siguiente;
        }
        return retorno;
    }
    
    public void imprimir(){
        Nodo_lugar aux = this.cabecera;
        
        while(aux != null){ // recorriendo todos los lugares
            System.out.print("["+aux.id+"] ::: ");     
            Nodo_ruta actual = aux.cabecera;
            
            while(actual != null){
                System.out.print(" ->["+actual.ruta.fin+"] ");
                actual = actual.siguiente;
            }
            System.out.println("");
            aux = aux.siguiente;
        }
    }
    
    public void Grafo(){
        
        String resultante = "digraph finite_state_machine {\n" +
"	fontname=\"Helvetica,Arial,sans-serif\"\n" +
"	node [fontname=\"Helvetica,Arial,sans-serif\"]\n" +
"	edge [fontname=\"Helvetica,Arial,sans-serif\", dir = none]\n" 
        +this.nodos + this.enlaces +"}";
        System.out.println(resultante);
    
    
    }
    
    
    public void Grafo_2(){
        
        String resultante = "digraph L{\n" +
"    node[shape=box  style= filled]\n" +
"    edge[dir=\"left\" ]\n";
 
    
        
        
        
        Nodo_lugar aux = this.cabecera;
        
        while(aux != null){ // recorriendo todos los lugares
            
            
            // agregando lugar actual         1[label="Album 1"];
            resultante += "    "+ aux.id +"[label=\""+aux.id+" "+aux.valor.nombre+"\"];\n" ;
            System.out.print("["+aux.id+"] ::: "); 
            
            // enlace de lugares
            if(aux.siguiente!=null){
                //1->2;
                resultante +=  "    " + aux.id + "->" +aux.siguiente.id+";\n";
            
            }
            
            
            Nodo_ruta actual = aux.cabecera;
            
            // enlace a la primera ruta
            
            String reg = "";
            String reg_2 = "";
            if(actual != null){
                
                reg += aux.id; 
                reg_2 += aux.id; 
                //resultante +=  "    " + aux.id + "->" +actual.hashCode()+";\n";
            }
            
            
            while(actual != null){
                // agregando los nodos
                resultante += "    "+ actual.hashCode()+"[label=\""+actual.ruta.fin+"\"];\n" ;
                
                
                //haciendo enlace
                reg += "->"+actual.hashCode();
                reg_2 += ";"+actual.hashCode();
                System.out.print(" ->["+actual.ruta.fin+"] ");
                
                
                actual = actual.siguiente;
            
           
           }
            
           if (!reg.equals("")){
                //1->a->b->c;
                resultante +=  "    " + reg +";\n";
                //{rank = same;2;d;e;f}
                resultante +=  "    {rank = same;" + reg_2 +"}\n";
            }
           
            System.out.println("");
            aux = aux.siguiente;
        }
        resultante += "}";
        System.out.println(resultante);
    }
    
    
}
