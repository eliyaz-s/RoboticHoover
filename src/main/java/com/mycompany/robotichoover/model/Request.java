package com.mycompany.robotichoover.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "roomSize",
    "coords",
    "patches",
    "instructions"
})
public class Request {

    @JsonProperty("roomSize")
    private List<Integer> roomSize = null;
    @JsonProperty("coords")
    private List<Integer> coords = null;
    @JsonProperty("patches")
    private List<List<Integer>> patches = null;
    /**
     * The Instructions Schema
     * <p>
     *
     *
     */
    @JsonProperty("instructions")
    private String instructions = "";
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("roomSize")
    public List<Integer> getRoomSize() {
        return roomSize;
    }

    @JsonProperty("roomSize")
    public void setRoomSize(List<Integer> roomSize) {
        this.roomSize = roomSize;
    }

    @JsonProperty("coords")
    public List<Integer> getCoords() {
        return coords;
    }

    @JsonProperty("coords")
    public void setCoords(List<Integer> coords) {
        this.coords = coords;
    }

    @JsonProperty("patches")
    public List<List<Integer>> getPatches() {
        return patches;
    }

    @JsonProperty("patches")
    public void setPatches(List<List<Integer>> patches) {
        this.patches = patches;
    }

    /**
     * The Instructions Schema
     * <p>
     *
     *
     */
    @JsonProperty("instructions")
    public String getInstructions() {
        return instructions;
    }

    /**
     * The Instructions Schema
     * <p>
     *
     *
     */
    @JsonProperty("instructions")
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("roomSize", roomSize).append("coords", coords).append("patches", patches).append("instructions", instructions).append("additionalProperties", additionalProperties).toString();
    }

}
