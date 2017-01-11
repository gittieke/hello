package be.jslm.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import be.jslm.domain.StockQuote;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YQLResultsWrapper {

	@JsonProperty("quote")		
	private List<StockQuote> stockQuoteList;

	public List<StockQuote> getStockQuoteList() {
		return stockQuoteList;
	}

	public void setStockQuoteList(List<StockQuote> stockQuoteList) {
		this.stockQuoteList = stockQuoteList;
	}	
	
}
