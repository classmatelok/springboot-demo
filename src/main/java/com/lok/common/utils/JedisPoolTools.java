package com.lok.common.utils;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolTools {
	private static Logger logger = LoggerFactory.getLogger(JedisPoolTools.class);
	
	private static JedisPool jedisPool = null;
	private static String url ="" ;
    private static int port = 6379 ;
    private static String password ="" ;
    private static int maxTotal = 0 ;
    private static int database = 1 ;
    
    static{
          try {
        	  //方式一：通过输入流加载properties文件
        	 JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
             Properties pro = new Properties();
             InputStream in = JedisPoolTools.class.getResourceAsStream("/redis.properties" );
             pro.load(in);
             url = pro.getProperty("redis_url" );
             port = Integer.parseInt(pro.getProperty("redis_port" ));
             password = pro.getProperty("redis_password" );
             maxTotal = Integer.parseInt(pro.getProperty("redis_maxTotal" ));
             database = Integer.parseInt(pro.getProperty("redis_database" ));
             
             //方式二：直接通过spring的@PropertySource+@value("")注解读取，则可省掉上面加载代码
             // N/A
             
             jedisPoolConfig.setMaxTotal(maxTotal);
             jedisPool = new JedisPool(jedisPoolConfig,url,port,0,password,database);
             logger.info("jedisPool连接池:"+jedisPool);
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
    
    
    /**
     * 获取连接
     * @return
     */
	public static Jedis getJedis() {
    	Jedis jedis = null;
    	while (jedis==null) {
			try {
				jedis = jedisPool.getResource();
			} catch (Exception e) {
				closeJedis(jedis);
			}
		}
    	System.out.println(jedis);
    	return jedis;
    }
    
    /**
     * 释放连接(旧版本通过jedisPool.returnBrokenResource(jedis)释放)
     */
	public static void closeJedis(Jedis jedis) {
    	jedis.close();
    }
}
