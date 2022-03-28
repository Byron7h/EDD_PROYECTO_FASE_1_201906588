package f2_proyecto_estructuras;

import java.util.LinkedList;

public class ABB {

    Nodo_ABB raiz;
    String auxiliar;
    int altura = 0;
    LinkedList<Nodo_ABB> cola = new LinkedList<>();
    String grafo = "digraph finite_state_machine {\n" +
"	fontname=\"Helvetica,Arial,sans-serif\"\n" +
"	node [fontname=\"Helvetica,Arial,sans-serif\"]\n" +
"	node [shape = circle];\n";
    
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
            grafo +=  "     "+ raiz.hashCode()+"[label=\""+raiz.valor+"\"];\n";
        
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
            grafo +=  "     "+ actual.hijo_derecha.hashCode()+"[label=\""+actual.hijo_derecha.valor+" h"+actual.hijo_derecha.altura+"\"];\n";
            grafo +=  "     "+ actual.hashCode()+ "->"+ actual.hijo_derecha.hashCode()+";\n";
            crear_grafo(actual.hijo_derecha);
        }
        if (actual.hijo_izquierda != null){ 
            grafo +=  "     "+ actual.hijo_izquierda.hashCode()+"[label=\""+actual.hijo_izquierda.valor+"h "+actual.hijo_izquierda.altura+"\"];\n";
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
        grafo += "}";
        System.out.println(grafo);
    }
  
    
    public boolean buscar(Nodo_ABB nodo, int dato){
        
        if(nodo == null){ // no lo encontró
            return false;
        }
        
        if(dato == nodo.valor){ // lo encontramos
            return true;
        }else if(dato < nodo.valor){
            return buscar(nodo.hijo_izquierda, dato);
        }else{
            return buscar(nodo.hijo_derecha, dato);
        }
        
    }

    public boolean buscar( int dato){
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
    
    
    
}
