
package br.edu.ifpb.si.pdm.analitico.jsonobjects;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Smiling {

    private Double value;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Smiling() {
    }

    /**
     * 
     * @param value
     */
    public Smiling(Double value) {
        this.value = value;
    }

    /**
     * 
     * @return
     *     The value
     */
    public Double getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The value
     */
    public void setValue(Double value) {
        this.value = value;
    }

    public Smiling withValue(Double value) {
        this.value = value;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Smiling withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
