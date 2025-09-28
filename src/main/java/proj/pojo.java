package proj;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class pojo {

    String id;
    String name;

    @JsonProperty("class")
    String CharClass;

    Integer level;
    List<Item> inventory;
    List<Skills> skills;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    public String getCharClass() {
        return CharClass;
    }

    public void setCharClass(String charClass) {
        CharClass = charClass;
    }





}
