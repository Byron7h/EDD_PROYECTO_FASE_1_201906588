package f2_proyecto_estructuras;

/*
    Para encontrar el camino más corto vamos a utilizar el algoritmo de dijkstra

 */
public class Camino {
    
    int id_inicio;
    int id_final;
    Lista_Ad grafo;
    int tamano; // cantidad de nodos en el grafo
    Nodo_lugar ultimo;
    
    // id_nodo_inicio, id_nodo final, Lista de adyacencia
   
    public Camino(int id_inicio, int id_final, Lista_Ad grafo){
        this.id_inicio = id_inicio;
        this.id_final = id_final;
        this.grafo = grafo;
        this.tamano = Tamano();
        Dikstra();
        Camino();
    }
    
    public int Tamano(){
        
        int contador = 0;
        Nodo_lugar actual = grafo.cabecera;
        
        while(actual != null){
            contador++;
            actual = actual.siguiente;
        }
        
        return contador;
    }
    
        public int Tamano_rutas(Nodo_lugar actual){
        
        int contador = 0;
        Nodo_ruta aux = actual.cabecera;
        
        while(actual != null){
            contador++;
            actual = actual.siguiente;
        }
        
        return contador;
    }
    
    
    
    public void Dikstra(){
        
        
        // 1. lo primero que hace el algoritmo es inicializar todos los nodos, esto ya lo hicimos
        // cuando creamos los nodos
        
        // 2. nos colocamos en el ndodo origen y lo etiquetamos
        Nodo_lugar actual = grafo.buscar_lugar(id_inicio);
        actual.etiquetado = true;
        actual.distancia = 0;
        
        
        
        for ( int i = 0; i<this.tamano; i++ ){
            System.out.println(i);
            
            
            // 3. Traemos el nodo al que vamos a irnos y lo etiquetamos
            
            if(MinDistancia(actual)!= -1){
            
            actual = grafo.buscar_lugar(MinDistancia(actual));
            actual.etiquetado = true;
            Nodo_ruta aux = actual.cabecera;
            
            // 4. visitamos todos los vertices a los que podemos llegar desde el vertice actual
            for ( int w = 0; w<Tamano_rutas(actual); w++ ){
                System.out.println("  "+w);
                
                //5. todos los ultimos en sus rutas, actualizando sus distancias
                
                Ruta contenido = aux.ruta; //ruta actual
                Nodo_lugar evaluado = grafo.buscar_lugar(contenido.fin); //al que se va con esa ruta
                
                if(evaluado.etiquetado == false ){
                    
                    int distancia = actual.distancia + aux.ruta.peso;
                    if(distancia < evaluado.distancia){
                        evaluado.distancia = distancia;
                        evaluado.anterior = actual;
                    }
                } 
                aux = aux.siguiente;
            }  
        }
        }
    }
    
    public int MinDistancia(Nodo_lugar a){  // retorna el nodo con el coste mínimo 
                                     // entre los nodos no etiquetados a los que se puede ir 
                                     // desde el nodod actual    
        int id = -1;
        int peso = Integer.MAX_VALUE;
        
        Nodo_ruta actual = a.cabecera;
        
        while(actual != null){
            if(actual.ruta.peso<peso){      
                if ( grafo.buscar_lugar(actual.ruta.fin).etiquetado != true){
                    id = actual.ruta.fin;
                    peso = actual.ruta.peso;
                }
            }
            actual = actual.siguiente;
        }   
        System.out.println("DISTANCIA MINIMA "+id );
        return id;
    }
    
    public String Camino(){
        Nodo_lugar evaluado = grafo.buscar_lugar(id_final);
        String recorrido = " -> "+evaluado.valor.nombre;
        
        while(evaluado.anterior != null){
            recorrido = recorrido+""+evaluado.valor.nombre;

            evaluado = evaluado.anterior;
        }
        return recorrido;
    }
    
    
    
}
