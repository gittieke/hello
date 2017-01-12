package be.jslm.rest.client;

import java.util.List;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import be.jslm.domain.StockQuote;
import be.jslm.json.YQLResponseWrapper;
import be.jslm.service.StockQuoteService;

@Service 
public class StockQuoteRestClient
implements StockQuoteService {
	
	private static final Logger log = LoggerFactory.getLogger(StockQuoteRestClient.class);	
	
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
		
	public StockQuoteRestClient() {
		System.out.println("*** init Constructor ***"); //TODO:rmv
		this.restTemplate = new RestTemplate();		
	}
	
	public StockQuote getCurrentStockQuote(String symbol) throws Exception{return null;}
	
	public List<StockQuote> getStockQuote4Range(String symbol, LocalDate startDate, LocalDate endDate) throws Exception {
   		ResponseEntity<YQLResponseWrapper> resp = this.restTemplate.getForEntity(
   				queryBuilder(symbol), YQLResponseWrapper.class);
   		return resp.getBody().getQueryWrapper().getResults().getStockQuoteList();		
	}			           	   
   	   		   
   	private String queryBuilder(String symbol){   	
   		String where = String.format(" where symbol in (\"%s\")", symbol);
   		where += " and startDate = \"2016-04-15\" and endDate = \"2016-04-18\""; //TODO: logic to include period   	
		return url + "?q=" + query + where + "&" + format  + "&" +  env;
   	}

}
