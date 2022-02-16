public class Printer {
    private int MaxSymbLine = 100;
    private int line_count = 0;

    public void printSymbols(Symbol s) {
        s.printSymbol();
        if (line_count % MaxSymbLine == 0 && line_count != 0) {
            System.out.print('\n');
        }
        line_count++;
    }

    public synchronized void printSymbolsSync(Symbol s) throws InterruptedException {
        if (line_count % MaxSymbLine == 0 && line_count != 0) {
            System.out.print('\n');
        }
        s.printSymbol();
        notify();

        line_count++;
        wait();
    }
}
