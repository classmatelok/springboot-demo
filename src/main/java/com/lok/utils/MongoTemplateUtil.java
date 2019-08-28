/**
 * @author Lok
 */
package com.lok.utils;

import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

public class MongoTemplateUtil {
	
	private String host;
	private int point;
	private String username;
	private String password;
	private String databaseName;
	
	public MongoTemplate getMongoTemplate() {
		MongoClient mongoClient = new MongoClient(host, point);
		UserCredentials credential = new UserCredentials(username, password);
		return new MongoTemplate(mongoClient, databaseName, credential);
	}
	
}
