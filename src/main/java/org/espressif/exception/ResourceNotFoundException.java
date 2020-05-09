package org.espressif.exception;

public class ResourceNotFoundException extends CacheException {

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
