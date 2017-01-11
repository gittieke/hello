package be.jslm.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import be.jslm.pojo.StockQuote;
import be.jslm.service.HistoricalStockQuoteService;

@Service 
public class RestHistoricalStockQuoteService
implements HistoricalStockQuoteService {
	
	private static final Logger log = LoggerFactory.getLogger(RestHistoricalStockQuoteService.class);	
	
	private RestTemplate restTemplate;
		
	@Value("${yql.api}") 
	private String url;
	
	@Value("${yql.finance.historicaldata}") 
	private String query;
	
	@Value("${yql.format}") 
	private String format;
	
	@Value("${yql.env}") 
	private String env;
	
    //@Autowired
	//private Environment env;	
		
	public RestHistoricalStockQuoteService() {
		System.out.println("*** init Constructor ***");
		this.restTemplate = new RestTemplate();		
	}
	        	
   	public List<StockQuote> getLastStockQuote(String symbol){
   		
   		log.info("symbol:" +symbol);
   		log.info("url:" +url);
   		
		//this.restTemplate.getForObject(queryBuilder(symbol, period), StockQuote.class, new TypeReference<List<StockQuote>>(){});
   		String restJsonResp = this.restTemplate.getForObject(queryBuilder(symbol), String.class);
		log.info(restJsonResp);	
		return null;
   		
   	}
	   	
   	private String queryBuilder(String symbol){
   		
   		String where = String.format(" where symbol in (\"%s\")", symbol);
   		where += " and startDate = \"2016-04-15\" and endDate = \"2016-04-18\""; //TODO: logic to include period   	
		return url + "?q=" + query + where + "&" + format  + "&" +  env;
   	}

}
