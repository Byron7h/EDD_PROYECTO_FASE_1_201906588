
package f2_proyecto_estructuras;

public class Usuario {
    
      String nombre, contrasena, DPI;
      ABB capas;
      AVL imagenes = new AVL();
      Lista_doble albumes = new Lista_doble();
      
      public Usuario(String nombre, String contrasena,String DPI){
          this.DPI = DPI;
          this.nombre = nombre;
          this.contrasena = contrasena;
      }
      
      
      public String get_DPI(){
          return this.DPI;
      }
      
      public String get_nombre(){
          return this.nombre;
      }
            
      public String get_contrasena(){
          return this.contrasena;
      }
      
      public ABB get_capas(){
          return this.capas;
      }   
      
      public AVL get_imagenes(){
          return this.imagenes;
      }
      
      
 
}
