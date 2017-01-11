package be.jslm.service;

import java.util.List;

import be.jslm.domain.Period;
import be.jslm.domain.StockQuote;

public interface HistoricalStockQuoteService {
	
	public List<StockQuote> getLastStockQuote(String symbol) throws Exception;
	
	
		
}
