package be.jslm.pojo;

import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 "Symbol": "BVN",
 "Date": "2016-04-18",
 "Open": "8.16",
 "High": "8.25",
 "Low": "7.98",
 "Close": "8.01",
 "Volume": "1285300",
 */

//StockQuote{id=BVN, date='null', close='0.0', volume='0', high='0.0', low='0.0}

@JsonIgnoreProperties(ignoreUnknown = true)
public class StockQuote {

	@JsonProperty("Symbol")
	private String symbol;
		
	private LocalDate date;
	
	@JsonProperty("Close")
	private float close;
	
	@JsonProperty("Volume")
	private long volume;
	
	@JsonProperty("High")
	private float high;
	
	@JsonProperty("Low")	
	private float low;

	public StockQuote(){};

	public StockQuote(String symbol, LocalDate date, float close, long volume,float high, float low) {
		this.symbol = symbol;
		this.date = date;
		this.close = close;
		this.volume = volume;
		this.high = high;
		this.low = low;
	}
		
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public float getClose() {
		return close;
	}

	public void setClose(float close) {
		this.close = close;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	public float getHigh() {
		return high;
	}

	public void setHigh(float high) {
		this.high = high;
	}

	public float getLow() {
		return low;
	}

	public void setLow(float low) {
		this.low = low;
	}

	@Override
	public String toString() {
		return "StockQuote{" + "symbol=" + symbol + ", date='" + date + '\''
				+ ", close='" + close + '\'' + ", volume='" + volume + '\''
				+ ", high='" + high + '\'' + ", low='" + low + '}';
	}

}

/*
 * { "query": { "count": 2, "created": "2017-01-10T07:56:54Z", "lang": "en-US",
 * "results": { "quote": [ { "Symbol": "BVN", "Date": "2016-04-18", "Open":
 * "8.16", "High": "8.25", "Low": "7.98", "Close": "8.01", "Volume": "1285300",
 * "Adj_Close": "7.990745" }, { "Symbol": "BVN", "Date": "2016-04-15", "Open":
 * "7.68", "High": "8.15", "Low": "7.66", "Close": "8.08", "Volume": "1936200",
 * "Adj_Close": "8.060577" } ] } } }
 */