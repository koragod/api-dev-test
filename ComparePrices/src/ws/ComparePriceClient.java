package ws;


import java.text.MessageFormat;

import javax.ws.rs.core.*;
import com.sun.jersey.api.client.*;
import com.sun.jersey.api.client.config.*;



public class ComparePriceClient {

	private WebResource webResourceWalmart;
	private WebResource webResourceBestBuy;
	private Client client;
	private String walmartAPI = "http://api.walmartlabs.com/v1/search";
	
	
	private String bestBuyAPI = "https://api.bestbuy.com/v1/products((search=iPad))?format=json";
	
	private static final String REST_URI 
     = "https://api.bestbuy.com/v1/?format=json/?apiKey=pfe9fpy68yg28hvvma49sc89";
	// https://api.bestbuy.com/v1/products/8880044.json?apiKey=pfe9fpy68yg28hvvma49sc89
	
 
	public ComparePriceClient() {
		client = Client.create(new DefaultClientConfig());
		webResourceWalmart = client.resource(walmartAPI).path("");
		webResourceBestBuy = client.resource(bestBuyAPI).path("");
		
	}
	
	
	public String ComparePrice(String prod) {
		WebResource resourceWalmart = webResourceWalmart;
		resourceWalmart = resourceWalmart.queryParam("apiKey","rm25tyum3p9jm9x9x7zxshfa").queryParam("query",prod).queryParam("order","asc");
		String resultWalmart = resourceWalmart.accept(MediaType.TEXT_PLAIN).get(String.class);
		
		
		
		WebResource resourceBestBuy = webResourceBestBuy;
		resourceBestBuy = resourceBestBuy.queryParam("apiKey","pfe9fpy68yg28hvvma49sc89");
		String resultBestBuy = resourceBestBuy.accept(MediaType.TEXT_PLAIN).get(String.class);
		
		
		
		return resultBestBuy;
		
	}

}
