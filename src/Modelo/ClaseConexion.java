package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Paola
 */
public class ClaseConexion {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";

    private static final String USUARIO = "PAOLARIVERA_EXPO2024"; //Mismo usuario de la expo xq no me acordaba de la cotra de los dem{as
    private static final String CONTRASENA = "ITR2024";

    public static Connection getConexion() {
        try {
       
            Class.forName("oracle.jdbc.driver.OracleDriver");
 
            Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
          
            return conexion;
        } catch (SQLException e) {
            System.out.println("Este es el error clase" + e);
              return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Este es el error de la clase" + ex);
              return null;
        }
    }
    
}
