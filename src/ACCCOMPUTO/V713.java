package ACCCOMPUTO;

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
import static COMPUTO.V250.incluye;
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
public class V713 extends javax.swing.JFrame {
    Statement st;
    PreparedStatement ps = null;
    ResultSet rs;
    int Vnacional;
    DefaultListModel modelo = new DefaultListModel();
    public static String incluye = " ";

    public V713() {
        initComponents();
        lblcodigo.setText(codigo);
        rendimiento();
        marca();
        tipo();
    }

    public void rendimiento() {
        cbrendimiento.removeAllItems();
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            st = conexion.createStatement();
            st.executeUpdate("use noms;");
            rs = st.executeQuery("SELECT * FROM CartuchoTinRendimiento order by  elemento DESC");

            while (rs.next()) {
                String elemento = rs.getString("elemento");
                cbrendimiento.addItem(elemento);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }

    }

    public void marca() {
        cbmarca.removeAllItems();
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            st = conexion.createStatement();
            st.executeUpdate("use noms;");
            rs = st.executeQuery("SELECT * FROM CartuchoTinMarca order by  elemento ASC");

            while (rs.next()) {
                String elemento = rs.getString("elemento");
                cbmarca.addItem(elemento);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }

    }
    
     public void tipo() {
        cbtipo.removeAllItems();
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            st = conexion.createStatement();
            st.executeUpdate("use noms;");
            rs = st.executeQuery("SELECT * FROM cartuchotipo order by  elemento ASC");

            while (rs.next()) {
                String elemento = rs.getString("elemento");
                cbtipo.addItem(elemento);
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
        String tipo = cbtipo.getSelectedItem().toString();
        String marca = cbmarca.getSelectedItem().toString();
        String rendimiento = cbrendimiento.getSelectedItem().toString();

        int g = Integer.parseInt(genero);

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            Statement st = conexion.createStatement();
            st.executeUpdate("use noms;");

         ps = conexion.prepareStatement("insert into noms1web (codigo,Codigo2,descripcion,nacional,Grupo,descgrupo,Genero,"
                    + "descgenero,CostoUni,PrecioVenta,PrecioOferta,Ahorro,Utilidad,Margen,marca,hecho,importador,exportador,FechaAct,categoriaweb,campo1,campo2,campo3,campo4,campo5,campo6,campo7,campo8,campo9,campo10,campo11,campo12)\n"
                    + "VALUES\n"
                    + "('" + codigo + "','" + codigo2 + "','" + descripcion + "','" + Vnacional + "','" + grupo + "','" + descgrupo + "','" + g + "','" + descgenero + "','" + costounitario + "','" + precioventa + "','" + preciooferta + "','" + ahorro + "','" + utilidad + "','" + margen + "','" + marca + "','" + hecho + "','" + importador + "','" + exportador + "',getdate(),'" + categoriaweb + "' "
            + ",'" + "RENDIMIENTO "+ rendimiento  + "','" +"TAMAÑO "+ tipo + "','" +"MARCA "+marca+ "','"+"null','null','null','null','null','null','null','null','null')");
         
            
            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "¡Los datos han sido guardados exitósamente!");
                st.close();
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error en la base de datos" + ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(V713.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbmarca = new javax.swing.JComboBox();
        cbrendimiento = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cbtipo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        btnrefrescar = new javax.swing.JButton();
        btnguardar = new javax.swing.JToggleButton();
        jLabel11 = new javax.swing.JLabel();
        lblcodigo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnagregar = new javax.swing.JButton();
        btnregresar2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de captura codigos");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Marca:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 70, 30));

        jPanel1.add(cbmarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 170, 35));

        cbrendimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbrendimientoActionPerformed(evt);
            }
        });
        jPanel1.add(cbrendimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 30, 160, 35));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Rendimiento :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 90, 30));

        jPanel1.add(cbtipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 170, 35));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Tipo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 70, 30));

        btnrefrescar.setText("refrescar");
        btnrefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefrescarActionPerformed(evt);
            }
        });
        jPanel1.add(btnrefrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 100, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 650, 370));

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(0, 153, 0));
        btnguardar.setText("Grabar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, 160, 60));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("GENERO:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 68, 43));

        lblcodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(lblcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 230, 43));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("CARTUCHOS/TINTA DE IMPRESORAS ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 240, 40));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("CODIGO:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 68, 43));

        jLabel18.setText(" ");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 490, 90, 30));

        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/nueva.png"))); // NOI18N
        btnagregar.setText("Agregar nuevo elemento");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 250, 60));

        btnregresar2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnregresar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/volver.png"))); // NOI18N
        btnregresar2.setText("Regresar");
        btnregresar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresar2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnregresar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 210, 60));

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

    private void cbrendimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbrendimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbrendimientoActionPerformed

    private void btnrefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefrescarActionPerformed
    rendimiento();
        marca();
        tipo();
    }//GEN-LAST:event_btnrefrescarActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        NuevaOpcion m = new NuevaOpcion();
        m.setVisible(true);
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btnregresar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresar2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        CapturaCodigo cc = new CapturaCodigo();
        cc.setVisible(true);
    }//GEN-LAST:event_btnregresar2ActionPerformed
      
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
            java.util.logging.Logger.getLogger(V713.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(V713.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(V713.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(V713.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new V713().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JToggleButton btnguardar;
    private javax.swing.JButton btnrefrescar;
    private javax.swing.JButton btnregresar2;
    private javax.swing.JComboBox cbmarca;
    private javax.swing.JComboBox cbrendimiento;
    private javax.swing.JComboBox cbtipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblcodigo;
    // End of variables declaration//GEN-END:variables
}
