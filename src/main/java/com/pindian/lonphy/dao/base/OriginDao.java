package com.pindian.lonphy.dao.base;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OriginDao implements Dao {
	protected Session session;
	private Transaction transaction;
	private SessionFactory factory;
	public void begin() {
		Configuration cfg = new Configuration();
		factory = cfg.configure().buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();
	}
	public void commit() {
		transaction.commit();
		session.close();
		factory.close();
	}
	
	public void saveNewEntity(Object t) {
		begin();
		session.save(t);
		commit();
	}
	
	public <T> T findById(Class clazz, Serializable id) {
		begin();
		T t = (T) session.get(clazz, id);
		commit();
		return t;
	}
	
	public <T> List<T> findByCondition(Class clazz, String condition) {
		begin();
		List list = session.createQuery("from "+clazz.getSimpleName()+" where "+condition).list();
		commit();
		return list;
	}
	
	public void update(Class clazz, Serializable id,Object t) {
		begin();
		Object old = session.get(clazz, id);
		try {
			copyPropertiesExclude(t, old, new String[]{"id"});
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.update(old);
		commit();
	}
	
	public void delete(Class clazz, Serializable id) {
		begin();
		Object obj = session.get(clazz, id);
		if(obj!=null)
		session.delete(obj);
		commit();
	}
	
	/** 
     * 复制对象属性 
     *  
     * @param from 
     * @param to 
     * @param excludsArray 
     *            排除属性列表 
     * @throws Exception 
     */  
    public void copyPropertiesExclude(Object from, Object to,  
            String[] excludsArray) throws Exception {  
          
        List<String> excludesList = null;  
          
        if (excludsArray != null && excludsArray.length > 0) {  
              
            excludesList = Arrays.asList(excludsArray); // 构造列表对象  
        }  
          
        Method[] fromMethods = from.getClass().getDeclaredMethods();  
        Method[] toMethods = to.getClass().getDeclaredMethods();  
        Method fromMethod = null, toMethod = null;  
        String fromMethodName = null, toMethodName = null;  
          
        for (int i = 0; i < fromMethods.length; i++) {  
              
            fromMethod = fromMethods[i];  
            fromMethodName = fromMethod.getName();  
              
            if (!fromMethodName.contains("get"))  
                continue;  
            // 排除列表检测  
            if (excludesList != null  
                    && excludesList.contains(fromMethodName.substring(3)  
                            .toLowerCase())) {  
                  
                continue;  
            }  
            toMethodName = "set" + fromMethodName.substring(3);  
            toMethod = findMethodByName(toMethods, toMethodName);  
              
            if (toMethod == null)  
                continue;  
            Object value = fromMethod.invoke(from, new Object[0]);  
              
            if (value == null)  
                continue;  
            // 集合类判空处理  
            if (value instanceof Collection) {  
                  
                Collection<?> newValue = (Collection<?>) value;  
                  
                if (newValue.size() <= 0)  
                    continue;  
            }  
              
            toMethod.invoke(to, new Object[] { value });  
        }  
    }  
    public Method findMethodByName(Method[] methods, String name) {  
        
        for (int j = 0; j < methods.length; j++) {  
              
            if (methods[j].getName().equals(name)) {  
                  
                return methods[j];  
            }  
                  
        }  
        return null;  
    }  
}
