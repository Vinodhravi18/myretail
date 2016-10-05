package com.myretail.controller;

import com.myretail.business.ProductBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.model.Product;



@RestController						//Enables our class to listen for requests
@RequestMapping("/products")		//Filter to a specific path of request here /products
public class ProductController {

	@RequestMapping(value="/{productId}", method=RequestMethod.GET)
	public Product getProduct(@PathVariable String productId){

		ProductBo productBo = new ProductBo();
		return productBo.getProduct(productId);
	}


}
