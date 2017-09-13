package com.lok.utils;

import java.io.InputStream;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Description 
 * @author Xu Jiale
 * @date 2017年9月13日
 */

public class JedisPoolTools {
	//private static JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
	private static JedisPool jedisPool = null;
	
	private static String url ="" ;
    private static int port = 6379 ;
    private static String password ="" ;
    private static int maxTotal = 0 ;
    private static int database = 1 ;
    static{
          try {
        	 JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
              //将数据放在properties配置文件里，使移植性更强
             Properties pro = new Properties();
              //通过类文件得到类路径，再得到输入流
             InputStream in = JedisPoolTools.class .getResourceAsStream("/redis.properties" );
              //载入配置文件：
             pro.load(in);
             url = pro.getProperty("redis_url" );
             port = Integer.parseInt(pro.getProperty("redis_port" ));
             password = pro.getProperty("redis_password" );
             maxTotal = Integer.parseInt(pro.getProperty("redis_maxTotal" ));
             database = Integer.parseInt(pro.getProperty("redis_database" ));
             jedisPoolConfig.setMaxTotal(maxTotal);
             jedisPool = new JedisPool(jedisPoolConfig,url,port,0,password,database);
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
    
    /**
     * 获取连接
     * @return
     */
    public static Jedis getJedis() {
    	return jedisPool.getResource();
    }
    
    /**
     * 将连接放回连接池并关闭
     */
    public static void closeJedis(Jedis jedis) {
    	if (jedisPool!=null) {
    		jedisPool.returnResource(jedis);
			if (jedis!=null) {
				jedis.close();
			}
		}
    }
}
