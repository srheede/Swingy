package model;

import java.util.ArrayList;
import java.util.List;

public class Hero extends Character {
    private String heroName;
    private int experience;
    private int escape;
    public int i;
    public int j;
    private String heroInfo;
    private List<Artifact> artifacts = new ArrayList<Artifact>();

    public Hero(){

    }

    public void setCoordinates(int n) {
        this.i = n;
        this.j = n;
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

    public int getEscape(boolean add) {
        int n = escape;
        if (add) {
            for (Artifact artifact : artifacts) {
                n += artifact.getHelm();
            }
        }
        return n;
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
    public int getAttack(boolean add) {
        int attack = super.getAttack(false);
        if (add) {
            for (Artifact artifact : artifacts) {
                attack += artifact.getWeapon();
            }
        }
        return attack;
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
    public int getDefence(boolean add) {
        int defence = super.getDefence(false);
        if (add) {
            for (Artifact artifact : artifacts) {
                defence += artifact.getArmor();
            }
        }
        return defence;
    }

    @Override
    public void setDefence(int defence) {
        super.setDefence(defence);
        setHeroInfo();
    }

    public void setHeroInfo(){
        String[] newLines;
        String artifactName;
        heroInfo = " Player: " + this.getHeroName()
                    + "\n\n Hero Character: " + this.getCharacterType()
                    + "\n Level: " + this.getLevel()
                    + "\n XP: " + this.getExperience()
                    + "\n\n Attack: " + this.getAttack(true)
                    + "\n Defence: " + this.getDefence(true)
                    + "\n Strike Accuracy: " + this.getStrikeAccuracy() + "%"
                    + "\n Escape: " + this.getEscape(true) + "%"
                    + "\n\n Artifacts:\n";
            if (this.getArtifacts().isEmpty()){
                heroInfo = heroInfo.concat(" Hero doesn't have any artifacts.");
            }
            for (Artifact artifact : this.getArtifacts()){
                newLines = artifact.getName().split("~");
                artifactName = "";
                for (String newLine : newLines) {
                    artifactName = artifactName.concat(newLine);
                    artifactName = artifactName.concat("\n");
                }
                String[] words = artifactName.split("\n");
                heroInfo = heroInfo.concat(" " + words[0] + "\n " + words[1] + "\n");
            }
    }

    public String getHeroInfo() {
        return heroInfo;
    }
}
