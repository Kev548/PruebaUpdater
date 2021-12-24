/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Objects;
import Data.Parameters;
import Graphic.AreaImpresion;
import Graphic.Historial;
import Graphic.IMPRESORA;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 *
 * @author Kevin
 */
public class Methods {

    public void MessageDialog(String Text, String Icon) {
        Icon Icono = new ImageIcon(getClass().getResource("/Resources/" + Icon + ".png"));
        JOptionPane.showMessageDialog(null, Text, "SISTEMA", JOptionPane.INFORMATION_MESSAGE, Icono);
    }

    public String Fecha() {
        String Fecha = Objects.Format_Fecha.format(Objects.Date);
        return Fecha;
    }

    public String Hora() {
        String Hora = Objects.Format_Hora.format(Objects.Date);
        return Hora;
    }

    public JLabel[] getLabelsPlantilla() {
        JLabel[] Variables = new JLabel[56];
        Variables[0] = AreaImpresion.F1C1;
        Variables[1] = AreaImpresion.F1C2;
        Variables[2] = AreaImpresion.F1C3;
        Variables[3] = AreaImpresion.F1C4;
        Variables[4] = AreaImpresion.F2C1;
        Variables[5] = AreaImpresion.F2C2;
        Variables[6] = AreaImpresion.F2C3;
        Variables[7] = AreaImpresion.F2C4;
        Variables[8] = AreaImpresion.F3C1;
        Variables[9] = AreaImpresion.F3C2;
        Variables[10] = AreaImpresion.F3C3;
        Variables[11] = AreaImpresion.F3C4;
        Variables[12] = AreaImpresion.F4C1;
        Variables[13] = AreaImpresion.F4C2;
        Variables[14] = AreaImpresion.F4C3;
        Variables[15] = AreaImpresion.F4C4;
        Variables[16] = AreaImpresion.F5C1;
        Variables[17] = AreaImpresion.F5C2;
        Variables[18] = AreaImpresion.F5C3;
        Variables[19] = AreaImpresion.F5C4;
        Variables[20] = AreaImpresion.F6C1;
        Variables[21] = AreaImpresion.F6C2;
        Variables[22] = AreaImpresion.F6C3;
        Variables[23] = AreaImpresion.F6C4;
        Variables[24] = AreaImpresion.F7C1;
        Variables[25] = AreaImpresion.F7C2;
        Variables[26] = AreaImpresion.F7C3;
        Variables[27] = AreaImpresion.F7C4;
        Variables[28] = AreaImpresion.F8C1;
        Variables[29] = AreaImpresion.F8C2;
        Variables[30] = AreaImpresion.F8C3;
        Variables[31] = AreaImpresion.F8C4;
        Variables[32] = AreaImpresion.F9C1;
        Variables[33] = AreaImpresion.F9C2;
        Variables[34] = AreaImpresion.F9C3;
        Variables[35] = AreaImpresion.F9C4;
        Variables[36] = AreaImpresion.F10C1;
        Variables[37] = AreaImpresion.F10C2;
        Variables[38] = AreaImpresion.F10C3;
        Variables[39] = AreaImpresion.F10C4;
        Variables[40] = AreaImpresion.F11C1;
        Variables[41] = AreaImpresion.F11C2;
        Variables[42] = AreaImpresion.F11C3;
        Variables[43] = AreaImpresion.F11C4;
        Variables[44] = AreaImpresion.F12C1;
        Variables[45] = AreaImpresion.F12C2;
        Variables[46] = AreaImpresion.F12C3;
        Variables[47] = AreaImpresion.F12C4;
        Variables[48] = AreaImpresion.F13C1;
        Variables[49] = AreaImpresion.F13C2;
        Variables[50] = AreaImpresion.F13C3;
        Variables[51] = AreaImpresion.F13C4;
        Variables[52] = AreaImpresion.F14C1;
        Variables[53] = AreaImpresion.F14C2;
        Variables[54] = AreaImpresion.F14C3;
        Variables[55] = AreaImpresion.F14C4;

        return Variables;
    }

