package Rechnernetze.Queueing_And_Loss.Example;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class QueueSim extends JFrame {

    public QueueSim() {
        initUI();
    }

    private void initUI() {
        setTitle("Queueing And Loss");
        add(new Content());
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

            	QueueSim sk = new QueueSim();
                sk.setVisible(true);
            }
        });
    }
}