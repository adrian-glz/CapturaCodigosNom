/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRINCIPAL;

import CodigoPOJO.CodigoPOJO;
import JDBC.Conexion;
import JDBC.PersonaJDBC;
import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author agonzalez
 */
public class Principal extends javax.swing.JFrame {

    Statement st;
    PreparedStatement ps = null;
    ResultSet rs;

    /**
     * Creates new form Principal
     */
    //TextAutoCompleter textAutoCompleter;
    
    
    public Principal() {
        initComponents();
        TextPrompt codigosoundst = new TextPrompt("Codigo Sounds", txtcodigosounds);
        TextPrompt codigoproveedort = new TextPrompt("Codigo Proveedor o fisico", txtcodigoproveedor);
        TextPrompt codigobarrast = new TextPrompt("Codigo de barras", txtcodigobarras);
        TextPrompt descripciont = new TextPrompt("Descripcion", txtdescripcion);
      //  TextPrompt procedencia = new TextPrompt("Procedencia", txtcodigosounds);
        
                
     
        llenargeneros();
        llenargrupos();
        llenarfamilia();
        llenarproveedor();
        AutoCompleteDecorator.decorate(jcgenero);
        AutoCompleteDecorator.decorate(jcgrupo);
        AutoCompleteDecorator.decorate(jcproveedor);
        
        GregorianCalendar gg = new GregorianCalendar();
        SimpleDateFormat dd = new SimpleDateFormat("yyyy/MM/dd");
        String fechadisplay = dd.format(gg.getTime());
        lblfecha.setText(fechadisplay);   
        /*  textAutoCompleter = new TextAutoCompleter(txtgenero, new AutoCompleterCallback() {
         @Override
         public void callback(Object o) {
                Object a = textAutoCompleter.findItem(o);
                CodigoPOJO personaPOJO = (CodigoPOJO) a;
            }
        });
        PersonaJDBC.cargargeneros(textAutoCompleter);
        textAutoCompleter = new TextAutoCompleter(txtgrupos, new AutoCompleterCallback() {
            @Override
            public void callback(Object o) {
                Object a = textAutoCompleter.findItem(o);
                CodigoPOJO personaPOJO = (CodigoPOJO) a;
            }
        });

        PersonaJDBC.cargargrupos(textAutoCompleter);*/
    }

