package be.jslm.rest.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockQuoteController {
		
	@RequestMapping(value="/stockQuoteList", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String stockQuoteList() throws IOException {				
		String stockQuoteListJson = "C:\\Users\\id809201\\dev\\hello\\src\\main\\resources\\stock-quote-list.json";
		return new String(Files.readAllBytes(Paths.get(stockQuoteListJson)));				
	}
	
	@RequestMapping(value="/stockQuoteYQL", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String stockQuoteYQL() throws IOException {				
		String stockQuoteListJson = "C:\\Users\\id809201\\dev\\hello\\src\\main\\resources\\stock-quote-yql.json";
		return new String(Files.readAllBytes(Paths.get(stockQuoteListJson)));				
	}
}