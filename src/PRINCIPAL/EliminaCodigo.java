/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PRINCIPAL;

import JDBC.Conexion;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
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

/**
 *
 * @author AGONZALEZ
 */
public class EliminaCodigo extends javax.swing.JFrame {

     
    Statement st;
    PreparedStatement ps = null;
    ResultSet rs;

    public EliminaCodigo() {
        initComponents();
         setIconImage(new ImageIcon(getClass().getResource("/recursos/logo.png")).getImage());
    txt_cod.requestFocusInWindow();
           
    }

    public void existecodigo() {

        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            st = conn.createStatement();   st.executeUpdate("use noms");
            rs = st.executeQuery("select  codigo from noms1web where codigo='" + txt_cod.getText() + "'");

            boolean variable = rs.next();

            String s1 = Boolean.toString(variable);
             try {
                if (s1.equals("false")) {
                    while (rs.next()) {///
                    }

                    JOptionPane.showMessageDialog(null, "El codigo: " + txt_cod.getText() + " No existe o esta mal escrito", "Alerta", JOptionPane.WARNING_MESSAGE);

                } else {

                    int result = JOptionPane.showConfirmDialog(null, "Seguro que quiere Eliminar el codigo " + txt_cod.getText().trim() + "?", "ATENCION",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);

                    if (result == JOptionPane.YES_OPTION) {
                        eliminarcodigo();

                    } else if (result == JOptionPane.NO_OPTION) {

                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }

    }


    public void ayudaboton() {

        try {
        Conexion con = new Conexion();
            Connection conn = con.getConnection();
            st = conn.createStatement();
            st.executeUpdate("use noms;");
            rs = st.executeQuery("select * from ayudausuario where id=2");

            while (rs.next()) {

                String R1 = rs.getString(2);
                String R2 = rs.getString(3);
                String R3 = rs.getString(4);
                String R4 = rs.getString(5);
                String R5 = rs.getString(6);
                String R6 = rs.getString(7);
                String R7 = rs.getString(8);
                String R8 = rs.getString(9);
                String R9 = rs.getString(10);
                String R10 = rs.getString(11);
                String cadenas = R1 + "\n" + R2 + "\n" + R3 + "\n" + R4 + "\n" + R5 + "\n"
                        + R6 + "\n" + R7 + "\n" + R8 + "\n" + R9 + "\n" + R10 + "\n";

                String nc = cadenas.replaceAll("null", "");
                System.out.println(nc);

                JOptionPane.showMessageDialog(null, nc.trim());

            }
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
    }

    public void eliminarcodigo(){
    
        try {
              Conexion con = new Conexion();
            Connection conn = con.getConnection();
            st = conn.createStatement();
            st.executeUpdate("use noms");
            String query = "delete from noms1web where codigo= '" + txt_cod.getText() + "' ";
            ps = conn.prepareStatement(query);
            int n = ps.executeUpdate();

            if (n > 0) {
                JOptionPane.showMessageDialog(null, "¡Se elimino el codigo: " + txt_cod.getText().trim());
                st.close();
                txt_cod.setText("");
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error en la base de datos");
        }

    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_cod = new javax.swing.JTextField();
        btneliminar = new javax.swing.JButton();
        btnayudar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnvolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de captura codigos");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Insertar el codigo a eliminar:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 210, 40));

        txt_cod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codKeyPressed(evt);
            }
        });
        getContentPane().add(txt_cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 240, 40));

        btneliminar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btneliminar.setForeground(new java.awt.Color(255, 0, 0));
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 190, 50));

        btnayudar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnayudar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ayuda (2).png"))); // NOI18N
        btnayudar.setText("  AYUDA");
        btnayudar.setContentAreaFilled(false);
        btnayudar.setFocusPainted(false);
        btnayudar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ayuda (2).png"))); // NOI18N
        btnayudar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ayuda (2)60.png"))); // NOI18N
        btnayudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnayudarActionPerformed(evt);
            }
        });
        getContentPane().add(btnayudar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 240, 50));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 70, 20));

        btnvolver.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnvolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/home.png"))); // NOI18N
        btnvolver.setText("Volver");
        btnvolver.setToolTipText("");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnvolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 190, 50));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnayudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnayudarActionPerformed
           ayudaboton(); 
    }//GEN-LAST:event_btnayudarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        existecodigo(); 
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        this.dispose();
        Menu m = new Menu();
        m.setVisible(true);
    }//GEN-LAST:event_btnvolverActionPerformed

    private void txt_codKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                 existecodigo();
          }
    }//GEN-LAST:event_txt_codKeyPressed

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
            java.util.logging.Logger.getLogger(EliminaCodigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminaCodigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminaCodigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminaCodigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminaCodigo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnayudar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnvolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txt_cod;
    // End of variables declaration//GEN-END:variables
}
