package org.espressif.rest;

import org.espressif.dto.CacheDto;
import org.espressif.exception.CacheException;
import org.espressif.exception.handler.CacheExceptionHandler;
import org.espressif.service.itf.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.espressif.utils.Constants.SERVICE_NAME;

/**
 * Author: Ambikesh Shukla
 *
 * This class is used to put, get, remove and clear the value from cache.
 *
 */
@RestController
@RequestMapping(SERVICE_NAME)
public class CacheController {

    private static final Logger log = LoggerFactory.getLogger(CacheController.class);

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private CacheExceptionHandler exceptionHandler;

    @PostMapping
    public ResponseEntity<Object> putValueToCache(@RequestBody CacheDto cacheDto) {
        ResponseEntity<Object> response;
        try {
            cacheManager.putValue(cacheDto);
            response = new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Unable to put the value into cache for key {} and exception {}", cacheDto.getKey(), e);
            response = exceptionHandler.getErrorResponse(e);
        }
        return response;
    }

    @GetMapping(path = "{key}")
    public ResponseEntity<Object> getValueToCache(@PathVariable("key") String key) {
        ResponseEntity<Object> response;
        try {
            Object value = cacheManager.getValue(key);
            response = new ResponseEntity<>(value, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Unable to find a value from cache for key {} and exception {}", key, e);
            response = exceptionHandler.getErrorResponse(e);
        }
        return response;
    }

    @DeleteMapping(path = "{key}")
    public ResponseEntity<Object> removeValueToCache(@PathVariable("key") String key) {
        ResponseEntity<Object> response;
        try {
            cacheManager.remove(key);
            response = new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Unable to find a value from cache for key {} and exception {}", key, e);
            response = exceptionHandler.getErrorResponse(e);
        }
        return response;
    }

    @GetMapping(path = "clear")
    public ResponseEntity<Object> clearCache() {
        ResponseEntity<Object> response;
        try {
            cacheManager.clearCache();
            response = new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Unable to clear a cache and exception", e);
            response = exceptionHandler.getErrorResponse(e);
        }
        return response;
    }
}
