package org.espressif.dto;

import javax.validation.constraints.NotNull;

public class CacheDto {

    @NotNull
    private String key;
    private Object value;

    public CacheDto() {}

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
