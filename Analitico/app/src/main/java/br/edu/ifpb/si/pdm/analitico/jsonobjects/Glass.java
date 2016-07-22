
package br.edu.ifpb.si.pdm.analitico.jsonobjects;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Glass {

    private Double confidence;
    private String value;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Glass() {
    }

    /**
     * 
     * @param value
     * @param confidence
     */
    public Glass(Double confidence, String value) {
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

    public Glass withConfidence(Double confidence) {
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

    public Glass withValue(String value) {
        this.value = value;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Glass withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
