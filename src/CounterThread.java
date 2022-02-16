public class CounterThread extends Thread{
    private int MAXITER = 100000;
    private Counter counter;
    private boolean increment=true;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    public CounterThread(Counter counter, Boolean increment) {
        this.counter = counter;
        this.increment = increment;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < MAXITER) {
            try {
                if (increment) {
                    counter.increment();
                    // counter.syncIncrement();
                    // counter.syncBlockIncrement();
                    // counter.blockObjIncrement();
                } else {
                    counter.decrement();
                    // counter.syncDecrement();
                    // counter.syncBlockDecrement();
                    // counter.blockObjDecrement();
                }
            } catch (Exception e) {
            }
            // System.out.println("Thread name = "
            // + Thread.currentThread().getName());
            // Thread.sleep(5);
            i++;
        }
        counter.changeThreadComplToTrue(increment);
        counter.printResult();
    }
}
