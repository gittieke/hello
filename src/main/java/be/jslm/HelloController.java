package be.jslm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import be.jslm.service.StockQuoteService;

@Controller
public class HelloController {
	
	@Autowired
	private StockQuoteService stockQuoteService;
	
	@RequestMapping("/")
	public String home(String name, Model model) throws Exception {
		
		//List<StockQuote> stockQuoteList = stockQuoteService.getStockQuote4Range("BVN", null, null);
		//model.addAttribute("stockQuoteList", stockQuoteList);		
		return "home";
	}

}