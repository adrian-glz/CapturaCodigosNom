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
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author agonzalez
 */
public class Principal extends javax.swing.JFrame {

    Statement st;
    PreparedStatement ps = null;
    ResultSet rs;
    String generoid, grupoid, proveedorid;

    public Principal() {

        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/recursos/logo.png")).getImage());
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
        llenartablacategorias();
        GregorianCalendar gg = new GregorianCalendar();
        SimpleDateFormat dd = new SimpleDateFormat("yyyy/MM/dd");
        String fechadisplay = dd.format(gg.getTime());
        lblfecha.setText(fechadisplay);
        txtcodigosounds.requestFocusInWindow();
        jpanelcostos.setVisible(false);
        btngenerar.setEnabled(false);
        btngenerar.setVisible(false);

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

    public void llenartablacategorias() {
        TableColumn testColumn = jtcategorias.getColumnModel().getColumn(0);

        JComboBox<String> jccategories = new JComboBox<>();
        AutoCompleteDecorator.decorate(jccategories);

        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            st = conn.createStatement();
            st.executeUpdate("use cml;");
            rs = st.executeQuery("select * from categories order by categories_id ASC");
            // rs = st.executeQuery("select * from categories where parent_id ='"++"'order by categories_id ASC");

            while (rs.next()) {
                String elemento = rs.getString("categories_id").trim() + " " + rs.getString("categories_name_espanol").trim();
                jccategories.addItem(elemento);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
        testColumn.setCellEditor(new DefaultCellEditor(jccategories));
    }

    public void llenarfamilia() {
        //  jcfamilia.removeAllItems();

        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            st = conn.createStatement();
            st.executeUpdate("use noms;");
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

    public void nuevoelementofamilia() {
        //  jcfamilia.removeAllItems();
        jcfamilia.addItem("");
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

    public void llenarcategories() {
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
//////////////////////////////////////////////////////////////////////

    public void obtenidgenero() {
        String g = jcgenero.getSelectedItem().toString().trim();
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select genero from generos where descripcion ='" + g + "'");
            while (rs.next()) {
                generoid = rs.getString("genero").trim();
            }
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
    }

    public void obtenidproveedor() {
        String g = jcproveedor.getSelectedItem().toString().trim();
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select proveedor from proveedores where descripcion ='" + g + "'");
            while (rs.next()) {
                proveedorid = rs.getString("proveedor").trim();
            }
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
    }

    public void obtenidgrupo() {
        String g = jcgrupo.getSelectedItem().toString().trim();
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select grupo from grupos where descripcion ='" + g + "'");
            while (rs.next()) {
                grupoid = rs.getString("grupo").trim();
            }
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
    }

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
        btngenerar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jcprocedencia = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jcfamilia = new javax.swing.JComboBox();
        lblfecha = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jcapartado = new javax.swing.JComboBox();
        jpanelcostos = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPrecioventa = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        btnagregarfamilia = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtcategorias = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

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
        getContentPane().add(txtcodigoproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 180, 30));

        txtcodigobarras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtcodigobarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigobarrasKeyTyped(evt);
            }
        });
        getContentPane().add(txtcodigobarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 140, 30));

        txtdescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtdescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdescripcionKeyTyped(evt);
            }
        });
        getContentPane().add(txtdescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 140, 30));

        jcgrupo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcgrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcgrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 180, 30));

        jcgenero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcgenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcgenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 210, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Grupo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, -1, -1));

        lblcodigobarras.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblcodigobarras.setText("  ");
        getContentPane().add(lblcodigobarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 15, 130, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Genero");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 65, -1, -1));

        lblproveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblproveedor.setText(" ");
        getContentPane().add(lblproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 15, 180, -1));

        lbldescripcion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbldescripcion.setText("  ");
        getContentPane().add(lbldescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 15, 130, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Proveedor");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 65, -1, -1));

        jcproveedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcproveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 180, 30));

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
        getContentPane().add(btnayuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 60, 50));

        txtcodigosounds.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtcodigosounds.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigosoundsKeyTyped(evt);
            }
        });
        getContentPane().add(txtcodigosounds, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 170, 30));

        lblcodigosounds.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblcodigosounds.setText(" ");
        getContentPane().add(lblcodigosounds, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 170, -1));

        btngenerar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btngenerar.setText("Generar");
        btngenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngenerarActionPerformed(evt);
            }
        });
        getContentPane().add(btngenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 390, 40));

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
        getContentPane().add(lblfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, 80, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Clave Apartado");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 115, -1, -1));

        jcapartado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcapartado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--NO APLICA--", "APLICA" }));
        getContentPane().add(jcapartado, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 130, 130, 30));

        jpanelcostos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpanelcostos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Precio Venta:");
        jpanelcostos.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Costo:");
        jpanelcostos.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 40, 30));

        txtPrecioventa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPrecioventa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioventaKeyTyped(evt);
            }
        });
        jpanelcostos.add(txtPrecioventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 160, 30));

        txtCosto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });
        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoKeyTyped(evt);
            }
        });
        jpanelcostos.add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 160, 30));

        getContentPane().add(jpanelcostos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 260, 90));

        btnagregarfamilia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/123.png"))); // NOI18N
        btnagregarfamilia.setContentAreaFilled(false);
        getContentPane().add(btnagregarfamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 133, 20, 20));

        jtcategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null}
            },
            new String [] {
                "Categorias"
            }
        ));
        jtcategorias.setRowHeight(20);
        jScrollPane1.setViewportView(jtcategorias);
        if (jtcategorias.getColumnModel().getColumnCount() > 0) {
            jtcategorias.getColumnModel().getColumn(0).setResizable(false);
            jtcategorias.getColumnModel().getColumn(0).setPreferredWidth(80);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 240, 90));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtcodigoproveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoproveedorKeyTyped
        if (txtcodigoproveedor.getText().length() > 0) {
            lblproveedor.setText("Proveedor");
        } else {
            lblproveedor.setText("");
        }

        mostrarpanelcostos();
    }//GEN-LAST:event_txtcodigoproveedorKeyTyped

    private void txtcodigobarrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigobarrasKeyTyped
        if (txtcodigobarras.getText().length() > 0) {
            lblcodigobarras.setText("Codigo de barras");
        } else {
            lblcodigobarras.setText("");
        }

        mostrarpanelcostos();
    }//GEN-LAST:event_txtcodigobarrasKeyTyped

    private void txtdescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionKeyTyped
        if (txtdescripcion.getText().length() > 0) {
            lbldescripcion.setText("Descripcion");
        } else {
            lbldescripcion.setText("");
        }

        mostrarpanelcostos();
    }//GEN-LAST:event_txtdescripcionKeyTyped

    private void btnayudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnayudaActionPerformed
        JOptionPane.showMessageDialog(null, "Informacion de estatus:\n"
                + "A=ACTIVO\n"
                + "D=DESCATALOGADO\n"
                + "C=CANCELADO");
    }//GEN-LAST:event_btnayudaActionPerformed
    public void mostrarpanelcostos() {
        if (txtcodigosounds.getText().length() > 0
                & txtcodigoproveedor.getText().length() > 0
                & txtcodigobarras.getText().length() > 0
                & txtdescripcion.getText().length() > 0) {
            jpanelcostos.setVisible(true);
            btngenerar.setVisible(true);
        } else {
            jpanelcostos.setVisible(false);

        }
    }
    private void txtcodigosoundsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigosoundsKeyTyped
        if (txtcodigosounds.getText().length() > 0) {
            lblcodigosounds.setText("Codigo Sounds");
        } else {
            lblcodigosounds.setText("");
        }
        mostrarpanelcostos();
