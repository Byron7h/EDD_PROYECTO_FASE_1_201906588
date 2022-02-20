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
    
    
    
    
    
        
    int opcion = 0;                          
    Scanner sc = new Scanner(System.in);      // ScanNer números
    Scanner cadenas = new Scanner(System.in); // Scanner 
                                              
                                             

      
     public void LlamarMenu(){                // Void porque está vacio 
    
     
     do{
         System.out.println("•••         UDrawing Paper          •••");
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
                    Lista_ventanillas.imprimir();                  
                    break;
                    
                case 3:
                    
                    System.out.println("Se dió un paso");
                    Paso_cola_recepcion();
                    Paso_lista_ventanillas();
                    System.out.println("");
                    System.out.println("");
                    
                    
                    break;
                case 4:
                    Imp_c.imprimir();
                    break;
                case 5:
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
                     
                     Pila pila_respuesta = aux.tratar_img();
                     if (pila_respuesta != null){
                         //pila_respuesta.imprimir();
                         encolar_img(pila_respuesta);
                     } 
                 }            
             }
         }    
     }
     
     public void encolar_img (Pila pila){
         
         pila.imprimir();
         
               
        while( pila.vacia() != false){
            img aux = pila.avanzar();
            System.out.println(aux.get_tipo());
            //System.out.println(aux.);
                if (aux.get_tipo() == 2){ //color
                    Imp_c.insertar(aux);                  
                }else{  //blanco y negro
                    Imp_bn.insertar(aux);
                }
            }
        
        
        System.out.println("Impresora c");
        Imp_c.imprimir();
        System.out.println("Impresora bn");
        Imp_bn.imprimir();
        */
     }
     
     
 
     
}
