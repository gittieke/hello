package be.jslm.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import be.jslm.pojo.Period;
import be.jslm.pojo.StockQuote;
import be.jslm.service.HistoricalStockQuoteService;

@Service 
public class RestHistoricalStockQuoteService
implements HistoricalStockQuoteService {
	
	private static final Logger log = LoggerFactory.getLogger(RestHistoricalStockQuoteService.class);	
	
	@Autowired
	private RestTemplate restTemplate;	
	
	@Value("${yql.api}") 
	private String url;
	
	@Value("${yql.finance.historical}") 
	private String query;
	
	@Value("${yql.format}") 
	private String format;
	
	@Value("${yql.env}") 
	private String env;
	
   	public List<StockQuote> getLastStockQuote(String symbol){
   		return null;
   	}
	
   	public List<StockQuote> getStockQuote(String symbol, Enum<Period> period){
   		
   		log.info("symbol:" +symbol);
   		log.info("period:" +period);
							
		this.restTemplate.getForObject(queryBuilder(symbol, period), StockQuote.class);
		return null;
	/*	
		{
			  "query": {
			    "count": 2,
			    "created": "2017-01-10T07:56:54Z",
			    "lang": "en-US",
			    "results": {
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
			      ]
			    }
			  }
			}		
				
*/
		
		//restTemplate.getForObject(url, responseType, uriVariables)
		//restTemplate.getForObject(url, StockQuote.class);
	}
   	
   	private String queryBuilder(String symbol, Enum<Period> period){
   		
   		String where = String.format(" where symbol in (\"%s\")", symbol);
   		where += " and startDate = \"2016-04-15\" and endDate = \"2016-04-18\""; //TODO: logic to include period   					
		return url + "?q=" + query + where + "&" + format  + "&" +  env;
   	}

}
