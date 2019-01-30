
package com.codewars.model;

import java.util.HashMap;
import java.util.Map;

public class Ranks {

    private Overall overall;
    private Languages languages;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Overall getOverall() {
        return overall;
    }

    public void setOverall(Overall overall) {
        this.overall = overall;
    }

    public Languages getLanguages() {
        return languages;
    }

    public void setLanguages(Languages languages) {
        this.languages = languages;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
