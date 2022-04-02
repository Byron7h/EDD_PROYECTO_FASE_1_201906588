// Nos apoyamos en este tutorial https://www.youtube.com/watch?v=_z4xMj6C2yw&list=PLCLpAU8VN0j4RGemFfybZrWoSX57NbEq9&index=49
// ver las 3 clases anteriores y la posterior para entender que está pasando
package f2_proyecto_estructuras;

import java.util.ArrayList;
import java.util.LinkedList;

public class AVL {

    Nodo_AVL raiz;
    //String auxiliar;
    int altura = 0;
    
    // Lista_cola auxiliar para el recorrido en amplitud
    LinkedList<Nodo_AVL> cola = new LinkedList<>();
    
    // Arraylist auxiliar para el metodo sucesor inorden, para la eliminacion de nodos con 2 hijos
    ArrayList<Nodo_AVL> array = new ArrayList<>();
    String grafo = "";
    int contador = 0;
    
    public AVL(){
        this.raiz = null;
    }
    
    /*
    public void altura(int nivel){
        if (nivel > altura){
            altura = nivel;
        }
    }
    */
    
    /*
    public void insertar(int dato){
        if (this.raiz == null){
            Nodo_AVL nuevo = new Nodo_AVL(dato);
            nuevo.altura = 0;
            this.raiz = nuevo;
            
        
        }else{
            insertar(dato, raiz);     
        }       
    }

    */
    
    /*
    public void insertar(int dato, Nodo_AVL padre){
   
        // lado izquierdo, menores
        if (dato<padre.valor){
            if (padre.hijo_izquierda == null){
                Nodo_AVL nuevo = new Nodo_AVL(dato);
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
                Nodo_AVL nuevo = new Nodo_AVL(dato);
                nuevo.padre = padre; 
                nuevo.altura = padre.altura + 1;
                altura(padre.altura +1);
                padre.hijo_derecha = nuevo;
            }else{
                insertar(dato, padre.hijo_derecha);
            }
        }
    }
    
    */
    
    // obtener el factor de equilibrio
    public int obtenerFE(Nodo_AVL nodo){
        if( nodo == null){
            return -1;
        }else{
            return nodo.fe;
        }
    }
    
    public Nodo_AVL Rotacion_Izquierda_Simple(Nodo_AVL nodo){
        Nodo_AVL auxiliar = nodo.hijo_izquierda;
        nodo.hijo_izquierda = auxiliar.hijo_derecha;
        auxiliar.hijo_derecha = nodo;
        // altura
        nodo.fe= Math.max(obtenerFE(nodo.hijo_izquierda), obtenerFE(nodo.hijo_derecha)) +1 ;
        auxiliar.fe = Math.max(obtenerFE(auxiliar.hijo_izquierda), obtenerFE(auxiliar.hijo_derecha)) +1 ;
        return auxiliar;
    }
    
    
    public Nodo_AVL Rotacion_Derecha_Simple(Nodo_AVL nodo){
        Nodo_AVL auxiliar = nodo.hijo_derecha;
        nodo.hijo_derecha = auxiliar.hijo_izquierda;
        auxiliar.hijo_izquierda = nodo;
        // altura
        nodo.fe= Math.max(obtenerFE(nodo.hijo_izquierda), obtenerFE(nodo.hijo_derecha)) +1 ;
        auxiliar.fe = Math.max(obtenerFE(auxiliar.hijo_izquierda), obtenerFE(auxiliar.hijo_derecha)) +1 ;
        return auxiliar;
    }
    
    public Nodo_AVL Rotacion_Izquierda_Doble(Nodo_AVL nodo){
        Nodo_AVL auxiliar;
        nodo.hijo_izquierda = Rotacion_Derecha_Simple(nodo.hijo_izquierda);
        auxiliar = Rotacion_Izquierda_Simple(nodo);
        return auxiliar;
    }
    
