/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kazuo
 */
public class ConnectionFactory {

    private static final String URL = "jdbc:sqlite:C:\\Users\\kazuo\\Dropbox\\Georganização\\db\\APS.db";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão");
        }
    }

    private static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro no fechamento da conexão");
        }
    }

    public static void closeConnection(Connection con, PreparedStatement pst) {
        try {
            if (pst != null) {
                pst.close();
            }
            closeConnection(con);

        } catch (SQLException e) {
            throw new UnsupportedOperationException("Erro no fechamento do statement."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    public static void closeConnetion(Connection con, PreparedStatement pst, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException("Erro no fechamento do result set");
        }
    }

}
