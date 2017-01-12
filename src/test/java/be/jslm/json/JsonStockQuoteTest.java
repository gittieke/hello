package be.jslm.json;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import be.jslm.domain.StockQuote;

@RunWith(SpringRunner.class)
@JsonTest
public class JsonStockQuoteTest {

    @Autowired 
    private JacksonTester<YQLResponseWrapper> json;
        
	@Value("classpath:${file.json.stock.quote.yql}")
	private Resource jsonStockQuoteYQL;

    @Test    
    public void testDeserializeStockQuoteYQL() throws Exception {
    	    	    	              	
    	YQLResponseWrapper yqlResponseWrapper = this.json.readObject(jsonStockQuoteYQL);
    	List<StockQuote> stockQuoteList = yqlResponseWrapper.getQueryWrapper().getResults().getStockQuoteList();
    	
		Assert.notEmpty(stockQuoteList);
						
		StockQuote stockQuote = stockQuoteList.get(0);
		Assert.notNull(stockQuote);
		
	    Assert.isTrue(stockQuote.getLow() <= stockQuote.getClose(), "Low value should be lower or equal close ");
		Assert.isTrue(stockQuote.getClose() <= stockQuote.getHigh(), "High value should be higher or equal close ");    	
    	
    }
}