import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int result = 0;
    private final ReentrantLock locker = new ReentrantLock();
    private boolean thread_dec_compl = false;
    private boolean thread_inc_compl = false;

    public void decrement() {
        result--;
    }

    public void increment() {
        result++;
    }

    public synchronized void syncDecrement() {
        result--;
    }

    public synchronized void syncIncrement() {
        result++;
    }

    public void blockObjDecrement() throws InterruptedException {
        try {
            locker.lock();
            result--;
        } finally {
            locker.unlock();
        }
    }

    public void blockObjIncrement() throws InterruptedException {
        try {
            locker.lock();
            result++;
        } finally {
            locker.unlock();
        }
    }

    public void syncBlockDecrement() {
        synchronized (this) {
            result--;
        }
    }

    public void syncBlockIncrement() {
        synchronized (this) {
            result++;
        }
    }

    public void changeThreadComplToTrue(Boolean is_increment) {
        if (is_increment) {
            thread_inc_compl = true;
        } else {
            thread_dec_compl = true;
        }
    }

    public void printResult() {
        if (thread_dec_compl == true &&
                thread_inc_compl == true) {
            System.out.print(result + " \n");
            thread_dec_compl = false;
            thread_inc_compl = false;
            result = 0;
        }
    }
}
