package com.gs.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.gs.common.utils.LogMaker;

public class Configurations {
	private static Logger log = LogMaker.make();
	
	private static Map<String, String> config = new HashMap<String, String>();
	private static final String location = "classpath*:config-*.properties";
	static{
		init();
	}
	public static void init() {
		log.info(">>> start load config! <<<");
		PathMatchingResourcePatternResolver resolover = new PathMatchingResourcePatternResolver();
		Resource[] resources = null;
		try {
			resources = resolover.getResources(location);
			if(resources != null){
				for(Resource re : resources){
					Properties p = new Properties();
					p.load(re.getInputStream());
					for (Map.Entry<Object, Object> entry : p.entrySet()) {
						if(config.containsKey(entry.getKey().toString())){
							throw new Exception(String.format("键值%s重复", entry.getKey()));
						}else{
							config.put(entry.getKey().toString(), entry.getValue().toString());
						}
				    } 
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("配置文件加载异常");
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("配置文件加载异常");
		}
		log.info(">>> end load config! <<<");
	}

	public static String getProperty(String key, String defaultValue) {
		return null;
	}

	public static String getProperty(String key) {
		return config.get(key);
	}

	
	public static Integer getInteger(String key, Integer defaultValue) {
		String value = config.get(key);
		return value != null ? Integer.valueOf(value) : null;
	}

	public static String getInteger(String key) {
		return null;
	}

	public static void main(String[]args) throws IOException{
		System.out.println(getProperty("test"));
	}
}
