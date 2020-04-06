/**
 * @author Lok
 */
package com.lok.dao.impl;

//import org.bson.Document;
//import org.springframework.data.mongodb.core.MongoTemplate;

import com.lok.domain.User;
import com.lok.utils.MongoDBUtil;
import com.lok.utils.MongoTemplateUtil;
//import com.mongodb.client.MongoCollection;

public class MongoDbDao {
	
	/* 避免启动报错，此处屏蔽
	public void mongoDemo() {
		//工具类一
		//方式一：自主构造document，自由度高
		//MongoDatabase mongoDatabase = MongoDBUtil.getConnectByCredentials();
		MongoCollection<Document> docCollection = MongoDBUtil.getCollection("collection_name");
		Document doc = new Document();
		doc.append("Name", "name1");
		doc.append("Age", 20);
		docCollection.insertOne(doc);//需自己构造
		//方式二：直接用实体构造collection，操作方便
		MongoCollection<User> collection = MongoDBUtil.getCollection("collection_name", User.class);
		collection.insertOne(new User());//直接塞对应bean
		
		//工具类二
		MongoTemplate template = MongoTemplateUtil.getMongoTemplate();
		template.insert(new User());
		
		//方式三：jpa
	}
	*/
}
