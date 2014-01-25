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
    int fps = 24;
    int delay = 1000/fps;
    
    //actor ivars
    Player me;
    
    public GameView(){
        Timer gameTimer = new Timer(delay, this);
        gameTimer.start();
        setFocusable(true);
        addKeyListener(this);
        
        me = new Player();
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
        g.setColor(me.getColor());
        g.fillRect(me.getPositionX(), me.getPositionY(), me.getSizeX(), me.getSizeY());
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
        me.update();
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
                System.out.println("Left");
                me.setSpeedX(-10);
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("Right");
                me.setSpeedX(10);
//                me.setPositionX(me.getPositionX() + 10);
                break;
            case KeyEvent.VK_UP:
                System.out.println("Up");
                me.jump();
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
                System.out.println("Left");
                me.setSpeedX(0);
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("Right");
                me.setSpeedX(0);
                break;
            case KeyEvent.VK_UP:
                System.out.println("Up");
                break;
            default:
                System.out.println("Key not implemented");
        }
    }
}
