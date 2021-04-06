/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ACCELECTRONICA;


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
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author AGONZALEZ
 */
public class V1503 extends javax.swing.JFrame {
    
    Statement st;
    PreparedStatement ps = null;
    ResultSet rs;
    DefaultListModel modelo = new DefaultListModel();
    int Vnacional;
    public static String incluye = " ";
    /**
     * Creates new form V141
     */
    public V1503() {
        initComponents();
          setIconImage(new ImageIcon(getClass().getResource("/recursos/logo.png")).getImage());
        llenartipo();
        llenarcolor();
        llenarconectividad();
        llenarlistaincluye();
        linea();
      
    }

    public void comparacionnacional() {
        if (nacional.equals("NACIONAL")) {
            Vnacional = 1;
        }
        if (nacional.equals("AMERICANO")) {
            Vnacional = 0;
        }

    }

    public void tag(){
    
    }
    
    
    
    public void linea() {

        cblinea.removeAllItems();
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            st = conexion.createStatement();
            st.executeUpdate("use noms;");
            rs = st.executeQuery("SELECT * FROM audifonoslinea");

            while (rs.next()) {
                String elemento = rs.getString("elemento");
                cblinea.addItem(elemento);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            JOptionPane.showMessageDialog(this, "Problemas con la conexion verifique o vuelva a intentar" + genero);

            e.printStackTrace();
            return;
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
            rs = st.executeQuery("SELECT * FROM audifonoincluye order by  elemento asc");

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

    public void llenartipo() {
        cbtipo.removeAllItems();
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            st = conexion.createStatement();
            st.executeUpdate("USE NOMS;");
            rs = st.executeQuery("SELECT * FROM audifonotipo order by  elemento asc");

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

    public void llenarconectividad() {
        cbconectividad.removeAllItems();
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            st = conexion.createStatement();
            st.executeUpdate("USE NOMS;");
            rs = st.executeQuery("SELECT * FROM audifonoconexion order by  elemento asc");

            while (rs.next()) {
                String elemento = rs.getString("elemento");
                cbconectividad.addItem(elemento);
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

        String recargable = cbrecargable.getSelectedItem().toString();
        String conectividad = cbconectividad.getSelectedItem().toString();
        String tipo = cbtipo.getSelectedItem().toString();
        String color = cbcolor.getSelectedItem().toString();
        String manoslibres = cbmlibres.getSelectedItem().toString();
        String linea = cblinea.getSelectedItem().toString();
       String ipx = cbipx.getSelectedItem().toString();
        int g = Integer.parseInt(genero);

        
               if (recargable.equals("SI")) {
            recargable = "RECARGABLE";

        }
        if (recargable.equals("NO")) {
            recargable = "NO RECARGABLE";
        }
 
        if (manoslibres.equals("SI")) {
            manoslibres = "MANOS LIBRES";

        }
        if (manoslibres.equals("NO")) {
            manoslibres = "SIN MANOS LIBRES";
        }

        if (ipx.equals("SI")) {
            ipx = "IPX";

        }
        if (ipx.equals("NO")) {
            ipx = "SIN IPX";
        }

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            Statement st = conexion.createStatement();
            st.executeUpdate("USE NOMS;");

            ps = conexion.prepareStatement("insert into noms1web (codigo,Codigo2,descripcion,nacional,Grupo,descgrupo,Genero,"
                    + "descgenero,CostoUni,PrecioVenta,PrecioOferta,Ahorro,Utilidad,Margen,marca,hecho,importador,exportador,"
                    + "FechaAct,categoriaweb,campo1,campo2,campo3,campo4,campo5,campo6,campo7,campo8,campo9,campo10,campo11,campo12)\n"
                    + "VALUES\n"
                    + "('" + codigo + "','" + codigo2 + "','" + descripcion + "','" + Vnacional + "','" + grupo + "','" + descgrupo + "',"
                    + "'" + g + "','" + descgenero + "','" + costounitario + "','" + precioventa + "','" + preciooferta + "','" + ahorro + "',"
                    + "'" + utilidad + "','" + margen + "','" + marca + "','" + hecho + "','" + importador + "','" + exportador + "',getdate(),"
                    + "'" + categoriaweb + "' ,'" + "CONEXION "+conectividad + "','"+"LINEA "+linea+"','" +"TIPO "+ tipo + "','" + manoslibres + "','" + recargable + "','" +"COLOR "+ color + "',"
                    + "'" + "INCLUYE "+incluye + "' ,'"+ipx+"','null','null','null','null')");
            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "¡Los datos han sido guardados exitósamente!");
                st.close();
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error en la base de datos" + ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(V1503.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbconectividad = new javax.swing.JComboBox();
        cbrecargable = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        lincluye = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbcolor = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbtipo = new javax.swing.JComboBox();
        btnpasalista = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lfinal = new javax.swing.JList();
        cbmlibres = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cblinea = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        cbipx = new javax.swing.JComboBox();
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
        jLabel2.setText("Conectividad:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 90, 38));

        jPanel1.add(cbconectividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 171, 38));

        cbrecargable.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));
        jPanel1.add(cbrecargable, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 171, 38));

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

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Recargable:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 100, 35));

        jLabel9.setText(" ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 60, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Tipo:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 90, 35));

        jPanel1.add(cbtipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 171, 38));

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

        cbmlibres.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));
        jPanel1.add(cbmlibres, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 171, 38));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Manos libres:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 90, 35));

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

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Linea:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 90, 35));

        jPanel1.add(cblinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 171, 38));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Ipx:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 90, 35));

        cbipx.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));
        jPanel1.add(cbipx, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 171, 38));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 700, 360));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("CODIGO:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 68, 43));
        getContentPane().add(lblcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 220, 43));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("AUDIFONOS BLUETOOTH");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 190, 40));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("GENERO:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 68, 43));

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
        // TODO add your handling code here:
   /*     DefaultListModel model2 = (DefaultListModel) lfinal.getModel();
        String elementos = (String) lincluye.getSelectedValue();
        
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {

            int selectedIndex = lfinal.getSelectedIndex();
            if (selectedIndex != -1) {

                model2.remove(selectedIndex);///remueve valor de tabla

              //  modelo.addElement(elementos);///agregar elemento al modelo llfinal
              //  lfinal.setModel(modelo);
            }

        }*/
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
        llenartipo();
        llenarcolor();
        llenarconectividad();
        llenarlistaincluye();
        linea();
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
            java.util.logging.Logger.getLogger(V1503.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(V1503.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(V1503.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(V1503.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new V1503().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JToggleButton btnguardar;
    private javax.swing.JButton btnpasalista;
    private javax.swing.JButton btnregresar1;
    private javax.swing.JComboBox cbcolor;
    private javax.swing.JComboBox cbconectividad;
    private javax.swing.JComboBox cbipx;
    private javax.swing.JComboBox cblinea;
    private javax.swing.JComboBox cbmlibres;
    private javax.swing.JComboBox cbrecargable;
    private javax.swing.JComboBox cbtipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JList lfinal;
    private javax.swing.JList lincluye;
    // End of variables declaration//GEN-END:variables
}
