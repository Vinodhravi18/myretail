package com.myretail.controller;

import com.myretail.business.ProductNameBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.model.ProductName;

@RestController
@RequestMapping("/productName")
public class ProductNameController {

	@Autowired
	private ProductNameBo productNameBo;

	@RequestMapping(value="/{productId}", method=RequestMethod.GET)
	public ProductName getProductName(@PathVariable String productId){
		return productNameBo.getProductName(productId);
	}

	
}
