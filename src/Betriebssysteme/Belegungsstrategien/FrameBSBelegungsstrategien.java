package Betriebssysteme.Belegungsstrategien;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FrameBSBelegungsstrategien extends JFrame {

	private final int LENGTH = 1024;
	private final int HEIGHT = 768;
	
    public FrameBSBelegungsstrategien() {

        initUI();
    }

    private void initUI() {

        setTitle("Belegungsstrategien");

        add(new PanelBSBelegungsstrategien());

        setSize(LENGTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
            	try {
            		FrameBSBelegungsstrategien fm = new FrameBSBelegungsstrategien();
                    fm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}            	
            }
        });
    }
}