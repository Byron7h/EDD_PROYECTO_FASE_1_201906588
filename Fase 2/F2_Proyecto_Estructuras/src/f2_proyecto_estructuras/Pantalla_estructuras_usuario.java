/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f2_proyecto_estructuras;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class Pantalla_estructuras_usuario extends javax.swing.JFrame {

    /**
     * Creates new form Pantalla_estructuras_usuario
     */
    Usuario usuario;
    private ImageIcon imagen;
    private Icon icono;
    int opcion = -1;
    
    
    public Pantalla_estructuras_usuario(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Grupo_botones = new javax.swing.ButtonGroup();
        Panel_menu = new javax.swing.JPanel();
        RB_imagenes = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        RB_capas = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        Boton_visualizar = new javax.swing.JButton();
        capa_id_text = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        imagen_id_text = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Boton_actualizar = new javax.swing.JButton();
        Panel_imagen = new javax.swing.JPanel();
        Label_img = new javax.swing.JLabel();

        Grupo_botones.add(RB_imagenes);
        RB_imagenes.setText("Árbol de imágenes");
        RB_imagenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_imagenesActionPerformed(evt);
            }
        });

        Grupo_botones.add(jRadioButton2);
        jRadioButton2.setText("Listado de álbumes");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        Grupo_botones.add(RB_capas);
        RB_capas.setText("Árbol de capas");
        RB_capas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_capasActionPerformed(evt);
            }
        });

        Grupo_botones.add(jRadioButton4);
        jRadioButton4.setText("Imagen cómo estructura");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        Grupo_botones.add(jRadioButton5);
        jRadioButton5.setText("Capa como estructura");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        jLabel1.setText("Estructuras disconibles");

        Boton_visualizar.setText("Visualizar");
        Boton_visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_visualizarActionPerformed(evt);
            }
        });

        jLabel6.setText("Capa a graficar");

        imagen_id_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imagen_id_textActionPerformed(evt);
            }
        });

        jLabel7.setText("Imagen a graficar");

        Boton_actualizar.setText("Actualizar");
        Boton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_actualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_menuLayout = new javax.swing.GroupLayout(Panel_menu);
        Panel_menu.setLayout(Panel_menuLayout);
        Panel_menuLayout.setHorizontalGroup(
            Panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_menuLayout.createSequentialGroup()
                .addGroup(Panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_menuLayout.createSequentialGroup()
                        .addGroup(Panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_menuLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1))
                            .addGroup(Panel_menuLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(Panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RB_imagenes)
                                    .addComponent(RB_capas)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jRadioButton4)
                                    .addGroup(Panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(Panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(capa_id_text, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))
                                        .addComponent(jRadioButton5))
                                    .addGroup(Panel_menuLayout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addGroup(Panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(imagen_id_text, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))))))
                        .addGap(0, 52, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_menuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Boton_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Boton_visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        Panel_menuLayout.setVerticalGroup(
            Panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_menuLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(RB_capas)
                .addGap(18, 18, 18)
                .addComponent(RB_imagenes)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(capa_id_text, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton4)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imagen_id_text, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addGroup(Panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Boton_visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        Label_img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout Panel_imagenLayout = new javax.swing.GroupLayout(Panel_imagen);
        Panel_imagen.setLayout(Panel_imagenLayout);
        Panel_imagenLayout.setHorizontalGroup(
            Panel_imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_imagenLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(Label_img, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                .addContainerGap())
        );
        Panel_imagenLayout.setVerticalGroup(
            Panel_imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_imagenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label_img, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(Panel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(Panel_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(Panel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(Panel_imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RB_imagenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_imagenesActionPerformed
        opcion = 2;
    }//GEN-LAST:event_RB_imagenesActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        opcion = 5;
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void RB_capasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_capasActionPerformed
        opcion = 1;
    }//GEN-LAST:event_RB_capasActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        opcion = 4;
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        opcion = 3;
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void Boton_visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_visualizarActionPerformed
       
        if ( opcion != -1){
 
            switch (opcion) {
                case 1:
                    
                    
                    usuario.capas.crear_grafo(usuario.capas.raiz);
                    String dto = usuario.capas.imprimir();
                    Creador_img gen = new Creador_img(dto);
                    //String dto = usuario.capas.crear_grafo(usuario.capas.raiz);
                    //Creador_img cre = new Creador_img(dto);
                    JOptionPane.showMessageDialog(this, "Se generó la imagen");
                    Actualizar_img(Label_img,"C:\\Users\\usuario\\Desktop\\provisional\\imagenes\\1.jpg");
                    //Actualizar_img(Label_img,"src/imagenes/0.png");
//
                    break;
                case 2:
                    
                    usuario.imagenes.crear_grafo(usuario.imagenes.raiz);
                    String dt = usuario.imagenes.imprimir();
                    Creador_img gend = new Creador_img(dt);
                    //String dto = usuario.capas.crear_grafo(usuario.capas.raiz);
                    //Creador_img cre = new Creador_img(dto);
                    JOptionPane.showMessageDialog(this, "Se generó la imagen");
                    Actualizar_img(Label_img,"C:\\Users\\usuario\\Desktop\\provisional\\imagenes\\1.jpg");
                    //Actualizar_img(Label_img,"src/imagenes/0.png");

                        
                    break;
                    
                case 3:
                    
                    
                    String id = capa_id_text.getText();
                    if(!"".equals(id)){
                        
                        Matriz_pixeles j = usuario.capas.recorrido_capas(id);
                        Creador_img m = new Creador_img(j,1);
                        JOptionPane.showMessageDialog(this, "Se generó la imagen");
                        Actualizar_img(Label_img,"C:\\Users\\usuario\\Desktop\\provisional\\imagenes\\0.jpg");
                    }else{
                        JOptionPane.showMessageDialog(this, "Ingrese las capas a graficar");
                    }
                    break;

                case 4:
                    
                    
                    //int ide = Integer.parseInt(imagen_id_text.getText());
                    //int ide = Integer.parseInt(imagen_id_text.getText());
                    
                    if(!"".equals(imagen_id_text.getText())){
                        
                        
                        int ide = Integer.parseInt(imagen_id_text.getText());
                    
                        Nodo_AVL nuevo = usuario.imagenes.buscar(ide);
                        if (nuevo != null){
                            ABB arbol = nuevo.imagen.capas;
                            //Matriz_pixeles p = arbol.recorrido_Amplitud();
                            //Creador_img q = new Creador_img(p);

                            
                            
                            
                        
                            arbol.crear_grafo(arbol.raiz);
                            String dtox = arbol.imprimir();
                            Creador_img genx = new Creador_img(dtox);
                            //String dto = usuario.capas.crear_grafo(usuario.capas.raiz);
                            //Creador_img cre = new Creador_img(dto);
                            JOptionPane.showMessageDialog(this, "Se generó la imagen");
                            Actualizar_img(Label_img,"C:\\Users\\usuario\\Desktop\\provisional\\imagenes\\1.jpg");
                            //Actualizar_img(Label_img,"src/imagenes/0.png");
                    }else{
                        JOptionPane.showMessageDialog(this, "Ingrese la imagen a graficar");
                        }
                    
                    }  break;
                    
                case 5:
                    
                    Creador_img w = new Creador_img(usuario.albumes);
                    
                    JOptionPane.showMessageDialog(this, "Se generó la imagen");
                            Actualizar_img(Label_img,"C:\\Users\\usuario\\Desktop\\provisional\\imagenes\\0.jpg");
                    
                    
                    break;
                    
                    
            }
            
            
        
        
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione una opción");
        }
        
        
        
    }//GEN-LAST:event_Boton_visualizarActionPerformed

    private void imagen_id_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imagen_id_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imagen_id_textActionPerformed

    private void Boton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_actualizarActionPerformed
        Actualizar_img(Label_img,"src/imagenes/1.jpg");

    }//GEN-LAST:event_Boton_actualizarActionPerformed

    /**
     * @param args the command line arguments
     */
    
    
    public void Actualizar_img(JLabel Label_img, String ruta){
        this.imagen = new ImageIcon(ruta);
        this.icono = new ImageIcon(this.imagen.getImage().getScaledInstance(Label_img.getWidth(),Label_img.getHeight(),Image.SCALE_DEFAULT));//Convirtiendo la imagen a un icóno para poder ponerlo en el label
        // alto de la imagen, ancho de la imagen, algoritmo de escalamiento de la imagen
        Label_img.setIcon(this.icono);
        this.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_actualizar;
    private javax.swing.JButton Boton_visualizar;
    private javax.swing.ButtonGroup Grupo_botones;
    private javax.swing.JLabel Label_img;
    private javax.swing.JPanel Panel_imagen;
    private javax.swing.JPanel Panel_menu;
    private javax.swing.JRadioButton RB_capas;
    private javax.swing.JRadioButton RB_imagenes;
    private javax.swing.JTextField capa_id_text;
    private javax.swing.JTextField imagen_id_text;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    // End of variables declaration//GEN-END:variables
}
