import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BounceFrame extends JFrame {
    private BallCanvas canvas;
    private int startClick = 0;
    private BallThread last_thread;
    public static final int WIDTH = 480;
    public static final int HEIGHT = 350;

    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setTitle("Bounce programm");
        this.canvas = new BallCanvas();
        System.out.println("In Frame Thread name = "
                + Thread.currentThread().getName());
        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);
        JButton buttonStop = new JButton("Stop");
        JButton buttonSymbolOut1 = new JButton("Def count");

        buttonSymbolOut1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Counter counter = new Counter();
                CounterThread thread1 = new CounterThread(counter);
                CounterThread thread2 = new CounterThread(counter, false);
                thread1.start();
                thread2.start();
                System.out.println("Thread name = " +
                        thread1.getName());
                System.out.println("Thread name = " +
                        thread2.getName());
            }
        }); 

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

        buttonPanel.add(buttonSymbolOut1);
        buttonPanel.add(buttonStop);

        content.add(buttonPanel, BorderLayout.SOUTH);
    }
}