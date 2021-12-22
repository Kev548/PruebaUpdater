using DashBoardTelefonia.Clases;
using Login;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace NewDashboardTelefoniaV2._0.Controllers
{
    

    public class TelefoniaController : Controller
    {
        [Autorizar]
        public ActionResult Index()
        {
            return View();
        }
        [Autorizar]
        [HttpGet]
        public ActionResult GetEstadosPorDia(string FechaIni, string FechaFin)
        {
            return this.Content(DataChart.Estados_Por_Dia(FechaIni, FechaFin), "application/json", System.Text.Encoding.UTF8);
        }
        [Autorizar]
        [HttpGet]
        public ActionResult GetEstadoProveedor()
        {
            return this.Content(DataChart.Transacciones_Estado_Proveedor(), "application/json", System.Text.Encoding.UTF8);
        }
        [Autorizar]
        [HttpGet]
        public ActionResult Get_Parameter(string Condition)
        {
            return this.Content(DataChart.Get_Parameter(Condition), "application/json", System.Text.Encoding.UTF8);
        }
        [Autorizar]
        [HttpGet]
        public ActionResult Saldo_Operador(string Fecha)
        {
            return this.Content(DataChart.Saldo_Operador(), "application/json", System.Text.Encoding.UTF8);
        }
        [Autorizar]
        [HttpGet]
        public ActionResult Traza_Saldo(string FechaIni, string FechaFin, int Tipo)
        {
            return this.Content(DataChart.Traza_Saldo(FechaIni, FechaFin, Tipo), "application/json", System.Text.Encoding.UTF8);
        }
        [Autorizar]
        [HttpGet]
        public ActionResult Set_Limite_Compra(int MAX, int MED, int MIN,int USER)
        {
            return this.Content(DataChart.Set_LimiteCompra(MAX, MED, MIN, USER), "application/json", System.Text.Encoding.UTF8);
        }
    }
}