package colourtastic;

import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Game Object class is the abstract base class 
 * @author mikelrob
 */
public abstract class GameObject {
    
    protected int sizeX, sizeY;
    protected int posX, posY;
    protected Color color;
    
    public GameObject(){
        sizeX = sizeY = posX = posY = 0;
        color = Color.WHITE;
    }
    
    /**
     * Abstract method use by game loop to tell game objects
     * to ready themselves
     */
    public abstract void update();
    
    public int getSizeX(){
        return sizeX;
    }
    
    public int getSizeY(){
        return sizeY;
    }
    
    public void setSizeX(int newX){
        sizeX = newX;
    }
    
    public void setSizeY(int newY){
        sizeY = newY;
    }
    
    public int getPositionX(){
        return posX;
    }
    
    public int getPositionY(){
        return posY;
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
