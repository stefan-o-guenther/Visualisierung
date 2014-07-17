package Rechnernetze.Pipeline_Protocol.Test;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class HitTesting extends JFrame {

    public HitTesting() {
        
        setTitle("Hit testing");
        
        add(new Surface());
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 150);
        setLocationRelativeTo(null);           
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                HitTesting ht = new HitTesting();
                ht.setVisible(true);
            }
        });     
    }
}