    public void CreateCarpets() {
        try {
            if (new File("C:\\Users\\" + Parameters.UserPC + "\\AppData\\Roaming\\Printer" + Parameters.VersionProgram + "\\Logs\\").mkdirs()) {

            } else {
            }
        } catch (Exception e) {
            Objects.Logs.WriteLog("Error CreateCarpets", "Fallo al Crear Carpeta Logs\n" + e);
        }
        try {
            if (new File(Parameters.UrlDataBase).mkdirs()) {
                System.out.println("ESTA CREANDO URL DB");
            } else {
            }
        } catch (Exception e) {
            Objects.Logs.WriteLog("Error CreateCarpets", "Fallo al Crear Carpeta Logs\n" + e);
        }

    }

    public void SyncExcel(JTable TablaExcel) {
        this.DeleteDB();
        Object[] Array = new Object[8];
        for (int j = 0; j < TablaExcel.getRowCount(); j++) {
            for (int i = 0; i < TablaExcel.getColumnCount(); i++) {
                Array[i] = TablaExcel.getValueAt(j, i);
            }
            InsertIntoDB(Array);
        }

    }

    public void GuardarDocumento(JTable Tabla) {
        String[] Array = new String[4];
        for (int j = 0; j < Tabla.getRowCount(); j++) {
            for (int i = 0; i < Tabla.getColumnCount(); i++) {
                Array[i] = Tabla.getValueAt(j, i).toString();
            }
            this.GuardarFac(Array);
        }
    }

    public void MostarDocumentos() {

    }

