/**
 * @author Lok
 */
package com.lok.utils;

import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

//导包spring-boot-starter-data-mongodb
public class MongoTemplateUtil {
	
	private static String host;
	private static int point;
	private static String username;
	private static String password;
	private static String databaseName;
	
	public static MongoTemplate getMongoTemplate() {
		MongoClient mongoClient = new MongoClient(host, point);
		UserCredentials credential = new UserCredentials(username, password);
		return new MongoTemplate(mongoClient, databaseName, credential);
	}
	
}
