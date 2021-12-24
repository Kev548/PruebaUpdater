/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Graphic.AreaImpresion;
import Graphic.Historial;
import Logic.Methods;
import Logic.Tables;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Kevin
 */
public class Objects {
     
    public static Logs Logs = new Logs();
    
    
    public static Date Date = new Date();
    public static DecimalFormat DecimalFormat = new DecimalFormat("#.00");
    public static DateFormat Format_Fecha = new SimpleDateFormat("dd-MM-yyyy");
    public static DateFormat Format_Hora = new SimpleDateFormat("HH:mm:ss");
    public static Methods Methods = new Methods();
    public static AreaImpresion AreaImpresion = new AreaImpresion();
    public static Tables Tables = new Tables();
    public static Connections Connections = new Connections();
    public static Parameters Parameters = new Parameters();
   

}
