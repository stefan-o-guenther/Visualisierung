package Rechnernetze.Congestion_Avoidance;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FrameRNCongestionAvoidance extends JFrame {

	private final int LENGTH = 1024;
	private final int HEIGHT = 768;
	
    public FrameRNCongestionAvoidance() {

        initUI();
    }

    private void initUI() {

        setTitle("Belegungsstrategien");

        add(new PanelRNCongestionAvoidance());

        setSize(LENGTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
            	try {
            		FrameRNCongestionAvoidance fm = new FrameRNCongestionAvoidance();
                    fm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}            	
            }
        });
    }
}
