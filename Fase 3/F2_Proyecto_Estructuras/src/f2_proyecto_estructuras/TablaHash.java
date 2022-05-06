package f2_proyecto_estructuras;

public class TablaHash {

    

    
    Nodo_hash tablita[]; // vector de nodos hash
    int contador;

    
    public TablaHash(){
        
        // aca le colocamos el tamaño del vector
        tablita = new Nodo_hash[37];
        contador = 0; 
    }
    
    // recibiendo el dato, desde acá vamos a cerar el objeto
    public void insertar(Mensajero m){
        contador++;
        Nodo_hash nuevo = new Nodo_hash(m);
        
        // paso 1. encontrar el hash, nuestra llave
        int indice = Obtener_llave(m.DPI);
        System.out.println(m.DPI+ " == " + indice);
        
        // paso 2. insertarlo en la tabla hash
            // verificar si ya existe la llave, si sí, nos vamos a colisión
        
        if(existe_llave(indice)){
           // si ya está ocupada esa posición debemos reasignarlo, resolver colisión
           indice = colision(m); 
        }
        
        // se inserta
        tablita[indice] = nuevo;
        
        
        // desvordamiento --> solo se va a ejecutar la primera vez que ejecutemos un valor 
   
        System.out.println((contador));
        System.out.println((tablita.length));
        System.out.println((float)contador/(float)tablita.length);
        
        if (((float)contador/(float)tablita.length)>0.75){
            // reestructuración de la tabla

            
            
            System.out.println("entro al rehash");
            
            rehash();
            
        
        }
    
    
    }
    
    public void insertar_2(Mensajero m){

        Nodo_hash nuevo = new Nodo_hash(m);
        
        // paso 1. encontrar el hash, nuestra llave
        int indice = Obtener_llave(m.DPI);
        System.out.println(m.DPI + " == " + indice);
        
        // paso 2. insertarlo en la tabla hash
            // verificar si ya existe la llave, si sí, nos vamos a colisión
        
        if(existe_llave(indice)){
           // si ya está ocupada esa posición debemos reasignarlo, resolver colisión
           indice = colision(m); 
        }
        
        // se inserta
        tablita[indice] = nuevo;
        
        
        // desvordamiento --> solo se va a ejecutar la primera vez que ejecutemos un valor 
   
        System.out.println((contador));
        System.out.println((tablita.length));
        System.out.println((float)contador/(float)tablita.length);
    
    } 
    
    public int Obtener_llave(long cliente){
        
        // h(llv) = llv % M
        long llave = cliente % tablita.length; //usamos el modulo para evitar que sea mayor al num de nodos       
        return (int)llave; 
    }

    public boolean existe_llave(int llave){
        
        // si la tablita es null en la posición de la llave
        if( tablita[llave] == null){
            return false;
        
        }else{
            return true;
        }
    }
    

    public int colision(Mensajero cliente){
       
        int i = 0;
        int llave = -1;
        while(true){
            i++;
            int llv = (int)((((cliente.DPI % 7) + 1) * i)%tablita.length);
            System.out.println("intento " + i);
            
            if (!existe_llave(llv)){
                System.out.println("Nueva llave por colision: " + llv);
                llave = llv;
                break;
            }
        }   
        return llave;
    }

    
    
    public void rehash(){
        
        // generar la nueva tabla con tamaño del siguiente elemento
        Nodo_hash aux [] = tablita.clone();
        tablita = new Nodo_hash[Tamano_sig(tablita.length)];
        
        // copiamos los valores existentes
        
        for (int i = 0; i<aux.length; i++){
            if(aux[i] != null){
                insertar_2(aux[i].valor);
            }
        }
    } 
    

    public int Tamano_sig(int actual){
        
        //valor primo es un numero que solo es divisible entre 1 y si mismo
        int sig = actual;
        int cont = 2;
        boolean primo = false;
        
        // buscamos valor primo
        while( primo!= true){
            sig ++;          
            // si es primo se sale del ciclo
            while(sig > cont){
                primo = true;
                if (sig % cont == 0){
                    // no es primo
                    primo = false;
                    break;
                }
            cont++;
            }
        cont = 2;
        }
        System.out.println("nuevo tamaño "+sig);
        return sig;
    }  
    
    public void imprimir(){
        System.out.println("IMPRESION");
        for ( int i = 0; i<tablita.length; i++){
            if(tablita[i]!=null){
                System.out.println("    "+i+" "+tablita[i].valor.DPI);             
            }
            else{
                System.out.println("null");
            }
        }
    
    }
    public String grafo(){
        
        String grafo = "digraph G {\n" +
        "node [shape=plaintext];\n" +
        "some_node [\n" +
        "label=<\n" +
        "<table border=\"0\" cellborder=\"1\" cellspacing=\"0\">\n";
        for ( int i = 0; i<tablita.length; i++){
            if(tablita[i]!=null){
                System.out.println("    "+i+" "+tablita[i].valor.DPI); 
                
                grafo += "<tr>\n" +
                "   <td bgcolor=\"white\">"+i+"</td>\n" +
                "   <td bgcolor=\"white\">"+tablita[i].valor.DPI+"</td>\n" +
                "</tr>\n";
                
            }
            else{
                System.out.println("null");
                
                grafo += "<tr>\n" +
                "   <td bgcolor=\"white\">"+i+"</td>\n" +
                "   <td bgcolor=\"white\">null</td>\n" +
                "</tr>\n";
                
            }
        }
        grafo += "</table>>\n" +
"];\n" +
"}";
        return grafo;
    }
    
    
    
}

    
    
    
    

    
