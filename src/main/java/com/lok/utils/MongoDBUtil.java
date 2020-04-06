package com.lok.utils;

import java.util.ArrayList;
import java.util.List;

//import org.bson.Document;
//
//import com.mongodb.MongoClient;
//import com.mongodb.MongoCredential;
//import com.mongodb.ServerAddress;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
 
//mongodb 连接数据库工具类，导包mongo-java-driver
public class MongoDBUtil {

	//以下信息可通过properties - @value方式注入
	private static String host;
	private static int point;
	private static String username;
	private static String password;
	private static String databaseName;
	
	/* 避免启动报错，此处屏蔽
    // 方式一：不通过认证获取连接数据库对象
    public static MongoDatabase getConnect(){
        //连接到 mongodb 服务
        MongoClient mongoClient = new MongoClient(host, point);
        //连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase(databaseName);
        //返回连接数据库对象
        return mongoDatabase;
    }
 
    // 方式二：需要密码认证方式连接
    public static MongoDatabase getConnectByCredentials(){
        List<ServerAddress> adds = new ArrayList<>();
        //ServerAddress()两个参数分别为 服务器地址 和 端口
        ServerAddress serverAddress = new ServerAddress(host, point);
        adds.add(serverAddress);
        
        List<MongoCredential> credentials = new ArrayList<>();
        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
        MongoCredential mongoCredential = MongoCredential.createScramSha1Credential(username, databaseName, password.toCharArray());
        credentials.add(mongoCredential);
        
        //通过连接认证获取MongoDB连接
        MongoClient mongoClient = new MongoClient(adds, credentials);
        //连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase(databaseName);
        //返回连接数据库对象
        return mongoDatabase;
    }
    
    public static MongoCollection<Document> getCollection(String connectionName){
    	MongoDatabase mongoDatabase = MongoDBUtil.getConnectByCredentials();
    	MongoCollection<Document> collection = mongoDatabase.getCollection(connectionName);
    	return collection;
    }
	public static <T> MongoCollection<T> getCollection(String connectionName, Class<T> clz){
		MongoDatabase mongoDatabase = MongoDBUtil.getConnectByCredentials();
		MongoCollection<T> collection = mongoDatabase.getCollection(connectionName, clz);
		return collection;
	}
	*/
}
