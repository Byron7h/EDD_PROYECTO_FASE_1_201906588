/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_1_estructuras;
import java.util.Scanner; 











public class Menu {
    
    
    //  ESTRUCTURAS
    
    public static Cola Cola_recepcion = new Cola();
    public static Lista_Ventanillas Lista_ventanillas  = new Lista_Ventanillas();
    public static Impresora Imp_c = new Impresora();
    public static Impresora Imp_bn = new Impresora();
    public static int contador = 0;
    public static int contador_2 = 0; // contador para la imresora a color
    public static boolean accede = false; // bool para activar las impresoras
    public static Lista Lista_espera = new Lista();
    public static Lista temporal = new Lista();
    public static Lista Atendidos = new Lista();
    
    
    
    
    
        
    int opcion = 0;                          
    Scanner sc = new Scanner(System.in);      // ScanNer números
    Scanner cadenas = new Scanner(System.in); // Scanner 
                                              
                                             

      
     public void LlamarMenu(){                // Void porque está vacio 
    
     
     do{
         System.out.println("----------- UDrawing Paper -----------");
         System.out.println("1. Carga masiva de clientes");
         System.out.println("2. Número de ventanillas");
         System.out.println("3. Ejecutar Paso");
         System.out.println("4. Estado de memoria de las estructuras");
         System.out.println("5. Reportes");
         System.out.println("6. Acerca de");
         System.out.println("7. Salir");
         opcion = sc.nextInt();
         System.out.println("");
         
            
            
            
            
            switch(opcion){
                case 1:                 
                    System.out.print("Ingrese la dirección del archivo");
                    System.out.println("");
                    String ruta ;
                    ruta = cadenas.nextLine();
                    
                    System.out.print("Ingrese la cantidad de Clientes");
                    System.out.println("");
                    int cantidad;
                    cantidad = sc.nextInt();
                    Cola_recepcion = lectura_Json(ruta, cantidad);
                    Cola_recepcion.imprimir();

              
                    break;
                case 2:
                    System.out.println("Ingrese la cantidad de ventanillas");
                    int cantidad_v;
                    cantidad_v = sc.nextInt();
                    for (int i = 0; i< cantidad_v; i++){
                        int num = i+1;
                        ventanilla nueva = new ventanilla(num); 
                        Lista_ventanillas.Anadir(nueva);
                    }
                    //Lista_ventanillas.imprimir();
                    System.out.println("Se han creado "+cantidad_v+" ventanillas");
                    System.out.println("");
                    break;
                    
                case 3:
                    contador++;
                    System.out.println("PASO" + contador);
                    Paso_cola_recepcion();
                    Paso_lista_ventanillas();
                    Paso_impresoras();
                    Paso_lista_espera();
                    Pasos_lista_espera_2();
                    System.out.println("");
                    System.out.println("");
                    
                    break;
                case 4:
                    System.out.println("No se llegó hasta esta funcion");
                    break;
                case 5:
                    Atendidos.imprimir();
                    break;
                case 6:
                    break;
                    
                case 7:
                    System.out.println("Gracias por utilizar nuestro programa");
                    break;
            }
     }while(opcion != 7);


    }
    
     
     public Cola lectura_Json(String ruta, int tamano){
         
        //String ruta = "C:\\Users\\usuario\\Documents\\Byron\\7mo semestre\\Estructuras\\EDD_PROYECTO_FASE_1_201906588\\Entrada.json";
        //int tamano = 50;  
        
        Lector lectura = new Lector(ruta, tamano);
        Cola colita = lectura.Lectura();
        return colita;
     
     }
     
     public void Paso_cola_recepcion(){
         //Aca dejaremos el espacio para agregar los randomicer (While hasta que a + b >0)
     }
     
     public void Paso_lista_ventanillas(){
         //Recorremos todas las ventanillas y vemos en que estado estan
         // si estan desocupadas verificamos que haya elemtos en la cola, si hay procedemos a introducirlo
         System.out.println("   VENTANILLAS");
         int num_vent = Lista_ventanillas.tamano();
         if (num_vent < 1){
             System.out.println("Aún no se han creado ventanillas");
         }else{
             for (int j=0; j<num_vent; j++){
                 ventanilla aux = Lista_ventanillas.Obtener(j);
                 
                 if(aux.disponible){ // ventanilla disponible, metemos nodo
                     
                     //metemos el top de la cola de los usuarios en la ventanilla y lo sacamos de la cola
                     //pero primero debemos ver si está vacía
                     
                     if(Cola_recepcion.vacia() == false){// cola con elementos
                         
                         nodo top_cola = Cola_recepcion.avanzar(); //extraemos de la cola
                         if (top_cola != null){
                             aux.set_nodo_evaluado(top_cola); //introducimos el nodo a la ventaniñña                    
                            }
                         }
                         
                 }else{ // ventanila ocupada, operamos lo de adentro
                     
                     nodo nodo_lista_espera = aux.get_nodo_evaluado();    
                     Pila pila_respuesta = aux.tratar_img();
                     if (pila_respuesta != null){
                         //pila_respuesta.imprimir();
                         temporal.Anadir(nodo_lista_espera);
                         encolar_img(pila_respuesta);
                     } 
                 }            
             }
         }    
     }
     
