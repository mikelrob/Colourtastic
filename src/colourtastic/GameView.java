/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package colourtastic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JPanel;

/**
 *
 * @author mikelrob
 */
public class GameView extends JPanel implements ActionListener{
    
    int fps = 24;
    int delay = 1000/fps;
    
    public GameView(){
        Timer gameTimer = new Timer(delay, this);
        gameTimer.start();
    }
    
    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(100, 100, 100, 100);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
//        System.out.println(System.currentTimeMillis());
        this.repaint();
    }
}
