package com.myretail.business;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myretail.model.ProductName;
import com.myretail.model.ProductPrice;
import com.myretail.model.CurrentPrice;
import com.myretail.model.Product;

@Service
public class ProductBo {

	public Product getProduct(String productId) {

		RestTemplate restTemplate = new RestTemplate();   //RestTemplate is used to make HTTP requests
		ProductName productName = new ProductName();
		ProductPrice productPrice = new ProductPrice();

		try{

			 productName = restTemplate.getForObject("http://localhost:8080/productName/"+productId, ProductName.class);
			 productPrice = restTemplate.getForObject("http://localhost:8080/productPrice/"+productId, ProductPrice.class);

			Product product = new Product();


			CurrentPrice currentPrice = new CurrentPrice();
			product.setProductName(productName.getProductName());
			currentPrice.setCurrency(productPrice.getCurrency());
			currentPrice.setValue(productPrice.getProductPrice());

			product.setCurrentPrice(currentPrice);
			product.setProductId(productId);

			return product;


		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}


}
