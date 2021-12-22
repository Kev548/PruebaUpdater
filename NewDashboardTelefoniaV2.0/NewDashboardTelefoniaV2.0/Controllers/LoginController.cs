using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Controllers
{
    public class LoginController : Controller
    {
        //
        // GET: /Login/
        
        public ActionResult Index()
        {
            Session.Abandon();
            Response.Cache.SetCacheability(HttpCacheability.NoCache);
            Response.Cache.SetNoStore();
            Response.Cache.SetExpires(DateTime.UtcNow.AddHours(-1));
            Response.AppendHeader("Cache-Control", "no-store, no-cache, must-revalidate, post-check=0, pre-check=0");
            return View();
        }
        [HttpGet]
        public ActionResult Leave()
        {
            Session.Abandon();
            return Redirect("/Login/Index");
        }



        [HttpPost]
        public ActionResult Autenticar(string usrid, string pas)
        {
            string res = Login.Login.Autenticar(usrid, pas);
            if (res.Equals("0")) {
                Session.Abandon();
            }
            if (res.Equals("1"))
            {
                System.Web.Security.FormsAuthentication.SetAuthCookie(usrid, false);
            }
            return this.Content(res, "application/json", System.Text.Encoding.UTF8);
            
        }

    }
}
