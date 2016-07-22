
package br.edu.ifpb.si.pdm.analitico.jsonobjects;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Nose {

    private Double x;
    private Double y;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Nose() {
    }

    /**
     * 
     * @param y
     * @param x
     */
    public Nose(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 
     * @return
     *     The x
     */
    public Double getX() {
        return x;
    }

    /**
     * 
     * @param x
     *     The x
     */
    public void setX(Double x) {
        this.x = x;
    }

    public Nose withX(Double x) {
        this.x = x;
        return this;
    }

    /**
     * 
     * @return
     *     The y
     */
    public Double getY() {
        return y;
    }

    /**
     * 
     * @param y
     *     The y
     */
    public void setY(Double y) {
        this.y = y;
    }

    public Nose withY(Double y) {
        this.y = y;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Nose withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
