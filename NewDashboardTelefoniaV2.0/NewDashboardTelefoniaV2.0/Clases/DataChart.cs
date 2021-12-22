using NewDashboardTelefoniaV2._0.Clases;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Script.Serialization;
using System.Xml;

namespace DashBoardTelefonia.Clases
{
    public class DataChart
    {
        /// <summary>
        /// Metodo que Consulta USP_GET_DATA_ESTADOS_POR_DIA_V2 
        /// Estrae los Valores por Dia entre un rango de fechas
        /// </summary>
        /// <param name="FechaIni"></param>
        /// <param name="FechaFin"></param>
        /// <returns></returns>
        public static string Estados_Por_Dia(string FechaIni,string FechaFin)
        {
            try
            {
                string Result = "";
                using (SqlConnection conn = new SqlConnection(NewDashboardTelefoniaV2._0.Properties.Settings.Default.Valor))
                {
                    conn.Open();
                    SqlDataAdapter da = new SqlDataAdapter();
                    DataTable dt = new DataTable();
                    da.SelectCommand = new SqlCommand("[USP_GET_DATA_ESTADOS_POR_DIA_V2]", conn);
                    da.SelectCommand.CommandTimeout = 0;
                    da.SelectCommand.Parameters.AddWithValue("@FECHAINI", FechaIni);
                    da.SelectCommand.Parameters.AddWithValue("@FECHAFIN", FechaFin);
                    da.SelectCommand.CommandType = CommandType.StoredProcedure;
                    da.Fill(dt);
                    Result = CreateJson(dt);
                    conn.Dispose();
                    conn.Close();
                }
                return Result;
            }
            catch (Exception e)
            {
                Log.Write("Estados_Por_Dia", e.ToString());
                return null;
                throw;
            }
            
        }

        /// <summary>
        /// Este Metodo consulta USP_GET_DATA_TRANSACCIONES_ESTADO_PROVEEDOR y devuelve los estados de transaccion por proveedor  del dia
        /// </summary>
        /// <param name="Fecha"></param>
        /// <returns></returns>
        public static string Transacciones_Estado_Proveedor(DateTime? Fecha = null)
        {
            try
            {
                string Result = "";
                if (Fecha == null) Fecha = DateTime.Today;

                using (SqlConnection conn = new SqlConnection(NewDashboardTelefoniaV2._0.Properties.Settings.Default.Valor))
                {
                    SqlDataAdapter da = new SqlDataAdapter();
                    DataTable dt = new DataTable();
                    conn.Open();

                    da.SelectCommand = new SqlCommand("[USP_GET_DATA_TRANSACCIONES_ESTADO_PROVEEDOR]", conn);
                    da.SelectCommand.CommandTimeout = 0;
                    da.SelectCommand.Parameters.AddWithValue("@FECHA", Fecha);
                    da.SelectCommand.CommandType = CommandType.StoredProcedure;
                    da.Fill(dt);
                    Result = CreateJson(dt);
                    conn.Dispose();
                    conn.Close();
                }
                return Result;
            }
            catch (Exception e)
            {
                Log.Write("Transacciones_Estado_Proveedor", e.ToString());
                return null;
                throw;
            }
            
        }

        /// <summary>
        /// Este Metodo consulta USP_GET_DATA_TRAZO_SALDO_V2 y busca la informacion dependiendo del Tipo Entre un Rango de Fechas
        /// </summary>
        /// <param name="FechaIni"></param>
        /// <param name="FechaFin"></param>
        /// <param name="Tipo"></param>
        /// <returns></returns>
        public static string Traza_Saldo(string FechaIni, string FechaFin,int Tipo)
        {
            try
            {
                string Result = "";
                using (SqlConnection conn = new SqlConnection(NewDashboardTelefoniaV2._0.Properties.Settings.Default.Valor))
                {
                    SqlDataAdapter da = new SqlDataAdapter();
                    DataTable dt = new DataTable();
                    conn.Open();
                    da.SelectCommand = new SqlCommand("[USP_GET_DATA_TRAZO_SALDO_V2]", conn);
                    da.SelectCommand.CommandTimeout = 0;
                    da.SelectCommand.Parameters.AddWithValue("@FECHAINI", FechaIni);
                    da.SelectCommand.Parameters.AddWithValue("@FECHAFIN", FechaFin);
                    da.SelectCommand.Parameters.AddWithValue("@TIPO", Tipo);
                    da.SelectCommand.CommandType = CommandType.StoredProcedure;
                    da.Fill(dt);
                    Result = CreateJson(dt);
                    conn.Dispose();
                    conn.Close();
                }

                return Result;
            }
            catch (Exception e)
            {
                Log.Write("Traza_Saldo", e.ToString());
                return null;
                throw;
            }
            
        }

