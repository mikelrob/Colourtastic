/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colourtastic;

import java.util.*;
import java.awt.Graphics;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Conor
 */
public class LevelManager {
    
    public static List<Platform> platList = new ArrayList<Platform>();
    
    public static boolean loadLevel(int i){
        
        platList.clear();
        platList.add(new Platform(350, 290, 100, 20, 255, 255, 255));
        BufferedReader br = null;
 
        try {
 
            String sCurrentLine;
 
            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/Level" + i + ".txt"));
 
            while ((sCurrentLine = br.readLine()) != null) {
                String[] tempString = sCurrentLine.split(",");

                platList.add(new Platform(Integer.parseInt(tempString[0]),Integer.parseInt(tempString[1]),Integer.parseInt(tempString[2]),Integer.parseInt(tempString[3]),Integer.parseInt(tempString[4]),Integer.parseInt(tempString[5]),Integer.parseInt(tempString[6])));
            }
 
        } catch (IOException e) {
            
            e.printStackTrace();
        } finally {
            
            try {
                
                if (br != null)br.close();
            } catch (IOException ex) {
                
                ex.printStackTrace();
            }
        }
        
        return false;
    }
    
    
    public static void Draw(Graphics g){
        for(int i = 0; i < platList.size(); i++){
            Platform tempPlat = platList.get(i);
            
            g.setColor(new Color(tempPlat.platColor.getRed(),tempPlat.platColor.getGreen(),tempPlat.platColor.getBlue()));
            g.fillRect(tempPlat.platRect.x, tempPlat.platRect.y, tempPlat.platRect.width, tempPlat.platRect.height);
        }
        
    }
    
}
