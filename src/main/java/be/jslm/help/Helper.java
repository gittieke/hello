package be.jslm.help;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Helper {
	
	@Autowired
	private static ApplicationContext ctx;

	/** only one main in Spring Boot project
	public static void main (String args[]){
					
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
		    System.out.println(beanName);
		}	
	}*/

}