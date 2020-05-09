package org.espressif.service.impl;

import org.espressif.cache.AbstractCache;
import org.espressif.cache.LRUCache;
import org.espressif.dto.CacheDto;
import org.espressif.exception.CacheException;
import org.espressif.exception.ResourceNotFoundException;
import org.espressif.service.itf.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * Author: Ambikesh Shukla
 *
 * This class communicate with LRU cache to get the data from cache.
 *
 */
@Service
public class CacheManagerImpl implements CacheManager {

    private static final String CACHE_NAME = "lru_cache";

    private static final Logger log = LoggerFactory.getLogger(CacheManagerImpl.class);

    public static AbstractCache<Object> lruCache = null;

    public CacheManagerImpl() {
        if(lruCache == null) {
            lruCache = new LRUCache(CACHE_NAME);
        }
    }

    @Override
    public Object getValue(String key) throws CacheException {
        Object o = lruCache.get(key);
        if (o == null) {
            throw new ResourceNotFoundException("Value for this key is not present : " + key);
        }
        return lruCache.get(key);
    }

    @Override
    public void putValue(CacheDto cacheDto) {
        lruCache.push(cacheDto.getKey(), cacheDto.getValue());
    }

    @Override
    public Object remove(String key) throws CacheException {
        Object o = lruCache.remove(key);
        if (o == null) {
            throw new ResourceNotFoundException("Value for this key is not present : " + key);
        }
        return lruCache.remove(key);
    }

    @Override
    public void clearCache() {
        lruCache.clear();
    }
}
