
package f2_proyecto_estructuras;


public class Dijstra {
    private int mCostos[][];
    private int ultimo []; // aca guardamos el ultimo nodo que se visitó antes del destino
    private int D []; // Costo de cada nodo
    private boolean F[]; // vertices visitados
    private int s, n; // s el el id del origen y n el numero de nodos
    
    public Dijstra( int s, Lista_Ad lista){
        n = 6; // •tamaño del grafo 
        this.s = s;
        //mCostos = matriz con todos los pesos
        ultimo = new int[n]; // array del tamaño de la cantidad de nodos
        D = new int[n];
        F = new boolean[n];
    }
    
    public void caminosMinimos(){
        
        for (int i = 0; i <n ; i++){
            F[i]=false; // inicializando todos los nodods como no visitados
            D[i] = mCostos[s][i]; // le colocamos el peso del origen en todos sus posibles destinos
            ultimo[i] = s;
        }
        
        F[s] = true;
        D[s] = 0;
        // pasos para marcar los n - 1 vertices
        for (int i = 0; i < n; i++){
            int v= minimo();
            
            F[v] = true;
            //  actualizando distancias de vertices no marcados
            for (int w = 0 ; w<n ; w++){
                if (!F[v]){
                    if (D[v] + mCostos[v][w] < D[w]){
                        D[w] = D[v] + mCostos[v][w];
                        ultimo[w] = v;
                    }                
                }
            }  
        }
        
        for(int i = 0; i<n; i++){
            System.out.println("Coste minimo a " +i+":"+D[i]);
        }
    }
    
    public int minimo(){
        //int mx = Grafo.inf;
        int v = 1;
        
        for (int j = 0; j<n; j++){
            //if(!F[j] && (D[j])<= mx){
              //  mx = D[j];
              //  v = j;
            //}
        
        }
        return v;
    }
    
}
