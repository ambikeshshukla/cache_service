package org.espressif.cache;

import java.util.Collection;
import java.util.Map;

public interface Cacheable<T> {

    void push(String id, T obj);

    T get(String key);

    T remove(String key);

    void clear();

    Map<String, T> getBulk(Collection<String> keyList);
}
