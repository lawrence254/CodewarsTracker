
package com.codewars.model;

import java.util.HashMap;
import java.util.Map;

public class CodeChallenges {

    private Integer totalAuthored;
    private Integer totalCompleted;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getTotalAuthored() {
        return totalAuthored;
    }

    public void setTotalAuthored(Integer totalAuthored) {
        this.totalAuthored = totalAuthored;
    }

    public Integer getTotalCompleted() {
        return totalCompleted;
    }

    public void setTotalCompleted(Integer totalCompleted) {
        this.totalCompleted = totalCompleted;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