    public Nodo_AVL Rotacion_Derecha_Doble(Nodo_AVL nodo){
        Nodo_AVL auxiliar;
        nodo.hijo_derecha = Rotacion_Izquierda_Simple(nodo.hijo_derecha);
        auxiliar = Rotacion_Derecha_Simple(nodo);
        return auxiliar;
    }
    
    
    
    
    public void crear_grafo( Nodo_AVL actual){

        
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
    public Nodo_AVL buscar(Nodo_AVL nodo, int dato){
        
        if(nodo == null){ // no lo encontró
            return null;
        }
        else if(dato == nodo.valor){ // lo encontramos
            return nodo;
        }else if(dato < nodo.valor){
            return buscar(nodo.hijo_izquierda, dato);
        }else{
            return buscar(nodo.hijo_derecha, dato);
        } 
    }

    public Nodo_AVL buscar( int dato){
        return buscar(raiz, dato);
    }
    
    // recorridos
    public void recorrido_Preorden(){
        recorrido_Preorden(raiz);
        System.out.println("");
    }
    
    public void recorrido_Preorden(Nodo_AVL nodo){
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
    
    public void recorrido_Inorden(Nodo_AVL nodo){
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
    
    public void recorrido_Postorden(Nodo_AVL nodo){
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
        
        Nodo_AVL actual = cola.removeLast();
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
    
    public void corregir_alturas(Nodo_AVL nodo){

        if (nodo == null){
            return;
        }
        if (nodo == raiz){
            nodo.altura =0;
            recorrido_Inorden(nodo.hijo_izquierda);
            recorrido_Inorden(nodo.hijo_derecha);
        }else{
            nodo.altura = nodo.padre.altura+1;
            recorrido_Inorden(nodo.hijo_izquierda);
            recorrido_Inorden(nodo.hijo_derecha); 
        }
    }
    
    
    
    // método para eliminar un nodo en un árbol
    public void eliminar(int valor){
        // primero vemos si existe
        Nodo_AVL nodo = buscar(valor);
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
                
                Nodo_AVL hijo = nodo.hijo_izquierda;
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
                Nodo_AVL sucesor = srecorrido_Inorden(nodo.valor);
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
     
    public Nodo_AVL srecorrido_Inorden( int buscado){
        array = new ArrayList<>();
        srecorrido_Inorden(raiz);
        //System.out.println(array);
        for (int i = 0; i<array.size();i++){
            if(buscado ==array.get(i).valor){
                // retornando el sucesor
                return array.get(i+1);
                    //System.out.print("Sucesor inorden de "+array.get(i).valor+" -> "+array.get(i+1).valor);
            }  
        }
        return null;
    }
    
    public void srecorrido_Inorden(Nodo_AVL nodo){
        if (nodo == null){
            return;
        }
        srecorrido_Inorden(nodo.hijo_izquierda);
        array.add(nodo);
        srecorrido_Inorden(nodo.hijo_derecha);
    }
    
    

    
    
    
    
    public Nodo_AVL insertarAVL(Nodo_AVL nuevo, Nodo_AVL sub_arbol){
        Nodo_AVL nuevo_padre = sub_arbol;
        if (nuevo.valor<sub_arbol.valor){
            if(sub_arbol.hijo_izquierda == null){
                sub_arbol.hijo_izquierda = nuevo;
                System.out.println("HIJO Izquierda");
                //System.out.println("entro");
            }else{
                sub_arbol.hijo_izquierda = insertarAVL(nuevo, sub_arbol.hijo_izquierda);
                if ((obtenerFE(sub_arbol.hijo_izquierda) - obtenerFE(sub_arbol.hijo_derecha))==2 ){
                    if(nuevo.valor<sub_arbol.hijo_izquierda.valor){
                        nuevo_padre = Rotacion_Izquierda_Simple(sub_arbol);
                    }else{
                        nuevo_padre = Rotacion_Izquierda_Doble(sub_arbol);
                    }
                }
            }
        }else if (nuevo.valor>sub_arbol.valor){
            System.out.println("estro al 2");
            if(sub_arbol.hijo_derecha == null){
                sub_arbol.hijo_derecha = nuevo; 
                System.out.println("HIJO DEREDGA");
            }else{
                sub_arbol.hijo_derecha  = insertarAVL(nuevo, sub_arbol.hijo_derecha);
                if ((obtenerFE(sub_arbol.hijo_derecha) - obtenerFE(sub_arbol.hijo_izquierda) == 2 )){
                    if(nuevo.valor>sub_arbol.hijo_derecha.valor){
                        nuevo_padre = Rotacion_Derecha_Simple(sub_arbol);
                    }else{
                        nuevo_padre = Rotacion_Derecha_Doble(sub_arbol);
                    }
                }
            }
        }else{ // nodo dublicado
            System.out.println("nodo duplicado");
        }
        // actualizando el fe
        if(sub_arbol.hijo_izquierda == null && sub_arbol.hijo_derecha != null ){
            sub_arbol.fe = sub_arbol.hijo_derecha.fe +1 ;   
        }else if(sub_arbol.hijo_derecha == null && sub_arbol.hijo_izquierda != null){
            sub_arbol.fe = sub_arbol.hijo_izquierda.fe +1 ; 
        }else{
            sub_arbol.fe= Math.max(obtenerFE(sub_arbol.hijo_izquierda),obtenerFE(sub_arbol.hijo_derecha))+1;
        }
        
        return nuevo_padre;
    }
    
    public void insertarAVL(Imagen img){
        Nodo_AVL nuevo = new Nodo_AVL(img); 
        System.out.println("Inserto   ");
        if(raiz == null){
            raiz= nuevo;
        }else{
            raiz = insertarAVL(nuevo, raiz);
        }
        
    }
    
}