    public void Historial() {
        try {
            LocalDate localDate = IMPRESORA.Fecha.getDatoFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
            Parameters.VarConnect = Objects.Connections.getConnetion();
            String Query = "INSERT INTO HISTORIAL  (Factura,Nombre,Direccion,Nit,Fecha,TotalLetras,Total) values (?,?,?,?,?,?,?)";
            PreparedStatement ps = Parameters.VarConnect.prepareStatement(Query);
            ps.setString(1, IMPRESORA.CORRELATIVO.getText());
            ps.setString(2, IMPRESORA.Nombre.getText());
            ps.setString(3, IMPRESORA.Direccion.getText());
            ps.setString(4, IMPRESORA.Nit.getText());
            ps.setDate(5, sqlDate);
            ps.setString(6, IMPRESORA.TLetras.getText());
            ps.setString(7, IMPRESORA.Total.getText());
            int n = ps.executeUpdate();
            if (n > 0) {
                System.out.println("SE INSERTO HISTORIAL");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Objects.Logs.WriteLog("Error GuardarFac ", "No se Pudo Insertar Datos\n" + e);
        }
    }

    public void ImprimirDocumento(JTable Tabla) {

        JLabel[] Val = this.getLabelsPlantilla();
        int c = 0;
        for (int j = 0; j < Tabla.getRowCount(); j++) {
            for (int i = 0; i < Tabla.getColumnCount(); i++) {
                Val[c++].setText(Tabla.getValueAt(j, i).toString());
            }
        }

        for (int i = c; i < Val.length; i++) {
            Val[i].setForeground(new java.awt.Color(255, 255, 255));
        }
    }

    public boolean InsertIntoDB(Object[] Array) {
        try {
            Parameters.VarConnect = Objects.Connections.getConnetion();
            String Query = "INSERT INTO PRODUCTOS  (Codigo,Descripcion,PrecioCosto,PrecioVenta,PrecioMayoreo,Existencia,InvMinimo,Departamento) values (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = Parameters.VarConnect.prepareStatement(Query);
            ps.setString(1, "" + Array[0]);
            ps.setString(2, "" + Array[1]);
            ps.setString(3, "" + Array[2]);
            ps.setString(4, "" + Array[3]);
            ps.setString(5, "" + Array[4]);
            ps.setString(6, "" + Array[5]);
            ps.setString(7, "" + Array[6]);
            ps.setString(8, "" + Array[7]);
            int n = ps.executeUpdate();
            if (n > 0) {
                System.out.println("DATOS INSERTADOS: " + Array[0] + " " + Array[1] + " " + Array[2] + " " + Array[3] + " " + Array[4] + "" + Array[5] + " " + Array[6] + " " + Array[7]);
            }
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            Objects.Logs.WriteLog("Error InsertIntoDB ", "No se Pudo Insertar Datos\n" + e);
            return false;
        }

    }

    public void DeleteDB() {
        try {
            Parameters.VarConnect = Objects.Connections.getConnetion();
            String Query = "DELETE FROM PRODUCTOS";
            PreparedStatement ps = Parameters.VarConnect.prepareStatement(Query);
            int n = ps.executeUpdate();
            if (n > 0) {
                Objects.Logs.WriteLog("Event", "SE BORRO " + Parameters.DbName);
            }
        } catch (SQLException e) {

        }
    }

    public boolean Importar(File archivo, JTable TablaExcel) {
        Workbook wb;

        boolean respuesta = false;
        DefaultTableModel modeloT = new DefaultTableModel();
        TablaExcel.setModel(modeloT);
        TablaExcel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        try {
            wb = WorkbookFactory.create(new FileInputStream(archivo));
            Sheet hoja = wb.getSheetAt(0);
            Iterator filaIterator = hoja.rowIterator();
            int indiceFila = -1;
            while (filaIterator.hasNext()) {
                indiceFila++;
                Row fila = (Row) filaIterator.next();
                Iterator columnaIterator = fila.cellIterator();
                Object[] listaColumna = new Object[10000];
                int indiceColumna = -1;
                while (columnaIterator.hasNext()) {
                    indiceColumna++;
                    Cell celda = (Cell) columnaIterator.next();
                    if (indiceFila == 0) {
                        modeloT.addColumn(celda.getStringCellValue());
                    } else if (celda != null) {
                        switch (celda.getCellType()) {
                            case Cell.CELL_TYPE_NUMERIC:
                                listaColumna[indiceColumna] = celda.getNumericCellValue();
                                break;
                            case Cell.CELL_TYPE_STRING:
                                listaColumna[indiceColumna] = celda.getStringCellValue();
                                break;
                            case Cell.CELL_TYPE_BOOLEAN:
                                listaColumna[indiceColumna] = celda.getBooleanCellValue();
                                break;

                            default:

                                break;
                        }
                        System.out.println("col" + indiceColumna + " valor: true - " + celda + ".");

                    }
                }
                if (indiceFila != 0) {
                    modeloT.addRow(listaColumna);
                }
            }

            respuesta = true;
        } catch (IOException | InvalidFormatException | EncryptedDocumentException e) {
            System.err.println(e.getMessage());
        }
        return respuesta;
    }

    public String FormatoDecimal(double precio) {
        String Retorno = Objects.DecimalFormat.format(precio);
        String Caracteres1 = "" + Retorno.charAt(0) + Retorno.charAt(1);
        String Caracteres2 = "" + Retorno.charAt(0);
        if (Caracteres1.equals("-.") == true) {
            String[] parts = Retorno.split("-");
            Retorno = "-0" + parts[1];
        }
        if (Caracteres2.equals(".") == true) {
            Retorno = "0" + Retorno;
        }
        return Retorno;
    }

    public void Calculos(JTable Tabla) {
        double Total = 0;
        double Precio;
        int Cantidad;
        for (int i = 0; i < Tabla.getRowCount(); i++) {
            Precio = 0;
            Cantidad = 0;
            Precio = Double.parseDouble(Tabla.getValueAt(i, 2).toString());
            Cantidad = Integer.parseInt(Tabla.getValueAt(i, 0).toString());
            Tabla.setValueAt(this.FormatoDecimal(Precio * Cantidad), i, 3);
            Total = Total + Double.parseDouble(Tabla.getValueAt(i, 3).toString());
        }

        IMPRESORA.Total.setText("Q." + FormatoDecimal(Total));
    }

    public void getProduct(String CodeProduct, JTable Tabla) {
        if (Tabla.getRowCount() <= 13) {
            try {
                Parameters.VarConnect = Objects.Connections.getConnetion();
                String Array[] = new String[20];
                String sql = "SELECT * from PRODUCTOS WHERE Codigo=  '" + CodeProduct + "' or Descripcion='" + CodeProduct + "'";
                System.out.println("sql = " + sql);
                Statement st = Parameters.VarConnect.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    try {
                        boolean ingreso = true;
                        for (int i = 0; i < Tabla.getRowCount(); i++) {
                            if (Tabla.getValueAt(i, 1).toString().equals(rs.getString("Descripcion")) == true) {
                                int cantidad = Integer.parseInt(Tabla.getValueAt(i, 0).toString()) + 1;
                                double precio = cantidad * Double.parseDouble(Tabla.getValueAt(i, 2).toString());
                                Tabla.setValueAt(cantidad, i, 0);
                                Tabla.setValueAt(this.FormatoDecimal(precio), i, 3);
                                ingreso = false;
                            }
                        }
                        if (ingreso == true) {
                            Array[0] = "" + 1;
                            Array[1] = rs.getString("Descripcion");
                            Array[2] = this.FormatoDecimal(Double.parseDouble(rs.getString("PrecioVenta")));
                            Array[3] = this.FormatoDecimal(Double.parseDouble(rs.getString("PrecioVenta")) * Double.parseDouble(Array[0]));
                            if(Array[2].equals("0.00")==false){
                            new Tables().InsertTabla(Tabla, Array);
                            }
                             if(Array[2].equals("0.00")==true){
                             Objects.Methods.MessageDialog(Array[1]+"\nNO TIENE PRECIO DE VENTA\nPRECIO VENTA = Q."+Array[2], "faltaprecio");
                             }
                        }
                        Calculos(Tabla);
                        IMPRESORA.TLetras.setText("");
                        IMPRESORA.scanner.setText("");
                        IMPRESORA.scanner.requestFocus();
                    } catch (Exception e) {
                        Objects.Methods.MessageDialog("Error: " + e.getMessage(), "error");
                        IMPRESORA.scanner.setText("");
                        IMPRESORA.scanner.requestFocus();
                    }

                }

            } catch (SQLException e) {
                Objects.Methods.MessageDialog("Error: " + e.getMessage(), "error");
                IMPRESORA.scanner.setText("");
                IMPRESORA.scanner.requestFocus();
            }
        } else {
            Objects.Methods.MessageDialog("LIMITE MAXIMO 14 FILAS", "Error");
        }
    }

