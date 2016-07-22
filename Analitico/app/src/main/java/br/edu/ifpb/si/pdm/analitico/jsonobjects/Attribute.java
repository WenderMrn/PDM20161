
package br.edu.ifpb.si.pdm.analitico.jsonobjects;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Attribute {

    private Age age;
    private Gender gender;
    private Glass glass;
    private Pose pose;
    private Race race;
    private Smiling smiling;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Attribute() {
    }

    /**
     * 
     * @param pose
     * @param age
     * @param glass
     * @param gender
     * @param race
     * @param smiling
     */
    public Attribute(Age age, Gender gender, Glass glass, Pose pose, Race race, Smiling smiling) {
        this.age = age;
        this.gender = gender;
        this.glass = glass;
        this.pose = pose;
        this.race = race;
        this.smiling = smiling;
    }

    /**
     * 
     * @return
     *     The age
     */
    public Age getAge() {
        return age;
    }

    /**
     * 
     * @param age
     *     The age
     */
    public void setAge(Age age) {
        this.age = age;
    }

    public Attribute withAge(Age age) {
        this.age = age;
        return this;
    }

    /**
     * 
     * @return
     *     The gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * 
     * @param gender
     *     The gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Attribute withGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    /**
     * 
     * @return
     *     The glass
     */
    public Glass getGlass() {
        return glass;
    }

    /**
     * 
     * @param glass
     *     The glass
     */
    public void setGlass(Glass glass) {
        this.glass = glass;
    }

    public Attribute withGlass(Glass glass) {
        this.glass = glass;
        return this;
    }

    /**
     * 
     * @return
     *     The pose
     */
    public Pose getPose() {
        return pose;
    }

    /**
     * 
     * @param pose
     *     The pose
     */
    public void setPose(Pose pose) {
        this.pose = pose;
    }

    public Attribute withPose(Pose pose) {
        this.pose = pose;
        return this;
    }

    /**
     * 
     * @return
     *     The race
     */
    public Race getRace() {
        return race;
    }

    /**
     * 
     * @param race
     *     The race
     */
    public void setRace(Race race) {
        this.race = race;
    }

    public Attribute withRace(Race race) {
        this.race = race;
        return this;
    }

    /**
     * 
     * @return
     *     The smiling
     */
    public Smiling getSmiling() {
        return smiling;
    }

    /**
     * 
     * @param smiling
     *     The smiling
     */
    public void setSmiling(Smiling smiling) {
        this.smiling = smiling;
    }

    public Attribute withSmiling(Smiling smiling) {
        this.smiling = smiling;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Attribute withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
