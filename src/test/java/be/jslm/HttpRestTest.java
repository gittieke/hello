package be.jslm;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
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
	 * 
	 * incapsulate where possible the behaviour in the class itself without outscoping stuff in the constructor (restTemplate in this example) 
	 */
	//private HistoricalStockQuoteService service = new RestHistoricalStockQuoteService(new RestTemplateBuilder());
	@Autowired
	private HistoricalStockQuoteService service;
	
	@Autowired
    private ApplicationContext applicationContext;
			
	/** 
	 * Integration Test - REST call to YQL over HTTP 
	 */
	@Test
	public void testGetLastStockQuote() {		
		log.info("test - service.getLastStockQuote");		
		service.getLastStockQuote("BVN");	
		log.info("test - service.getLastStockQuote");									
	}
	
	@Test
	public void getBeanDefinitionNamesTest() {
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
		    System.out.println(beanName);
		}
	}
	
}
