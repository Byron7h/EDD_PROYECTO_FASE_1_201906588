
package f2_proyecto_estructuras;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;


public class Busca_caminos {
    Busca_caminos graph ;
    

    // Aquí está el número de punto fijo n, el conjunto de vértices Vertax, el conjunto de aristas, si ha sido visitado es el marcador visitado
    private int n;
    private int numberOfEdges;
    private double[] distance;
    private String[] path;
    private ArrayList<String> Vertax;
    private static int[][] edges;
    private boolean[] isVisited;
    private Lista_Ad lista;
    private String contenido = "";
    private int fin;
    Calendar reloj = Calendar.getInstance();
    
    
    
    // recibimos el id del municipio que buscamos
    public  Busca_caminos(int f, Lista_Ad lista, int fin){
        this.fin = fin;
        this.lista = lista;
        this.n = Tamano();
        numberOfEdges=0;
        Vertax = new ArrayList<>(n);
        edges  = new int[n][n];
        isVisited = new boolean[n+1];
        distance = new double[n];
        for (int i = 0; i <n ; i++) {
            distance[i] = Double.POSITIVE_INFINITY;
        }

        path = new String[n];
        for (int i = 0; i <n ; i++) {
            path[i] = "";
        }
        llenar_matriz();
        showEdges();
        dijkStra(f);
    }

    // Imprimir lista de adyacencia
    public static void showEdges(){
        for (int[] edse: edges
        ) {
            System.out.println(Arrays.toString(edse));
        }

    }
    // Obtener el número de vértices
    public  int GetSizeOfGraph(ArrayList<String> Vertax){
        return Vertax.size();
    }
    // Agregar vértice
    public  void addVertax(String s){
        Vertax.add(s);
    }
    // Obtiene el primer vértice adyacente del vértice especificado
    public int getFirstCO(int index){
        for (int i = 0; i <Vertax.size() ; i++) {
            if (edges[index][i]>0) return i;
        }
        return n;
    }
    // Obtiene los vértices adyacentes secuenciales del vértice especificado
    public int getNextCO(int index,int firstCO){
        for (int i =firstCO+1 ; i <Vertax.size() ; i++) {
            if (edges[index][i]>0) return i;
        }
        return n;
    }
    // Agregar borde
    public  void addEdges(int e1,int e2 , int weight){
        edges[e1][e2] = weight;
        //edges[e2][e1] = weight;
        numberOfEdges++;
    }
    // Obtener el número de aristas
    public int getNumberOfEdges(){
        return numberOfEdges;
    }

    public void dijkStra(int index ){

        // CO son las coordenadas necesarias para la iteración, headIndex es el vértice inicial de cada DIJKSTRA


        int CO;
        int headIndex = index;
        //
        // Establece la distancia desde el punto inicial al punto inicial, naturalmente 0
        distance[index]=0;


        // Luego haz lo siguiente para cada vértice
        // 1. Establece este vértice en conocido, no te preocupes por la distancia y la ruta de este punto, porque ha sido diseñado antes
        // 2. Encuentra cada vértice adyacente de este vértice. Para un vértice desconocido, compare la distancia alcanzada a lo largo de este vértice con su distancia original, si es menor que la distancia original, actualice la distancia y actualice la ruta
        // 3. Después de establecer este vértice, use la función indexGet para encontrar el vértice con la distancia más pequeña entre los vértices desconocidos actuales, y utilícelo como el siguiente vértice para realizar el paso 2

        while (!isVisited[headIndex]){

            // CO es la primera CO que no ha sido visitada
            CO = getFirstCO(headIndex);
            while(isVisited[CO]){
                CO = getNextCO(headIndex,CO);
            }

            // Si el vértice headIndex no tiene vértices adyacentes que no hayan sido visitados, la coordenada del vértice se obtiene como n, lo que indica que es el último nodo desconocido, y solo necesita establecerse como conocido
            if (CO==n) {
                isVisited[headIndex]=true;
                //System.out.println("Coordinate not found ");
            }
            // Ejecuta el paso 2 para todos los vértices adyacentes a través de un bucle
            else {
                while (!isVisited[CO]&&CO<n) {
                    isVisited[headIndex]=true;
                    double currentDis = distance[headIndex]+edges[headIndex][CO];
                    if (currentDis<distance[CO]) {
                        distance[CO] = currentDis;

                        path[CO] = path[headIndex]+" "+Vertax.get(headIndex);
                    }

                    CO = getNextCO(headIndex, CO);

                }
            }

            headIndex = indexGet(distance,isVisited);


        }
        
       String list = "";
       String retorno = "\n Escalas       Hora de llegada       Ubicación \n";
  

        for (int i = 0; i <n ; i++) {
            path[i] = path[i]+" "+Vertax.get(i);   
            if( Integer. parseInt(Vertax.get(i))  == fin){             
                list = path[i];
            } 
        }
        
        
        int hora = reloj.get(Calendar.HOUR_OF_DAY);
        int minutos = reloj.get(Calendar.MINUTE);
        String[] r = list.split(" ", 0);      
        int contado = -1;
        
        for(String h :r){  
            contado++;
            if(!"".equals(h) && !" ".equals(h)){
                Nodo_lugar nodo = lista.buscar_lugar(Integer.parseInt(h));
                String nombre = nodo.valor.nombre;
                
                // encontramos la posicion en los arreglos de distancia
                int a = 0;
                for (int i = 0; i <n ; i++) { 
                    if( Vertax.get(i).equals(h)){   
                        a = (int)distance[i];
                        break;
                    } 
                }
                
                int distancia = a+minutos;
                
                retorno += "      " +contado + "             " +hora+":"+distancia+ "                         "+nombre+"\n" ;                
            }
        }
        
        
        System.out.println("Iniciar nodo:"+Vertax.get(index));
        for (int i = 0; i <n ; i++) {
            if( Integer.parseInt(Vertax.get(i))  == fin){
                
                String au = "Ruta mas eficiente: " + path[i]+"     Tiempo estimado: "+distance[i] +" minutos";
                contenido = au +"\n"+ retorno;
            }
            System.out.println(Vertax.get(i)+"   "+distance[i]+"   "+path[i]);
        }
    }
    // Devuelve el siguiente vértice requerido a través de la matriz de distancia y la matriz de acceso dadas
    public int indexGet(double[] distance, boolean[] isVisited){
        int j=0;
        double mindis=Double.POSITIVE_INFINITY;
        for (int i = 0; i < distance.length; i++) {
            if (!isVisited[i]){
                if(distance[i]<mindis){
                    mindis=distance[i];
                    j=i;
                }
            }
        }
        return j;
    }
    
    public int Tamano(){
        
        int contador = 0;
        Nodo_lugar actual = lista.cabecera;
        
        while(actual != null){
            contador++;
            actual = actual.siguiente;
        }
        
        return contador;
    }
    
    
    public void llenar_matriz(){
        
        
        Nodo_lugar actual = lista.cabecera;
        while(actual != null){
            addVertax(""+actual.id);
            Nodo_ruta aux = actual.cabecera;
            while(aux!= null){
                Ruta r = aux.ruta;
                addEdges(r.inicio,r.fin,r.peso);  
                aux = aux.siguiente;
            }
           actual = actual.siguiente;
        }

    }
    
    public String get_contenido(){
        String aux = contenido;
        contenido ="";
        return aux;
        
    }
    
}

