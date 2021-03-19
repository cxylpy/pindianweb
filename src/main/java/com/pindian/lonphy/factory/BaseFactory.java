package com.pindian.lonphy.factory;

import java.util.HashMap;

public class BaseFactory {
	private static HashMap<String,Object> set = new HashMap<String,Object>();
	public static <T> T getInstance(Class clazz) {
		if(set.containsKey(clazz.getSimpleName())) {
			return (T) set.get(clazz.getSimpleName());
		} else {
			Object o = null;
			try {
				o = clazz.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			set.put(clazz.getSimpleName(), o);
			return (T) o;
		}
	}
}
