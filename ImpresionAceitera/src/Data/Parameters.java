/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Graphic.IMPRESORA;
import Logic.Tables;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin
 */
public class Parameters {

    //VARIABLES
    public static String URLold;
    public static Connection VarConnect = null;
    public static String ProgramName = "IMPRESORA TICKET";
    public static String VersionProgram = "   V.1.0.0";
    public static String Os = System.getProperty("os.name");
    public static String UserPC = System.getProperty("user.name");
    public static boolean KevServices = true;
    public static String Company = "FERRETERIA EL GRINGO";
    public static String DbName = "DB_IMPRESORA";
    public static String DbPassword = "Admin35$_";
    public static String UrlDataBase = "C:\\Users\\" + UserPC + "\\AppData\\Roaming\\Printer" + Parameters.VersionProgram + "\\Data\\";
    public static String RutaLog = "C:\\Users\\" + Parameters.UserPC + "\\AppData\\Roaming\\Printer" + Parameters.VersionProgram + "\\Logs\\LOG " + Objects.Methods.Fecha() + ".txt";
    public static String IconoApp = "Logo2";
    public static String IconoDB = "Access";
    public static int ColorApp1 = 16;
    public static int ColorApp2 = 135;
    public static int ColorApp3 = 75;
    public static boolean Scanner = true;
    public static int NumeroFact=-1;
    public static String DevelperNumber="+502 58110479";
    

    public void ParametrosDefault() {
        boolean Delete = DeleteParametros();
        System.out.println("Delete = " + Delete);
        if (Delete == true) {
            try {

                Parameters.VarConnect = Objects.Connections.getConnetion();
                String Query = "INSERT INTO PARAMETROS  (ProgramName,VersionProgram,Os,UserPC,Company,UrlDataBase,RutaLog,IconoApp,IconoDB,ColorApp1,ColorApp2,ColorApp3,NumeroFact,Scanner) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = Parameters.VarConnect.prepareStatement(Query);
                ps.setString(1, "IMPRESORA TICKET");
                ps.setString(2, "   V.1.0.0");
                ps.setString(3, System.getProperty("os.name"));
                ps.setString(4, System.getProperty("user.name"));
                ps.setString(5, "FERRETERIA EL GRINGO");
                ps.setString(6, "C:\\Users\\" + UserPC + "\\AppData\\Roaming\\Printer" + Parameters.VersionProgram + "\\Data\\");
                ps.setString(7, "C:\\Users\\" + Parameters.UserPC + "\\AppData\\Roaming\\Printer" + Parameters.VersionProgram + "\\Logs\\LOG " + Objects.Methods.Fecha() + ".txt");
                ps.setString(8, "Logo2");
                ps.setString(9, "Access");
                ps.setInt(10, 16);
                ps.setInt(11, 135);
                ps.setInt(12, 75);
                boolean val = false;
                int Correlativo = -1;
                do {
                    try {
                        Correlativo = Integer.parseInt(JOptionPane.showInputDialog(null, "INGRESA CORRELATIVO DE FACTURA"));
                        val = false;
                    } catch (Exception e) {
                        Objects.Methods.MessageDialog("ERROR: " + e.getMessage(), "error");
                        val = true;
                    }
                } while (val);
                ps.setInt(13, Correlativo);
                IMPRESORA.CORRELATIVO.setText("A - " + Correlativo);
                ps.setBoolean(14, true);
                int n = ps.executeUpdate();
                if (n > 0) {
                    Objects.Methods.MessageDialog("RESET EXITOSO!", "DB");
                }
            } catch (SQLException e) {
                System.out.println(e);
                Objects.Logs.WriteLog("Error ParametrosDefault ", "No se Pudo Insertar Datos\n" + e);
            }
        }

    }

    public boolean DeleteParametros() {
        try {
            Parameters.VarConnect = Objects.Connections.getConnetion();
            String Query = "DELETE FROM PARAMETROS";
            PreparedStatement ps = Parameters.VarConnect.prepareStatement(Query);
            int n = ps.executeUpdate();
            if (n >= 0) {
                return true;
            }
        } catch (SQLException e) {
            return false;
        }
        return false;
    }

    public int LoadParameters() {
            try {
                Parameters.VarConnect = Objects.Connections.getConnetion();
                String sql = "SELECT * from PARAMETROS";
                Statement st = Parameters.VarConnect.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    ProgramName = rs.getString("ProgramName");
                    VersionProgram = rs.getString("VersionProgram");
                    Os = rs.getString("Os");
                    UserPC = rs.getString("UserPC");
                    Company = rs.getString("Company");
                    UrlDataBase = rs.getString("UrlDataBase");
                    RutaLog = rs.getString("RutaLog");
                    IconoApp = rs.getString("IconoApp");
                    IconoDB = rs.getString("IconoDB");
                    ColorApp1 = rs.getInt("ColorApp1");
                    ColorApp2 = rs.getInt("ColorApp2");
                    ColorApp3 = rs.getInt("ColorApp3");
                    NumeroFact = rs.getInt("NumeroFact");
                    Scanner = rs.getBoolean("Scanner");

                }
                if (NumeroFact == -1) {
                    ParametrosDefault();
                    this.LoadParameters();
                }
                return NumeroFact;
            } catch (Exception e) {
            }
        return NumeroFact;
    }
    
    public void ClenForm(){
        try {
           Parameters.VarConnect = Objects.Connections.getConnetion();
            String sql = "SELECT NumeroFact from PARAMETROS";
            Statement st = Parameters.VarConnect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                IMPRESORA.CORRELATIVO.setText("A - " + rs.getString("NumeroFact"));
                    IMPRESORA.Nombre.setText("");
                    IMPRESORA.Nit.setText("");
                    IMPRESORA.Fecha.setDatoFecha(null);
                    IMPRESORA.Direccion.setText("");
                    IMPRESORA.TLetras.setText("");
                    Objects.Tables.TablasRemoveRow(IMPRESORA.TablaImpresion, Tables.TablaImpresion);
                    IMPRESORA.Total.setText("Q.0.00");
                    IMPRESORA.scanner.requestFocus();
            } 
        } catch (Exception e) {
        }
            
    
    }
    
    public void setCorrelativo() {

        int Correlativo = 0;
        try {
            Parameters.VarConnect = Objects.Connections.getConnetion();
            String sql = "SELECT NumeroFact from PARAMETROS";
            Statement st = Parameters.VarConnect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Correlativo = rs.getInt("NumeroFact");
                Correlativo = Correlativo + 1;
            }
            try {
                Parameters.VarConnect = Objects.Connections.getConnetion();
                String Query = "UPDATE PARAMETROS SET NumeroFact=" + Correlativo;
                PreparedStatement ps = Parameters.VarConnect.prepareStatement(Query);
                int n = ps.executeUpdate();
                if (n > 0) {
                    IMPRESORA.CORRELATIVO.setText("A - " + Correlativo);
                    IMPRESORA.Nombre.setText("");
                    IMPRESORA.Nit.setText("");
                    IMPRESORA.Fecha.setDatoFecha(null);
                    IMPRESORA.Direccion.setText("");
                    IMPRESORA.TLetras.setText("");
                    Objects.Tables.TablasRemoveRow(IMPRESORA.TablaImpresion, Tables.TablaImpresion);
                    IMPRESORA.Total.setText("Q.0.00");
                    IMPRESORA.scanner.requestFocus();
                }
            } catch (SQLException e) {

            }
        } catch (Exception e) {
        }

    }

}
