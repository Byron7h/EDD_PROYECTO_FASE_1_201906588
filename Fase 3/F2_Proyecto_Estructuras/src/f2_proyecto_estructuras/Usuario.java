
package f2_proyecto_estructuras;

public class Usuario {
    
    // nombre -> nombre completo
    
      long DPI;
      String nombre, contrasena, username, correo, direccion;
      int tel, id_municipio;
      ABB capas;
      AVL imagenes = new AVL();
      Lista_doble albumes = new Lista_doble();
      
      
      // nombre, username, dpi, contraseña, correo, tel, id_municipio
      public Usuario(String nombre, String username, long DPI, String contrasena, 
              String correo, int tel, String direccion ,int id_municipio ){
            
          this.DPI = DPI;
          this.nombre = nombre;
          this.contrasena = contrasena;
          this.username = username;
          this.correo = correo;
          this.tel = tel;
          this.id_municipio  = id_municipio ;
          this.direccion = direccion;

      }
      
      
      public long get_DPI(){
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
