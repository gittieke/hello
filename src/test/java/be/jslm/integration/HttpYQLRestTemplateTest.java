package be.jslm.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import be.jslm.domain.StockQuote;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource("/test.properties")
public class HttpYQLRestTemplateTest {
	
	private static final Logger log = LoggerFactory.getLogger(HttpYQLRestTemplateTest.class);
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Value("${yql.api}") 
	private String url;
	
	@Value("${yql.finance.historicaldata}") 
	private String query;
	
	@Value("${yql.format}") 
	private String format;
	
	@Value("${yql.env}") 
	private String env;
	
	/** 
	 * Integration Test - REST call to YQL over HTTP to test the connection to the outside (Proxy test)
	 */
	@Test
	@Timed(millis=1000)
	public void testProxy() {
				
		String whereClause = " where symbol in (\"BVN\") and startDate = \"2016-04-15\" and endDate = \"2016-04-18\"";
		String yqlUrl = url + "?q=" + query + whereClause + "&" + format  + "&" +  env;
		
		log.info(yqlUrl);		
		String resp = this.restTemplate.getForObject(yqlUrl, String.class);
		log.info(resp);					
	}
		
	//@Test:TODO: deserialise TEST: assert on high/low/vol/date
	public void test(){
		
		String whereClause = " where symbol in (\"BVN\") and startDate = \"2016-04-15\" and endDate = \"2016-04-18\"";	
		String restJsonUrl = url + "?q=" + query + whereClause  + "&" + format  + "&" +  env;
		
/*TODO: handle: http://wiki.fasterxml.com/JacksonInFiveMinutes
"query": {
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
    },{
     "Symbol": "BVN",
     "Date": "2016-04-15",
		 */
		
		StockQuote stockQuote = this.restTemplate.getForObject(restJsonUrl, StockQuote.class);
        log.info(stockQuote.toString());

		
	}

}
