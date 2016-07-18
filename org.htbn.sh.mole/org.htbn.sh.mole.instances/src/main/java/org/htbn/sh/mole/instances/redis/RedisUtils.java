package org.htbn.sh.mole.instances.redis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Component
public class RedisUtils {
	
	private static Logger logger = LoggerFactory.getLogger(RedisUtils.class);
	
	@Autowired
	private RedisTemplate<Serializable, Object> redisTemplate;
	/**
	 * 写入缓存
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean setValueCache(final String key, String value, Long expireTime) {
		boolean result = false;
		try {
			ValueOperations<Serializable, Object> operations =  redisTemplate.opsForValue();
			operations.set(key, value);
			redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
			result = true;
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 写入缓存
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean setHashCache(final String key, Object value, Long expireTime) {
		boolean result = false;
		try {
			HashOperations<Serializable, Object,Object> operations =  redisTemplate.opsForHash();
			Map<String,Object> map = (JSONObject) JSON.toJSON(value);
			operations.putAll(key, map);
			//
			redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
			result = true;
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 写入缓存
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean setListCache(final String key, List<String> value, Long expireTime) {
		boolean result = false;
		try {
			ListOperations<Serializable, Object> operations =  redisTemplate.opsForList();
			operations.leftPushAll(key, value);
			redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
			result = true;
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 写入缓存
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean setSetCache(final String key, Set<Object> value, Long expireTime) {
		boolean result = false;
		try {
			SetOperations<Serializable,Object> operations =  redisTemplate.opsForSet();
			operations.add(key, value);
			//
			redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
			result = true;
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * 读取缓存
	 * 
	 * @param key
	 * @return
	 */
	public Object getValueCache(final String key) {
		Object result = null;
		ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
		result = operations.get(key);
		return result;
	}
	
	/**
	 * 读取缓存
	 * 
	 * @param key
	 * @return
	 */
	public Map<Object,Object> getHashCache(final String key) {
		HashOperations<Serializable, Object,Object> operations = redisTemplate.opsForHash();
		return operations.entries(key);
	}
	
	/**
	 * 读取缓存
	 * 
	 * @param key
	 * @return
	 */
	public List<Object> getListCache(final String key) {
		ListOperations<Serializable, Object> operations = redisTemplate.opsForList();
		return null;
	}
	/**
	 * 读取缓存
	 * 
	 * @param key
	 * @return
	 */
	public Set<Object> getSetCache(final String key) {
		Object result = null;
		SetOperations<Serializable, Object> operations = redisTemplate.opsForSet();
		return operations.members(key);
	}
}
