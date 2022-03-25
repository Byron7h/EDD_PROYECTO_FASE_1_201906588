package f2_proyecto_estructuras;

public class ABB {

    Nodo_ABB raiz;
    String grafo = "digraph finite_state_machine {\n" +
"	fontname=\"Helvetica,Arial,sans-serif\"\n" +
"	node [fontname=\"Helvetica,Arial,sans-serif\"]\n" +
"	node [shape = circle];\n";
    
    public ABB(){
        this.raiz = null;
    }
    
    
    public void insertar(int dato){
        if (this.raiz == null){
            Nodo_ABB nuevo = new Nodo_ABB(dato);
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
                padre.hijo_izquierda = nuevo;
                
            }else{
                insertar(dato, padre.hijo_izquierda);
            }
        }
        
        // lado derecho, mayores o iguales
        else {
            if (padre.hijo_derecha == null){
                Nodo_ABB nuevo = new Nodo_ABB(dato);
                padre.hijo_derecha = nuevo;
            }else{
                insertar(dato, padre.hijo_derecha);
            }
        }
    }
    
    public void crear_grafo( Nodo_ABB actual){
        if (actual.hijo_derecha != null){ 
            //creamos el nodo derecha enlazamos e implementamos recursividada
            grafo +=  "     "+ actual.hijo_derecha.hashCode()+"[label=\""+actual.hijo_derecha.valor+"\"];\n";
            grafo +=  "     "+ actual.hashCode()+ "->"+ actual.hijo_derecha.hashCode()+";\n";
            crear_grafo(actual.hijo_derecha);
        }
        if (actual.hijo_izquierda != null){ 
            grafo +=  "     "+ actual.hijo_izquierda.hashCode()+"[label=\""+actual.hijo_izquierda.valor+"\"];\n";
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
  
}
