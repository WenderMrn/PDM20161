
package br.edu.ifpb.si.pdm.analitico.jsonobjects;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Face {

    private Attribute attribute;
    private String faceId;
    private Position position;
    private String tag;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Face() {
    }

    /**
     * 
     * @param position
     * @param faceId
     * @param tag
     * @param attribute
     */
    public Face(Attribute attribute, String faceId, Position position, String tag) {
        this.attribute = attribute;
        this.faceId = faceId;
        this.position = position;
        this.tag = tag;
    }

    /**
     * 
     * @return
     *     The attribute
     */
    public Attribute getAttribute() {
        return attribute;
    }

    /**
     * 
     * @param attribute
     *     The attribute
     */
    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public Face withAttribute(Attribute attribute) {
        this.attribute = attribute;
        return this;
    }

    /**
     * 
     * @return
     *     The faceId
     */
    public String getFaceId() {
        return faceId;
    }

    /**
     * 
     * @param faceId
     *     The face_id
     */
    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }

    public Face withFaceId(String faceId) {
        this.faceId = faceId;
        return this;
    }

    /**
     * 
     * @return
     *     The position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * 
     * @param position
     *     The position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    public Face withPosition(Position position) {
        this.position = position;
        return this;
    }

    /**
     * 
     * @return
     *     The tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * 
     * @param tag
     *     The tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    public Face withTag(String tag) {
        this.tag = tag;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Face withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
