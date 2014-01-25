/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colourtastic;

import java.awt.Rectangle;
import java.awt.geom.Point2D;
/**
 *
 * @author Conor
 */
public class PhysicsCheck {
    
    public static int checkDown(Rectangle hitbox, int yVelocity){
        
        Point2D cornerLeft = new Point2D.Float(hitbox.x, hitbox.y + hitbox.height);
        Point2D cornerRight = new Point2D.Float(hitbox.x + hitbox.width, hitbox.y + hitbox.height);
        
        Platform closestPlat = LevelManager.platList.get(0);
        int distance = 1000;
        
        for(int i = 0; i < LevelManager.platList.size(); i++){
            Platform tempPlat = LevelManager.platList.get(i);
            if(((cornerLeft.getX() > tempPlat.platRect.x) && (cornerLeft.getX() < tempPlat.platRect.x + tempPlat.platRect.width)) || ((cornerRight.getX() > tempPlat.platRect.x) && (cornerRight.getX() < tempPlat.platRect.x + tempPlat.platRect.width))){
                if(cornerLeft.getY() < tempPlat.platRect.y && cornerRight.getY() < tempPlat.platRect.y){
                    if(tempPlat.platRect.y - cornerLeft.getY() < distance){
                        closestPlat = tempPlat;
                        distance = (int)(tempPlat.platRect.y - cornerLeft.getY());
                    }
                }
            }
        }
        
        if(distance > yVelocity){
            return yVelocity;
        }else{
            return distance - 1;
        }
        
    }
    
    
    
    
    
    /*
    public static float checkDown(Rectangle hitbox, float yVelocity){
        
        if(yVelocity == 0){
            return 0;
        }
        
        Point2D cornerC = new Point2D.Float(hitbox.x, hitbox.y + hitbox.height);
        Point2D cornerD = new Point2D.Float(hitbox.x + hitbox.width, hitbox.y + hitbox.height);
        
        Platform Plat = LevelManager.platList.get(0);
        int minDistance = 1000;
        
        for(int i = 0; i < LevelManager.platList.size(); i++){
            
            Platform tempPlat = LevelManager.platList.get(i);
            
             if((cornerC.getX() > tempPlat.platRect.x && cornerC.getX() < tempPlat.platRect.x + tempPlat.platRect.width) || (cornerD.getX() > tempPlat.platRect.x && cornerD.getX() < tempPlat.platRect.x + tempPlat.platRect.width)){
                if(cornerC.getY() < tempPlat.platRect.y || cornerD.getY() < tempPlat.platRect.y){
                    
                    if(tempPlat.platRect.y - (hitbox.y + hitbox.height) < minDistance){
                        Plat = tempPlat;
                        minDistance = Plat.platRect.y - (hitbox.y + hitbox.height);
                    }
                }
             }
        }
        
        System.out.println(Plat.toString());
        
        int moveC = (int)((Plat.platRect.y) - cornerC.getY());
        int moveD = (int)((Plat.platRect.y) - cornerD.getY());
                    
                    
        if(moveC > yVelocity && moveD > yVelocity){
            return yVelocity;
        }
                    
                    System.out.println("moveC: " + moveC + "  -  moveD: " + moveD);
                    //if(moveC < moveD)
                    return moveC;
    }
        
        */
       
}
