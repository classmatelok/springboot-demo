/**
 * @author Lok
 */
package com.lok.dao.impl;

import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.lok.domain.User;
import com.lok.utils.MongoDBUtil;
import com.lok.utils.MongoTemplateUtil;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDbDao {
	
	public void mongoDemo() {
		//1st
		MongoDatabase mongoDatabase = MongoDBUtil.getConnectByCredentials();
		MongoCollection<Document> collection = mongoDatabase.getCollection("collection_name");
		Document doc = new Document();
		doc.append("Name", "name1");
		doc.append("Age", 20);
		collection.insertOne(doc);
		
		//2nd
		MongoTemplateUtil mongoTemplateUtil = new MongoTemplateUtil();
		MongoTemplate template = mongoTemplateUtil.getMongoTemplate();
		template.insert(new User());
	}
	
}
