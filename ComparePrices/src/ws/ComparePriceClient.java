package ws;


import java.text.MessageFormat;

import javax.ws.rs.core.*;
import com.sun.jersey.api.client.*;
import com.sun.jersey.api.client.config.*;



public class ComparePriceClient {

	private WebResource webResource;
	private Client client;
	private String walmartAPIComplete = "http://api.walmartlabs.com/v1/search?apiKey=rm25tyum3p9jm9x9x7zxshfa&query=iPod";
	private String walmartAPI = "http://api.walmartlabs.com/v1/search?apiKey=rm25tyum3p9jm9x9x7zxshfa&query=iPod&sort=price&order=asc";
	
	
	private String bestBuyAPI = "https://api.bestbuy.com/v1/?format=json?apiKey=pfe9fpy68yg28hvvma49sc89";
	
	private static final String REST_URI 
     = "https://api.bestbuy.com/v1/?format=json/?apiKey=pfe9fpy68yg28hvvma49sc89";
	// https://api.bestbuy.com/v1/products/8880044.json?apiKey=pfe9fpy68yg28hvvma49sc89
	
 
	public ComparePriceClient() {
		client = Client.create(new DefaultClientConfig());
		
		webResource = client.resource(walmartAPI).path("");
		
	}
	
	public String ComparePrice(String prod) {
		WebResource resource = webResource;
		resource = 
				resource.path(MessageFormat.format("", new Object[] {prod}));
		
		String result = resource.accept(MediaType.TEXT_PLAIN).get(String.class);
		
		return result;
		
	}

}
