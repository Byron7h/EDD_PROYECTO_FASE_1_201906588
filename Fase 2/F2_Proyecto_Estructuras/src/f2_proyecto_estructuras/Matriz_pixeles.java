/*
    Este archivo lo copiamos de uno que desarrollamos en la carpeta lab -> ejemplos aux -> clase 5 -> matriz_en_java
    Es de la versión en java de un ejemplo que nos dió el aux de ua matriz en Python
 */
package f2_proyecto_estructuras;

/**
 *
 * @author usuario
 */
public class Matriz_pixeles {
    
    
    
    /*
    class Matriz():
    def __init__(self):
        self.root=NodoMatriz(-1,-1,"Root")


##Buscar columna
    def buscar_columna(self,x):
        aux=self.root
        while aux is not None:
            if(aux.x==x):
                return aux
            aux=aux.siguiente
        return None
##Buscar la fila
    def buscar_fila(self,y):
        aux=self.root
        while aux is not None:
            if(aux.y==y):
                return aux
            aux=aux.abajo
        return None
    */
    
    
    
    
    Nodo_matriz cabecera;
    int alto = 0;
    int ancho = 0;
    public Matriz_pixeles(){
        this.cabecera = new Nodo_matriz(-1,-1,"Raiz");
    }
    
    //buscar columna
    public Nodo_matriz buscar_columna(int x){
        Nodo_matriz aux = cabecera;
        while (aux!= null){
            if (aux.x == x){
                return aux;
            }
            aux = aux.siguiente;  
        }
        return null;   
    }
    
    //buscar fila
    public Nodo_matriz buscar_fila(int y){
        Nodo_matriz aux = cabecera;
        while (aux!= null){
            if (aux.y == y){
                return aux;
            }
            aux = aux.abajo;  
        }
        return null;   
    }
    
        /*
    ##Insertar Cabecera Columna
    def crear_columna(self,x):
        nodo_col=self.root
        nuevo=NodoMatriz(x,-1,"COL")
        columna=self.insertar_orden_col(nuevo,nodo_col)
        return columna
    */
    
    // insertar cabecera columna
    public Nodo_matriz crear_columna(int x){
        Nodo_matriz nodo_col = cabecera;
        Nodo_matriz nuevo = new Nodo_matriz(x, -1,"COL");
        Nodo_matriz columna = insertar_orden_col(nuevo, nodo_col);
        return columna;   
    }
    
    /*
    ##Insertar en orden columnas
    def insertar_orden_col(self,nuevo,cabeza_col):
        aux = cabeza_col
        insertado=False
        while True:
            if(nuevo.x==aux.x):
                # si la posicion ya existe sobre escribimos
                aux.y=nuevo.y
                aux.dato=nuevo.dato
                return aux
            elif(aux.x>nuevo.x):
                #insertar en medio, antes del aux
                insertado=True
                break
            if aux.siguiente is not None:
                aux=aux.siguiente
            else:
                #insertar despues del auxiliar
                insertado=False
                break
        if insertado:
            nuevo.siguiente=aux
            aux.anterior.siguiente=nuevo
            nuevo.anterior=aux.anterior
            aux.anterior=nuevo
        else:
            aux.siguiente=nuevo
            nuevo.anterior=aux
        return nuevo
    */
    
    //insertar en orden columnas
    
    public Nodo_matriz insertar_orden_col(Nodo_matriz nuevo, Nodo_matriz cabeza_col){
        Nodo_matriz aux = cabeza_col;
        boolean insertado = false;
        while(true){
            if(nuevo.x == aux.x){
                //si la posición existe, sobre escribimos
                aux.y = nuevo.y;
                aux.dato = nuevo.dato;
                return aux;
            }
            else if(aux.x>nuevo.x){
                //intertar en medio
                insertado = true;
                break; 
            }
            if(aux.siguiente != null){
                aux = aux.siguiente;
            }
            else{
                //insertando después de aux
                insertado = false;
                break;
            }
        }
        if (insertado){
            nuevo.siguiente = aux;
            aux.anterior.siguiente = nuevo;
            nuevo.anterior = aux.anterior;
            aux.anterior = nuevo;
        
        }else{
            aux.siguiente = nuevo;
            nuevo.anterior = aux;
        }
        return nuevo;
    }
    
    /*
    ##Insertar Cabecera Fila
    def crear_fila(self,y):
        nodo_fila=self.root
        nuevo=NodoMatriz(-1,y,"Fila")
        columna=self.insertar_orden_fil(nuevo,nodo_fila)
        return columna 
    */
    
    // insertar Cabecera fila
    public Nodo_matriz crear_fila(int y){
        Nodo_matriz nodo_fila = cabecera;
        Nodo_matriz nuevo = new Nodo_matriz(-1, y, "fila"); 
        Nodo_matriz columna = insertar_orden_fil(nuevo, nodo_fila);
        return columna;
        
    }
    
    /*
##Insertar en orden Filas
    def insertar_orden_fil(self,nuevo,cabeza_fila):
        aux = cabeza_fila
        insertado=False
        while True:
            if(nuevo.y==aux.y):
                # si la posicion ya existe sobre escribimos
                aux.x=nuevo.x
                aux.dato=nuevo.dato
                return aux
            elif(aux.y>nuevo.y):
                #insertar en medio, antes del aux
                insertado=True
                break
            if aux.abajo is not None:
                aux=aux.abajo
            else:
                #insertar despues del auxiliar
                insertado=False
                break
        if insertado:
            nuevo.abajo=aux
            aux.arriba.abajo=nuevo
            nuevo.arriba=aux.arriba
            aux.arriba=nuevo
        else:
            aux.abajo=nuevo
            nuevo.arriba=aux
        return nuevo
    */
    