        /// <summary>
        /// Este Metodo consulta USP_GET_DATA_DOUGHNUT_CHART_SALDO Que es el que extrae el saldo Actual 
        /// para la grafica de barra
        /// </summary>
        /// <param name="Fecha"></param>
        /// <returns></returns>
        public static string Saldo_Operador(DateTime? Fecha = null)
        {
            try
            {
                string Result = "";
                if (Fecha == null) Fecha = DateTime.Today;

                using (SqlConnection conn = new SqlConnection(NewDashboardTelefoniaV2._0.Properties.Settings.Default.Valor))
                {
                    SqlDataAdapter da = new SqlDataAdapter();
                    DataTable dt = new DataTable();
                    conn.Open();
                    da.SelectCommand = new SqlCommand("[USP_GET_DATA_DOUGHNUT_CHART_SALDO]", conn);
                    da.SelectCommand.CommandTimeout = 0;
                    da.SelectCommand.Parameters.AddWithValue("@FECHA", DateTime.Today);
                    da.SelectCommand.Parameters.AddWithValue("@TIPO", 1);
                    da.SelectCommand.CommandType = CommandType.StoredProcedure;
                    da.Fill(dt);
                    Result = CreateJson(dt);
                    conn.Dispose();
                    conn.Close();
                }
                return Result;
            }
            catch (Exception e)
            {
                Log.Write("Saldo_Operador", e.ToString());
                return null;
                throw;
            }
            
        }

        /// <summary>
        /// Este Metodo consulta USP_GET_AID_PARAMETRO y a travez de una Key retorna el Valor de un Parametro
        /// </summary>
        /// <param name="Condition"></param>
        /// <returns></returns>
        public static string Get_Parameter(string Condition)
        {
            try
            {
                string Result = "";
                using (SqlConnection conn = new SqlConnection(NewDashboardTelefoniaV2._0.Properties.Settings.Default.Valor))
                {
                    SqlDataAdapter da = new SqlDataAdapter();
                    DataTable dt = new DataTable();
                    conn.Open();
                    da.SelectCommand = new SqlCommand("[USP_GET_AID_PARAMETRO]", conn);
                    da.SelectCommand.CommandTimeout = 0;
                    da.SelectCommand.Parameters.AddWithValue("@Llave", Condition);
                    da.SelectCommand.CommandType = CommandType.StoredProcedure;
                    da.Fill(dt);
                    Result = CreateJson(dt);
                    conn.Dispose();
                    conn.Close();
                }
                
                return Result;
            }
            catch (Exception e)
            {
                Log.Write("Get_Parameter", e.ToString());
                return null;
                throw;
            }
            
        }
        
        /// <summary>
        /// INGRESA EL LIMITE DE COMPRA MAXIMA, MEDIA Y MINIMA SE NECESITA TENER UN USUARIO VALIDADO 
        /// </summary>
        /// <param name="MAX"></param>
        /// <param name="MED"></param>
        /// <param name="MIN"></param>
        /// <param name="USER"></param>
        /// <returns></returns>
        public static string Set_LimiteCompra(int MAX,int MED,int MIN,int USER)
        {
            try
            {
                string Result = "";
                using (SqlConnection conn = new SqlConnection(NewDashboardTelefoniaV2._0.Properties.Settings.Default.Valor))
                {
                    SqlDataAdapter da = new SqlDataAdapter();
                    DataTable dt = new DataTable();
                    conn.Open();
                    da.SelectCommand = new SqlCommand("[USP_SET_LIMITE_COMPRA]", conn);
                    da.SelectCommand.CommandTimeout = 0;
                    da.SelectCommand.Parameters.AddWithValue("@MAX", MAX);
                    da.SelectCommand.Parameters.AddWithValue("@MED", MED);
                    da.SelectCommand.Parameters.AddWithValue("@MIN", MIN);
                    da.SelectCommand.Parameters.AddWithValue("@USER", USER);
                    da.SelectCommand.CommandType = CommandType.StoredProcedure;
                    da.Fill(dt);
                    Result = CreateJson(dt);
                    conn.Dispose();
                    conn.Close();
                }
               
                return Result;
            }
            catch (Exception e)
            {
                Log.Write("Set_LimiteCompra", e.ToString());
                return null;
                throw;
            }

        }
       
        /// <summary>
        /// Metodo que serializa una Tabla y retorna un Json
        /// </summary>
        /// <param name="table"></param>
        /// <returns></returns>
        private static string CreateJson(DataTable table)
        {
            try
            {
                JavaScriptSerializer JavaScriptSerializer = new JavaScriptSerializer();
                JavaScriptSerializer.MaxJsonLength = 2147483647;
                List<Dictionary<string, object>> parentRow = new List<Dictionary<string, object>>();
                Dictionary<string, object> childRow;
                foreach (DataRow row in table.Rows)
                {
                    childRow = new Dictionary<string, object>();
                    foreach (DataColumn col in table.Columns)
                    {
                        childRow.Add(col.ColumnName, row[col]);
                    }
                    parentRow.Add(childRow);
                }
                return JavaScriptSerializer.Serialize(parentRow);
            }
            catch (Exception)
            {
                return null;
                throw;
            }
            
        }
    }
 }