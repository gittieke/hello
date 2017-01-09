package be.jslm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloApplicationTests {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testJsonResponse(){
		
		String query = "select * from yahoo.finance.historicaldata";
		String whereClause = " where symbol in (\"BVN\") and startDate = \"2016-04-15\" and endDate = \"2016-04-18\"";
		String format = "&format=json&";
		String env = "&env=store://datatables.org/alltableswithkeys&callback=";

		String restJsonUrl = "http://query.yahooapis.com/v1/public/yql?q=" + query + whereClause + format + env;
		String restJsonResp = this.restTemplate.getForObject(restJsonUrl, String.class);
		
		System.out.println(restJsonResp);
	}
	
	@Test
	public void testJsonResults(){
		
		String query = "select * from yahoo.finance.historicaldata";
		String whereClause = " where symbol in (\"BVN\") and startDate = \"2016-04-15\" and endDate = \"2016-04-18\"";
		String format = "&format=json&";
		String env = "&env=store://datatables.org/alltableswithkeys&callback=";

		String restJsonUrl = "http://query.yahooapis.com/v1/public/yql?q=" + query + whereClause + format + env;

		
		ResponseEntity<Object[]> responseEntity = this.restTemplate.getForEntity(restJsonUrl, Object[].class);
		Object[] objects = responseEntity.getBody();
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();
	}

}
