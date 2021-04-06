/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PRINCIPAL;

import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.DefaultEditorKit;

/**
 *
 * @author AGONZALEZ
 */
public class VerCodigos extends javax.swing.JFrame {

    ResultSet rs;

    DefaultTableModel md;
    Statement st;
    /**
     * Creates new form Vercodigos
     */
    public VerCodigos() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/recursos/logo.png")).getImage());
       tblcodigos.requestFocusInWindow();

        llenartable();
        contador();
    }

  public void contador() {

    
         try {
          Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            st = conexion.createStatement();
            st.executeUpdate("use noms");

            //Seleccionar datos
            rs = st.executeQuery("select count (*) from noms1web  ");
          
     
            try {
              
                while (rs.next()) {
                    
                    Object[] fila = (new Object[]{rs.getString(1)});
                    String c=rs.getString(1);
                    
                    lblcontador.setText(c+" Registro(s)");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VerCodigos.class.getName()).log(Level.SEVERE, null, ex);
        }
 
  
  
  }
 
      public void llenartable() {

      String data[][] = {};
      String cabeza[] = {"Codigo", "Fecha","Genero"};///definimos nombre cada columna en encabezado

      md = new DefaultTableModel(data, cabeza) {
          @Override
          public boolean isCellEditable(int row, int column) {
          
              for (int i = 0; i <1; i++) {
                  if (column == i) {//editar solo la columna 4
                      return true;  //La columna 4 es editable.
                  }

              }
    return false;  //El resto de celdas no son editables.
            }
          };
          
      
      
        tblcodigos.setModel(md); //igualamos en modelo en jplatos
        JTableHeader th;
        th = tblcodigos.getTableHeader();
        th.setFont(new java.awt.Font("tahoma", 0, 15));//seteamos fuente en el header
        //Centrar el encabezado de la tabla
        TableCellRenderer rendererFromHeader = tblcodigos.getTableHeader().getDefaultRenderer();//
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.LEFT); 

       
        tblcodigos.getColumnModel().getColumn(0).setPreferredWidth(200); //Matrícula
        tblcodigos.getColumnModel().getColumn(0).setMaxWidth(200);
        tblcodigos.getColumnModel().getColumn(0).setMinWidth(200);

        tblcodigos.getColumnModel().getColumn(1).setPreferredWidth(200); //Nombre
        tblcodigos.getColumnModel().getColumn(1).setMaxWidth(500);
        tblcodigos.getColumnModel().getColumn(1).setMinWidth(200);
       
        tblcodigos.getColumnModel().getColumn(2).setPreferredWidth(200); //Nombre
        tblcodigos.getColumnModel().getColumn(2).setMaxWidth(500);
        tblcodigos.getColumnModel().getColumn(2).setMinWidth(200);

       
 
         //Conexión a la BD
     
         try {
          Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            st = conexion.createStatement();
            st.executeUpdate("use noms");

            //Seleccionar datos
            rs = st.executeQuery("select codigo, genero, fechaact from noms1web order by FechaAct");
            md = (DefaultTableModel) tblcodigos.getModel();
            md.setRowCount(0);
            try {
              
                while (rs.next()) {
                    
                    Object[] fila = (new Object[]{rs.getString(1), rs.getString(3), rs.getString(2)});
                    md.addRow(fila);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VerCodigos.class.getName()).log(Level.SEVERE, null, ex);
        } }
    
    
       public void ayudaboton() {

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            st = conexion.createStatement();
            st.executeUpdate("use noms;");
            rs = st.executeQuery("select * from ayudausuario where id=3");

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
             //   System.out.println(nc);
                  JOptionPane.showMessageDialog(null, nc.trim());

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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblcodigos = new javax.swing.JTable();
        btnayudar = new javax.swing.JButton();
        btnvolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnrefrescar = new javax.swing.JButton();
        lblcontador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de captura codigos");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Codigos capturados: ");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 250, 60));

        tblcodigos.setAutoCreateRowSorter(true);
        tblcodigos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblcodigos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblcodigos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblcodigos.setRowHeight(20);
        tblcodigos.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(tblcodigos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 84, 650, 350));

        btnayudar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ayuda (2).png"))); // NOI18N
        btnayudar.setContentAreaFilled(false);
        btnayudar.setFocusPainted(false);
        btnayudar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ayuda (2).png"))); // NOI18N
        btnayudar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ayuda (2)60.png"))); // NOI18N
        btnayudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnayudarActionPerformed(evt);
            }
        });
        getContentPane().add(btnayudar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 90, 70));

        btnvolver.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnvolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/home.png"))); // NOI18N
        btnvolver.setText("Volver");
        btnvolver.setToolTipText("");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnvolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 450, 50));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 500, 100, 30));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 10, 30));

        btnrefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/r.png"))); // NOI18N
        btnrefrescar.setText("Refrescar");
        btnrefrescar.setContentAreaFilled(false);
        btnrefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefrescarActionPerformed(evt);
            }
        });
        getContentPane().add(btnrefrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 140, 50));

        lblcontador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblcontador.setForeground(new java.awt.Color(0, 51, 255));
        getContentPane().add(lblcontador, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 170, 60));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnayudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnayudarActionPerformed
        ayudaboton();
    }//GEN-LAST:event_btnayudarActionPerformed

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        this.dispose();
        Menu m = new Menu();
        m.setVisible(true);
    }//GEN-LAST:event_btnvolverActionPerformed

    private void btnrefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefrescarActionPerformed
        llenartable();
        contador();
    }//GEN-LAST:event_btnrefrescarActionPerformed

    
    
    public static void main(String args[]) throws InstantiationException, UnsupportedLookAndFeelException, IllegalAccessException {
     
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VerCodigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
   
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerCodigos().setVisible(true); 
                
            }
        });
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnayudar;
    private javax.swing.JButton btnrefrescar;
    private javax.swing.JButton btnvolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblcontador;
    public javax.swing.JTable tblcodigos;
    // End of variables declaration//GEN-END:variables
}
