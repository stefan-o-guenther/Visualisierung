package Betriebssysteme.Buddy_Systeme;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FrameBSBuddySysteme extends JFrame {

	private final int LENGTH = 1024;
	private final int HEIGHT = 768;
	
    public FrameBSBuddySysteme() {

        initUI();
    }

    private void initUI() {

        setTitle("Belegungsstrategien");

        add(new PanelBSBuddySysteme());

        setSize(LENGTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
            	try {
            		FrameBSBuddySysteme fm = new FrameBSBuddySysteme();
                    fm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}            	
            }
        });
    }
}
