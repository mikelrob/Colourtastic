package colourtastic;

import java.awt.Color;
import java.awt.Rectangle;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Game Object class is the abstract base class 
 * @author mikelrob
 */
public abstract class GameObject {
    
    protected Rectangle goRect;
    protected int sizeX, sizeY;
    protected int posX, posY;
    protected Color color;
    
    public GameObject(){
        goRect =  new Rectangle(0,0,0,0);
        color = Color.WHITE;
    }
    
    /**
     * Abstract method use by game loop to tell game objects
     * to ready themselves
     */
    public abstract void update();
    
    public int getSizeX(){
        return goRect.width;
    }
    
    public int getSizeY(){
        return goRect.height;
    }
    
    public int getPositionX(){
        return goRect.x;
    }
    
    public int getPositionY(){
        return goRect.y;
    }
    
    public void setPositionX(int newX){
        posX = newX;
    }
    
    public void setPositionY(int newY){
        posY = newY;
        
    }
    
    public Color getColor(){
        return color;
    }
}
