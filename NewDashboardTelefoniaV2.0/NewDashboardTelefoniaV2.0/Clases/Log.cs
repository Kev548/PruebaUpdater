using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;

namespace NewDashboardTelefoniaV2._0.Clases
{
    public class Log
    {
        
        private static void VerifyDir(string path)
        {
            try
            {
                DirectoryInfo dir = new DirectoryInfo(path);
                if (!dir.Exists)
                {
                    dir.Create();
                }
            }
            catch { }
        }



        public static void Write(string Metodo,string Text)
        {
            string Path = "C:/DashBoardTelefoniaV2/";
            VerifyDir(Path);
            string Nombrelog = "Log - "+DateTime.Now.Day.ToString() +"-"+ DateTime.Now.Month.ToString() +"-"+ DateTime.Now.Year.ToString() + ".txt";
            try
            {
                System.IO.StreamWriter file = new System.IO.StreamWriter(Path + Nombrelog, true);
                file.WriteLine(DateTime.Now.ToString("HH:mm:ss") + "| Error "+ Metodo + " | " + Text);
                file.Close();
            }
            catch (Exception) {

            }
        }

    }
}