     public void encolar_img (Pila pilar){
         
         int tamano = pilar.tamano();
         for (int m = 0; m < tamano; m++){
             img img_agregar = pilar.avanzar();
             int tipo = img_agregar.get_tipo();
             int id_cliente = img_agregar.get_id();
             int numero = img_agregar.get_num(); 
             img uno = new img(tipo, id_cliente, numero);         
            switch(tipo){
                case 1: 
                    Imp_bn.insertar(uno);
                    break;           
                case 2:   
                    Imp_c.insertar(uno);
                    break;
            }        
         }
     }
     
     
    public void Paso_impresoras(){
         boolean i_c = Imp_c.vacia();
         boolean i_bn = Imp_bn.vacia();

         if (i_c != true || i_bn != true){     
             if (accede == true){
                 
                System.out.println("    IMPRESORAS");
                if (i_c != true){
                    if (contador_2 == 1){
                        img auxiliar = Imp_c.avanzar();
                        System.out.println("        Impresión COLOR");
                        impresion_realizada(auxiliar.get_id());
                        contador_2 = 0;
                    }else{
                        contador_2++;
                    }                
                }    
                if (i_bn != true){
                     img auxiliar = Imp_bn.avanzar();
                    System.out.println("        Impresión B/N");  
                    impresion_realizada(auxiliar.get_id());
                }                   
            }else{
                 accede = true;         
            }         
        } 
   }
         

     public void Paso_lista_espera(){
         
         if(temporal.EstaVacia()!= true){
            System.out.println("    LISTA ESPERA");    
            int num = temporal.tamano();
            for (int j=0; j<num; j++){
                
                int id = temporal.Obtener(j).get_id();
                String nombre = temporal.Obtener(j).get_nombre();
                int img_c = temporal.Obtener(j).get_img_c();
                int img_bn = temporal.Obtener(j).get_img_bn();               
                nodo nuevo = new nodo(id, nombre, img_c, img_bn);
        
                
                 Lista_espera.Anadir(nuevo);
                 System.out.println("       Se añadió al cliente "+ nombre);
              
            }
            temporal = new Lista();
         }

     }
     
     
     public void Pasos_lista_espera_2(){
               
        boolean existe = false;
        int num = Lista_espera.tamano();
        if (num > 0){
            
           //Primer ciclo para ver cantidad
           
           for (int j=0; j<num; j++){
               
               if (Lista_espera.Obtener(j).get_impresiones() == 0){ 
                   existe = true;
                   break;
                }
            }
           
           if(existe){
               Lista auxiliar = new Lista();
                for (int j=0; j<num; j++){
                    
                    int id = Lista_espera.Obtener(j).get_id();
                    String nombre = Lista_espera.Obtener(j).get_nombre();
                    int img_c = Lista_espera.Obtener(j).get_img_c();
                    int img_bn = Lista_espera.Obtener(j).get_img_bn();               
                    nodo nuevo = new nodo(id, nombre, img_c, img_bn);
                    nuevo.set_impresiones(Lista_espera.Obtener(j).get_impresiones());

                    
                    if (Lista_espera.Obtener(j).get_impresiones() == 0){
                        System.out.println("       • Se atenció al cliente "+ nombre);
                        Atendidos.Anadir(nuevo);
                                               
                    }else{     
                        auxiliar.Anadir(nuevo);
                    }
                    
                }
                Lista_espera = auxiliar;
           }
        }  
     }

     
     public void impresion_realizada(int id){ //vamos a recibir el id del cliente propietario de la impresion
                                              // lo buscamos en el la lista de espera, y le restamos 1 a su atributo impresiones
  
        nodo actual = Lista_espera.get_cabecera();
        if (actual != null){
            while( actual.get_id() != id){
                actual = actual.get_siguiente();
            }
            actual.impresion();
            //System.out.println("Se le resto una impresion a "+ actual.get_nombre());
        }
     }
}
     
