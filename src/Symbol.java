public class Symbol {
    private String symbol;
    public Symbol(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol(){
       return symbol;
    }

    public void printSymbol(){
        System.out.print(symbol);
    }
}
