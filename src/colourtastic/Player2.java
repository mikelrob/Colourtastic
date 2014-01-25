/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colourtastic;

import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
/**
 *
 * @author Conor
 */
public class Player2 {
    
    public boolean wrapHor = true;
    public boolean wrapVert = true;
    
    public Rectangle playerRect; 
    public Color playerColor;
    private final int gravity = 2;
    private int speedX = 0, speedY = 0;
    private final int yCap = 50;
    private final int moveSpeed = 8;
    public boolean keyLeft, keyRight, keyUp;
    
    public Player2(){
        playerRect = new Rectangle(400,200,32,32);
        playerColor = Color.RED;
    }
    
    public void Update(){
        speedY += gravity;
        
        System.out.println(speedY);
        speedY = PhysicsCheck.checkDown(playerRect, speedY);
        
        if(speedY > yCap)
            speedY = yCap;
        
        if(wrapHor){
            if((playerRect.x + playerRect.width) < 0){
                playerRect.x = 800;
            }
            if(playerRect.x > 800){
                playerRect.x = 0 - playerRect.width;
            }
        }
        
        if(wrapVert){
            if((playerRect.y + playerRect.height) < 0){
                playerRect.y = playerRect.y + playerRect.height;
            }
            if(playerRect.y > 600){
                playerRect.y = 0 - playerRect.height;
            }
        }
        
        playerRect.setLocation((int)(playerRect.getX() + speedX), (int)(playerRect.getY() + speedY));
    }
    
    public void Draw(Graphics g){
        g.setColor(playerColor);
        g.fillRect(playerRect.x, playerRect.y, playerRect.width, playerRect.height);
        
    }
    
    public void moveRight(boolean moving){
        if(moving && !keyLeft){
            keyRight = true;
            speedX = moveSpeed;
        }else{
            keyRight = false;
            speedX = 0;
        }
    }
    
    public void moveLeft(boolean moving){
        if(moving && !keyRight){
            keyLeft = true;
            speedX = -moveSpeed;
        }else{
            keyLeft = false;
            speedX = 0;
        }
    }
    
    public void jump(){
        if(speedY == 0 && !keyUp){
            speedY = -25;
            keyUp = true;
        }
    }
    
    public void respawn(){
        playerRect.setLocation(playerRect.x,playerRect.y - 40);
        speedX = 0;
        speedY = 0;
    }
    
    
}
