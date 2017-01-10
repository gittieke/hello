package be.jslm;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

	public String symbol;
	public Date date;
	public String close;
	
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getClose() {
		return close;
	}
	
	public void setClose(String close) {
		this.close = close;
	}
	
	 @Override
	    public String toString() {
	        return "Quote{" +
	                "id=" + symbol +
	                ", quote='" + close + '\'' +
	                ", date='" + date + '\'' +
	                '}';
	    }	
	
	
}
/*
"quote": [
          {
        "Symbol": "BVN",
        "Date": "2016-04-18",
        "Open": "8.16",
        "High": "8.25",
        "Low": "7.98",
        "Close": "8.01",
        "Volume": "1285300",
        "Adj_Close": "7.990745"
        },
          {
        "Symbol": "BVN",
        "Date": "2016-04-15",
        "Open": "7.68",
        "High": "8.15",
        "Low": "7.66",
        "Close": "8.08",
        "Volume": "1936200",
        "Adj_Close": "8.060577"
        }
*/