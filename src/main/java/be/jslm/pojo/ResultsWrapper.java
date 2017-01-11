package be.jslm.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsWrapper {

	@JsonProperty("quote")		
	private List<StockQuote> stockQuoteList;

	public List<StockQuote> getStockQuoteList() {
		return stockQuoteList;
	}

	public void setStockQuoteList(List<StockQuote> stockQuoteList) {
		this.stockQuoteList = stockQuoteList;
	}	
	
}
