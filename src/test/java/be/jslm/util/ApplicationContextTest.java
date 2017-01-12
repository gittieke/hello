package be.jslm.util;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import be.jslm.service.StockQuoteService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationContextTest {
	
	private static final Logger log = LoggerFactory.getLogger(ApplicationContextTest.class);
		
	@Autowired
    private ApplicationContext applicationContext;
					
	@Test
	public void logBeanDefinitionNames() {
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
		    log.info(beanName);
		}
	}
	
}
