/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colourtastic;

import java.awt.Rectangle;
import java.awt.Color;

/**
 *
 * @author Conor
 */
public class Platform {
    
    public Color platColor;
    public int indexColor;
    
    public Rectangle platRect;
    
    public Platform(int x, int y, int w, int h, int r, int g, int b){
        platColor = new Color(r, g, b);
        platRect = new Rectangle(x, y, w, h);
    }
    
}

/*
public class Platform extends GameObject{
    
    @Override
    public void update(){
        
    }
}

*/