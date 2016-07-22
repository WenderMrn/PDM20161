
package br.edu.ifpb.si.pdm.analitico.jsonobjects;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Position {

    private Center center;
    private EyeLeft eyeLeft;
    private EyeRight eyeRight;
    private Double height;
    private MouthLeft mouthLeft;
    private MouthRight mouthRight;
    private Nose nose;
    private Double width;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Position() {
    }

    /**
     * 
     * @param mouthLeft
     * @param center
     * @param height
     * @param width
     * @param mouthRight
     * @param eyeLeft
     * @param nose
     * @param eyeRight
     */
    public Position(Center center, EyeLeft eyeLeft, EyeRight eyeRight, Double height, MouthLeft mouthLeft, MouthRight mouthRight, Nose nose, Double width) {
        this.center = center;
        this.eyeLeft = eyeLeft;
        this.eyeRight = eyeRight;
        this.height = height;
        this.mouthLeft = mouthLeft;
        this.mouthRight = mouthRight;
        this.nose = nose;
        this.width = width;
    }

    /**
     * 
     * @return
     *     The center
     */
    public Center getCenter() {
        return center;
    }

    /**
     * 
     * @param center
     *     The center
     */
    public void setCenter(Center center) {
        this.center = center;
    }

    public Position withCenter(Center center) {
        this.center = center;
        return this;
    }

    /**
     * 
     * @return
     *     The eyeLeft
     */
    public EyeLeft getEyeLeft() {
        return eyeLeft;
    }

    /**
     * 
     * @param eyeLeft
     *     The eye_left
     */
    public void setEyeLeft(EyeLeft eyeLeft) {
        this.eyeLeft = eyeLeft;
    }

    public Position withEyeLeft(EyeLeft eyeLeft) {
        this.eyeLeft = eyeLeft;
        return this;
    }

    /**
     * 
     * @return
     *     The eyeRight
     */
    public EyeRight getEyeRight() {
        return eyeRight;
    }

    /**
     * 
     * @param eyeRight
     *     The eye_right
     */
    public void setEyeRight(EyeRight eyeRight) {
        this.eyeRight = eyeRight;
    }

    public Position withEyeRight(EyeRight eyeRight) {
        this.eyeRight = eyeRight;
        return this;
    }

    /**
     * 
     * @return
     *     The height
     */
    public Double getHeight() {
        return height;
    }

    /**
     * 
     * @param height
     *     The height
     */
    public void setHeight(Double height) {
        this.height = height;
    }

    public Position withHeight(Double height) {
        this.height = height;
        return this;
    }

    /**
     * 
     * @return
     *     The mouthLeft
     */
    public MouthLeft getMouthLeft() {
        return mouthLeft;
    }

    /**
     * 
     * @param mouthLeft
     *     The mouth_left
     */
    public void setMouthLeft(MouthLeft mouthLeft) {
        this.mouthLeft = mouthLeft;
    }

    public Position withMouthLeft(MouthLeft mouthLeft) {
        this.mouthLeft = mouthLeft;
        return this;
    }

    /**
     * 
     * @return
     *     The mouthRight
     */
    public MouthRight getMouthRight() {
        return mouthRight;
    }

    /**
     * 
     * @param mouthRight
     *     The mouth_right
     */
    public void setMouthRight(MouthRight mouthRight) {
        this.mouthRight = mouthRight;
    }

    public Position withMouthRight(MouthRight mouthRight) {
        this.mouthRight = mouthRight;
        return this;
    }

    /**
     * 
     * @return
     *     The nose
     */
    public Nose getNose() {
        return nose;
    }

    /**
     * 
     * @param nose
     *     The nose
     */
    public void setNose(Nose nose) {
        this.nose = nose;
    }

    public Position withNose(Nose nose) {
        this.nose = nose;
        return this;
    }

    /**
     * 
     * @return
     *     The width
     */
    public Double getWidth() {
        return width;
    }

    /**
     * 
     * @param width
     *     The width
     */
    public void setWidth(Double width) {
        this.width = width;
    }

    public Position withWidth(Double width) {
        this.width = width;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Position withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
