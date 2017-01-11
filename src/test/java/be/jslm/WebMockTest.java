package be.jslm;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import be.jslm.domain.StockQuote;
import be.jslm.rest.client.HistoricalStockQuoteRestClient;
import be.jslm.service.HistoricalStockQuoteService;

@RunWith(SpringRunner.class)
@WebMvcTest(HistoricalStockQuoteRestClient.class)
public class WebMockTest {
	
	private static final Logger log = LoggerFactory.getLogger(WebMockTest.class);	

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private HistoricalStockQuoteService service;

    @Test
    public void mockGetStockQuote() throws Exception {
    	    	
    	
    	List<StockQuote> stockQuoteList = new ArrayList<StockQuote>(){{add(
    			new StockQuote("BVN", new LocalDate(2017,1,9), new Float(12.79), 1005700, new Float(13.00), new Float(12.44))
    	);}};
    	
    	// arrange
    	when(service.getLastStockQuote("BVN")).thenReturn(stockQuoteList);
    	
    	// act
    	List l = service.getLastStockQuote("BVN");
    	Iterator<StockQuote> iter = l.iterator();
    	while(iter.hasNext()){
    		log.info(iter.next().toString());
    	}
    	
    	// assert
    	    	 
    }
    
    @Test
    public void mockGetStockQuote2() throws Exception {
    	HistoricalStockQuoteService service = mock(HistoricalStockQuoteRestClient.class);
    	List l = service.getLastStockQuote("BVN");
    	verify(service).getLastStockQuote("BVN");
    	
    	// act    	
    	Iterator<StockQuote> iter = l.iterator();
    	while(iter.hasNext()){
    		log.info(iter.next().toString());
    	}
    	
    	
    	
    }	
    
}
