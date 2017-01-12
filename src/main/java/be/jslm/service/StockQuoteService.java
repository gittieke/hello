package be.jslm.service;

import java.util.List;

import org.joda.time.LocalDate;

import be.jslm.domain.StockQuote;

public interface StockQuoteService {
	
	public StockQuote getCurrentStockQuote(String symbol) throws Exception;
	
	public List<StockQuote> getStockQuote4Range(String symbol, LocalDate startDate, LocalDate endDate) throws Exception;
				
}
