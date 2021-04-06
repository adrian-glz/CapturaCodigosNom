/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package COMPUTO;


import PRINCIPAL.CapturaCodigo;
import static PRINCIPAL.CapturaCodigo.ahorro;
import static PRINCIPAL.CapturaCodigo.categoriaweb;
import static PRINCIPAL.CapturaCodigo.codigo;
import static PRINCIPAL.CapturaCodigo.codigo2;
import static PRINCIPAL.CapturaCodigo.costounitario;
import static PRINCIPAL.CapturaCodigo.descgenero;
import static PRINCIPAL.CapturaCodigo.descgrupo;
import static PRINCIPAL.CapturaCodigo.descripcion;
import static PRINCIPAL.CapturaCodigo.exportador;
import static PRINCIPAL.CapturaCodigo.genero;
import static PRINCIPAL.CapturaCodigo.grupo;
import static PRINCIPAL.CapturaCodigo.hecho;
import static PRINCIPAL.CapturaCodigo.importador;
import static PRINCIPAL.CapturaCodigo.marca;
import static PRINCIPAL.CapturaCodigo.margen;
import static PRINCIPAL.CapturaCodigo.nacional;
import static PRINCIPAL.CapturaCodigo.preciooferta;
import static PRINCIPAL.CapturaCodigo.precioventa;
import static PRINCIPAL.CapturaCodigo.utilidad;
import PRINCIPAL.NuevaOpcion;
import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author AGONZALEZ
 */
public class V145 extends javax.swing.JFrame {
    
    Statement st;
    PreparedStatement ps = null;
    ResultSet rs;
    DefaultListModel modelo = new DefaultListModel();
    int Vnacional;
    public static String incluye = " ";
   
    public V145() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/recursos/logo.png")).getImage());
        llenarcolor();
        llenarcompatibilidad();
        llenarlistaincluye();

    }

    public void comparacionnacional() {
        if (nacional.equals("NACIONAL")) {
            Vnacional = 1;
        }
        if (nacional.equals("AMERICANO")) {
            Vnacional = 0;
        }

    }

 
    public void eliminarelementolista() {

        DefaultListModel model2 = (DefaultListModel) lfinal.getModel();

        Object elementos = (String) lfinal.getSelectedValue();

        int filaseleccionada = lfinal.getSelectedIndex();
        if (filaseleccionada >= 0) {

            int selectedIndex = lfinal.getSelectedIndex();
            if (selectedIndex != -1) {
                model2.remove(lfinal.getSelectedIndex());///remueve valor de tabla
            }
        } else {
            JOptionPane.showMessageDialog(this, "No ha seleccionado ninguna fila o la tabla está vacía");
        }
    }

    public void agregarelementolista() {
        DefaultListModel model2 = (DefaultListModel) lincluye.getModel();
        String elementos = (String) lincluye.getSelectedValue();

        int filaseleccionada = lincluye.getSelectedIndex();

        if (filaseleccionada >= 0) {

            modelo.addElement(elementos);///agregar elemento al modelo llfinal
            lfinal.setModel(modelo);

            int selectedIndex = lincluye.getSelectedIndex();
            if (selectedIndex != -1) {
                model2.remove(selectedIndex);///remueve valor de tabla
            }

        } else {
            JOptionPane.showMessageDialog(this, "No ha seleccionado ninguna fila o la tabla está vacía");

        }
    }
