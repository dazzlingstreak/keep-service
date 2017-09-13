package com.learning.keep.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by huangdawei on 2017/9/13.
 */
@ConfigurationProperties(prefix = "wisely",locations = "classpath:wiselySetting.yml")
public class WiselySetting {

    private String name;

    private String mood;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
