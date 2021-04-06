/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PRINCIPAL;

import javax.swing.ImageIcon;

/**
 *
 * @author AGONZALEZ
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/recursos/logo.png")).getImage());
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btncapturanom = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnopcionmultiple = new javax.swing.JButton();
        btneliminarcodigo = new javax.swing.JButton();
        btnvisualiza = new javax.swing.JButton();
        btnopcionmultiple1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Bienvenido");
        setAutoRequestFocus(false);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btncapturanom.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btncapturanom.setForeground(new java.awt.Color(255, 255, 255));
        btncapturanom.setText("Captura de nom");
        btncapturanom.setBorder(null);
        btncapturanom.setBorderPainted(false);
        btncapturanom.setContentAreaFilled(false);
        btncapturanom.setFocusPainted(false);
        btncapturanom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncapturanomActionPerformed(evt);
            }
        });
        getContentPane().add(btncapturanom, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 37, 280, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Ver 1.2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, 50, 20));

        btnopcionmultiple.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnopcionmultiple.setForeground(new java.awt.Color(255, 255, 255));
        btnopcionmultiple.setText("Insertar nueva opcion");
        btnopcionmultiple.setContentAreaFilled(false);
        btnopcionmultiple.setFocusPainted(false);
        btnopcionmultiple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnopcionmultipleActionPerformed(evt);
            }
        });
        getContentPane().add(btnopcionmultiple, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 285, 280, 50));

        btneliminarcodigo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btneliminarcodigo.setForeground(new java.awt.Color(255, 255, 255));
        btneliminarcodigo.setText("Eliminar codigo");
        btneliminarcodigo.setContentAreaFilled(false);
        btneliminarcodigo.setFocusPainted(false);
        btneliminarcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarcodigoActionPerformed(evt);
            }
        });
        getContentPane().add(btneliminarcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 280, 50));

        btnvisualiza.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnvisualiza.setForeground(new java.awt.Color(255, 255, 255));
        btnvisualiza.setText("Ver codigos capturados");
        btnvisualiza.setContentAreaFilled(false);
        btnvisualiza.setFocusPainted(false);
        btnvisualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvisualizaActionPerformed(evt);
            }
        });
        getContentPane().add(btnvisualiza, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 205, 280, 50));

        btnopcionmultiple1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnopcionmultiple1.setForeground(new java.awt.Color(255, 255, 255));
        btnopcionmultiple1.setText("Cerrar");
        btnopcionmultiple1.setContentAreaFilled(false);
        btnopcionmultiple1.setFocusPainted(false);
        btnopcionmultiple1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnopcionmultiple1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnopcionmultiple1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 280, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ta_1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnopcionmultipleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnopcionmultipleActionPerformed
        NuevaOpcion m = new NuevaOpcion();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnopcionmultipleActionPerformed

    private void btncapturanomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncapturanomActionPerformed
        CapturaCodigo m = new CapturaCodigo();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btncapturanomActionPerformed

    private void btneliminarcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarcodigoActionPerformed
        EliminaCodigo m = new EliminaCodigo();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btneliminarcodigoActionPerformed

    private void btnvisualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvisualizaActionPerformed
        VerCodigos m = new VerCodigos();
        m.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnvisualizaActionPerformed

    private void btnopcionmultiple1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnopcionmultiple1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnopcionmultiple1ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncapturanom;
    private javax.swing.JButton btneliminarcodigo;
    private javax.swing.JButton btnopcionmultiple;
    private javax.swing.JButton btnopcionmultiple1;
    private javax.swing.JButton btnvisualiza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
