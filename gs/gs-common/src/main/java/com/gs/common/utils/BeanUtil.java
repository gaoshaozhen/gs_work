package com.gs.common.utils;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtilsBean;

public class BeanUtil {
//	public static Map<String, Object> toMap(Object bean){
//		Map<String, Object> map = null;
//			try {
//				BeanUtils.populate(bean, map);
//			} catch (IllegalAccessException | InvocationTargetException e) {
//				e.printStackTrace();
//			}
//		return map;
//	}
	
	/**
	 * bean  转map   bean定义必须有public修饰  ，否则转化会失败
	 * @param obj
	 * @return
	 */
	 public static Map<String, Object> beanToMap(Object obj) { 
         Map<String, Object> params = new HashMap<String, Object>(0); 
         try { 
             PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean(); 
             PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj); 
             for (int i = 0; i < descriptors.length; i++) { 
                 String name = descriptors[i].getName(); 
                 if (!"class".equals(name)) { 
                     params.put(name, propertyUtilsBean.getNestedProperty(obj, name)); 
                 } 
             } 
         } catch (Exception e) { 
             e.printStackTrace(); 
         } 
         return params; 
 }
}
