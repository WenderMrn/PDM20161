
package br.edu.ifpb.si.pdm.analitico.jsonobjects;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Gender {

    private Double confidence;
    private String value;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Gender() {
    }

    /**
     * 
     * @param value
     * @param confidence
     */
    public Gender(Double confidence, String value) {
        this.confidence = confidence;
        this.value = value;
    }

    /**
     * 
     * @return
     *     The confidence
     */
    public Double getConfidence() {
        return confidence;
    }

    /**
     * 
     * @param confidence
     *     The confidence
     */
    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public Gender withConfidence(Double confidence) {
        this.confidence = confidence;
        return this;
    }

    /**
     * 
     * @return
     *     The value
     */
    public String getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The value
     */
    public void setValue(String value) {
        this.value = value;
    }

    public Gender withValue(String value) {
        this.value = value;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Gender withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
