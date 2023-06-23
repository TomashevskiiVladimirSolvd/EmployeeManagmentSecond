package com.solvd.laba.model;

import java.util.Objects;

public class EmployeeSkill {
    private long id;
    private String proficiencyLevel;
    private Skill skill;

    public EmployeeSkill() {
    }

    ;

    public EmployeeSkill(long id, String proficiencyLevel) {
        this.id = id;
        this.proficiencyLevel = proficiencyLevel;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProficiencyLevel() {
        return proficiencyLevel;
    }

    public void setProficiencyLevel(String proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeSkill that = (EmployeeSkill) o;
        return id == that.id && Objects.equals(proficiencyLevel, that.proficiencyLevel) && Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, proficiencyLevel, skill);
    }

    @Override
    public String toString() {
        return "EmployeeSkill{" +
                "id=" + id +
                ", proficiencyLevel='" + proficiencyLevel + '\'' +
                ", skill=" + skill +
                '}';
    }
}
