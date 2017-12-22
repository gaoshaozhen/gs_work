package com.gs.sdk.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;

import com.gs.common.utils.LogMaker;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class DefaultJedisTemplate implements JedisTemplate {
	private static Logger log = LogMaker.make();
	private static JedisPool pool;
	static {
		pool = new JedisFactory().getJedisPool();
	}

	private static Jedis getJedis() {
		return pool.getResource();
	}
	

	/**
	 * 关闭jedis
	 * 
	 * @param jedis
	 */
	public static void closeJedis(Jedis jedis) {
		if (jedis != null) {
			jedis.close();
		}
	}

	/**
	 * 字符串存储
	 */
	@Override
	public String set(String key, String value) {
		Jedis jedis = getJedis();
		String result = null;
		try {
			result = jedis.set(key, value);
		} catch (Exception e) {
			log.error("redis error", e);
			;
		} finally {
			closeJedis(jedis);
		}
		return result;
	}

	/**
	 * 获取字符串
	 */
	@Override
	public String get(String key) {
		Jedis jedis = getJedis();
		String result = null;
		try {
			result = jedis.get(key);
		} catch (Exception e) {
			log.error("redis error", e);
			;
		} finally {
			closeJedis(jedis);
		}
		return result;
	}

	/**
	 * 删除字符串,可传入多个key，会一并清除
	 */
	@Override
	public Long del(String... keys) {
		Jedis jedis = getJedis();
		Long result = null;
		try {
			result = jedis.del(keys);
		} catch (Exception e) {
			log.error("redis error", e);
		} finally {
			closeJedis(jedis);
		}
		return result;
	}

	/**
	 * 存储map，已存在key值就直接替换原来的所有field都会被清除掉，没有就创建
	 * 
	 */
	@Override
	public String hmset(String key, Map<String, String> value) {
		Jedis jedis = getJedis();
		String result = null;
		try {
			result = jedis.hmset(key, value);
		} catch (Exception e) {
			log.error("redis error", e);
		} finally {
			closeJedis(jedis);
		}
		return result;
	}

	/**
	 * 获取map中的值，field至少传入一个，否则会抛出异常
	 */
	@Override
	public List<String> hmget(String key, String... field) {
		Jedis jedis = getJedis();
		List<String> result = null;
		try {
			result = jedis.hmget(key, field);
		} catch (Exception e) {
			log.error("redis error", e);
		} finally {
			closeJedis(jedis);
		}
		return result;
	}

	/**
	 * 返回为指定key值的map的键的数量 如果有同名的不是map型的数据会抛出异常
	 */
	@Override
	public Long hlen(String key) {
		Jedis jedis = getJedis();
		Long result = null;
		try {
			result = jedis.hlen(key);
		} catch (Exception e) {
			log.error("redis error", e);
		} finally {
			closeJedis(jedis);
		}
		return result;
	}

	/**
	 * 检查是否存在key值
	 */
	@Override
	public Boolean exists(String key) {
		Jedis jedis = getJedis();
		Boolean result = null;
		try {
			result = jedis.exists(key);
		} catch (Exception e) {
			log.error("redis error", e);
		} finally {
			closeJedis(jedis);
		}
		return result;
	}

	/**
	 * 返回一个hash中左右的值,类型不是hash抛出异常
	 */
	@Override
	public Set<String> hkeys(String key) {
		Jedis jedis = getJedis();
		Set<String> result = null;
		try {
			result = jedis.hkeys(key);
		} catch (Exception e) {
			log.error("redis error", e);
		} finally {
			closeJedis(jedis);
		}
		return result;
	}
	
	@Override
	public Map<String, String> hgetAll(String key){
		Jedis jedis = getJedis();
		Map<String, String> result = null;
		try {
			result = jedis.hgetAll(key);
		} catch (Exception e) {
			log.error("redis error", e);
		} finally {
			closeJedis(jedis);
		}
		return result;
	}
	
	@Override
	public Long expire(String key, int seconds){
		Jedis jedis = getJedis();	
		Long result = null;
		try {
			result = jedis.expire(key, seconds);
		} catch (Exception e) {
			log.error("redis error", e);
		} finally {
			closeJedis(jedis);
		}
		return result;
	}


	public static void main(String[] args) {
//		PrintStream p = System.out;
//		Jedis jedis = new Jedis("localhost", 6379);
////		jedis.ex
////		 jedis.hk.set("x", "a");
//		 
////		Map<String, String> map = new HashMap<String, String>();
////		map.put("a", "1");
////		map.put("b", "2");
////		jedis.hmset("q", map);
////		jedis.get("q");
////		Console c = System.console();
		
		
//		System.out.println(JedisUtil.getClient().hkeys("ajaxForm"));
	}
}
