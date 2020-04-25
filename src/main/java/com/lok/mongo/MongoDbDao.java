/**
 * @author Lok
 */
package com.lok.mongo;

//import java.util.List;
//
//import org.bson.Document;
//import org.springframework.data.mongodb.core.MongoTemplate;
//
//import com.lok.crud.domain.User;
//import com.mongodb.BasicDBObject;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.model.Filters;
//import com.mongodb.client.model.FindOneAndReplaceOptions;

public class MongoDbDao {
	
	//避免启动报错，此处屏蔽
	public void mongoDemo() {
		/*
		//工具类一
		//方式一：自主构造document，自由度高
		//MongoDatabase mongoDatabase = MongoDBUtil.getConnectByCredentials();
		MongoCollection<Document> docCollection = MongoDBUtil.getCollection("collection_name");
		Document doc = new Document();
		doc.append("Name", "name1");
		doc.append("Age", 20);
		docCollection.insertOne(doc);//需自己构造
		//方式二：直接用实体构造collection，操作方便
		MongoCollection<UserMongo> collection = MongoDBUtil.getCollection("collection_name", UserMongo.class);
		FindOneAndReplaceOptions options = new FindOneAndReplaceOptions();
		options.upsert(true);
		collection.findOneAndReplace(new BasicDBObject("id", "1"), new UserMongo(), options);//直接塞对应bean
		//通过一些泛型操作尤佳
		List<UserMongo> list = MongoDBUtil.getList("collection_name", UserMongo.class);
		List<UserMongo> listWithFilter = MongoDBUtil.getListWithFilter("collection_name", UserMongo.class, Filters.eq("id", 1));//或Filters.and、or或Bson实现类皆可
		MongoDBUtil.remove("collection_name", UserMongo.class, new BasicDBObject("name", "Jack"));
		
		//工具类二
//		MongoTemplate template = MongoTemplateUtil.getMongoTemplate();
//		template.insert(new UserMongo());
		
		//方式三：jpa
		 */
	}
	
}
