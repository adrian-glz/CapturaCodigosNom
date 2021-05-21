package JDBC;

import CodigoPOJO.CodigoPOJO;
import JDBC.Conexion;
//import POJO.CodigoPOJO;
//import com.mxrck.autocompleter.TextAutoCompleter;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonaJDBC {

    public static void cargarCompleter(TextAutoCompleter completador) {
        Connection con = null;
        PreparedStatement st = null;

        try {

            con = Conexion.getConnection();
            st = con.prepareStatement("select c.descripcion,c.codigo from codigos c, periodo p where c.codigo=p.codigo and p.mes>=1 and p.ano=2021  \n"
                    + "and c.codigo COLLATE SQL_Latin1_General_CP1_CI_AS not in (select codigo from noms.dbo.noms1web) and c.estatus<>'D' and c.grupo not in (20,25) \n"
                    + "group by c.codigo,c.descripcion");

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CodigoPOJO pojo = new CodigoPOJO(rs.getString(1).trim(), rs.getString(2));
                completador.addItem(pojo);
            }
            rs.close();
            //  st.closeOnCompletion();///borar si sale algo mal
        } catch (Exception e) {

            System.out.println("Error al cargar el AutoCompleter " + e);

        } finally {

            Conexion.close(con);
            Conexion.close(st);
        }
    }

    public static void cargargeneros(TextAutoCompleter completador) {
        Connection con = null;
        PreparedStatement st = null;

        try {

            con = Conexion.getConnection();
            st = con.prepareStatement("select * from generos  order by descripcion");

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CodigoPOJO pojo = new CodigoPOJO(rs.getString(1).trim(), rs.getString(2));
                completador.addItem(pojo);
            }
            rs.close();
            //  st.closeOnCompletion();///borar si sale algo mal
        } catch (Exception e) {

            System.out.println("Error al cargar el AutoCompleter " + e);

        } finally {

            Conexion.close(con);
            Conexion.close(st);
        }
    }

    public static void cargargrupos(TextAutoCompleter completador) {
        Connection con = null;
        PreparedStatement st = null;

        try {

            con = Conexion.getConnection();
            st = con.prepareStatement("select * from grupos  order by descripcion");

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CodigoPOJO pojo = new CodigoPOJO(rs.getString(1).trim(), rs.getString(2));
                completador.addItem(pojo);
            }
            rs.close();
            //  st.closeOnCompletion();///borar si sale algo mal
        } catch (Exception e) {

            System.out.println("Error al cargar el AutoCompleter " + e);

        } finally {

            Conexion.close(con);
            Conexion.close(st);
        }
    }

}
