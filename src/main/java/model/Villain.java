package model;

import java.util.Random;

public class Villain extends Character {
    private int capture;
    private Artifact artifact;
    private String quote;

    public Villain(int n){
        Random rand = new Random();
        artifact = new Artifact(rand.nextInt(13));
        switch (n){
            case 0:
                super.setCharacterType("Doctor Octopus");
                quote = "Intelligence is not a privilege, it's a gift. And you use it for the good of mankind.";
                super.setAttack(23);
                super.setDefence(50);
                super.setStrikeAccuracy(20);
                capture = 30;
                break;
            case 1:
                super.setCharacterType("Poison Ivy");
                quote = "You seem to have confused me with some warm-blooded damsel in distress.";
                super.setAttack(60);
                super.setDefence(25);
                super.setStrikeAccuracy(45);
                capture = 90;
                break;
            case 2:
                super.setCharacterType("Harley Quinn");
                quote = "Aw, c'mon Puddin - don'tcha wanna rev up ya Harley? VROOOM VROOM!";
                super.setAttack(70);
                super.setDefence(40);
                super.setStrikeAccuracy(30);
                capture = 55;
                break;
            case 3:
                super.setCharacterType("Venom");
                quote = "Never wound what you can't kill.";
                super.setAttack(200);
                super.setDefence(60);
                super.setStrikeAccuracy(15);
                capture = 25;
                break;
            case 4:
                super.setCharacterType("Magneto");
                quote = "The thing none of you will ever understand is that there are no sides. No heroes or villains.";
                super.setAttack(50);
                super.setDefence(50);
                super.setStrikeAccuracy(50);
                capture = 50;
                break;
            case 5:
                super.setCharacterType("Darth Vader");
                quote = "You underestimate the power of the dark side!";
                super.setAttack(110);
                super.setDefence(40);
                super.setStrikeAccuracy(55);
                capture = 70;
                break;
            case 6:
                super.setCharacterType("The Joker");
                quote = "As you know, madness is like gravity...all it takes is a little push.";
                super.setAttack(15);
                super.setDefence(300);
                super.setStrikeAccuracy(400);
                capture = 100;
                break;
            case 7:
                super.setCharacterType("Agent Smith");
                quote = "Every mammal on this planet instinctively develops a natural equilibrium with the surrounding environment but you humans do not.";
                super.setAttack(65);
                super.setDefence(70);
                super.setStrikeAccuracy(35);
                capture = 100;
                break;
        }
    }

    @Override
    public int getAttack(boolean add) {
        if (add)
            return super.getAttack(false) + artifact.getWeapon();
        else
            return super.getAttack(false);
    }

    @Override
    public int getDefence(boolean add) {

        if (add)
            return super.getDefence(false) + artifact.getArmor();
        else
            return super.getDefence(false);
    }

    public int getCapture(boolean add) {

        if (add)
            return capture + artifact.getHelm();
        else
            return capture;
    }

    public Artifact getArtifact() {
        return artifact;
    }

    public String getQuote() {
        return quote;
    }
}
