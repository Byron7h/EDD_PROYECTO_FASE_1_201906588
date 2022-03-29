package f2_proyecto_estructuras;

import java.util.ArrayList;
import java.util.LinkedList;

public class ABB {

    Nodo_ABB raiz;
    String auxiliar;
    int altura = 0;
    
    // Lista_cola auxiliar para el recorrido en amplitud
    LinkedList<Nodo_ABB> cola = new LinkedList<>();
    
    // Arraylist auxiliar para el metodo sucesor inorden, para la eliminacion de nodos con 2 hijos
    ArrayList<Nodo_ABB> array = new ArrayList<>();
    String grafo = "";
    int contador = 0;
    
    public ABB(){
        this.raiz = null;
    }
    
    public void altura(int nivel){
        if (nivel > altura){
            altura = nivel;
        }
    }
    

     
    public void insertar(int dato){
        if (this.raiz == null){
            Nodo_ABB nuevo = new Nodo_ABB(dato);
            nuevo.altura = 0;
            this.raiz = nuevo;
            
        
        }else{
            insertar(dato, raiz);     
        }       
    }


    public void insertar(int dato, Nodo_ABB padre){
   
        // lado izquierdo, menores
        if (dato<padre.valor){
            if (padre.hijo_izquierda == null){
                Nodo_ABB nuevo = new Nodo_ABB(dato);
                nuevo.padre = padre; 
                nuevo.altura = padre.altura +1;
                altura(padre.altura +1);
                padre.hijo_izquierda = nuevo;
                
            }else{
                insertar(dato, padre.hijo_izquierda);             
            }
        }
        
        // lado derecho, mayores o iguales
        else {
            if (padre.hijo_derecha == null){
                Nodo_ABB nuevo = new Nodo_ABB(dato);
                nuevo.padre = padre; 
                nuevo.altura = padre.altura + 1;
                altura(padre.altura +1);
                padre.hijo_derecha = nuevo;
            }else{
                insertar(dato, padre.hijo_derecha);
            }
        }
    }
    
    public void crear_grafo( Nodo_ABB actual){

        
        if (actual.hijo_derecha != null){ 
            //creamos el nodo derecha enlazamos e implementamos recursividada
            grafo +=  "     "+ actual.hijo_derecha.hashCode()+"[label=\""+actual.hijo_derecha.valor+" D"+"\"];\n";
            grafo +=  "     "+ actual.hashCode()+ "->"+ actual.hijo_derecha.hashCode()+";\n";
            crear_grafo(actual.hijo_derecha);
        }
        if (actual.hijo_izquierda != null){ 
            grafo +=  "     "+ actual.hijo_izquierda.hashCode()+"[label=\""+actual.hijo_izquierda.valor+" I"+"\"];\n";
            grafo +=  "     "+ actual.hashCode()+ "->"+ actual.hijo_izquierda.hashCode()+";\n";
            crear_grafo(actual.hijo_izquierda);
        } 
        
        if(actual.hijo_derecha != null &&actual.hijo_izquierda != null){
            
        grafo +=  "     {rank=same; "+actual.hijo_izquierda.hashCode()+"; "+actual.hijo_derecha.hashCode()+";}\n";
        grafo += "     {edge[style=invis];\n" +
                 "     "+actual.hijo_izquierda.hashCode()+" ->"+actual.hijo_derecha.hashCode()+";\n" +
                 "     } ";
        }

    }
    
