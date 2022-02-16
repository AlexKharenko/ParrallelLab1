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

    public synchronized void printSymbolsSync(Symbol s) {
        if (line_count % MaxSymbLine == 0 && line_count != 0) {
            System.out.print('\n');
        }
        s.printSymbol();

        line_count++;
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
        }
    }
}
