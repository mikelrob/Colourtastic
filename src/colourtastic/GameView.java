package colourtastic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.JPanel;

/**
 * GameView class represents the game.
 * @author mikelrob
 */
public class GameView extends JPanel implements ActionListener, KeyListener{
    
    //framerate ivars
    int fps = 30;
    int delay = 1000/fps;
    
    //actor ivars
    Player2 me;
    
    public GameView(){
        Timer gameTimer = new Timer(delay, this);
        gameTimer.start();
        setFocusable(true);
        addKeyListener(this);
        LevelManager.loadLevel(1);
        me = new Player2();
    }
    
    /**
     * This method paints the game scene
     * @param g
     */
    @Override
    public void paint(Graphics g){
        //fill back ground
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        //draw player
        me.Draw(g);
        
        LevelManager.Draw(g);
    }

    /**
     * This method is triggered by Actions in the Game.
     * Including framerate timer, key presses etc
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
//        System.out.println(ae.getID());
//        System.out.println(System.currentTimeMillis());
        me.Update();
        this.repaint();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
//        System.out.println(ke.getKeyChar() + " typed");
    }

    @Override
    public void keyPressed(KeyEvent ke) {
//        System.out.println(ke.getKeyChar() + " pressed");
        int c = ke.getKeyCode();
        switch(c){
            case KeyEvent.VK_LEFT:
                //System.out.println("Left");
                me.moveLeft(true);
                break;
            case KeyEvent.VK_RIGHT:
                //System.out.println("Right");
                me.moveRight(true);
//                me.setPositionX(me.getPositionX() + 10);
                break;
            case KeyEvent.VK_UP:
                me.jump();
                break;
            case KeyEvent.VK_SPACE:
                me.respawn();
                break;
            default:
                System.out.println("Key not implemented");
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int c = ke.getKeyCode();
        switch(c){
            case KeyEvent.VK_LEFT:
                //System.out.println("Left");
                //me.setSpeedX(0);
                me.moveLeft(false);
                break;
            case KeyEvent.VK_RIGHT:
                //System.out.println("Right");
                //me.setSpeedX(0);
                me.moveRight(false);
                break;
            case KeyEvent.VK_UP:
                me.keyUp = false;
                break;
            case KeyEvent.VK_G:
                me.playerColor=Color.RED;
                break;
            case KeyEvent.VK_H:
                me.playerColor=Color.BLUE;
                break;
            case KeyEvent.VK_J:
                me.playerColor=Color.GREEN;
                break;
            default:
                System.out.println("Key not implemented");
        }
    }
}