    //Insertar en orden Filas
    public Nodo_matriz insertar_orden_fil(Nodo_matriz nuevo, Nodo_matriz cabeza_fila){
        Nodo_matriz aux = cabeza_fila;
        boolean insertado = false;
        while(true){
            if(nuevo.y == aux.y){
                //si la posición existe, sobre escribimos
                aux.x = nuevo.x;
                aux.dato = nuevo.dato;
                return aux;
            }
            else if(aux.y>nuevo.y){
                //intertar en medio, antes del aux
                insertado = true;
                break; 
            }
            if(aux.abajo != null){
                aux = aux.abajo;
            }
            else{
                //insertando después de aux
                insertado = false;
                break;
            }
        }
        if (insertado){
            nuevo.abajo = aux;
            aux.arriba.abajo = nuevo;
            nuevo.arriba = aux.arriba;
            aux.arriba= nuevo;
        
        }else{
            aux.abajo = nuevo;
            nuevo.arriba = aux;
        }
        return nuevo;
    }
    
    
    
    /*
    ##Metodo para insertar   
    def insertarNodo(self,x,y,dato):
        nuevo=NodoMatriz(x,y,dato)
        NodoColumna = self.buscar_columna(x)
        NodoFila =self.buscar_fila(y)
        ##Caso 1---No existe fila ni columna
        if NodoFila is None and NodoColumna is None:
            print("Caso1, ---No existe fila ni columna")
            ##crear las cabeceras
            NodoColumna=self.crear_columna(x)
            NodoFila=self.crear_fila(y)
            #insertamos contenido
            nuevo=self.insertar_orden_col(nuevo,NodoFila)
            nuevo=self.insertar_orden_fil(nuevo,NodoColumna)
            return
        ##Caso 2---No existe Fila, pero si columna
        elif NodoFila is None and NodoColumna is not None:
            print("Caso2")
            ##crear las cabeceras
            ##NodoColumna=self.crear_columna(x)
            NodoFila=self.crear_fila(y)
            #insertamos contenido
            nuevo=self.insertar_orden_col(nuevo,NodoFila)
            nuevo=self.insertar_orden_fil(nuevo,NodoColumna)
            return
    */
    
    
    public void insertarNodo (int x, int y, String dato){
        Nodo_matriz nuevo = new Nodo_matriz(x, y, dato);
        Nodo_matriz NodoColumna = buscar_columna(x);
        Nodo_matriz NodoFila = buscar_fila(y);
        
        // dimesiones de la matriz
        if (ancho<y){
            ancho = y;
        }
        if(alto<x){
            alto = x;
        }
        
        
        
        // caso 1 -> no existe fila ni columna
        if (NodoFila == null && NodoColumna == null){
            System.out.println("caso 1 -> no existe fila ni columna");
            //creando cabeceras
            NodoColumna = crear_columna(x);
            NodoFila = crear_fila(y);
            
            //insertamos el contenido
            nuevo = insertar_orden_col(nuevo, NodoFila);
            nuevo = insertar_orden_fil(nuevo, NodoColumna);  
        }
        
        //caso 2 -> no existe fila, pero si columna
        else if(NodoFila == null && NodoColumna != null){
            System.out.println("caso 2 -> no existe fila, pero si columna");
            //creando cabeceras
            //NodoColumna = crear_columna(x);
            NodoFila = crear_fila(y);
            
            //insertamos el contenido
            nuevo = insertar_orden_col(nuevo, NodoFila);
            nuevo = insertar_orden_fil(nuevo, NodoColumna); 
        }
        
        //caso 3 -> no existe columna, pero si fila
        else if(NodoFila != null && NodoColumna == null){
            System.out.println("caso 3 -> no existe columna, pero si fila");
            //creando cabeceras
            NodoColumna = crear_columna(x);
            //NodoFila = crear_fila(y);
            
            //insertamos el contenido
            nuevo = insertar_orden_col(nuevo, NodoFila);
            nuevo = insertar_orden_fil(nuevo, NodoColumna); 
        }
        
        //caso 4 -> existe columna y fila
        else if(NodoFila != null && NodoColumna != null){
            System.out.println("caso 4 -> existe columna y fila");
            //creando cabeceras
            //NodoColumna = crear_columna(x);
            //NodoFila = crear_fila(y);
            
            //insertamos el contenido
            nuevo = insertar_orden_col(nuevo, NodoFila);
            nuevo = insertar_orden_fil(nuevo, NodoColumna); 
        }
    
    }
    
    
    
    
    /*
            ##Caso 3---No existe columna, pero si fila
        elif NodoFila is not None and NodoColumna is None:
            print("Caso3")
            ##crear las cabeceras
            NodoColumna=self.crear_columna(x)
            ##NodoFila=self.crear_fila(y)
            #insertamos contenido
            nuevo=self.insertar_orden_col(nuevo,NodoFila)
            nuevo=self.insertar_orden_fil(nuevo,NodoColumna)
            return
        ##caso en el que si existe fila y columna
        elif NodoFila is not None and NodoColumna is not None:
            print("Caso4")
            ##crear las cabeceras
            ##NodoColumna=self.crear_columna(x)
            ##NodoFila=self.crear_fila(y)
            #insertamos contenido
            nuevo=self.insertar_orden_col(nuevo,NodoFila)
            nuevo=self.insertar_orden_fil(nuevo,NodoColumna)
            return
    */
    
    
    //NOS FALTA EL M´PETODO DE IMPRIMIR
}
