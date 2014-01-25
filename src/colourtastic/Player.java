package colourtastic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Conor
 */
public class Player extends GameObject implements ActionListener{
    
    private int speedX;
    private int speedY = 9;
    private Timer jumpTimer;
    private boolean isOnPlatform;
    
    public Player(){
        jumpTimer = new Timer(1000, this);
        posX = posY = 0;
        sizeX = sizeY = 50;
        color = Color.YELLOW;
    }

    @Override
    public void update() {
        posX += speedX;
        posY += speedY;
        
        System.out.println(posX + ", " + posY);
    }
    
    public void setSpeedX(int newX){
        speedX = newX;
    }
    
    public void setSpeedY(int newY){
        speedY = newY;
    }
    
    public void setIsOnPlatform(boolean newValue){
        isOnPlatform = newValue;
    }
    
    public boolean isOnPlatform(){
        return isOnPlatform;
    }
    
    public void jump(){
        if(isOnPlatform){
            speedY = -9;
            jumpTimer.start();
            isOnPlatform = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        speedY = 9;
        jumpTimer.stop();
    }
}
