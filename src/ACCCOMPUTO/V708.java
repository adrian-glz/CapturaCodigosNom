

package ACCCOMPUTO;

 
 
import JDBC.Conexion;
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
import java.sql.Connection;
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
public final class V708 extends javax.swing.JFrame {

    Statement st;
    PreparedStatement ps = null;
    ResultSet rs;
    int Vnacional;
    DefaultListModel modelo = new DefaultListModel();
    public static String incluye = " ";

    public V708() {
        initComponents();
        lblcodigo.setText(codigo);
        llenarcolor();
        llenartipo();
        llenarvelocidad();
        llenarconexion();
        llenarlistaincluye();
     }

    public void llenarcolor() {
        cbcolor.removeAllItems();
        try {
               Conexion con = new Conexion();
            Connection conn = con.getConnection();
            st = conn.createStatement();
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

   
   
    public void llenarvelocidad() {
        cbvelocidad.removeAllItems();
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            st = conn.createStatement();
            st.executeUpdate("use NOMS;");
            rs = st.executeQuery("select * from RedesVelocidad order by  elemento desc");

            while (rs.next()) {
                String elemento = rs.getString("elemento");
                cbvelocidad.addItem(elemento);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            JOptionPane.showMessageDialog(this, "Problemas con la conexion verifique o vuelva a intentar");

            e.printStackTrace();
            return;
        }
    }

    public void llenartipo() {
        cbtipo.removeAllItems();
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            st = conn.createStatement();
            st.executeUpdate("use NOMS;");
            rs = st.executeQuery("select * from RedesTipo order by  elemento desc");

            while (rs.next()) {
                String elemento = rs.getString("elemento");
                cbtipo.addItem(elemento);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            JOptionPane.showMessageDialog(this, "Problemas con la conexion verifique o vuelva a intentar");

            e.printStackTrace();
            return;
        }
    }

    public void llenarconexion() {
        cbconexion.removeAllItems();
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            st = conn.createStatement();
            st.executeUpdate("use NOMS;");
            rs = st.executeQuery("select * from Redesconexion order by  elemento desc");

            while (rs.next()) {
                String elemento = rs.getString("elemento");
                cbconexion.addItem(elemento);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            JOptionPane.showMessageDialog(this, "Problemas con la conexion verifique o vuelva a intentar");

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

    public void eliminarelementolista() {

        DefaultListModel model2 = (DefaultListModel) lfinal.getModel();

        Object elementos = (String) lfinal.getSelectedValue();

        int filaseleccionada = lfinal.getSelectedIndex();
        //  System.out.println("fila>>"+filaseleccionada);
        if (filaseleccionada >= 0) {

               int selectedIndex = lfinal.getSelectedIndex();
            if (selectedIndex != -1) {

                model2.remove(lfinal.getSelectedIndex());///remueve valor de tabla
            }

        } else {
            JOptionPane.showMessageDialog(this, "No ha seleccionado ninguna fila o la tabla está vacía");
            
        }

    }

    public void insertarcodigo() {
        variableincluye();
        comparacionnacional();

         String color = cbcolor.getSelectedItem().toString();
        String velocidad = cbvelocidad.getSelectedItem().toString();
        String tipo = cbtipo.getSelectedItem().toString();
         int g = Integer.parseInt(genero);
 
        try {
             Conexion con = new Conexion();
            Connection conn = con.getConnection();
            st = conn.createStatement();
            st.executeUpdate("USE NOMS;");

            ps = conn.prepareStatement("insert into noms1web (codigo,Codigo2,descripcion,nacional,Grupo,descgrupo,Genero,"
                    + "descgenero,CostoUni,PrecioVenta,PrecioOferta,Ahorro,Utilidad,Margen,marca,hecho,importador,exportador,FechaAct,categoriaweb,campo1,campo2,campo3,campo4,campo5,campo6,campo7,campo8,campo9,campo10,campo11,campo12)\n"
                    + "VALUES\n"
                    + "('" + codigo + "','" + codigo2 + "','" + descripcion + "','" + Vnacional + "','" + grupo + "','" + descgrupo + "','" + g + "','" + descgenero + "','" + costounitario + "','" + precioventa + "','" + preciooferta + "','" + ahorro + "','" + utilidad + "','" + margen + "','" + marca + "','" + hecho + "','" + importador + "','" + exportador + "',getdate(),'" + categoriaweb + "' "
                    + ",'" + "TIPO " + tipo + "','" + "VELOCIDAD " + velocidad + "','" + "COLOR " + color + "','"+"INCLUYE "+incluye+"','null','null','null','null','null','null','null','null')");
                 
//   + ",'" + "TAMAÑO  " + tamano + "','"  +"CONEXION "+   cone + "' ,'"+"COLOR "+color+"','"  + "INCLUYE " + incluye + "','null','null'null','null','null','null','null','null')");

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
    }

    public void llenarlistaincluye() {

        lincluye.removeAll();
        DefaultListModel modelo = new DefaultListModel();
        try {
                 Conexion con = new Conexion();
            Connection conn = con.getConnection();
            st = conn.createStatement();
            st.executeUpdate("USE NOMS;");
            rs = st.executeQuery("SELECT * FROM RedesIncluye order by  elemento asc");

            while (rs.next()) {
                modelo.addElement(rs.getString("elemento"));
            }
            lincluye.setModel(modelo);
            st.close();
        } catch (Exception e) {
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lincluye = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbcolor = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        lfinal = new javax.swing.JList();
        jLabel9 = new javax.swing.JLabel();
        btnpasalista = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnrefrescar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbvelocidad = new javax.swing.JComboBox();
        cbtipo = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cbconexion = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btngrabar = new javax.swing.JToggleButton();
        jLabel13 = new javax.swing.JLabel();
        lblcodigo = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnregresar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        btnagregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de captura codigos");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lincluye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lincluyeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lincluye);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 170, 100));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Incluye:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 82, 35));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Color:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 80, 30));

        jPanel1.add(cbcolor, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 171, 35));

        lfinal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lfinalMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(lfinal);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 171, 100));

        jLabel9.setText(" ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 60, -1));

        btnpasalista.setText(">");
        btnpasalista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpasalistaActionPerformed(evt);
            }
        });
        jPanel1.add(btnpasalista, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, -1, -1));

        jButton1.setText("x");
        jButton1.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 40, 20));

        btnrefrescar.setText("Refrescar");
        btnrefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefrescarActionPerformed(evt);
            }
        });
        jPanel1.add(btnrefrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 110, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Velocidad:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 90, 30));

        cbvelocidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbvelocidadActionPerformed(evt);
            }
        });
        jPanel1.add(cbvelocidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 171, 35));

        cbtipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtipoActionPerformed(evt);
            }
        });
        jPanel1.add(cbtipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 171, 35));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Tipo:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 90, 30));

        cbconexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbconexionActionPerformed(evt);
            }
        });
        jPanel1.add(cbconexion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 171, 35));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Conexion:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 90, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 700, 390));

        jLabel1.setText(" ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, 10, 20));

        btngrabar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btngrabar.setForeground(new java.awt.Color(0, 153, 0));
        btngrabar.setText("Grabar");
        btngrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngrabarActionPerformed(evt);
            }
        });
        getContentPane().add(btngrabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, 180, 60));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("CODIGO:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 68, 43));

        lblcodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(lblcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 230, 43));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("GENERO:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 90, 43));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("REDES");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 260, 40));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 510, 70, -1));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, 60, 20));

        btnregresar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnregresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/volver.png"))); // NOI18N
        btnregresar.setText("Regresar");
        btnregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 210, 60));

        jLabel19.setText(" ");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 500, 90, 30));

        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/nueva.png"))); // NOI18N
        btnagregar.setText("Agregar nuevo elemento");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 270, 60));

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

    private void btnpasalistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpasalistaActionPerformed
        agregarelementolista();
    }//GEN-LAST:event_btnpasalistaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         eliminarelementolista();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnrefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefrescarActionPerformed
        llenarcolor();
        llenartipo();
        llenarvelocidad();
        llenarlistaincluye();
    }//GEN-LAST:event_btnrefrescarActionPerformed

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

    private void cbvelocidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbvelocidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbvelocidadActionPerformed

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
        this.dispose();
        CapturaCodigo cc = new CapturaCodigo();
        cc.setVisible(true);
    }//GEN-LAST:event_btnregresarActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        NuevaOpcion m = new NuevaOpcion();
        m.setVisible(true);

    }//GEN-LAST:event_btnagregarActionPerformed

    private void cbtipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbtipoActionPerformed

    private void cbconexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbconexionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbconexionActionPerformed

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
            java.util.logging.Logger.getLogger(V708.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(V708.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(V708.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(V708.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new V708().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JToggleButton btngrabar;
    private javax.swing.JButton btnpasalista;
    private javax.swing.JButton btnrefrescar;
    private javax.swing.JButton btnregresar;
    private javax.swing.JComboBox cbcolor;
    private javax.swing.JComboBox cbconexion;
    private javax.swing.JComboBox cbtipo;
    private javax.swing.JComboBox cbvelocidad;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JList lfinal;
    private javax.swing.JList lincluye;
    // End of variables declaration//GEN-END:variables
}
