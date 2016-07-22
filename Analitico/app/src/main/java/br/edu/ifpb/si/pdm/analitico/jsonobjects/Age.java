
package br.edu.ifpb.si.pdm.analitico.jsonobjects;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Age {

    private Long range;
    private Long value;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Age() {
    }

    /**
     * 
     * @param range
     * @param value
     */
    public Age(Long range, Long value) {
        this.range = range;
        this.value = value;
    }

    /**
     * 
     * @return
     *     The range
     */
    public Long getRange() {
        return range;
    }

    /**
     * 
     * @param range
     *     The range
     */
    public void setRange(Long range) {
        this.range = range;
    }

    public Age withRange(Long range) {
        this.range = range;
        return this;
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

    public Age withValue(Long value) {
        this.value = value;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Age withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
