package be.jslm.integration;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import be.jslm.domain.StockQuote;
import be.jslm.service.StockQuoteService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpStockQuoteServiceTest {
	
	private static final Logger log = LoggerFactory.getLogger(HttpStockQuoteServiceTest.class);
	
	/*
	 * Service under test: SpringBoot does not provide a autoconfigured restTemplate.
	 * 
	 * https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-restclient-customization
	 * 
	 * incapsulate where possible the behaviour in the class itself without outscoping stuff in the constructor (restTemplate in this example) 
	 */
	@Autowired
	private StockQuoteService service;
			
	/** 
	 * Integration Test - REST call to YQL over HTTP 
	 */
	@Test
	public void testStockQuote4Range() throws Exception {					
		List<StockQuote> stockQuoteList = service.getStockQuote4Range("BVN", null,  null);	
		Assert.notEmpty(stockQuoteList);
						
		StockQuote stockQuote = stockQuoteList.get(0);
		Assert.notNull(stockQuote);
		
	    Assert.isTrue(stockQuote.getLow() <= stockQuote.getClose(), "Low value should be lower or equal close ");
		Assert.isTrue(stockQuote.getClose() <= stockQuote.getHigh(), "High value should be higher or equal close ");						
		
	}
		
}
