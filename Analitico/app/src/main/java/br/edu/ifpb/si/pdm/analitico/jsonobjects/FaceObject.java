
package br.edu.ifpb.si.pdm.analitico.jsonobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class FaceObject {

    private List<Face> face = new ArrayList<Face>();
    private Long imgHeight;
    private String imgId;
    private Long imgWidth;
    private String sessionId;
    private String url;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public FaceObject() {
    }

    /**
     * 
     * @param imgId
     * @param face
     * @param sessionId
     * @param imgWidth
     * @param url
     * @param imgHeight
     */
    public FaceObject(List<Face> face, Long imgHeight, String imgId, Long imgWidth, String sessionId, String url) {
        this.face = face;
        this.imgHeight = imgHeight;
        this.imgId = imgId;
        this.imgWidth = imgWidth;
        this.sessionId = sessionId;
        this.url = url;
    }

    /**
     * 
     * @return
     *     The face
     */
    public List<Face> getFace() {
        return face;
    }

    /**
     * 
     * @param face
     *     The face
     */
    public void setFace(List<Face> face) {
        this.face = face;
    }

    public FaceObject withFace(List<Face> face) {
        this.face = face;
        return this;
    }

    /**
     * 
     * @return
     *     The imgHeight
     */
    public Long getImgHeight() {
        return imgHeight;
    }

    /**
     * 
     * @param imgHeight
     *     The img_height
     */
    public void setImgHeight(Long imgHeight) {
        this.imgHeight = imgHeight;
    }

    public FaceObject withImgHeight(Long imgHeight) {
        this.imgHeight = imgHeight;
        return this;
    }

    /**
     * 
     * @return
     *     The imgId
     */
    public String getImgId() {
        return imgId;
    }

    /**
     * 
     * @param imgId
     *     The img_id
     */
    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public FaceObject withImgId(String imgId) {
        this.imgId = imgId;
        return this;
    }

    /**
     * 
     * @return
     *     The imgWidth
     */
    public Long getImgWidth() {
        return imgWidth;
    }

    /**
     * 
     * @param imgWidth
     *     The img_width
     */
    public void setImgWidth(Long imgWidth) {
        this.imgWidth = imgWidth;
    }

    public FaceObject withImgWidth(Long imgWidth) {
        this.imgWidth = imgWidth;
        return this;
    }

    /**
     * 
     * @return
     *     The sessionId
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * 
     * @param sessionId
     *     The session_id
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public FaceObject withSessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    public FaceObject withUrl(String url) {
        this.url = url;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public FaceObject withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
