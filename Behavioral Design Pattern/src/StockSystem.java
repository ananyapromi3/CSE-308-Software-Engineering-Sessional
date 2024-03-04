import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class StockSystem implements Serializable {
    private ArrayList<Stock> stocks;

    public StockSystem() {
        this.stocks = new ArrayList<>();
    }

    public ArrayList<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(ArrayList<Stock> stocks) {
        this.stocks = stocks;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }
}
