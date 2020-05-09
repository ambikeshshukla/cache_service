package org.espressif.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Ambikesh Shukla
 * This is used as cache and user can create your own cache by using this.
 *
 * @param <T>
 */
public abstract class AbstractCache<T> implements Cacheable<T> {

    protected static final Logger log = LoggerFactory.getLogger(AbstractCache.class);

    protected Map<String, T> cache;
    protected String name;

    public AbstractCache(String name) {
        this.name = name;
        init();
    }

    @Override
    public void push(String id, T obj) {
        if(cache != null){
            cache.put(id, obj);
        }
    }

    @Override
    public T get(String key) {
        return cache != null ? cache.get(key) : null;
    }

    @Override
    public T remove(String key) {
        return cache != null ? cache.remove(key) : null;
    }

    @Override
    public void clear() {
        if(cache != null) {
            cache.clear();
        }
    }

    public void init(){
        cache = new HashMap<>();
    }

    @Override
    public Map<String, T> getBulk(Collection<String> keyList) {
        throw new UnsupportedOperationException("getBulk is not Supported In LRU cache");
    }
}