    public void llenargeneros() {
        jcgenero.removeAllItems();

        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            st = conn.createStatement();

            rs = st.executeQuery("select * from generos order by descripcion asc");

            while (rs.next()) {
                String elemento = rs.getString("descripcion").trim();
                jcgenero.addItem(elemento);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
    }

    public void llenargrupos() {
        jcgrupo.removeAllItems();

        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            st = conn.createStatement();

            rs = st.executeQuery("select * from grupos order by descripcion asc");

            while (rs.next()) {
                String elemento = rs.getString("descripcion").trim();
                jcgrupo.addItem(elemento);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
    }
    public void llenarfamilia() {
      //  jcfamilia.removeAllItems();

        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            st = conn.createStatement();
             st.executeUpdate("USE noms;");
            rs = st.executeQuery("select * from similares order by elemento ASC");

            while (rs.next()) {
                String elemento = rs.getString("elemento").trim();
                jcfamilia.addItem(elemento);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
    }

      public void llenarproveedor() {
        jcproveedor.removeAllItems();

        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            st = conn.createStatement();

            rs = st.executeQuery("select * from proveedores order by descripcion asc");

            while (rs.next()) {
                String elemento = rs.getString("descripcion").trim();
                jcproveedor.addItem(elemento);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtcodigoproveedor = new javax.swing.JTextField();
        txtcodigobarras = new javax.swing.JTextField();
        txtdescripcion = new javax.swing.JTextField();
        jcgrupo = new javax.swing.JComboBox();
        jcgenero = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        lblcodigobarras = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblproveedor = new javax.swing.JLabel();
        lbldescripcion = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcproveedor = new javax.swing.JComboBox();
        jcestatus = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        btnayuda = new javax.swing.JButton();
        txtcodigosounds = new javax.swing.JTextField();
        lblcodigosounds = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jcprocedencia = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jcfamilia = new javax.swing.JComboBox();
        lblfecha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Captura codigo nuevo");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText(" ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 340, -1, -1));

        txtcodigoproveedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtcodigoproveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigoproveedorKeyTyped(evt);
            }
        });
        getContentPane().add(txtcodigoproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 180, 30));

        txtcodigobarras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtcodigobarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigobarrasKeyTyped(evt);
            }
        });
        getContentPane().add(txtcodigobarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 140, 30));

        txtdescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtdescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdescripcionKeyTyped(evt);
            }
        });
        getContentPane().add(txtdescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 140, 30));

        jcgrupo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcgrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcgrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 180, 30));

        jcgenero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcgenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcgenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 180, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Grupo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, -1, -1));

        lblcodigobarras.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblcodigobarras.setText("  ");
        getContentPane().add(lblcodigobarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 5, 130, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Genero");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 65, -1, -1));

        lblproveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblproveedor.setText(" ");
        getContentPane().add(lblproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 5, 180, -1));

        lbldescripcion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbldescripcion.setText("  ");
        getContentPane().add(lbldescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 5, 130, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Proveedor");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 65, -1, -1));

        jcproveedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcproveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 180, 30));

        jcestatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcestatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "C", "D" }));
        getContentPane().add(jcestatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 70, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Estatus");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 115, -1, -1));

        btnayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/HELP2.png"))); // NOI18N
        btnayuda.setContentAreaFilled(false);
        btnayuda.setFocusPainted(false);
        btnayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnayudaActionPerformed(evt);
            }
        });
        getContentPane().add(btnayuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 60, 50));

        txtcodigosounds.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtcodigosounds.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigosoundsKeyTyped(evt);
            }
        });
        getContentPane().add(txtcodigosounds, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 170, 30));

        lblcodigosounds.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblcodigosounds.setText(" ");
        getContentPane().add(lblcodigosounds, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 140, -1));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 380, 60));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Procedencia");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 115, -1, -1));

        jcprocedencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcprocedencia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Importado", "Nacional" }));
        getContentPane().add(jcprocedencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 180, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Familia");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 115, -1, -1));

        jcfamilia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcfamilia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--NO APLICA--" }));
        getContentPane().add(jcfamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 130, 30));

        lblfecha.setText("  ");
        getContentPane().add(lblfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 360, 80, 20));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtcodigoproveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoproveedorKeyTyped
        if (txtcodigoproveedor.getText().length() > 0) {
            lblproveedor.setText("Proveedor");
        } else {
            lblproveedor.setText("");
        }
    }//GEN-LAST:event_txtcodigoproveedorKeyTyped

    private void txtcodigobarrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigobarrasKeyTyped
        if (txtcodigobarras.getText().length() > 0) {
            lblcodigobarras.setText("Codigo de barras");
        } else {
            lblcodigobarras.setText("");
        }
    }//GEN-LAST:event_txtcodigobarrasKeyTyped

    private void txtdescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionKeyTyped
        if (txtdescripcion.getText().length() > 0) {
            lbldescripcion.setText("Descripcion");
        } else {
            lbldescripcion.setText("");
        }
    }//GEN-LAST:event_txtdescripcionKeyTyped

    private void btnayudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnayudaActionPerformed
        JOptionPane.showMessageDialog(null, "Informacion de estatus:\n"
                + "A=ACTIVO\n"
                + "D=DESCATALOGADO\n"
                + "C=CANCELADO");
    }//GEN-LAST:event_btnayudaActionPerformed

    private void txtcodigosoundsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigosoundsKeyTyped
        if (txtcodigosounds.getText().length() > 0) {
            lblcodigosounds.setText("Codigo Sounds");
        } else {
            lblcodigosounds.setText("");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigosoundsKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      ///variables para uso en insert sql
        System.out.println(">>>"+jcfamilia.getSelectedItem().toString());
        if (txtcodigosounds.equals(" ")
                || txtcodigoproveedor.equals(" ")
                || txtcodigobarras.equals(" ")
                || txtdescripcion.equals(" ")
                || jcfamilia.getSelectedItem().toString().equals("--NO APLICA--")) {

            JOptionPane.showMessageDialog(rootPane, "Faltan datos, si aparecen datos en blanco, comunicate con el comprador responsable");

          //  vaciarcampiosvalores();
        } else {
          ExisteCodigo();
        }
        
        
      
    }//GEN-LAST:event_jButton1ActionPerformed

    public void ExisteCodigo() {//comprobar 

        ////evento para buscar codigo
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://" + "192.168.1.80:55024" + "", "usounds", "madljda");
            st = conexion.createStatement();
            
            rs = st.executeQuery("select codigo, descripcion, grupo, precioventa from codigos where codigo='" + txtcodigosounds.getText() + "' or codigo2='" + txtcodigosounds.getText() + "'");
            //  System.out.println(">>>"+sucursalglobal);

            boolean friv = rs.next();
            String s1 = Boolean.toString(friv);
            try {
                if (s1.equals("true")) {

                    while (rs.next()) {
                    }
                    JOptionPane.showMessageDialog(null, "El codigo ya existe, intente con otro", "Alerta", JOptionPane.WARNING_MESSAGE);

                } else {
                  //PROCEDEMOS
                    insertacodigo();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

     
    }
    public void insertacodigo() {
   String codigosounds =txtcodigosounds.getText();
        String codigoproveedor =txtcodigoproveedor.getText();
        String codigobarras =txtcodigobarras.getText();
        String descripcion =txtdescripcion.getText();
        String grupo =jcgrupo.getSelectedItem().toString();
        String genero =jcgenero.getSelectedItem().toString();
        String proveedor =jcproveedor.getSelectedItem().toString();
        String estatus =jcestatus.getSelectedItem().toString();    
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SS");
        LocalDateTime date = LocalDateTime.now();
        //   System.out.println(dtf.format(date));
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://" + "192.168.1.80:55024" + "", "usounds", "madljda");
            st.executeUpdate("use cml;");
            Statement st = conexion.createStatement();

            ps = conexion.prepareStatement("insert into codigos  (Codigo, CodigoProv, Estatus, Codigo2, CodigoNuevo, Descripcion,"
                    + " Artista,UnidadMedida  , Genero , Grupo  , Linea  , Proveedor, Proveedor2 , Nacional , Iva  , ClaveApartado ,"
                    + " CostoLista  , CostoNetoLista , CostoReposicion, PrecioVenta, FechaAlta , FechaActualizacion , TipoArticulo ,"
                    + " FechaActExpCosto, DescClienFrec ) "
                    + "VALUES('" + codigosounds + "',"
                    + "'" + txtgondola.getText().toUpperCase() + "','" + txtcantidad.getText().toUpperCase() + "','" + date + "');");
            int n = ps.executeUpdate();
            System.out.println("¡Los datos han sido guardados exitósamente!" + n);
            if (n >= 0) {
                JOptionPane.showMessageDialog(null, "¡Los datos han sido guardados exitósamente!");
                System.out.println("¡Los datos han sido guardados exitósamente!" + n);
                limpiarventanas();
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error en la base de datos");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CapturaInventario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnayuda;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox jcestatus;
    private javax.swing.JComboBox jcfamilia;
    private javax.swing.JComboBox jcgenero;
    private javax.swing.JComboBox jcgrupo;
    private javax.swing.JComboBox jcprocedencia;
    private javax.swing.JComboBox jcproveedor;
    private javax.swing.JLabel lblcodigobarras;
    private javax.swing.JLabel lblcodigosounds;
    private javax.swing.JLabel lbldescripcion;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblproveedor;
    private javax.swing.JTextField txtcodigobarras;
    private javax.swing.JTextField txtcodigoproveedor;
    private javax.swing.JTextField txtcodigosounds;
    private javax.swing.JTextField txtdescripcion;
    // End of variables declaration//GEN-END:variables
}
