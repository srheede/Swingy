package model;

import static controller.Methods.hero;

public class Character {
    private int level;
    private String characterType;
    private int attack;
    private int defence;
    private int strikeAccuracy;
    private int xCoordinate;
    private int yCoordinate;

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

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
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

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}
