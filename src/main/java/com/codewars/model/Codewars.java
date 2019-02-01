
package com.codewars.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Codewars {

    private String username;
    private String name;
    private Integer honor;
    private String clan;
    private Integer leaderboardPosition;
    private List<Object> skills = null;
    private Ranks ranks;
    private CodeChallenges codeChallenges;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHonor() {
        return honor;
    }

    public void setHonor(Integer honor) {
        this.honor = honor;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public Integer getLeaderboardPosition() {
        return leaderboardPosition;
    }

    public void setLeaderboardPosition(Integer leaderboardPosition) {
        this.leaderboardPosition = leaderboardPosition;
    }

    public List<Object> getSkills() {
        return skills;
    }

    public void setSkills(List<Object> skills) {
        this.skills = skills;
    }

    public Ranks getRanks() {
        return ranks;
    }

    public void setRanks(Ranks ranks) {
        this.ranks = ranks;
    }

    public CodeChallenges getCodeChallenges() {
        return codeChallenges;
    }

    public void setCodeChallenges(CodeChallenges codeChallenges) {
        this.codeChallenges = codeChallenges;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
