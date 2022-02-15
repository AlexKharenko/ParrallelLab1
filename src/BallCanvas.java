import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.*;

public class BallCanvas extends JPanel {
    private ArrayList<Ball> balls = new ArrayList<>();
    private ArrayList<Pocket> pockets = new ArrayList<>();
    private int balls_dropped = 0;

    public int getBallsDroppedNumber() {
        return balls_dropped;
    }

    public void makePockets() {
        pockets.add(new Pocket(0, 0));
        pockets.add(new Pocket(this.getWidth() / 2 - 30, 0));
        pockets.add(new Pocket(this.getWidth() - 30, 0));
        pockets.add(new Pocket(0, this.getHeight() - 30));
        pockets.add(new Pocket(this.getWidth() / 2 - 30, this.getHeight() - 30));
        pockets.add(new Pocket(this.getWidth() - 30, this.getHeight() - 30));
    }

    public boolean ballDropped(Ball b) {
        if (b.hasDropped(pockets)) {
            System.out.print("Ball dropped!");
            remove(b);
            return true;
        }
        return false;
    }

    public void remove(Ball b) {
        for (int i = 0; i < balls.size(); i++) {
            if (balls.get(i) == b) {
                balls.remove(i);
                balls_dropped++;
                break;
            }
        }
    }

    public void add(Ball b) {
        this.balls.add(b);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < balls.size(); i++) {
            Ball b = balls.get(i);
            b.draw(g2);
        }
        for (int i = 0; i < pockets.size(); i++) {
            Pocket p = pockets.get(i);
            p.draw(g2);
        }
    }
}