    public void imprimir(){
        
        // encabezado del grafo
        String aux = "digraph finite_state_machine {\n" +
"	fontname=\"Helvetica,Arial,sans-serif\"\n" +
"	node [fontname=\"Helvetica,Arial,sans-serif\"]\n" +
"	node [shape = circle];\n";
        aux +=  "     "+ raiz.hashCode()+"[label=\""+raiz.valor+"\"];\n";
        
        // contenido y final del grafo
        grafo += "}";
        
        aux = aux + grafo;
        System.out.println(aux);
        
        // volviendo al estado original
        grafo = "";
    }
  
    
    // modificamos el método buscar para que nos devuelva el nodo, si lo encuentra, o null si no
    public Nodo_ABB buscar(Nodo_ABB nodo, int dato){
        
        if(nodo == null){ // no lo encontró
            return null;
        }
        
        if(dato == nodo.valor){ // lo encontramos
            return nodo;
        }else if(dato < nodo.valor){
            return buscar(nodo.hijo_izquierda, dato);
        }else{
            return buscar(nodo.hijo_derecha, dato);
        }
        
    }

    public Nodo_ABB buscar( int dato){
        return buscar(raiz, dato);
    }
    
    // recorridos
    
    public void recorrido_Preorden(){
        recorrido_Preorden(raiz);
        System.out.println("");
    }
    
    public void recorrido_Preorden(Nodo_ABB nodo){
        if (nodo == null){
            return;
        }
        System.out.print(nodo.valor+" ");
        recorrido_Preorden(nodo.hijo_izquierda);
        recorrido_Preorden(nodo.hijo_derecha);

    }
    
    
    public void recorrido_Inorden(){
        
        recorrido_Inorden(raiz);
        System.out.println("");
    }
    
    public void recorrido_Inorden(Nodo_ABB nodo){
        if (nodo == null){
            return;
        }
        recorrido_Inorden(nodo.hijo_izquierda);
        System.out.print(nodo.valor+" ");
        recorrido_Inorden(nodo.hijo_derecha);

    }
    
    
    
    public void recorrido_Postorden(){
        recorrido_Postorden(raiz);
        System.out.println("");
        
    }
    
    public void recorrido_Postorden(Nodo_ABB nodo){
        if (nodo == null){
            return;
        }     
        recorrido_Postorden(nodo.hijo_izquierda);
        recorrido_Postorden(nodo.hijo_derecha);
        System.out.print(nodo.valor+" ");
    }
    
    
    /*
    public void recorrido_Amplitud(){ 
        System.out.println("");
        System.out.print(raiz.valor+" ");
        for(int i=1; i<altura+1; i++){ // vamos a ir recorriendo por niveles
            recorrido_Amplitud(raiz, i);
        }

    }
    
    public void recorrido_Amplitud(Nodo_ABB nodo, int nivel){
        //System.out.println("entro");
        if(nodo == null){
            return;
        }
        int h = nodo.altura;
        if (h == nivel){
            System.out.print(nodo.valor+" ");
        }else if(h<nivel){
            recorrido_Amplitud(nodo.hijo_izquierda, nivel);
            recorrido_Amplitud(nodo.hijo_derecha, nivel);
        } 
    }
    
    */
    
    public void recorrido_Amplitud(){
        cola.addFirst(raiz);
        recorrido_Amplitud_2();
    
    }
    
