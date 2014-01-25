package colourtastic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.Rectangle;

/**
 *
 * @author Conor
 */
public class Player implements ActionListener{
    
    public Rectangle playerRect;
    private final int gravity = 2;
    private final int friction = 1;
    private final int capX = 5;
    
    private int speedX = 0, speedY = 0;
    private int velX = 0, velY = 0;
    private int posX = 0, posY = 0;
    
    public Color color;
    public boolean keyLeft, keyRight, keyUp;
    
    private Timer jumpTimer;
    private boolean isOnPlatform;
    
    public Player(){
        jumpTimer = new Timer(1000, this);
        playerRect = new Rectangle(400,100,25,25);
        posX = posY = 100;
        color = Color.YELLOW;
    }

    public void update() {
        speedY += gravity;
        velY += speedY;
        
        if(velY > 10){
            velY = 10;
        }
        
        if(!keyLeft && !keyRight){
            velX = 0;
        }
        
        if(keyLeft && !keyRight){
            velX += speedX;
            if(velX < -capX)
                velX = -capX;
        }
        if(keyRight && !keyLeft){
            velX += speedX;
            if(velX > capX)
                velX = capX;
        }
        
        velY = velY < 0 ? velY : (int)PhysicsCheck.checkDown(playerRect, velY);
        
        if(velY == 0){
            //System.out.println("true");
            setIsOnPlatform(true);
        }else{
            //System.out.println("false");
            setIsOnPlatform(false);
        }
        
        //System.out.println("velX: " + velX + " - velY: " + velY);
        
        posX += velX;
        posY += velY;
        
        playerRect.setLocation(posX, posY);
    }
    
    public void setSpeedX(int newX){
        speedX = newX; 
    }
    
    public void setSpeedY(int newY){
        System.out.println(velY);
        speedY = newY;
    }
    
    public void setIsOnPlatform(boolean newValue){
        isOnPlatform = newValue;
    }
    
    public boolean isOnPlatform(){
        return isOnPlatform;
    }
    
    public void jump(){
        if(isOnPlatform()){
            System.out.println("Jump");
            setSpeedY(-10);
            //jumpTimer.start();
            isOnPlatform = false;
        }
    }
    
    public Color getColor(){
        return color;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        //speedY = 9;
        //jumpTimer.stop();
    }
}
