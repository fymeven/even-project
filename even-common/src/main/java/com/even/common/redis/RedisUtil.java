package com.even.common.redis;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis cache 工具类
 * Created by fymeven on 2017/7/23.
 */
public final class RedisUtil {
    private Logger logger = Logger.getLogger(RedisUtil.class);

    @Resource(name = "redisTemplate")
    private RedisTemplate<Serializable, Object> redisTemplate;

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 获取表达式key的size
     * @param pattern
     * @return
     */
    public int getSize(String pattern){
        Set<Serializable> keys = redisTemplate.keys(pattern);
        return keys.size();
    }

    /**
     * 获取表达式key的集合
     * @param pattern
     * @return
     */
    public Set getKeys(String pattern){
        Set keys = redisTemplate.keys(pattern);
        return keys;
    }

    /**
     * 获取表达式value的集合
     * @param pattern
     * @return
     */
    public Set getValues(String pattern) {
        Set values=new HashSet();
        Set keys = this.getKeys(pattern);
        for (Object key : keys) {
            Object value = this.get((String) key);
            values.add(value);
        }
        return values;
    }


    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate
                .opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
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
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setRedisTemplate(
            RedisTemplate<Serializable, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}