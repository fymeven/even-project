package com.even.common.redis;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RedisCache implements Cache {

    private String keyPrefix = "shiro_redis_session:";

    @Resource(name = "redisUtil")
    private RedisUtil redisUtil;

    @Override
    public Object get(Object key){
        return redisUtil.get(keyPrefix+key.toString());
    }

    @Override
    public Object put(Object key, Object value) throws CacheException {
        try {
            redisUtil.set(keyPrefix+key.toString(), value);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Object remove(Object key) throws CacheException {
        try {
            if (redisUtil.exists(keyPrefix+key.toString())) {
                redisUtil.remove(keyPrefix+key.toString());
            }
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public void clear() {
        redisUtil.removePattern(keyPrefix + "*");
    }

    @Override
    public int size() {
        int size = redisUtil.getSize(keyPrefix + "*");
        return size;
    }

    @Override
    public Set keys() {
        Set keys = redisUtil.getKeys(keyPrefix + "*");
        return keys;
    }

    @Override
    public Collection values() {
        Set values=new HashSet();
        Set keys = this.keys();
        for (Object key : keys) {
            Object value = this.get(key);
            values.add(value);
        }
        return values;
    }

    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }
}
