package be.jslm.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import be.jslm.rest.client.StockQuoteRestClient;
import be.jslm.service.StockQuoteService;

@RunWith(SpringRunner.class)
@WebMvcTest(StockQuoteRestClient.class)
public class MockWebMvcTest {
	
	private static final Logger log = LoggerFactory.getLogger(MockWebMvcTest.class);	

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private StockQuoteService service;
    
    @Test
    public void mockTest() throws Exception {
    	
    }

/*TODO:when needed: focus on the client side for now    
    @Test
    public void mockGetStockQuote() throws Exception {
    	    	
    	
    	List<StockQuote> stockQuoteList = new ArrayList<StockQuote>(){{add(
    			new StockQuote("BVN", new LocalDate(2017,1,9), new Float(12.79), 1005700, new Float(13.00), new Float(12.44))
    	);}};
    	
    	// arrange
    	when(service.getStockQuote4Range("BVN",LocalDate.now(), LocalDate.now())).thenReturn(stockQuoteList);
    	
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
    	StockQuoteService service = mock(StockQuoteRestClient.class);
    	List l = service.getLastStockQuote("BVN");
    	verify(service).getLastStockQuote("BVN");
    	
    	// act    	
    	Iterator<StockQuote> iter = l.iterator();
    	while(iter.hasNext()){
    		log.info(iter.next().toString());
    	}    	    	    	
    }	
*/    
}