
package com.codewars.model;

import java.util.HashMap;
import java.util.Map;

public class Languages {

    private Java java;
    private Sql sql;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Java getJava() {
        return java;
    }

    public void setJava(Java java) {
        this.java = java;
    }

    public Sql getSql() {
        return sql;
    }

    public void setSql(Sql sql) {
        this.sql = sql;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
