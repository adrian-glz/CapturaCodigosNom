/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
            st = con.prepareStatement("select * from codigos  where Estatus='A' order by codigo" );
                    
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
