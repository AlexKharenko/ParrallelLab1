
public class BallThread extends Thread {
    private Ball b;
    private boolean stop = false;
    private BallThread block_thread;
    private int MAXITER = 10000;

    public BallThread(Ball ball) {
        b = ball;
    }

    public BallThread(Ball ball, BallThread block_thread) {
        b = ball;
        this.block_thread = block_thread;
    }

    @Override
    public void run() {
        int i = 0;
        try {
            if (block_thread != null){
                block_thread.join();
                block_thread = null;
            }
                while (!stop && i > MAXITER) {
                    if (b.move()) {
                        System.out.println("Thread name = "
                                + Thread.currentThread().getName() + " was stopped!");
                        stop = true;
                    }
                    // System.out.println("Thread name = "
                    //         + Thread.currentThread().getName());
                    Thread.sleep(5);
                    i++;
                }
        } catch (InterruptedException ex) {
        }
    }
}