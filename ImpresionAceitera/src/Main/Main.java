/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Data.Objects;
import Data.Parameters;
import Graphic.AreaImpresion;
import Graphic.IMPRESORA;
import Logic.Windows;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Kev
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Objects.Methods.CreateCarpets();
        Objects.Parameters.LoadParameters();
        Windows.IMPRESORA.setVisible(true);
        IMPRESORA.scanner.requestFocus();
    }
    
    
   

}
