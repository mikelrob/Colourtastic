/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package colourtastic;

import javax.swing.JFrame;

/**
 *
 * @author mikelrob
 */
public class Colourtastic extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Colourtastic! A game of perception");
        
        //start the game
        Colourtastic game = new Colourtastic();
    }
    
    public Colourtastic(){
        //constructor
        setTitle("Colourtastic");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        GameView gameView = new GameView();
        this.add(gameView);
        
        setVisible(true);
    }
}
