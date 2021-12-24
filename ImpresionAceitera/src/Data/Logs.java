/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin
 */
public class Logs {

    public void WriteLog(String Evento, String Texto) {
        Objects.Methods.CreateCarpets();
        File archivo; //variable para manipular al archivo
        FileWriter escribir; //Para escribir en el Archivo
        PrintWriter linea; // Para escribir en el Archivo
        System.out.println("Esta Entrando a WriteLog");
        archivo = new File(Parameters.RutaLog);
        System.out.println("Se Guarda la Ruta en archivo");
        System.out.println(archivo.exists());
        if (archivo.exists()==true) {
            try {
                System.out.println("ESTA ENTRANDO");
                archivo.createNewFile();
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);

                //Escribimos en el archivo
                linea.println("LOGS:");
                linea.println(Objects.Methods.Hora() + " " + Evento + ": " + Texto);
                linea.close();
            } catch (Exception e) {
                System.out.println("Esta Entrando en Catch: "+e.getMessage());
            }

        } else {
            try {
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                //Escribimos en el archivo
                linea.println(Objects.Methods.Hora() + " " + Evento + ": " + Texto);
                linea.close();
            } catch (Exception e) {
            }
        }

    }

    public void ReadLog() {
        try {
            BufferedReader leer = new BufferedReader(new FileReader(new File(Parameters.RutaLog)));
            String linea = leer.readLine();
            while (linea != null) {
                // Bitacora_Errores.txtlogs.append(linea + "\n");
                linea = leer.readLine();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "FALLO AL REALIZAR ESCRITURA EN LOG");
        }

    }

}
