package be.jslm;

import org.joda.time.LocalDate;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.json.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.json.*;
import org.springframework.test.context.junit4.*;

import be.jslm.pojo.StockQuote;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@JsonTest
public class JsonTestLastStockQuote {

    @Autowired
    private JacksonTester<StockQuote> json;

    @Test
    public void testSerialize() throws Exception {
    	StockQuote lastStockQuote = new StockQuote("BVN", new LocalDate(2017,1,9), new Float(12.79), 1005700, new Float(13.00), new Float(12.44));
        // Assert against a `.json` file in the same package as the test
        assertThat(this.json.write(lastStockQuote)).isEqualToJson("expected.json");
        // Or use JSON path based assertions
        assertThat(this.json.write(lastStockQuote)).hasJsonPathStringValue("@.Symbol");
        assertThat(this.json.write(lastStockQuote)).extractingJsonPathStringValue("@.Symbol")
                .isEqualTo("BVN");
    }

    //@Test
    /*
    public void testDeserialize() throws Exception {
        String content = "{\"make\":\"Ford\",\"model\":\"Focus\"}";
        assertThat(this.json.parse(content))
                .isEqualTo(new VehicleDetails("Ford", "Focus"));
        assertThat(this.json.parseObject(content).getMake()).isEqualTo("Ford");
    }*/

}
