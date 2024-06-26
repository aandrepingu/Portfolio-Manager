/**
 * 
 */
package application;
import yahoofinance.*;
import java.util.HashSet;
/**
 * 
 */
public class StockContainer {
	private HashSet<Stock> myStocks;
	
	/**
	 * Constructor which creates a stock container from an array of stocks
	 * @param stocks Array of stocks to be put into this StockContainer
	 */
	public StockContainer(Stock[] stocks) {
		myStocks = new HashSet<Stock>();
		for(Stock stock : stocks) {
			myStocks.add(stock);
		}
	}
}
