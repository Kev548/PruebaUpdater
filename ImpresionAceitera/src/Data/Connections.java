package Data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Connections {

    Connection CONEXION_DATABASE = null;
    Statement ESTABLECER = null;
    String rutafile = "";

//variables estaticas para que el user ponga la ruta
    public Connections() {

        try {
            if (Parameters.Os.equals("Linux")) {
                String User = System.getProperty("user.name");
                rutafile = "/home/kev/Documentos/GitHub/DB_MEDICAMENTOS.accdb";
                Parameters.UrlDataBase = rutafile;
                String Url = "jdbc:ucanaccess://" + rutafile + ";jackcessOpener=Data.CryptCodecOpener";
                CONEXION_DATABASE = DriverManager.getConnection(Url, Parameters.UserPC, Parameters.DbPassword);
                ESTABLECER = CONEXION_DATABASE.createStatement();

            }
            if (Parameters.Os.equals("Windows 10")) {
                String Url = "jdbc:ucanaccess://" + Parameters.UrlDataBase + Parameters.DbName + ".accdb" + ";jackcessOpener=Data.CryptCodecOpener";
                CONEXION_DATABASE = DriverManager.getConnection(Url, Parameters.UserPC, Parameters.DbPassword);
                ESTABLECER = CONEXION_DATABASE.createStatement();

            }
            if (Parameters.Os.equals("Windows 8.1")) {
                String Url = "jdbc:ucanaccess://" + Parameters.UrlDataBase + Parameters.DbName + ".accdb" + ";jackcessOpener=Data.CryptCodecOpener";
                CONEXION_DATABASE = DriverManager.getConnection(Url, Parameters.UserPC, Parameters.DbPassword);
                ESTABLECER = CONEXION_DATABASE.createStatement();

            }
            if (Parameters.Os.equals("Windows 7")) {
                String Url = "jdbc:ucanaccess://" + Parameters.UrlDataBase + Parameters.DbName + ".accdb" + ";jackcessOpener=Data.CryptCodecOpener";
                CONEXION_DATABASE = DriverManager.getConnection(Url, Parameters.UserPC, Parameters.DbPassword);
                ESTABLECER = CONEXION_DATABASE.createStatement();

            }

        } catch (SQLException e) {
            CrearDB();
        }
    }

     public void CrearDB() {
        try {
            Objects.Methods.CreateCarpets();
            Path Origen = Paths.get("C:\\Program Files\\" + Parameters.ProgramName + "\\" + Parameters.DbName + ".accdb");
            Path Destino = Paths.get("C:\\Users\\" + Parameters.UserPC + "\\AppData\\Roaming\\" + Parameters.ProgramName + Parameters.VersionProgram + "\\Data\\");
            Files.copy(Origen, Destino, StandardCopyOption.REPLACE_EXISTING);
            Objects.Methods.MessageDialog("SISTEMA:\nINSTALACION COMPLETA NECESITAMOS APLICAR CAMBIOS\nDEBES ABRIR NUEVAMENTE LA APLICACION", "DB_48X48");
            System.exit(0);
        } catch (IOException e) {
            try {
                Objects.Methods.CreateCarpets();
                Path Origen = Paths.get("C:\\Program Files (x86)\\" + Parameters.ProgramName + "\\" + Parameters.DbName + ".accdb");
                Path Destino = Paths.get("C:\\Users\\" + Parameters.UserPC + "\\AppData\\Roaming\\" + Parameters.ProgramName + Parameters.VersionProgram + "\\Data\\");
                Files.copy(Origen, Destino, StandardCopyOption.REPLACE_EXISTING);
                Objects.Methods.MessageDialog("SISTEMA:\nINSTALACION COMPLETA NECESITAMOS APLICAR CAMBIOS\nDEBES ABRIR NUEVAMENTE LA APLICACION", "DB_48X48");
                System.exit(0);
            } catch (IOException Error) {
                Objects.Methods.MessageDialog("EL SISTEMA NO PUDO REALIZAR LA REPARACION CONTACTE AL PROGRAMADOR\nCORREO: " + Parameters.DevelperNumber + "\nDETALLE DE ERROR\n" + Error, "Whatsapp");
                System.exit(0);
            }
        }

    }
    
    public Connection getConnetion() {

        return CONEXION_DATABASE;
    }

    public void Desconexion() {
        try {
            CONEXION_DATABASE.close();

        } catch (SQLException ex) {
            System.out.println("Error Desconexion " + "No se Pudo Desconectar la Base de Datos" + ex);

        }
    }

}
