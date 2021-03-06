import java.util.ArrayList;
import java.util.Random;
import java.awt.geom.*;
import java.awt.*;

class Ball {
    private BallCanvas canvas;
    private static final int XSIZE = 20;
    private static final int YSIZE = 20;
    private int x = 0;
    private int y = 0;
    private int dx = 2;
    private int dy = 2;

    public Ball(BallCanvas c) {
        this.canvas = c;

        if (Math.random() < 0.5) {
            x = new Random().nextInt(this.canvas.getWidth());
            y = 0;
        } else {
            x = 0;
            y = new Random().nextInt(this.canvas.getHeight());
        }
    }

    public boolean hasDropped(ArrayList<Pocket> pockets) {
        for (int i = 0; i < pockets.size(); i++) {
            int[] p_cords = pockets.get(i).getCords();
            int[] p_size = pockets.get(i).getPocketSize();
            float dx = (p_cords[0] + p_size[0] / 2) - (x + XSIZE / 2);
            float dy = (p_cords[1] + p_size[1] / 2) - (y + YSIZE / 2);
            double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
            if (distance < XSIZE / 2) {
                return true;
            }
        }
        return false;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.darkGray);
        g2.fill(new Ellipse2D.Double(x, y, XSIZE, YSIZE));

    }

    public boolean move() {
        x += dx;
        y += dy;
        if (x < 0) {
            x = 0;
            dx = -dx;
        }
        if (x + XSIZE >= this.canvas.getWidth()) {
            x = this.canvas.getWidth() - XSIZE;
            dx = -dx;
        }
        if (y < 0) {
            y = 0;
            dy = -dy;
        }
        if (y + YSIZE >= this.canvas.getHeight()) {
            y = this.canvas.getHeight() - YSIZE;
            dy = -dy;
        }
        boolean dropped = this.canvas.ballDropped(this);
        this.canvas.repaint();
        return dropped;
    }
}