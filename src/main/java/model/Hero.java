package model;

import java.util.ArrayList;
import java.util.List;

public class Hero extends Character {
    private String heroName;
    private int experience;
    private int escape;
    private String heroInfo;
    private List<Artifact> artifacts = new ArrayList<Artifact>();

    public Hero(){

    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
        setHeroInfo();
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
        setHeroInfo();
    }

    public int getEscape() {
        return escape;
    }

    public void setEscape(int escape) {
        this.escape = escape;
        setHeroInfo();
    }

    public List<Artifact> getArtifacts() {
        return artifacts;
    }

    public void addArtifact(Artifact artifact) {
        this.artifacts.add(artifact);
        setHeroInfo();
    }

    @Override
    public void setAttack(int attack) {
        super.setAttack(attack);
        setHeroInfo();
    }

    @Override
    public void setCharacterType(String characterType) {
        super.setCharacterType(characterType);
        setHeroInfo();
    }

    @Override
    public void setStrikeAccuracy(int strikeAccuracy) {
        super.setStrikeAccuracy(strikeAccuracy);
        setHeroInfo();
    }

    @Override
    public void setLevel(int level) {
        super.setLevel(level);
        setHeroInfo();
    }

    @Override
    public void setDefence(int defence) {
        super.setDefence(defence);
        setHeroInfo();
    }

    public void setHeroInfo(){
            heroInfo = " " + this.getHeroName()
                    + "\n Hero Character: " + this.getCharacterType()
                    + "\n Level: " + this.getLevel()
                    + "\n XP: " + this.getExperience()
                    + "\n Attack: " + this.getAttack()
                    + "\n Defence: " + this.getDefence()
                    + "\n Strike Accuracy: " + this.getStrikeAccuracy() + "/4"
                    + "\n Escape: " + this.getEscape() + "/4"
                    + "\n Artifacts:\n";
            if (this.getArtifacts().isEmpty()){
                heroInfo = heroInfo.concat(" Hero doesn't have any artifacts.");
            }
            for (Artifact artifact : this.getArtifacts()){
                heroInfo = heroInfo.concat(artifact.getName()
                        + "\tWeapon: " + artifact.getWeapon()
                        + " Armor: " + artifact.getArmor()
                        + " Helm: " + artifact.getHelm() + "\n");
            }
    }

    public String getHeroInfo() {
        return heroInfo;
    }
}
