package com.myretail.configuration;

import java.util.Arrays;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
public class DBConfiguration {

	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception{
		
		MongoCredential credential = MongoCredential.createCredential("dbuser", "myretaildb", "dbpassword".toCharArray());
		ServerAddress serverAddress = new ServerAddress("ds049456.mlab.com",49456);
		
		MongoClient mongoClient = new MongoClient(serverAddress,Arrays.asList(credential));
		
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient,"myretaildb");
		
		return simpleMongoDbFactory;
	}
	
	
	public MongoTemplate mongoTemplate() throws Exception{
		return new MongoTemplate(mongoDbFactory());
	}

}