// TODO add your handling code here:
    }//GEN-LAST:event_txtcodigosoundsKeyTyped

    private void btngenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngenerarActionPerformed
        ///variables para uso en insert sql
        System.out.println(">>>" + txtCosto.getText());
        if (txtcodigosounds.getText().equals("")
                || txtcodigoproveedor.getText().equals("")
                || txtcodigobarras.getText().equals("")
                || txtdescripcion.getText().equals("")
                || txtCosto.getText().equals("")
                || txtPrecioventa.getText().equals("") //  || jcfamilia.getSelectedItem().toString().equals("--NO APLICA--")
                ) {
            JOptionPane.showMessageDialog(rootPane, "Faltan datos , favor de capturarlos todos");
            //  vaciarcampiosvalores();
        } else {
            ExisteCodigo();
        }
    }//GEN-LAST:event_btngenerarActionPerformed

    private void txtPrecioventaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioventaKeyTyped
        if (txtPrecioventa.getText().length() > 0) {
            btngenerar.setEnabled(true);
        } else {
            btngenerar.setEnabled(false);
        }
    }//GEN-LAST:event_txtPrecioventaKeyTyped

    private void txtCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyTyped
        if (txtCosto.getText().length() > 0) {

        } else {
            btngenerar.setEnabled(false);
        }
    }//GEN-LAST:event_txtCostoKeyTyped

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        for (int x = 0; x < jtcategorias.getRowCount(); x++) {

            try {

                String vcodigo = ((String) jtcategorias.getValueAt(x, 0).toString());//obtener valor de precio
                //  String vc= vcodigo.replaceAll("[^0-1-2-3-4-5-6-7-8-9-.00]", "");//dejameos solo los elementos"[^0-1-2-3-4-5-6-7-8-9-.00]"
                String singuiones = vcodigo.replaceAll("[^0-1-2-3-4-5-6-7-8-9-.00]", "");//dejameos solo los elementos"[^0-1-2-3-4-5-6-7-8-9-.00]"
                String vfinal = singuiones.replaceAll("[-]", "");//dejameos solo los elementos"[^0-1-2-3-4-5-6-7-8-9-.00]"

                //  pse = conexion.prepareStatement("INSERT INTO ventas ( `fecha`,`Sucursal`, `Folio`, `Caja`, `Articulo`, `Codigo`, `Grupo`, `Cantidad`, `Precioventa`, `Vendedor`, `Cajero`, `Claveventa`, `Hora`) "
                //         + "VALUES ( '" + rfecha + "','1','" + folio + "','1','" + numarticulo + "','" + vcodigo + "','00','" + vcantidad + "','" + vprecioformateado + "','1111','00','777','" + rhora + "')");
                //   numarticulo = numarticulo + 1;
                //   n = pse.executeUpdate();
                System.out.println("-->" + vfinal);
            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(rootPane, "Error en la base de datos 901" + ex);
            }
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

        // String apartado="";
        String codigosounds = txtcodigosounds.getText().trim();
        String codigoproveedor = txtcodigoproveedor.getText().trim();
        String codigobarras = txtcodigobarras.getText().trim();
        String descripcion = txtdescripcion.getText().trim();
        String costo = txtCosto.getText().trim();
        String precioventa = txtPrecioventa.getText().trim();
        String grupo = jcgrupo.getSelectedItem().toString().trim();
        String genero = jcgenero.getSelectedItem().toString().trim();
        String apartado = jcapartado.getSelectedItem().toString().trim();
        String familia = jcfamilia.getSelectedItem().toString().trim();
        String procedencia = jcprocedencia.getSelectedItem().toString().trim();
        String proveedor = jcproveedor.getSelectedItem().toString().trim();
        String estatus = jcestatus.getSelectedItem().toString().trim();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SS");
        LocalDateTime date = LocalDateTime.now();

        obtenidgenero();
        obtenidgrupo();
        obtenidproveedor();

        //   System.out.println(dtf.format(date));
        if (apartado.equals("--NO APLICA--")) {
            apartado = "N";
        } else {
            apartado = "A";
        }
        if (procedencia.equals("Nacional")) {
            procedencia = "1";
        } else {
            procedencia = "0";
        }
        //
        if (familia.equals("--NO APLICA--")) {
            familia = "NULL";
        }

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            Statement st = conexion.createStatement();
            st.executeUpdate("use cml;");
            ps = conexion.prepareStatement("insert into codigos  (Codigo, CodigoProv, Estatus, Codigo2, CodigoNuevo, Descripcion,"
                    + " Artista,UnidadMedida  , Genero , Grupo  , Linea  , Proveedor, Proveedor2 , Nacional , Iva  , ClaveApartado ,"
                    + " CostoLista  , CostoNetoLista , CostoReposicion, PrecioVenta, FechaAlta , FechaActualizacion , TipoArticulo ,"
                    + " FechaActExpCosto, DescClienFrec ) "
                    + "VALUES('" + codigosounds + "',"
                    + "'" + codigoproveedor + "','" + estatus + "','" + codigobarras + "',NULL," ////nacional
                    + "'" + descripcion + "',NULL,'PZA','" + generoid + "','" + grupoid + "',NULL,'" + proveedorid + "','" + proveedorid + "','" + procedencia + "','11.00','" + apartado + "'"
                    + ",'" + costo + "','" + costo + "','" + costo + "','" + precioventa + "',getdate(),NULL,'S',NULL,'0.00')");
            int n = ps.executeUpdate();
            //  System.out.println("¡Los datos han sido guardados exitósamente!" + n);
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "¡Los datos han sido guardados exitósamente!");
                System.out.println("¡Los datos han sido guardados exitósamente!" + n);
                CapturaCodigo c = new CapturaCodigo();
                c.txt_id.setText(codigosounds);
                this.dispose();
                c.setVisible(true);
                c.colorearblanco();
                c.vaciarcampiosvalores();
                c.recuperarcampos();
                //  limpiarventanas();
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error en la base de datos" + ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JButton btnagregarfamilia;
    private javax.swing.JButton btnayuda;
    private javax.swing.JButton btngenerar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcapartado;
    private javax.swing.JComboBox jcestatus;
    private javax.swing.JComboBox jcfamilia;
    private javax.swing.JComboBox jcgenero;
    private javax.swing.JComboBox jcgrupo;
    private javax.swing.JComboBox jcprocedencia;
    private javax.swing.JComboBox jcproveedor;
    private javax.swing.JPanel jpanelcostos;
    private javax.swing.JTable jtcategorias;
    private javax.swing.JLabel lblcodigobarras;
    private javax.swing.JLabel lblcodigosounds;
    private javax.swing.JLabel lbldescripcion;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblproveedor;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtPrecioventa;
    private javax.swing.JTextField txtcodigobarras;
    private javax.swing.JTextField txtcodigoproveedor;
    public static javax.swing.JTextField txtcodigosounds;
    private javax.swing.JTextField txtdescripcion;
    // End of variables declaration//GEN-END:variables
}
