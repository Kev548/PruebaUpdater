using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Security;

namespace Login
{
    public class Login
    {
        private const string APID = "8";
        private static string url = "http://192.168.0.24:3002";
        public static string UserLogged;


        public static string Autenticar(string usrid, string pas)
        {
            // valida si el usuario existe en el sistema
            var httpWebRequest = (System.Net.HttpWebRequest)WebRequest.Create(url + "/Login");
            httpWebRequest.ContentType = "application/json";
            httpWebRequest.Method = "POST";


            using (var streamWriter = new StreamWriter(httpWebRequest.GetRequestStream()))
            {
                string json = "{\"name\":\"" + usrid + "\"," +
                              "\"pass\":\"" + pas + "\"}";
                streamWriter.Write(json);
            }

            var httpResponse = (HttpWebResponse)httpWebRequest.GetResponse();
            using (var streamReader = new StreamReader(httpResponse.GetResponseStream()))
            {
                try
                {
                    var result = streamReader.ReadToEnd();
                    if (result.Equals("")) return "0";

                    JObject jObject = JObject.Parse(result);

                    string token = (string)jObject.SelectToken("token");
                    if (string.IsNullOrEmpty(token)) return "0";

                    HttpContext.Current.Session["tkn"] = (string)jObject.SelectToken("token");

                    // valida que el usuario tiene acceso en esta aplicacion
                    return AutenticarAplicacion(usrid);
                }
                catch
                {
                    return "0";
                }
            }
        }

        public static string AutenticarAplicacion(string User)
        {
            // valida en bd que el usuario tenga acceso a esta aplicacion

            var httpWebRequest = (HttpWebRequest)WebRequest.Create(url + "/LoginApp");
            httpWebRequest.ContentType = "application/json";
            httpWebRequest.Method = "POST";
            httpWebRequest.Headers.Add("access-token",
                Convert.ToString(HttpContext.Current.Session["tkn"]));

            using (var streamWriter = new StreamWriter(httpWebRequest.GetRequestStream()))
            {
                string json = "{\"apid\":\"" + APID + "\"}";
                streamWriter.Write(json);
            }

            var httpResponse = (HttpWebResponse)httpWebRequest.GetResponse();
            using (var streamReader = new StreamReader(httpResponse.GetResponseStream()))
            {
                try
                {
                    var result = streamReader.ReadToEnd();
                    JObject jObject = JObject.Parse(result);
                    if ((int)jObject.SelectToken("role") < 0) return "0";
                    HttpContext.Current.Session["role"] = (int)jObject.SelectToken("role");
                    UserLogged = User;
                    return "1";
                }
                catch
                {
                    return "0";
                }
            }
        }
    }
}