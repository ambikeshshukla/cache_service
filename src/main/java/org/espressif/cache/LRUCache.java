package org.espressif.cache;


import java.util.Deque;
import java.util.LinkedList;


public class LRUCache extends AbstractCache<Object> {

    private static final int CACHE_SIZE = 3;

    private final Deque<String> deque;

    public LRUCache(String name) {
        super(name);
        deque = new LinkedList<>();
    }

    @Override
    public void push(String id, Object obj) {
        if(!cache.containsKey(id)) {
            if(cache.size() == CACHE_SIZE) {
                String removeLast = deque.removeLast();
                cache.remove(removeLast);
            }
        } else {
            String removeElement = null;
            for (String element: deque) {
                if(element.equals(id)) {
                    removeElement = element;
                    break;
                }
            }
            deque.remove(removeElement);
        }
        cache.put(id, obj);
        deque.push(id);
    }

    @Override
    public Object get(String key) {
        if(cache.containsKey(key)) {
            String old = null;
            for (String element: deque) {
                if(element.equals(key)) {
                    old = element;
                    break;
                }
            }
            deque.remove(old);
            deque.push(key);
            return cache.get(key);
        }
        return null;
    }

    @Override
    public Object remove(String key) {
        if(cache.containsKey(key)) {
            deque.remove(key);
            return cache.remove(key);
        }
        return null;
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public void init() {
        super.init();
    }
}
