package com.even.common.shiro;

import com.even.common.redis.RedisCache;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

public class CacheManager implements org.apache.shiro.cache.CacheManager {
    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return new RedisCache();
    }
}
