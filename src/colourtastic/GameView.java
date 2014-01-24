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
    public void paintComponent(Graphics g){
        //fill back ground
        g.setColor(Color.BLACK);
        g.fillRect(100, 100, 100, 100);
        
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
            case KeyEvent.VK_A:
                System.out.println("A");
                break;
            default:
                System.out.println("Key not implemented");
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        System.out.println(ke.getKeyChar() + " released");
    }
}