    public void recorrido_Amplitud_2(){
        if (cola.isEmpty()){
            return;
        } 
        
        Nodo_ABB actual = cola.removeLast();
        //se muestra
        
        System.out.print(actual.valor+" ");
        
        // si tiene hijos los agragamos a la cola
        if (actual.hijo_izquierda != null){
            cola.addFirst(actual.hijo_izquierda);    
        }
        if (actual.hijo_derecha != null){
            cola.addFirst(actual.hijo_derecha);
        }
        recorrido_Amplitud_2();
    }
    
    
    // método para eliminar un nodo en un árbol
    public void eliminar(int valor){
        // primero vemos si existe
        Nodo_ABB nodo = buscar(valor);
        if ( nodo != null){
        
        // procedemos según la cantidad de hijos que tenga
        
        //  • ningun hijo, solo eliminamos
            if(nodo.hijo_derecha == null && nodo.hijo_izquierda == null){
                
                if(nodo == raiz){
                    raiz = null;
                }else{     
                    // el nodo es el de la izquierda o el de la derecha del padre? 
                    if(nodo.valor< nodo.padre.valor){ // es el hijo de la izquierda
                    
                        nodo.padre.hijo_izquierda = null;
                
                    }else{// es el hijo de la derecha
                        nodo.padre.hijo_derecha = null;
                    }  
                }
            }
            
        //  • un hijo, se elimina el nodo y se sustituye por su hijo, acá nos faltó la validación de si se queire eliminar la raiz por este camino   
            // solo tiene hijo a la derecha
            else if(nodo.hijo_derecha != null && nodo.hijo_izquierda == null){
                
                //Nodo_ABB hijo = nodo.hijo_derecha;
                
                if(nodo.valor< nodo.padre.valor){ // es el hijo de la izquierda 
                    
                    // acomodando apuntadores
                    
                    nodo.padre.hijo_izquierda = nodo.hijo_derecha;
                    nodo.hijo_derecha.padre = nodo.padre;
                    
                }else{// es el hijo de la derecha
                    
                    nodo.padre.hijo_derecha= nodo.hijo_derecha;
                    nodo.hijo_derecha.padre = nodo.padre;
                } 
                
                
                
            
            // solo tiene hijo a la izquierda
            }else if(nodo.hijo_derecha == null && nodo.hijo_izquierda != null){
                
                Nodo_ABB hijo = nodo.hijo_izquierda;
                if(nodo.valor< nodo.padre.valor){ // es el hijo de la izquierda 
                    
                    // acomodando apuntadores
                    nodo.padre.hijo_izquierda = nodo.hijo_izquierda;
                    nodo.hijo_izquierda.padre = nodo.padre;
                    
                }else{// es el hijo de la derecha
                    
                    nodo.padre.hijo_derecha= nodo.hijo_izquierda;
                    nodo.hijo_izquierda.padre = nodo.padre;
                } 
                
            //  • dos hijos, encontramos el nodo, y lo sustituimos por su sucesor inornden           
            }else{
                
                // encontrando sucesor inorden
                Nodo_ABB sucesor = srecorrido_Inorden(nodo.valor);
                if (sucesor != null){
                    
                    // eliminar el sucesor del árbol
                    eliminar(sucesor.valor);
                    
                    //sustituyendo el nodo a eliminar por el sucesor, esto si no es la raiz
                    if (nodo.padre != null){
                        if(nodo.valor< nodo.padre.valor){ // es el hijo de la izquierda 
                            // acomodando apuntadores
                            nodo.padre.hijo_izquierda = sucesor;
                            sucesor.padre = nodo.padre;
                    
                        }else{// es el hijo de la derecha
                            nodo.padre.hijo_derecha= sucesor;
                            sucesor.padre = nodo.padre;
                        }
                    }
                    
                    if(nodo == raiz){ // incluimos validaciones por si se elimina la raiz
                        raiz = sucesor;
                    }               
                    sucesor.hijo_derecha = nodo.hijo_derecha;
                    nodo.hijo_derecha.padre = sucesor;
                    sucesor.hijo_izquierda = nodo.hijo_izquierda;
                    nodo.hijo_izquierda.padre = sucesor;
                } 
            }
        }
    }
    
    
    public Nodo_ABB srecorrido_Inorden( int buscado){
        array = new ArrayList<>();
        srecorrido_Inorden(raiz);
        //System.out.println(array);
        for (int i = 0; i<array.size();i++){
            if(buscado ==array.get(i).valor){
                // retornando el sucesor
                return array.get(i-1);
                    //System.out.print("Sucesor inorden de "+array.get(i).valor+" -> "+array.get(i+1).valor);
            }  
        }
        return null;
    }
    
    public void srecorrido_Inorden(Nodo_ABB nodo){
        if (nodo == null){
            return;
        }

        
        srecorrido_Inorden(nodo.hijo_izquierda);
        array.add(nodo);
        srecorrido_Inorden(nodo.hijo_derecha);

    }
    
    
    
    
}
