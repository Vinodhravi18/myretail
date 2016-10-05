package com.myretail.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.myretail.model.ProductName;


@Service
public class ProductNameBo {


	@Autowired
	private MongoTemplate mongoTemplate;

	public ProductName getProductName(String productId) {

		try{
			Query query = new Query();
			query.addCriteria(Criteria.where("productId").is(productId));
			return mongoTemplate.findOne(query, ProductName.class);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}


}