    public void getSugerencia(JList Jlist, String Search, boolean Estado) {
        String sql = "";
        try {

            Jlist.removeAll();
            Tables.ListaModel.removeAllElements();
            Parameters.VarConnect = Objects.Connections.getConnetion();
            String Array[] = new String[20];
            if (Estado == true) {
                sql = "SELECT * from PRODUCTOS WHERE Descripcion like '" + Search + "%' order by Descripcion asc";
            }
            if (Estado == false) {
                sql = "SELECT * from PRODUCTOS WHERE Descripcion like '%" + Search + "%' order by Descripcion asc";
            }

            Statement st = Parameters.VarConnect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int Index = 0;
            while (rs.next()) {
                Tables.ListaModel.add(0, rs.getString("Descripcion"));
                Index = Index + 1;
            }
            Jlist.setModel(Tables.ListaModel);
            if (Tables.ListaModel.getSize() == 0 && Estado == true) {
                this.getSugerencia(Jlist, Search, false);
            }
        } catch (SQLException e) {
            e.getMessage();
        }

    }

    public void GuardarFac(String[] Detalle) {
        try {
            Parameters.VarConnect = Objects.Connections.getConnetion();
            String Query = "INSERT INTO DETALLE  (Factura,Cantidad,Descripción,PrecioU,Total) values (?,?,?,?,?)";
            PreparedStatement ps = Parameters.VarConnect.prepareStatement(Query);
            ps.setString(1, IMPRESORA.CORRELATIVO.getText());
            ps.setString(2, Detalle[0]);
            ps.setString(3, Detalle[1]);
            ps.setString(4, Detalle[2]);
            ps.setString(5, Detalle[3]);
            int n = ps.executeUpdate();
            if (n > 0) {
                System.out.println("SE INSERTO DETALLE");
            }
        } catch (SQLException e) {
            System.out.println("FALLO DETALLE" + e.getMessage());
            Objects.Logs.WriteLog("Error GuardarFac ", "No se Pudo Insertar Datos\n" + e);
        }
    }

