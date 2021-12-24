/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Objects;
import Graphic.IMPRESORA;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kevin
 */
public class Tables {

    public static DefaultTableModel TablaImpresion = new DefaultTableModel();
    public static DefaultTableModel TablaHistorial = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int filas, int columnas) {
            return false;
        }
    };
    public static DefaultListModel ListaModel = new DefaultListModel();
    public void InsertTabla(JTable Tabla, String[] Texto) {
        try {
            TablasAddRow(Texto);
            Tabla.setModel(Tables.TablaImpresion);
        } catch (Exception e) {
            Objects.Logs.WriteLog("Error InsertTabla", "FALLO AL INSERTAR REGISTRO TABLA: " + Tabla.getName());
        }
    }
    public boolean TablasRemoveRow(JTable Tabla, DefaultTableModel Model) {
        if (Model.getRowCount() == 0) {
            return true;
        }
        if (Model.getRowCount() != 0) {
            for (int i = Tabla.getRowCount() - 1; i >= 0; i--) {
                Model.removeRow(i);
            }
            return true;
        }
        return false;
    }
    public void TablasAddRow(String[] Array) {
        Tables.TablaImpresion.addRow(Array);
    }
}
