package com.myretail.controller;

import com.myretail.business.ProductPriceBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.model.ProductPrice;

@RestController
@RequestMapping("/productPrice")
public class ProductPriceController {

	@Autowired
	public ProductPriceBo productPriceBo;

	@RequestMapping(value="/{productId}", method=RequestMethod.GET)
	public ProductPrice getProductPrice(@PathVariable String productId){
		return productPriceBo.getProductPrice(productId);
	}

}
