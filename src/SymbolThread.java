
public class SymbolThread extends Thread {
    private Symbol symbol;
    private Printer printer;
    private Boolean sync = false;
    private int MAXITER = 5000;

    public SymbolThread(Symbol symbol, Printer printer) {
        this.symbol = symbol;
        this.printer = printer;
    }

    public SymbolThread(Symbol symbol, Printer printer, Boolean sync) {
        this.symbol = symbol;
        this.printer = printer;
        this.sync = sync;
    }

    @Override
    public void run() {
        int i = 0;
        try {
            while (i < MAXITER) {
                try {
                    if (sync) {
                        printer.printSymbolsSync(symbol);
                    } else {
                        printer.printSymbols(symbol);
                    }
                } catch (Exception e) {
                }
                // System.out.println("Thread name = "
                // + Thread.currentThread().getName());
                Thread.sleep(5);
                i++;
            }
        } catch (InterruptedException ex) {
        }
    }
}