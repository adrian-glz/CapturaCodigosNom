/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRINCIPAL;

import javax.swing.ImageIcon;

/**
 *
 * @author agonzalez
 */
public class Agregafamilia extends javax.swing.JFrame {
 
    public Agregafamilia() {
        initComponents();
          setIconImage(new ImageIcon(getClass().getResource("/recursos/logo.png")).getImage());
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtnuevafamilia = new javax.swing.JTextField();
        btnagregafamilia = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Añadir familia");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nueva familia:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 41, 90, 30));

        txtnuevafamilia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnuevafamiliaKeyTyped(evt);
            }
        });
        getContentPane().add(txtnuevafamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 260, 30));

        btnagregafamilia.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnagregafamilia.setText("agregar");
        getContentPane().add(btnagregafamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 180, 30));

        jLabel2.setText("  ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtnuevafamiliaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnuevafamiliaKeyTyped
        if (txtnuevafamilia.getText().length() > 0) {
            btnagregafamilia.setEnabled(true);
        } else {
            btnagregafamilia.setEnabled(false);
        }
    }//GEN-LAST:event_txtnuevafamiliaKeyTyped

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
            java.util.logging.Logger.getLogger(Agregafamilia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agregafamilia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agregafamilia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agregafamilia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregafamilia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregafamilia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtnuevafamilia;
    // End of variables declaration//GEN-END:variables
}
