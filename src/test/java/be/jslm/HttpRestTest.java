package be.jslm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import be.jslm.service.HistoricalStockQuoteService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpRestTest {
	
	private static final Logger log = LoggerFactory.getLogger(HttpRestTest.class);
	
	/*
	 * Service under test: SpringBoot does not provide a 
	 * 
	 * https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-restclient-customization
	 */
	//private HistoricalStockQuoteService service = new RestHistoricalStockQuoteService(new RestTemplateBuilder());
	@Autowired
	private HistoricalStockQuoteService service;
			
	/** 
	 * Integration Test - REST call to YQL over HTTP 
	 */
	@Test
	public void testGetLastStockQuote() {		
		log.info("test - service.getLastStockQuote");		
		service.getLastStockQuote("BVN");	
		log.info("test - service.getLastStockQuote");									
	}
}
