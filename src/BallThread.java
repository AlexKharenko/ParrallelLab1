
public class BallThread extends Thread {
    private Ball b;
    private boolean stop = false;
    private int MAXITER = 10000;

    public BallThread(Ball ball) {
        b = ball;
    }

    @Override
    public void run() {
        int i = 0;
        try {
            while (!stop && i < MAXITER) {
                if (b.move()) {
                    System.out.println("Thread name = "
                            + Thread.currentThread().getName() + " was stopped! Priority: "+ Thread.currentThread().getPriority());
                    stop = true;
                }
                // System.out.println("Thread name = "
                // + Thread.currentThread().getName()+" "+ Thread.currentThread().getPriority());
                Thread.sleep(1);
                i++;
            }
        } catch (InterruptedException ex) {
        }
    }
}