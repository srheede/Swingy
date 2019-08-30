package model;

import static controller.Methods.hero;

public class Character {
    private int level;
    private String characterType;
    private int attack;
    private int defence;
    private int strikeAccuracy;
    private Artifact artifact;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void levelUP(){
        this.level++;
        hero.setHeroInfo();
    }

    public String getCharacterType() {
        return characterType;
    }

    public void setCharacterType(String characterType) {
        this.characterType = characterType;
    }

    public int getAttack(boolean add) {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence(boolean add) {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getStrikeAccuracy() {
        return strikeAccuracy;
    }

    public void setStrikeAccuracy(int strikeAccuracy) {
        this.strikeAccuracy = strikeAccuracy;
    }

}
