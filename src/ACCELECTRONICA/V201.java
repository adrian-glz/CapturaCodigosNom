/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ACCELECTRONICA;

 
 
import ELECTRONICA.*;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author AGONZALEZ
 */
public final class V201 extends javax.swing.JFrame {

    Statement st;
    PreparedStatement ps = null;
    ResultSet rs;
    int Vnacional;
    DefaultListModel modelo = new DefaultListModel();
    public static String incluye = " ";

    public V201() {
        initComponents();
      
        lblcodigo.setText(codigo);  
        llenarcolor();
        llenarcontactos();
        llenarlongitud();
        llenarvoltaje();
        llenarentradausb();
        llenarvoltajeusb();
     }

    public void llenarcolor() {
        cbcolor.removeAllItems();
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            st = conexion.createStatement();
            st.executeUpdate("USE NOMS;");
            rs = st.executeQuery("SELECT * FROM colores order by  elemento asc");

            while (rs.next()) {
                String elemento = rs.getString("elemento");
                cbcolor.addItem(elemento);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
    }

    public void llenarcontactos() {
        cbcontactos.removeAllItems();
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            st = conexion.createStatement();
            st.executeUpdate("USE noms;");
            rs = st.executeQuery("select * from EnchufeMultipleContactos order by  elemento desc");

            while (rs.next()) {
                String elemento = rs.getString("elemento");
                cbcontactos.addItem(elemento);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
    }
    public void llenarlongitud() {
        cblongitud.removeAllItems();
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            st = conexion.createStatement();
            st.executeUpdate("USE noms;");
            rs = st.executeQuery("select * from EnchufeMultipleLongitud order by  elemento desc");

            while (rs.next()) {
                String elemento = rs.getString("elemento");
                cblongitud.addItem(elemento);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
    }
    public void llenarvoltaje() {
        cbvoltaje.removeAllItems();
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            st = conexion.createStatement();
            st.executeUpdate("USE noms;");
            rs = st.executeQuery("select * from EnchufeMultipleVoltaje order by  elemento desc");

            while (rs.next()) {
                String elemento = rs.getString("elemento");
                cbvoltaje.addItem(elemento);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
    }
    public void llenarentradausb() {
        cbentradasusb.removeAllItems();
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            st = conexion.createStatement();
            st.executeUpdate("USE noms;");
            rs = st.executeQuery("select * from EnchufeMultipleEntradasUsb order by  elemento desc");

            while (rs.next()) {
                String elemento = rs.getString("elemento");
                cbentradasusb.addItem(elemento);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
    }
    public void llenarvoltajeusb() {
        cbvoltajeusb.removeAllItems();
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            st = conexion.createStatement();
            st.executeUpdate("USE noms;");
            rs = st.executeQuery("select * from EnchufeMultipleUsbVoltaje order by  elemento desc");

            while (rs.next()) {
                String elemento = rs.getString("elemento");
                cbvoltajeusb.addItem(elemento);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
    }
 
    public void comparacionnacional() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SS");
        LocalDateTime date = LocalDateTime.now();

        if (nacional.equals("NACIONAL")) {
            Vnacional = 1;
        }
        if (nacional.equals("AMERICANO")) {
            Vnacional = 0;
        }

    }

    
    public void insertarcodigo() {
         comparacionnacional();

         String contactos = cbcontactos.getSelectedItem().toString();
         String longitud = cblongitud.getSelectedItem().toString();
         String voltaje = cbvoltaje.getSelectedItem().toString();
         String voltajeusb = cbvoltajeusb.getSelectedItem().toString();
         String entradausb = cbentradasusb.getSelectedItem().toString();
       
         String color = cbcolor.getSelectedItem().toString();
        int g = Integer.parseInt(genero);

       
                
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            Statement st = conexion.createStatement();
            st.executeUpdate("USE NOMS;");

            ps = conexion.prepareStatement("insert into noms1web (codigo,Codigo2,descripcion,nacional,Grupo,descgrupo,Genero,"
                    + "descgenero,CostoUni,PrecioVenta,PrecioOferta,Ahorro,Utilidad,Margen,marca,hecho,importador,exportador,FechaAct,categoriaweb,campo1,campo2,campo3,campo4,campo5,campo6,campo7,campo8,campo9,campo10,campo11,campo12)\n"
                    + "VALUES\n"
                    + "('" + codigo + "','" + codigo2 + "','" + descripcion + "','" + Vnacional + "','" + grupo + "','" + descgrupo + "','" + g + "','" + descgenero + "','" + costounitario + "','" + precioventa + "','" + preciooferta + "','" + ahorro + "','" + utilidad + "','" + margen + "','" + marca + "','" + hecho + "','" + importador + "','" + exportador + "',getdate(),'" + categoriaweb + "' "
                    + ",'" + "CONTACTOS " + contactos + "','" + "VOLTAJE " + voltaje + "','" + "ENTRADAS USB " + entradausb + "','"+"VOLTAJE USB "+voltajeusb+"','"+"LONGITUD "+longitud+"','"+"COLOR "+color+"','null','null','null','null','null','null')");

            System.out.println(
                    "CODIGO:" + codigo + "\n"
                    + "CODIGO2:" + codigo2 + "\n"
                    + "DESCRIPCION:" + descripcion + "\n"
                    + "NACIONAL:" + Vnacional + "\n"
                    + "GRUPO:" + grupo + "\n"
                    + "DESCRIPCION GRUPO:" + descgrupo + "\n"
                    + "# GENERO:" + g + "\n"
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
            //        + "CONECTIVIDAD:" + conectividad + "\n"
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
            Logger.getLogger(V201.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }

    
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbcolor = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        btnrefrescar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbcontactos = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cbvoltaje = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        cbentradasusb = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        cbvoltajeusb = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        cblongitud = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btngrabar = new javax.swing.JToggleButton();
        jLabel13 = new javax.swing.JLabel();
        lblcodigo = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnregresar = new javax.swing.JButton();
        btnagregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de captura codigos");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Color:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 80, 30));

        jPanel1.add(cbcolor, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 171, 35));

        jLabel9.setText(" ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 60, -1));

        btnrefrescar.setText("Refrescar");
        btnrefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefrescarActionPerformed(evt);
            }
        });
        jPanel1.add(btnrefrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 110, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Contactos :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 110, 30));

        cbcontactos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbcontactosActionPerformed(evt);
            }
        });
        jPanel1.add(cbcontactos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 171, 35));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Voltaje:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 110, 30));

        cbvoltaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbvoltajeActionPerformed(evt);
            }
        });
        jPanel1.add(cbvoltaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 171, 35));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Entradas usb :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 110, 30));

        cbentradasusb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbentradasusbActionPerformed(evt);
            }
        });
        jPanel1.add(cbentradasusb, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 171, 35));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Voltaje usb :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 90, 30));

        cbvoltajeusb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbvoltajeusbActionPerformed(evt);
            }
        });
        jPanel1.add(cbvoltajeusb, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 171, 35));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Longitud:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 30));

        cblongitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cblongitudActionPerformed(evt);
            }
        });
        jPanel1.add(cblongitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 171, 35));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 700, 190));

        jLabel1.setText(" ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, -1, 20));

        btngrabar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btngrabar.setForeground(new java.awt.Color(0, 153, 0));
        btngrabar.setText("Grabar");
        btngrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngrabarActionPerformed(evt);
            }
        });
        getContentPane().add(btngrabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 180, 60));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("CODIGO:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 68, 43));

        lblcodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(lblcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 230, 43));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("GENERO:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 90, 43));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("ENCHUFE MULTIPLE");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 230, 40));

        btnregresar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnregresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/volver.png"))); // NOI18N
        btnregresar.setText("Regresar");
        btnregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 210, 60));

        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/nueva.png"))); // NOI18N
        btnagregar.setText("Agregar nuevo elemento");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 270, 60));

        jLabel2.setText(" ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, -1, 20));

        jLabel3.setText(" ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 70, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btngrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngrabarActionPerformed
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
    }//GEN-LAST:event_btngrabarActionPerformed

    private void btnrefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefrescarActionPerformed
         llenarcolor();
        llenarcontactos();
        llenarlongitud();
        llenarvoltaje();
        llenarentradausb();
        llenarvoltajeusb();
    }//GEN-LAST:event_btnrefrescarActionPerformed

    private void cbcontactosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbcontactosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbcontactosActionPerformed

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
        this.dispose();
        CapturaCodigo cc = new CapturaCodigo();
        cc.setVisible(true);
    }//GEN-LAST:event_btnregresarActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        NuevaOpcion m = new NuevaOpcion();
        m.setVisible(true);

    }//GEN-LAST:event_btnagregarActionPerformed

    private void cbvoltajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbvoltajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbvoltajeActionPerformed

    private void cbentradasusbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbentradasusbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbentradasusbActionPerformed

    private void cbvoltajeusbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbvoltajeusbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbvoltajeusbActionPerformed

    private void cblongitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cblongitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cblongitudActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(V201.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(V201.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(V201.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(V201.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new V201().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JToggleButton btngrabar;
    private javax.swing.JButton btnrefrescar;
    private javax.swing.JButton btnregresar;
    private javax.swing.JComboBox cbcolor;
    private javax.swing.JComboBox cbcontactos;
    private javax.swing.JComboBox cbentradasusb;
    private javax.swing.JComboBox cblongitud;
    private javax.swing.JComboBox cbvoltaje;
    private javax.swing.JComboBox cbvoltajeusb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblcodigo;
    // End of variables declaration//GEN-END:variables
}
