package com.gs.sdk.redis;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import com.gs.common.utils.JsonUtil;

import redis.clients.jedis.JedisPool;

public class JedisFactory {
	public JedisPool getJedisPool() {
		JedisPool pool = new JedisPool();		
		return pool;
	}

	public JedisConfig getConfig() {
		JedisConfig config = null;
		try {
			config = JsonUtil.toObject(IOUtils.toString(new ClassPathResource(
					"redis.json").getInputStream(), "utf-8"), JedisConfig.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return config;
	}
}
