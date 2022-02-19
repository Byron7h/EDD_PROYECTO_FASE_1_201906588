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
    public static Lista Lista_ventanillas  = new Lista();
    
    
    
    
    
        
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
                    System.out.println("METODO DESCIFRADO");
                    break;
                case 3:
                    break;
                case 4:
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
     
     
 
     
}
