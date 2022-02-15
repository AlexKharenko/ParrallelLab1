
public class SymbolThread extends Thread {
    private Symbol sym;
    private int MAXITER = 100;

    public SymbolThread(Symbol symbol) {
        sym = symbol;
    }

    @Override
    public void run() {
        int i = 0;
        try {
            while (i < MAXITER) {
                sym.PrintSymbols();
                System.out.println("Thread name = "
                + Thread.currentThread().getName());
                Thread.sleep(5);
                i++;
            }
        } catch (InterruptedException ex) {
        }
    }
}