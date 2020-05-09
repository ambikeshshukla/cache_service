package org.espressif.service.itf;

import org.espressif.dto.CacheDto;
import org.espressif.exception.CacheException;

public interface CacheManager {
    Object getValue(String key) throws CacheException;

    void putValue(CacheDto cacheDto);

    Object remove(String key) throws CacheException;

    void clearCache();
}