    public void getHistorial() {
        try {
            Objects.Tables.TablasRemoveRow(Historial.TablaHistorial, Tables.TablaHistorial);
            Parameters.VarConnect = Objects.Connections.getConnetion();
            String Array[] = new String[20];
            String sql = "SELECT * from HISTORIAL ORDER BY Id DESC";
            Statement st = Parameters.VarConnect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Array[0] = rs.getString("Factura");
                Array[1] = rs.getString("Nombre");
                Array[2] = rs.getString("Direccion");
                Array[3] = rs.getString("Nit");
                Array[4] = rs.getString("Total");
                Tables.TablaHistorial.addRow(Array);
            }
            Historial.TablaHistorial.setModel(Tables.TablaHistorial);

        } catch (Exception e) {
        }

    }

    public java.util.Date SQLDateToDate(java.sql.Date sqlDate) {
        java.util.Date javaDate = null;
        if (sqlDate != null) {
            javaDate = new Date(sqlDate.getTime());
        }
        return javaDate;
    }

    public void SetPlantilla(JTable Tabla, boolean Re_Impresion) {
        String Factura = Tabla.getValueAt(Tabla.getSelectedRow(), 0).toString();
        String Array[] = new String[20];
        try {
            Parameters.VarConnect = Objects.Connections.getConnetion();

            String sql = "SELECT * from HISTORIAL WHERE Factura = '" + Factura + "'";
            Statement st = Parameters.VarConnect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                if (Re_Impresion == true) {
                    IMPRESORA.CORRELATIVO.setText(rs.getString("Factura"));
                }
                if (Re_Impresion == false) {
                    IMPRESORA.CORRELATIVO.setText("A - " + Parameters.NumeroFact);
                }
                IMPRESORA.Nombre.setText(rs.getString("Nombre"));
                IMPRESORA.Direccion.setText(rs.getString("Direccion"));
                IMPRESORA.Nit.setText(rs.getString("Nit"));
                if (Re_Impresion == true) {
                    IMPRESORA.Fecha.setDatoFecha(rs.getDate("Fecha"));
                }
                if (Re_Impresion == false) {
                    IMPRESORA.Fecha.setDatoFecha(null);
                }
                IMPRESORA.TLetras.setText(rs.getString("TotalLetras"));
                IMPRESORA.Total.setText(rs.getString("Total"));
            }

        } catch (Exception e) {
        }

        try {
            Objects.Tables.TablasRemoveRow(IMPRESORA.TablaImpresion, Tables.TablaImpresion);
            Parameters.VarConnect = Objects.Connections.getConnetion();
            String sql = "SELECT * from DETALLE WHERE Factura = '" + Factura + "'";
            Statement st = Parameters.VarConnect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Array[0] = rs.getString("Cantidad");
                Array[1] = rs.getString("Descripción");
                Array[2] = rs.getString("PrecioU");
                Array[3] = rs.getString("Total");
                Tables.TablaImpresion.addRow(Array);
            }
            IMPRESORA.TablaImpresion.setModel(Tables.TablaImpresion);

        } catch (Exception e) {
        }
        IMPRESORA.Re_Impresion = Re_Impresion;
        Windows.Historial.setVisible(false);
    }

}
