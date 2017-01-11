package be.jslm.rest;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import be.jslm.pojo.Period;
import be.jslm.pojo.StockQuote;
import be.jslm.service.HistoricalStockQuoteService;

@Service 
public class RestHistoricalStockQuoteService
implements HistoricalStockQuoteService {
	
	private static final Logger log = LoggerFactory.getLogger(RestHistoricalStockQuoteService.class);	
	
	private final RestTemplate restTemplate = null;
	
	@Value("${yql.api}") 
	private String url;
	
	/*
    public RestHistoricalStockQuoteService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }*/	
    
    @Autowired
	private Environment env;
    	
   	public List<StockQuote> getLastStockQuote(String symbol){
   		
   		log.info("symbol:" +symbol);
   		log.info("url:" +url);
   		
		//this.restTemplate.getForObject(queryBuilder(symbol, period), StockQuote.class, new TypeReference<List<StockQuote>>(){});
   		String restJsonResp = this.restTemplate.getForObject(queryBuilder(symbol), String.class);
		log.info(restJsonResp);
		
		return null;
   		
   	}
	
   	public List<StockQuote> getStockQuote(String symbol, Enum<Period> period){
   		
   		log.info("symbol:" +symbol);
   		log.info("period:" +period);
							
		//this.restTemplate.getForObject(queryBuilder(symbol, period), StockQuote.class, new TypeReference<List<StockQuote>>(){});
   		String restJsonResp = this.restTemplate.getForObject(queryBuilder(symbol), String.class);
		log.info(restJsonResp);
   		
		return null;
	
		
		//restTemplate.getForObject(url, responseType, uriVariables)
		//restTemplate.getForObject(url, StockQuote.class);
	}
   	
   	private String queryBuilder(String symbol){
   		
   		String where = String.format(" where symbol in (\"%s\")", symbol);
   		where += " and startDate = \"2016-04-15\" and endDate = \"2016-04-18\""; //TODO: logic to include period   	
		return env.getProperty("yql.api") + "?q=" + env.getProperty("finance.historicaldata") + where + "&" + env.getProperty("yql.format")  + "&" +  env.getProperty("yql.env");
   	}

}
