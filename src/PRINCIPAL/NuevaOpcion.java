/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PRINCIPAL;

import JDBC.Conexion;
import static PRINCIPAL.CapturaCodigo.genero;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AGONZALEZ
 */

public class NuevaOpcion extends javax.swing.JFrame {

    /**
     * Creates new form NuevaOpcion
     */
    Statement st;
    PreparedStatement ps = null;
    ResultSet rs;
    DefaultTableModel md;
   
    public NuevaOpcion() {
//       
        initComponents();
         setIconImage(new ImageIcon(getClass().getResource("/recursos/logo.png")).getImage());
        txt_nuevo.requestFocusInWindow();
         
         
         llenarcombobox();
        btnagregar.setEnabled(false);

    }
    
    public void eliminarelemento(){
        String ES2 = cbtablas.getSelectedItem().toString();
        int filaseleccionada = tbl_elementos.getSelectedRow();
        //    System.out.println("itemcodigo>>>>>"+filaseleccionada);
        if (filaseleccionada >= 0) {

            Object itemcodigo = (tbl_elementos.getValueAt(filaseleccionada, 0));//caja

            String velemento = itemcodigo.toString();

            try {
                Conexion con = new Conexion();
                Connection conn = con.getConnection();
                st = conn.createStatement();
                st.executeUpdate("USE NOMS;");
//            System.out.println(ES + TE + "<<<<<<<<");

                String p1 = "delete from " + ES2;
                String p2 = " where Elemento  ='" + velemento + "'";
                String queryf = "" + p1 + p2;

                /// System.out.println(">>>>>>"+queryf);
                ps = conn.prepareStatement(queryf);
                int n = ps.executeUpdate();

                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "¡Se elimino: " + velemento);
                    st.close();
                    llenartabla();
               txt_nuevo.setText("");
                }
            } catch (HeadlessException | SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Error en la base de datos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "¡Seleccione un elemento de la tabla!");

        }

    }

    public void agregarnuevoelemento() {
        String ES2 = cbtablas.getSelectedItem().toString();
        String TE = txt_nuevo.getText().toUpperCase();
        try {
          Conexion con = new Conexion();
            Connection conn = con.getConnection();
            st = conn.createStatement();
            st.executeUpdate("USE NOMS;");
//            System.out.println(ES + TE + "<<<<<<<<");

            String p1 = "insert into " + ES2;
            String p2 = " (Elemento)  values ('" + TE + "')";
            String queryf = "" + p1 + p2;

            //System.out.println(">>>>>>"+queryf);
            ps = conn.prepareStatement(queryf);
            int n = ps.executeUpdate();

            if (n > 0) {
                JOptionPane.showMessageDialog(null, "¡Los datos han sido guardados exitósamente!");
                st.close();
                txt_nuevo.setText("");
                btnagregar.setEnabled(false);
                llenartabla();

            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error en la base de datos");
        }

    }

    public void llenarcombobox() {

        Statement st;
        PreparedStatement ps = null;
        ResultSet rs;
        cbtablas.removeAllItems();
        try {
      Conexion con = new Conexion();
            Connection conn = con.getConnection();
            st = conn.createStatement();
            st.executeUpdate("use NOMS;");
            rs = st.executeQuery("select TABLE_NAME from INFORMATION_SCHEMA.TABLES \n"
                    + "where TABLE_NAME not in ('ayudausuario','noms1web','noms1webatributos')\n"
                    + "order by  TABLE_NAME ASC ");

            while (rs.next()) {
                String elemento = rs.getString(1);
                //System.out.println("elemento: " + elemento);
                cbtablas.addItem(elemento);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            JOptionPane.showMessageDialog(this, "Problemas con la conexion verifique o vuelva a intentar" + genero);

            e.printStackTrace();
            return;
        }
    }

    public void llenartabla() {
        String ES = cbtablas.getSelectedItem().toString();
        String ES2 = " order by  elemento ASC";

        try {

              Conexion con = new Conexion();
            Connection conn = con.getConnection();
            st = conn.createStatement();
            st.executeUpdate("USE NOMS;");
            rs = st.executeQuery("select * from " + ES + ES2);
            md = (DefaultTableModel) tbl_elementos.getModel();
            md.setRowCount(0);
            while (rs.next()) {

                Object[] fila = {rs.getString("elemento")};
                md.addRow(fila);

            }
            st.close();
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error en la base de datos");
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
        jLabel1 = new javax.swing.JLabel();
        txt_nuevo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbtablas = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_elementos = new javax.swing.JTable();
        btnrefrescar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnagregar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnvolver = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Añadir nueva opcion multiple");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nueva caracteristica a añadir:");

        txt_nuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nuevoKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Elige la tabla donde se va a insertar: ");

        cbtablas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtablasActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Contenido de tabla:");

        tbl_elementos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_elementos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Elementos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_elementos);
        if (tbl_elementos.getColumnModel().getColumnCount() > 0) {
            tbl_elementos.getColumnModel().getColumn(0).setResizable(false);
        }

        btnrefrescar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnrefrescar.setText("Ver contenido/Refrescar");
        btnrefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefrescarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnagregar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/agregar.png"))); // NOI18N
        btnagregar.setText("Agregar");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        btneliminar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/eliminar.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnvolver.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnvolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/home (2).png"))); // NOI18N
        btnvolver.setText("Volver");
        btnvolver.setToolTipText("");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnvolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnagregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnvolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbtablas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txt_nuevo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnrefrescar, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbtablas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnrefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 810, 360));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 130, 10, 90));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbtablasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtablasActionPerformed
        llenartabla();

    }//GEN-LAST:event_cbtablasActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        agregarnuevoelemento();
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btnrefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefrescarActionPerformed
        llenartabla();
    }//GEN-LAST:event_btnrefrescarActionPerformed

    private void txt_nuevoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nuevoKeyReleased
        String jc = txt_nuevo.getText();
        btnagregar.setEnabled(
                jc.length() != 0
        );
    }//GEN-LAST:event_txt_nuevoKeyReleased

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        eliminarelemento();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        this.dispose();
        Menu m = new Menu();
        m.setVisible(true);
    }//GEN-LAST:event_btnvolverActionPerformed

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
            java.util.logging.Logger.getLogger(NuevaOpcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaOpcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaOpcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaOpcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevaOpcion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnrefrescar;
    private javax.swing.JButton btnvolver;
    private javax.swing.JComboBox cbtablas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_elementos;
    private javax.swing.JTextField txt_nuevo;
    // End of variables declaration//GEN-END:variables
}
