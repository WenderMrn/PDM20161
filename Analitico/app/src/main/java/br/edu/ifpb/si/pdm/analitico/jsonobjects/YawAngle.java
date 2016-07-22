
package br.edu.ifpb.si.pdm.analitico.jsonobjects;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class YawAngle {

    private Long value;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public YawAngle() {
    }

    /**
     * 
     * @param value
     */
    public YawAngle(Long value) {
        this.value = value;
    }

    /**
     * 
     * @return
     *     The value
     */
    public Long getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The value
     */
    public void setValue(Long value) {
        this.value = value;
    }

    public YawAngle withValue(Long value) {
        this.value = value;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public YawAngle withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
