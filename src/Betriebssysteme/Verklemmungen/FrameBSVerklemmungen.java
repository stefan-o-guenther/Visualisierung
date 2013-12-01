package Betriebssysteme.Verklemmungen;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FrameBSVerklemmungen extends JFrame {

	private final int LENGTH = 1024;
	private final int HEIGHT = 768;
	
    public FrameBSVerklemmungen() {

        initUI();
    }

    private void initUI() {

        setTitle("Belegungsstrategien");

        add(new PanelBSVerklemmungen());

        setSize(LENGTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
            	try {
            		FrameBSVerklemmungen fm = new FrameBSVerklemmungen();
                    fm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}            	
            }
        });
    }
}
