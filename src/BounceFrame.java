import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BounceFrame extends JFrame {
    private BallCanvas canvas;
    private Color ballColorRed = Color.red;
    private Color ballColorBlue = Color.blue;
    private int startClick = 0;
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
        JLabel counterText = new JLabel("In pocket: 0");
        JButton buttonRed = new JButton("Add Red");
        JButton buttonBlue = new JButton("Add Blue");
        JButton buttonStop = new JButton("Stop");
        buttonRed.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (startClick == 0) {
                    canvas.makePockets();
                }

                Ball b = new Ball(canvas, ballColorRed);
                canvas.add(b);

                BallThread thread = new BallThread(b);
                thread.setPriority(10);
                thread.start();
                System.out.println("Thread name = " +
                        thread.getName());
                startClick++;
            }
        });
        buttonBlue.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (startClick == 0) {
                    canvas.makePockets();
                }

                Ball b = new Ball(canvas, ballColorBlue);
                canvas.add(b);

                BallThread thread = new BallThread(b);
                thread.setPriority(1);
                thread.start();
                System.out.println("Thread name = " +
                        thread.getName());
                startClick++;
            }
        });
        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

        ActionListener l1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counterText.setText("In pocket " + canvas.getBallsDroppedNumber());
            }
        };
        Timer t1 = new Timer(10, l1);
        t1.start();
        
        buttonPanel.add(counterText);
        buttonPanel.add(buttonRed);
        buttonPanel.add(buttonBlue);
        buttonPanel.add(buttonStop);

        content.add(buttonPanel, BorderLayout.SOUTH);
    }
}