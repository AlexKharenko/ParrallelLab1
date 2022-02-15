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
        JLabel counterText = new JLabel("In pocket: 0");
        JButton buttonStart = new JButton("Start");
        JButton buttonStop = new JButton("Stop");
        buttonStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (startClick == 0) {
                    canvas.makePockets();
                }

                Ball b = new Ball(canvas, RandomColor.getRandomColor());
                canvas.add(b);

                BallThread thread = new BallThread(b, last_thread);
                thread.start();
                last_thread = thread;
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
        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStop);

        content.add(buttonPanel, BorderLayout.SOUTH);
    }
}