/*
    private static void showList(List elementoquellega) {

        StringBuilder c = new StringBuilder();

        int size = elementoquellega.size();
        for (int i = 0; i < size; i++) {
            c.append(elementoquellega.get(i));

        }
        String cadena = c.toString();              ///almacena todo lo que el ciclo imprime 

        cadena = cadena.substring(0, cadena.length() - 1);//condicion de eliminar el ultimocaracter de la cadena
        incluye = cadena.replace(" ", "");//funcion eliminaespacios
        // System.out.println("INCLUIYE>: "+cadena);

    }
*/
    public void llenarcolor() {
        cbcolor.removeAllItems();
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            st = conexion.createStatement();
            st.executeUpdate("USE noms;");
            rs = st.executeQuery("SELECT * FROM colores order by  elemento asc");

            while (rs.next()) {
                String elemento = rs.getString("elemento");
                cbcolor.addItem(elemento);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            JOptionPane.showMessageDialog(this, "Problemas con la conexion verifique o vuelva a intentar" + genero);

            e.printStackTrace();
            return;
        }
    }

    public void llenarlistaincluye() {

        lincluye.removeAll();
        DefaultListModel modelo = new DefaultListModel();
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            st = conexion.createStatement();
            st.executeUpdate("USE NOMS;");
            rs = st.executeQuery("SELECT * FROM LentesRealidadIncluye order by  elemento asc");

            while (rs.next()) {
                modelo.addElement(rs.getString("elemento"));
            }
            lincluye.setModel(modelo);
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Problemas con la conexion verifique o vuelva a intentar");

            return;
        }

    }

    public void variableincluye() {
        int size = lfinal.getModel().getSize();
        StringBuilder c = new StringBuilder();

        for (int i = 0; i < size; i++) {
            c.append(lfinal.getModel().getElementAt(i) + ",");
        }
        String cadena = c.toString();
       try {
            if(cadena.length()>2){
            
            cadena = cadena.substring(0, cadena.length() - 1);
            incluye = cadena.trim();//funcion eliminaespacios
            }
            else{
             incluye="NO APLICA";
            }
            
            
            } catch (Exception e) {
            cadena = "NO APLICA";
        }

        /*     int size = lfinal.getModel().getSize();
         //StringBuilder c = new StringBuilder();

         List odernarlista = new ArrayList<>();
         for (int i = 0; i < size; i++) {
         //c.append(lfinal.getModel().getElementAt(i) + ",");
         odernarlista.add(lfinal.getModel().getElementAt(i) + ",");
         }
         Collections.sort(odernarlista);
    
         showList(odernarlista);*/
    }


    public void llenarcompatibilidad() {
        cbcompatibilidad.removeAllItems();
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            st = conexion.createStatement();
            st.executeUpdate("USE NOMS;");
            rs = st.executeQuery("SELECT * FROM LentesRealidadCompatibilidad order by  elemento asc");

            while (rs.next()) {
                String elemento = rs.getString("elemento");
                cbcompatibilidad.addItem(elemento);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            JOptionPane.showMessageDialog(this, "Problemas con la conexion verifique o vuelva a intentar");

            e.printStackTrace();
            return;
        }
    }

    public void insertarcodigo() {
        variableincluye();
        comparacionnacional();

         String compatibilidad = cbcompatibilidad.getSelectedItem().toString().trim();
         String color = cbcolor.getSelectedItem().toString().trim();
     
         int g = Integer.parseInt(genero);

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            Statement st = conexion.createStatement();
            st.executeUpdate("use noms ;");

    
    ps = conexion.prepareStatement("insert into noms1web (codigo,Codigo2,descripcion,nacional,Grupo,descgrupo,Genero,"
                    + "descgenero,CostoUni,PrecioVenta,PrecioOferta,Ahorro,Utilidad,Margen,marca,hecho,importador,exportador,FechaAct,categoriaweb,campo1,campo2,campo3,campo4,campo5,campo6,campo7,campo8,campo9,campo10,campo11,campo12)\n"
                    + "VALUES\n"
                    + "('" + codigo + "','" + codigo2 + "','" + descripcion + "','" + Vnacional + "','" + grupo + "','" + descgrupo + "','" + g + "','" + descgenero + "','" + costounitario + "','" + precioventa + "','" + preciooferta + "','" + ahorro + "','" + utilidad + "','" + margen + "','" + marca + "','" + hecho + "','" + importador + "','" + exportador + "',getdate(),'" + categoriaweb + "' "
            + ",'" +"COMPATIBILIDAD "+ compatibilidad + "','" +"COLOR "+ color + "','" +"INCLUYE "+ incluye + "','null','null','null','null','null','null','null','null','null')");
      
       System.out.println( 
                 "CODIGO:"+ codigo +"\n"
                 +"CODIGO2:"+codigo2+"\n"     
                 +"DESCRIPCION:"+descripcion+"\n"   
                 +"NACIONAL:"+Vnacional+"\n"
                 +"GRUPO:"+grupo+"\n"       
                 +"DESCRIPCION GRUPO:"+descgrupo+"\n"
                 +"# GENERO:"+g+"\n"
                    + "DESCRIPCION GENERO:" + descgenero + "\n"
                    + "COSTO UNITARIO:" + costounitario + "\n"
                    + "PRECIO VENTA:" + precioventa + "\n"
                    + "PRECIO OFERTA:" + preciooferta + "\n"
                    + "AHORRO:" + ahorro + "\n"
                    + "UTILIDAD:" + utilidad + "\n"
                    + "MARGEN:" + margen + "\n"
                    + "MARCA:" + marca + "\n"
                    + "HECHO EN:" + hecho + "\n"
                    + "IMPORTADOR:" + importador + "\n"
                    + "EXPORTADOR:" + exportador + "\n"
                    + "CAT WEB:" + categoriaweb + "\n"
             //       + "MULTIFUNCIONAL:" + multifuncional + "\n"
               //     + "VELOCIDAD:" + velocidad + "\n"
                    + "CONECTIVIDAD:" + compatibilidad + "\n"
                    + "COLOR:" + color + "\n"
                    + "INCLUYE:" + incluye + "\n"
            );
    
    
    int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "¡Los datos han sido guardados exitósamente!");
                st.close();
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error en la base de datos" + ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(V145.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbcompatibilidad = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        lincluye = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbcolor = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        btnpasalista = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lfinal = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblcodigo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JToggleButton();
        jLabel18 = new javax.swing.JLabel();
        btnregresar1 = new javax.swing.JButton();
        btnagregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de captura codigos");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Compatibilidad:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, 38));

        jPanel1.add(cbcompatibilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 171, 38));

        lincluye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lincluyeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lincluye);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 190, 110));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Incluye:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 80, 35));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Color:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 100, 35));

        jPanel1.add(cbcolor, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 171, 38));

        jLabel9.setText(" ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 60, -1));

        btnpasalista.setText(">");
        btnpasalista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpasalistaActionPerformed(evt);
            }
        });
        jPanel1.add(btnpasalista, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, -1, -1));

        lfinal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lfinalMouseClicked(evt);
            }
        });
        lfinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lfinalKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(lfinal);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 210, 110));

        jButton1.setText("x");
        jButton1.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 240, 40, 20));

        jButton2.setText("refrescar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 90, 30));

        jLabel3.setText(" ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 30, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 700, 360));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("CODIGO:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 68, 43));
        getContentPane().add(lblcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 220, 43));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("LENTES DE REALIDAD VIRTUAL          ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 290, 40));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("GENERO:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, 43));

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(0, 153, 0));
        btnguardar.setText("Grabar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, 170, 60));

        jLabel18.setText(" ");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 490, 90, 30));

        btnregresar1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnregresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/volver.png"))); // NOI18N
        btnregresar1.setText("Regresar");
        btnregresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnregresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 240, 60));

        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/nueva.png"))); // NOI18N
        btnagregar.setText("Agregar nuevo elemento");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 250, 60));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
              int result = JOptionPane.showConfirmDialog(null, "seguro que quieres capturar el codigo?", "ATENCION",
          JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (result == JOptionPane.YES_OPTION) {
            insertarcodigo();
            CapturaCodigo cc = new CapturaCodigo();
            cc.setVisible(true);
            this.dispose();

        } else if (result == JOptionPane.NO_OPTION) {

        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnpasalistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpasalistaActionPerformed
    agregarelementolista();

    }//GEN-LAST:event_btnpasalistaActionPerformed

    private void lfinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lfinalKeyPressed
 
    }//GEN-LAST:event_lfinalKeyPressed

    private void lincluyeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lincluyeMouseClicked
        
        if (evt.getClickCount() == 2) {
            agregarelementolista();
        }
    }//GEN-LAST:event_lincluyeMouseClicked

    private void lfinalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lfinalMouseClicked

        if (evt.getClickCount() == 2) {
            eliminarelementolista();
        }
    }//GEN-LAST:event_lfinalMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        eliminarelementolista();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        llenarcolor();
        llenarcompatibilidad();
        llenarlistaincluye();

 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnregresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresar1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        CapturaCodigo cc = new CapturaCodigo();
        cc.setVisible(true);
    }//GEN-LAST:event_btnregresar1ActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        NuevaOpcion m = new NuevaOpcion();
        m.setVisible(true);

    }//GEN-LAST:event_btnagregarActionPerformed


 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(V145.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(V145.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(V145.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(V145.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new V145().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JToggleButton btnguardar;
    private javax.swing.JButton btnpasalista;
    private javax.swing.JButton btnregresar1;
    private javax.swing.JComboBox cbcolor;
    private javax.swing.JComboBox cbcompatibilidad;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JList lfinal;
    private javax.swing.JList lincluye;
    // End of variables declaration//GEN-END:variables
}
