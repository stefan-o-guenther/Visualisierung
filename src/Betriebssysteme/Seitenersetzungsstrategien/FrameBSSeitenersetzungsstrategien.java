package Betriebssysteme.Seitenersetzungsstrategien;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FrameBSSeitenersetzungsstrategien extends JFrame {

	private final int LENGTH = 1024;
	private final int HEIGHT = 768;
	
    public FrameBSSeitenersetzungsstrategien() {

        initUI();
    }

    private void initUI() {

        setTitle("Belegungsstrategien");

        add(new PanelBSSeitenersetzungsstrategien());

        setSize(LENGTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
            	try {
            		FrameBSSeitenersetzungsstrategien fm = new FrameBSSeitenersetzungsstrategien();
                    fm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}            	
            }
        });
    }
}
