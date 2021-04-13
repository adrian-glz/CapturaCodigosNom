 package PRINCIPAL;
 
 
 
import CodigoPOJO.CodigoPOJO;
import INST_MUSICALES.V178;
import INST_MUSICALES.V561;
import JDBC.PersonaJDBC;
import COMPUTO.V115;
import COMPUTO.V116;
import COMPUTO.V120;
import COMPUTO.V133;
import ACCELECTRONICA.V141;
import ACCELECTRONICA.V149;
import ACCELECTRONICA.V153;
import ACCELECTRONICA.V154;
import ACCELECTRONICA.V188;
import COMPUTO.V192;
import ELECTRONICA.V193;
import ACCELECTRONICA.V44;
import COMPUTO.V47;
import ACCELECTRONICA.V524;
import COMPUTO.V546;
import ELECTRONICA.V59;
import ELECTRONICA.V618;
import ELECTRONICA.V706;
import ACCCOMPUTO.V713;
import CONSOLAS.V95;
import COMPUTO.V250;
import ELECTRONICA.V284;
import ELECTRONICA.V288;
import COMPUTO.V39;
import ACCELECTRONICA.V400;
import VJSOFTWARE.VJSOFTWARE;
import ELECTRONICA.V106;
import ELECTRONICA.V127;
import COMPUTO.V145;
import ACCELECTRONICA.V1503;
import ACCELECTRONICA.V1504;
import ELECTRONICA.V330;
import ACCCOMPUTO.V712;
import ACCCOMPUTO.V77;
import ELECTRONICA.V89;
import ELECTRONICA.V100;
import ELECTRONICA.V103;
import ELECTRONICA.V105;
import ELECTRONICA.V107;
import ELECTRONICA.V1502;
import ACCCOMPUTO.V702;
import ACCCOMPUTO.V709;
import ELECTRONICA.V91;
import ELECTRONICA.V92;
import ELECTRONICA.V94;
import ELECTRONICA.V101;
import ELECTRONICA.V104;
import ACCELECTRONICA.V140;
import ELECTRONICA.V598;
import ELECTRONICA.V599;
import ELECTRONICA.V600;
import ACCELECTRONICA.V126;
import ACCELECTRONICA.V142;
import ELECTRONICA.V114;
import ELECTRONICA.V132;
import ELECTRONICA.V287;
import ELECTRONICA.V327;
import ACCCOMPUTO.V155;
import ACCELECTRONICA.V420;
import ACCELECTRONICA.V532;
import ACCCOMPUTO.V700;
import ACCCOMPUTO.V703;
import ACCCOMPUTO.V705;
import ACCCOMPUTO.V707;
import ACCCOMPUTO.V708;
import ACCELECTRONICA.V176;
import ACCELECTRONICA.V177;
import ACCELECTRONICA.V312;
import ACCCOMPUTO.V710;
import ACCCOMPUTO.V711;
import ACCELECTRONICA.V201;
import ACCELECTRONICA.V530;
import ACCELECTRONICA.V541;
import ACCELECTRONICA.V542;
import ACCELECTRONICA.V99;
import CD.V20;
import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CapturaCodigo extends javax.swing.JFrame {
    
    Statement st;
    PreparedStatement ps = null;
    ResultSet rs;

    DefaultTableModel md;
    int count = 0;
    public static String CODIGO_GLOBAL = " ";

    public static String codigo = " ", codigo2 = " ", descripcion = " ",
            nacional = " ", grupo = " ", descgrupo = " ",
            genero = " ", descgenero = " ", ahorro = "",
            costounitario = " ", categoriaweb = "", precioventa = " ",
            preciooferta = " ", utilidad = " ", margen = " ", marca = " ",
            hecho = " ", importador = "", exportador = "";

    TextAutoCompleter textAutoCompleter;

    public CapturaCodigo() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/recursos/logo.png")).getImage());
        btnsig.setEnabled(false);
        jPanel1.setVisible(false);
        btnsig.setVisible(false);

        textAutoCompleter = new TextAutoCompleter(txt_id, new AutoCompleterCallback() {
            @Override
            public void callback(Object o) {
                Object a = textAutoCompleter.findItem(o);
                CodigoPOJO personaPOJO = (CodigoPOJO) a;
            }
        });
        PersonaJDBC.cargarCompleter(textAutoCompleter);
    }

    public void verificarnulos(){
        if (        codigo.equals(" ")
                || codigo2.equals(" ")
                || nacional.equals(" ")
                || grupo.equals(" ")
                || descgrupo.equals(" ")
                || genero.equals(" ")
                || descgenero.equals(" ")
                || costounitario.equals(" ")
                || precioventa.equals(" ")
                || preciooferta.equals(" ")
                || ahorro.equals(" ")
                || utilidad.equals(" ")
                || margen.equals(" ")
                || marca.equals(" ")
                || hecho.equals(" ")
                || importador.equals(" ")
                || exportador.equals(" ")
                || categoriaweb.equals(" ")
                || hecho.equals(" ")) {

            JOptionPane.showMessageDialog(rootPane, "Faltan datos, si aparecen datos en blanco, comunicate con el comprador responsable");

            vaciarcampiosvalores();
        } else {
            existecodigo();
        }
    }
     
    public void destinoventana() {

        descripcion = txt_descripcion.getText();
        String ge = txt_genero.getText();
        int genero = Integer.parseInt(ge);
        switch (genero) {

            case 20: {
                this.setVisible(false);
                V20 V = new V20();
                V.setVisible(true);

            }
            case 39: {
                this.setVisible(false);
                V39 V = new V39();
                V.setVisible(true);

            }
            break;
            case 44: {
                this.setVisible(false);
                V44 V = new V44();
                V.setVisible(true);
            }
            break;

            case 47: {
                this.setVisible(false);
                V47 V = new V47();
                V.setVisible(true);
            }
            break;

            case 59: {
                this.setVisible(false);
                V59 V = new V59();
                V.setVisible(true);
            }
            break;
            case 77: {
                this.setVisible(false);
                V77 V = new V77();
                V.setVisible(true);
            }
            break;

            case 83: {
                this.setVisible(false);
                VJSOFTWARE V = new VJSOFTWARE();
                V.setVisible(true);
            }
            break;

            case 85: {
                this.setVisible(false);
                VJSOFTWARE V = new VJSOFTWARE();
                V.setVisible(true);
            }
            break;
            case 89: {
                this.setVisible(false);
                V89 V = new V89();
                V.setVisible(true);
            }
            break;
            case 91: {
                this.setVisible(false);
                V91 V = new V91();
                V.setVisible(true);
            }
            break;
            case 92: {
                this.setVisible(false);
                V92 V = new V92();
                V.setVisible(true);
            }
            break;
            case 94: {
                this.setVisible(false);
                V94 V = new V94();
                V.setVisible(true);
            }
            break;
            case 95: {
                this.setVisible(false);
                V95 V = new V95();
                V.setVisible(true);
            }
            break;
            case 99: {
                this.setVisible(false);
                V99 V = new V99();
                V.setVisible(true);
            }
            break;
            case 100: {
                this.setVisible(false);
                V100 V = new V100();
                V.setVisible(true);
            }
            break;
            case 101: {
                this.setVisible(false);
                V101 V = new V101();
                V.setVisible(true);
            }
            break;

            case 103: {
                this.setVisible(false);
                V103 V = new V103();
                V.setVisible(true);
            }
            break;
            case 104: {
                this.setVisible(false);
                V104 V = new V104();
                V.setVisible(true);
            }
            break;
            case 105: {
                this.setVisible(false);
                V105 V = new V105();
                V.setVisible(true);
            }
            break;
            case 106: {
                this.setVisible(false);
                V106 V = new V106();
                V.setVisible(true);
            }
            break;
            case 107: {
                this.setVisible(false);
                V107 V = new V107();
                V.setVisible(true);
            }
            break;
            case 114: {
                this.setVisible(false);
                V114 V = new V114();
                V.setVisible(true);
            }
            break;
            case 115: {
                this.setVisible(false);
                V115 V = new V115();
                V.setVisible(true);
            }
            break;
            case 116: {
                this.setVisible(false);
                V116 V = new V116();
                V.setVisible(true);
            }
            break;
            case 120: {
                this.setVisible(false);
                V120 V = new V120();
                V.setVisible(true);
            }
            break;
            case 127: {
                this.setVisible(false);
                V127 V = new V127();
                V.setVisible(true);
            }
            break;
            case 126: {
                this.setVisible(false);
                V126 V = new V126();
                V.setVisible(true);
            }
            break;
            case 132: {
                this.setVisible(false);
                V132 V = new V132();
                V.setVisible(true);
            }
            break;
            case 133: {
                this.setVisible(false);
                V133 V = new V133();
                V.setVisible(true);
            }
            break;
            case 137: {
                this.setVisible(false);
                VJSOFTWARE V = new VJSOFTWARE();
                V.setVisible(true);
            }
            break;
            case 138: {
                this.setVisible(false);
                VJSOFTWARE V = new VJSOFTWARE();
                V.setVisible(true);
            }
            break;
            case 139: {
                this.setVisible(false);
                VJSOFTWARE V = new VJSOFTWARE();
                V.setVisible(true);
            }
            break;

            case 140: {
                this.setVisible(false);
                V140 V = new V140();
                V.setVisible(true);
            }
            break;
            case 141: {
                this.setVisible(false);
                V141 V = new V141();
                V.setVisible(true);
            }
            break;
            case 142: {
                this.setVisible(false);
                V142 V = new V142();
                V.setVisible(true);
            }
            break;
            case 145: {
                this.setVisible(false);
                V145 V = new V145();
                V.setVisible(true);
            }
            break;
            case 149: {
                this.setVisible(false);
                V149 V = new V149();
                V.setVisible(true);
            }
            break;

            case 153: {
                this.setVisible(false);
                V153 V = new V153();
                V.setVisible(true);
            }
            break;
            case 154: {
                this.setVisible(false);
                V154 V = new V154();
                V.setVisible(true);
            }
            break;
            case 155: {
                this.setVisible(false);
                V155 V = new V155();
                V.setVisible(true);
            }
            break;
            case 176: {
                this.setVisible(false);
                V176 V = new V176();
                V.setVisible(true);
            }
            break;
            case 177: {
                this.setVisible(false);
                V177 V = new V177();
                V.setVisible(true);
            }
            break;
            case 178: {
                this.setVisible(false);
                V178 V = new V178();
                V.setVisible(true);
            }
            break;
            case 188: {
                this.setVisible(false);
                V188 V = new V188();
                V.setVisible(true);
            }
            break;
            case 192: {
                this.setVisible(false);
                V192 V = new V192();
                V.setVisible(true);
            }
            break;
            case 193: {
                this.setVisible(false);
                V193 V = new V193();
                V.setVisible(true);
            }
            break;
            case 201: {
                this.setVisible(false);
                V201 V = new V201();
                V.setVisible(true);
            }
            break;
            case 250: {
                this.setVisible(false);
                V250 V = new V250();
                V.setVisible(true);
            }
            break;
            case 284: {
                this.setVisible(false);
                V284 V = new V284();
                V.setVisible(true);
            }
            break;
            case 287: {
                this.setVisible(false);
                V287 V = new V287();
                V.setVisible(true);
            }
            break;
            case 288: {
                this.setVisible(false);
                V288 V = new V288();
                V.setVisible(true);
            }
            break;
            case 312: {
                this.setVisible(false);
                V312 V = new V312();
                V.setVisible(true);
            }
            break;
            case 327: {
                this.setVisible(false);
                V327 V = new V327();
                V.setVisible(true);
            }
            break;
            case 330: {
                this.setVisible(false);
                V330 V = new V330();
                V.setVisible(true);
            }
            break;

            case 400: {
                this.setVisible(false);
                V400 V = new V400();
                V.setVisible(true);
            }
            break;
            case 420: {
                this.setVisible(false);
                V420 V = new V420();
                V.setVisible(true);
            }
            break;
            case 524: {
                this.setVisible(false);
                V524 V = new V524();
                V.setVisible(true);
            }
            break;
            case 530: {
                this.setVisible(false);
                V530 V = new V530();
                V.setVisible(true);
            }
            break;
            case 532: {
                this.setVisible(false);
                V532 V = new V532();
                V.setVisible(true);
            }
            break;
            case 541: {
                this.setVisible(false);
                V541 V = new V541();
                V.setVisible(true);
            }
            break;
            case 542: {
                this.setVisible(false);
                V542 V = new V542();
                V.setVisible(true);
            }
            break;
            case 546: {
                this.setVisible(false);
                V546 V = new V546();
                V.setVisible(true);
            }
            break;
            case 561: {
                this.setVisible(false);
                V561 V = new V561();
                V.setVisible(true);
            }
            break;
            case 598: {
                this.setVisible(false);
                V598 V = new V598();
                V.setVisible(true);
            }
            break;
            case 599: {
                this.setVisible(false);
                V599 V = new V599();
                V.setVisible(true);
            }
            break;
            case 600: {
                this.setVisible(false);
                V600 V = new V600();
                V.setVisible(true);
            }
            break;
            case 618: {
                this.setVisible(false);
                V618 V = new V618();
                V.setVisible(true);
            }
            break;
            case 700: {
                this.setVisible(false);
                V700 V = new V700();
                V.setVisible(true);
            }
            break;
            case 702: {
                this.setVisible(false);
                V702 V = new V702();
                V.setVisible(true);
            }
            break;

            case 703: {
                this.setVisible(false);
                V703 V = new V703();
                V.setVisible(true);
            }
            break;
            case 705: {
                this.setVisible(false);
                V705 V = new V705();
                V.setVisible(true);
            }
            break;
            case 706: {
                this.setVisible(false);
                V706 V = new V706();
                V.setVisible(true);
            }
            break;
            case 707: {
                this.setVisible(false);
                V707 V = new V707();
                V.setVisible(true);
            }
            break;
            case 708: {
                this.setVisible(false);
                V708 V = new V708();
                V.setVisible(true);
            }
            break;
            case 709: {
                this.setVisible(false);
                V709 V = new V709();
                V.setVisible(true);
            }
            break;
            case 710: {
                this.setVisible(false);
                V710 V = new V710();
                V.setVisible(true);
            }
            break;
            case 711: {
                this.setVisible(false);
                V711 V = new V711();
                V.setVisible(true);
            }
            break;
            case 712: {
                this.setVisible(false);
                V712 V = new V712();
                V.setVisible(true);
            }
            break;
            case 713: {
                this.setVisible(false);
                V713 V = new V713();
                V.setVisible(true);
            }
            break;
            case 1502: {
                this.setVisible(false);
                V1502 V = new V1502();
                V.setVisible(true);
            }
            break;
            case 1503: {
                this.setVisible(false);
                V1503 V = new V1503();
                V.setVisible(true);
            }
            break;
            case 1504: {
                this.setVisible(false);
                V1504 V = new V1504();
                V.setVisible(true);
            }
            break;
            default: {
                JOptionPane.showMessageDialog(this, "Aun no puedes capturar descripciones en el genero: " + genero);
            }
        }
    }

    public void vaciarcampiosvalores() {

        String codigo = " ", codigo2 = " ", descripcion = " ", nacional = " ", grupo = " ", descgrupo = " ", genero = " ", descgenero = " ", ahorro = "",
                costounitario = " ", categoriaweb = "", precioventa = " ", preciooferta = " ", utilidad = " ", margen = " ", marca = " ", importador = "", exportador = "";

        hecho = " ";

    }

    public void limpiarcampos() {
        txt_codbarra.setText("");
        txt_id.setText("");
        txt_descripcion.setText("");
        txt_nacionalidad.setText("");
        txt_grupo.setText("");
        txt_descgrupo.setText("");
        txt_genero.setText("");
        txt_descgenero.setText("");
        txt_costounitario.setText("");
        txt_precioventa.setText("");
        txt_preciooferta.setText("");
        txt_categoriaweb.setText("");
        txt_utilidad.setText("");
        txt_margen.setText("");
        txt_marca.setText("");
        txt_hecho.setText("");
        btnsig.setEnabled(false);
        txt_descripcion.setEnabled(false);

    }

    public void ayudaboton() {

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            st = conexion.createStatement();
            st.executeUpdate("use noms;");
            rs = st.executeQuery("select * from ayudausuario where id=1");

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
                //   System.out.println(nc.trim());

                JOptionPane.showMessageDialog(null, nc.trim());

            }
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
    }

    public void colorearverde() {
        // txt_nacionalidad.setBackground(Color.gray);
    }

    public void colorearrojo() {
        txt_hecho.setBackground(Color.red);
    }

    public void colorearblanco() {
        txt_nacionalidad.setBackground(Color.white);
        txt_hecho.setBackground(Color.white);
        txt_hecho.setEditable(false);

    }

    public void existecodigo() {

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            st = conexion.createStatement();
            st.executeUpdate("use noms");
            rs = st.executeQuery("select codigo from noms1web where codigo='" + txt_id.getText() + "'");

            boolean variable = rs.next();

            String s1 = Boolean.toString(variable);

            try {
                if (s1.equals("false")) {
                    while (rs.next()) {///
                    }
                    destinoventana();

                } else {
                    JOptionPane.showMessageDialog(null, "El codigo ya esta registrado en nom --> " + txt_id.getText(), "Alerta", JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CapturaCodigo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void recuperarcampos() {

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.80:55024", "usounds", "madljda");
            st = conexion.createStatement();
            st.executeUpdate("use cml;");

            //Seleccionar datos
            rs = st.executeQuery("select c.codigo,c.codigo2,c.descripcion,c.nacional,c.grupo,(select descripcion from grupos where grupo=c.grupo) as descgrupo, \n"
                    + "c.genero,(select descripcion from generos where genero=c.genero) as descgenero,(case when c.nacional=0 then c.costoreposicion*(select tipocambioventa from infor) else c.costoreposicion end) as CostoUnitario,\n"
                    + "(case when c.nacional=0 then c.precioventa*(select tipocambioventa from infor) else c.precioventa end) as precioventa,\n"
                    + "isnull((case when c.nacional=0 then (select preciooferta from ofertascodigo where codigo=c.codigo)*(select tipocambioventa from infor) else (select preciooferta from ofertascodigo where codigo=c.codigo)  end),0) as preciooferta,\n"
                    + "(case when c.nacional=0 then c.precioventa*(select tipocambioventa from infor) else c.precioventa end)- isnull((case when c.nacional=0 then (select preciooferta from ofertascodigo where codigo=c.codigo)*(select tipocambioventa from infor) else (select preciooferta from ofertascodigo where codigo=c.codigo)  end),0) as ahorro,\n"
                    + "round((isnull((nullif (case when c.nacional=0 then c.Precioventa * \n"
                    + "(select tipocambioventa from infor) else c.precioventa end,0)/(1+(select iva from infor))),0) - \n"
                    + "(case when c.nacional=0 then c.CostoReposicion * (select tipocambioventa from infor) else c.Costoreposicion end)),2) as utilidad,\n"
                    + "round((isnull((( round((isnull((nullif (case when c.nacional=0 then c.Precioventa * \n"
                    + "(select tipocambioventa from infor) else c.precioventa end,0)/(1+(select iva from infor))),0) - \n"
                    + "(case when c.nacional=0 then c.CostoReposicion * (select tipocambioventa from infor) else c.Costoreposicion end)),2)) / (nullif (case when c.nacional=0 then c.Precioventa * \n"
                    + "(select tipocambioventa from infor) else c.precioventa end,0)/(1+((select iva from infor))))),0)*100),2) as margen,\n"
                    + "(select marca_descripcion from marcas where marca_id=ci.marca_id) as marca,\n"
                    + "(select origen_descripcion from origen where origen_id=ci.origen_id) as hecho,\n"
                    + "(case when c.nacional=0 then 'CASA DE MUSICA DE LUXE, S.A. DE C.V. CML580203DQ6' else 'PRODUCTO NACIONAL' end) as importador,\n"
                    + "'AVE PASEO TRIUNFO DE LA REPUBLICA L21-23 CD. JUAREZ CHIH 32330' as exportador,\n"
                    + "getdate() as FechaAct,\n"
                    + "(select top 1 categories_id from codigos_to_categories where codigo=c.codigo order by fecha_alta desc) as CATEGORIA\n"
                    + "from codigos c, codigos_info ci\n"
                    + "where c.codigo=ci.codigo and c.codigo='" + txt_id.getText() + "'");

            while (rs.next()) {
                DecimalFormat df = new DecimalFormat("#0.00");
                jPanel1.setVisible(true);

                btnsig.setVisible(true);
                btnsig.setEnabled(true);
                txt_descripcion.setEnabled(true);

                
                codigo = rs.getString(1).trim();
                codigo2 = rs.getString(2).trim();
                String descripcionTEMPORAL = rs.getString(3).trim();
                nacional = rs.getString(4).trim();
                grupo = rs.getString(5).trim();
                descgrupo = rs.getString(6).trim();
                genero = rs.getString(7).trim();
                descgenero = rs.getString(8).trim();
                costounitario = rs.getString(9).trim();
                precioventa = rs.getString(10).trim();

                preciooferta = rs.getString(11).trim();
                ahorro = rs.getString(12).trim();
                utilidad = rs.getString(13).trim();
                margen = rs.getString(14).trim();
                marca = rs.getString(15).trim();
                try {
                    hecho = rs.getString(16).trim();
                } catch (Exception e) {
                    hecho = " ";
                    JOptionPane.showMessageDialog(rootPane, "Falta capturar donde esta hecho u origen del codigo");
                    colorearrojo();
                }
                importador = rs.getString(17).trim();
                exportador = rs.getString(18).trim();
                categoriaweb = rs.getString(20).trim();

                txt_codbarra.setText(codigo2);
                txt_descripcion.setText(descripcionTEMPORAL);

                if (nacional.equals("0")) {
                    nacional = "AMERICANO";
                    //   System.out.println("AMERICANO");
                    colorearverde();
                }
                if (nacional.equals("1")) {

                    nacional = "NACIONAL";
                    //  System.out.println("NACIONAL");
                }

                txt_nacionalidad.setText(nacional);
                txt_grupo.setText(grupo);
                txt_descgrupo.setText(descgrupo);
                txt_genero.setText(genero);
                txt_descgenero.setText(descgenero);
                double cu = Double.parseDouble(costounitario);
                txt_costounitario.setText(df.format(cu));
                double pv = Double.parseDouble(precioventa);
                txt_precioventa.setText(df.format(pv));
                double po = Double.parseDouble(preciooferta);
                txt_preciooferta.setText(df.format(po));
                double uti = Double.parseDouble(utilidad);
                txt_utilidad.setText(df.format(uti));
                double mar = Double.parseDouble(margen);
                txt_margen.setText(df.format(mar));
                txt_marca.setText(marca);
                txt_hecho.setText(hecho);
                txt_categoriaweb.setText(categoriaweb);

                //    System.out.println("RESULTADO"+codigo+codigo2+descripcion+nacional+grupo+descgrupo+genero+descgenero+
                //  costounitario+precioventa+preciooferta+utilidad+margen+marca+hecho);
            }

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error en la base de datos");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CapturaCodigo.class.getName()).log(Level.SEVERE, null, ex);

        }
        //System.out.println("IMPRESION EN CODIGO"+codigo); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_codbarra = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_descgrupo = new javax.swing.JTextField();
        txt_genero = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_costounitario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_precioventa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_preciooferta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_utilidad = new javax.swing.JTextField();
        txt_margen = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_marca = new javax.swing.JTextField();
        txt_grupo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_nacionalidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_descgenero = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_hecho = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_descripcion = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_categoriaweb = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnvolver = new javax.swing.JButton();
        btnsig = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de captura codigos");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_codbarra.setEditable(false);
        txt_codbarra.setText(" ");
        jPanel1.add(txt_codbarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 130, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("CODIGO DE BARRAS:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("DESCRIPCION GRUPO:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 120, 30));

        txt_descgrupo.setEditable(false);
        txt_descgrupo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_descgrupo.setText(" ");
        jPanel1.add(txt_descgrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 280, 30));

        txt_genero.setEditable(false);
        txt_genero.setText(" ");
        jPanel1.add(txt_genero, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 140, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("COSTO UNITARIO:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 130, 30));

        txt_costounitario.setEditable(false);
        txt_costounitario.setText(" ");
        jPanel1.add(txt_costounitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 140, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("PRECIO DE VENTA:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 130, 30));

        txt_precioventa.setEditable(false);
        txt_precioventa.setText(" ");
        jPanel1.add(txt_precioventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 140, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("PRECIO DE OFERTA:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 130, 30));

        txt_preciooferta.setEditable(false);
        txt_preciooferta.setText(" ");
        jPanel1.add(txt_preciooferta, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 140, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("UTILIDAD:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 70, 30));

        txt_utilidad.setEditable(false);
        txt_utilidad.setText(" ");
        jPanel1.add(txt_utilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 170, 30));

        txt_margen.setEditable(false);
        txt_margen.setText(" ");
        jPanel1.add(txt_margen, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 170, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("MARGEN:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, 70, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("MARCA:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 70, 30));

        txt_marca.setEditable(false);
        txt_marca.setText(" ");
        jPanel1.add(txt_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 130, 30));

        txt_grupo.setEditable(false);
        txt_grupo.setText(" ");
        jPanel1.add(txt_grupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 130, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("GRUPO:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 70, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("GENERO:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 120, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("NACIONALIDAD:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 130, 30));

        txt_nacionalidad.setEditable(false);
        txt_nacionalidad.setText(" ");
        jPanel1.add(txt_nacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 130, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("DESCRIPCION GENERO:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 130, 30));

        txt_descgenero.setEditable(false);
        txt_descgenero.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_descgenero.setText(" ");
        jPanel1.add(txt_descgenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 170, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("HECHO:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 70, 30));

        txt_hecho.setEditable(false);
        txt_hecho.setText(" ");
        jPanel1.add(txt_hecho, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 170, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("DESCRIPCION:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 90, 40));
        jPanel1.add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 700, 40));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("CATEGORIA WEB:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 100, 30));

        txt_categoriaweb.setEditable(false);
        txt_categoriaweb.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_categoriaweb.setText(" ");
        jPanel1.add(txt_categoriaweb, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, 170, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("*");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 40, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 98, 910, 278));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("CODIGO:");

        txt_id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_idKeyPressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/HELP2.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnbuscar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/buscar.png"))); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btnlimpiar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnlimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/limpiar.png"))); // NOI18N
        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnlimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addComponent(txt_id)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnlimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 910, 70));

        jLabel3.setText(" ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 150, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/sitio.png"))); // NOI18N
        jButton2.setText("Buscar en sounds.mx");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 300, 60));

        btnvolver.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnvolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/home.png"))); // NOI18N
        btnvolver.setText("Volver");
        btnvolver.setToolTipText("");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnvolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 260, 60));

        btnsig.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnsig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/next1.png"))); // NOI18N
        btnsig.setText("Siguiente");
        btnsig.setToolTipText("");
        btnsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsigActionPerformed(evt);
            }
        });
        getContentPane().add(btnsig, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 390, 310, 60));
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        colorearblanco();
        vaciarcampiosvalores();
        recuperarcampos();
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsigActionPerformed
        verificarnulos();
    }//GEN-LAST:event_btnsigActionPerformed

    private void txt_idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            colorearblanco();
            vaciarcampiosvalores();
            recuperarcampos();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            colorearblanco();
            vaciarcampiosvalores();
            limpiarcampos();
        }

    }//GEN-LAST:event_txt_idKeyPressed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        limpiarcampos();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ayudaboton();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        this.dispose();
        Menu m = new Menu();
        m.setVisible(true);
    }//GEN-LAST:event_btnvolverActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
        String cadena = "https://www.sounds.mx/catalogo?b=";
                
        String cadena2 = "https://www0.sounds.mx/advanced_search_result.php?keywords=";
     //   String cadena3 = "https://www.sounds.mx/admin/?modulo=prd&sku=";
 
        if(txt_id.getText().length()>1){       
        String C = txt_id.getText().replaceAll("[ ]", "");
        //.out.println(C);
        try {
          Desktop.getDesktop().browse(new URI(cadena + C));
           Desktop.getDesktop().browse(new URI(cadena2 + C));
          //  Desktop.getDesktop().browse(new URI(cadena3 + C));
         //   Desktop.getDesktop().browse(new URI("https://www.sounds.mx/?mod=catalogo&b=SWSMM2"));

        } catch (URISyntaxException ex) {
            System.out.println("error");
        } catch (IOException ex) {
            System.out.println("error2"); // hacer algo
        }
        }else{
         
          JOptionPane.showMessageDialog(rootPane, "Capture un codigo valido");
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CapturaCodigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CapturaCodigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CapturaCodigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CapturaCodigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CapturaCodigo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnsig;
    private javax.swing.JButton btnvolver;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_categoriaweb;
    private javax.swing.JTextField txt_codbarra;
    private javax.swing.JTextField txt_costounitario;
    private javax.swing.JTextField txt_descgenero;
    private javax.swing.JTextField txt_descgrupo;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_genero;
    private javax.swing.JTextField txt_grupo;
    private javax.swing.JTextField txt_hecho;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_marca;
    private javax.swing.JTextField txt_margen;
    private javax.swing.JTextField txt_nacionalidad;
    private javax.swing.JTextField txt_preciooferta;
    private javax.swing.JTextField txt_precioventa;
    private javax.swing.JTextField txt_utilidad;
    // End of variables declaration//GEN-END:variables
}
