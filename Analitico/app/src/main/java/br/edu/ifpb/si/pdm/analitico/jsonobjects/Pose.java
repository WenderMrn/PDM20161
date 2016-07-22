
package br.edu.ifpb.si.pdm.analitico.jsonobjects;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Pose {

    private PitchAngle pitchAngle;
    private RollAngle rollAngle;
    private YawAngle yawAngle;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Pose() {
    }

    /**
     * 
     * @param yawAngle
     * @param pitchAngle
     * @param rollAngle
     */
    public Pose(PitchAngle pitchAngle, RollAngle rollAngle, YawAngle yawAngle) {
        this.pitchAngle = pitchAngle;
        this.rollAngle = rollAngle;
        this.yawAngle = yawAngle;
    }

    /**
     * 
     * @return
     *     The pitchAngle
     */
    public PitchAngle getPitchAngle() {
        return pitchAngle;
    }

    /**
     * 
     * @param pitchAngle
     *     The pitch_angle
     */
    public void setPitchAngle(PitchAngle pitchAngle) {
        this.pitchAngle = pitchAngle;
    }

    public Pose withPitchAngle(PitchAngle pitchAngle) {
        this.pitchAngle = pitchAngle;
        return this;
    }

    /**
     * 
     * @return
     *     The rollAngle
     */
    public RollAngle getRollAngle() {
        return rollAngle;
    }

    /**
     * 
     * @param rollAngle
     *     The roll_angle
     */
    public void setRollAngle(RollAngle rollAngle) {
        this.rollAngle = rollAngle;
    }

    public Pose withRollAngle(RollAngle rollAngle) {
        this.rollAngle = rollAngle;
        return this;
    }

    /**
     * 
     * @return
     *     The yawAngle
     */
    public YawAngle getYawAngle() {
        return yawAngle;
    }

    /**
     * 
     * @param yawAngle
     *     The yaw_angle
     */
    public void setYawAngle(YawAngle yawAngle) {
        this.yawAngle = yawAngle;
    }

    public Pose withYawAngle(YawAngle yawAngle) {
        this.yawAngle = yawAngle;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Pose withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
