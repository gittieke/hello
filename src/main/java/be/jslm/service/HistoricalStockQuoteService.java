package be.jslm.service;

import java.util.List;

import be.jslm.pojo.Period;
import be.jslm.pojo.StockQuote;

public interface HistoricalStockQuoteService {
	
	public List<StockQuote> getLastStockQuote(String symbol) throws Exception;
	
	
		
}
