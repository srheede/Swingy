package controller;

import model.Artifact;
import model.Map;
import model.Villain;
import view.gui.ViewGUIMain;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import static controller.Methods.hero;
import static controller.Methods.loadMap;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static view.Views.viewGUIMain;

public class Game {

    private static Villain villain;
    private static Random rand;

    public Game() {
    }

    public static void conflict() {
        Random rand = new Random();
        villain = new Villain(rand.nextInt(7));
        try {String option = showInputDialog("Villian encountered!!\n"
                + "\n" + villain.getCharacterType() +"\n"
                + "\n" + villain.getQuote() + "\n"
                + "\nAttack: " + villain.getAttack(true) + "\n"
                + "Defence: " + villain.getDefence(true) + "\n"
                + "Strike Accuracy: " + villain.getStrikeAccuracy() + "\n"
                + "Capture Probability:" + villain.getCapture(true) + "\n"
                + "\nArtifacts:\n"
                + villain.getArtifact().getType() + ": " + villain.getArtifact().getName() +"\n"
                + "\nPlease enter the number of the desired operation:\n"
                + "\n1. Flight!\n"
                + "2. Run!\n");
        switch (option){
            case "1":
                fight();
                break;
            case "2":
                run();
                break;
            default:
            conflict();
            break;
        } } catch (Exception ignore){

        }
    }

    private static void run() {
        int escapeProb = ((100 - villain.getCapture(true)) + hero.getEscape(true)) / 2;
        rand = new Random();
        if (rand.nextInt(99) > (escapeProb - 1)) {
            showMessageDialog(viewGUIMain.frame, villain.getCharacterType() + " caught you!");
            fight();
        } else {
            showMessageDialog(viewGUIMain.frame, "You escaped from " + villain.getCharacterType() + "!");
            hero.setExperience(hero.getExperience() + (villain.getAttack(true)/2));
        }
    }

    private static void fight() {
        rand = new Random();
        if (rand.nextInt(99) > (hero.getStrikeAccuracy() - 1)) {
            showMessageDialog(viewGUIMain.frame, "Attack!\n"
                    + "\nYou missed!\n");
            defend();
        } else if ((villain.getDefence(true) - hero.getAttack(true)) > 0){
            villain.setDefence(villain.getDefence(false) - hero.getAttack(true));
            showMessageDialog(viewGUIMain.frame, "Attack!\n\n"
                    + villain.getCharacterType() + " takes " + hero.getAttack(true) + " damage!\n"
                    + "\nRemaining health: " + villain.getDefence(true));
            hero.setExperience(hero.getExperience() + hero.getAttack(true));
            defend();
        } else {
            villain.setDefence(villain.getDefence(false) - hero.getAttack(true));
            showMessageDialog(viewGUIMain.frame, "Attack!\n\n"
                    + villain.getCharacterType() + " takes " + hero.getAttack(true) + " damage!\n"
                    + "\nYou beat " + villain.getCharacterType() + "!");
            hero.setExperience(hero.getExperience() + hero.getAttack(true));
            collectArtifact();
        }
    }

    private static void collectArtifact() {
        try {String option = showInputDialog(viewGUIMain.frame, villain.getCharacterType() + " dropped " + villain.getArtifact().getName() + "!\n"
                + "\nPicking up this " + villain.getArtifact().getType() + " will replace your previous " + villain.getArtifact().getType() + ".\n"
                + "\nPlease enter the number of the desired operation:\n"
                + "\n1. Pick up " + villain.getArtifact().getType() + ".\n"
                + "2. Leave " + villain.getArtifact().getType() + ".\n");
        switch (option) {
            case "1":
                if (!hero.getArtifacts().isEmpty()) {
                    Artifact remove = new Artifact();
                    for (Artifact artifact : hero.getArtifacts()) {
                        if (artifact.getType().equals(villain.getArtifact().getType())) {
                            remove = artifact;
                        }
                    }
                    hero.getArtifacts().remove(remove);
                }
                hero.addArtifact(villain.getArtifact());
                break;
            case "2":
                break;
            default:
                collectArtifact();
                break;
        } } catch (Exception ignore){
        }
    }

    private static void defend() {
        rand = new Random();
        if (rand.nextInt(99) > (villain.getStrikeAccuracy() - 1)) {
            showMessageDialog(viewGUIMain.frame, "Defend!\n"
                    + "\n" + villain.getCharacterType() + " missed!\n");
            fight();
        } else if ((hero.getDefence(true) - villain.getAttack(true)) > 0){
            hero.setDefence(hero.getDefence(false) - villain.getAttack(true));
            showMessageDialog(viewGUIMain.frame, "Defend!\n\n"
                    + "You take " + villain.getAttack(true) + " damage!\n"
                    + "\nRemaining health: " + hero.getDefence(true));
            hero.setExperience(hero.getExperience() + (villain.getAttack(true) * 2));
            fight();
        } else {
            hero.setDefence(hero.getDefence(false) - villain.getAttack(true));
            showMessageDialog(viewGUIMain.frame, "Defend!\n\n"
                    + "You take " + villain.getAttack(true) + " damage!\n"
                    + "\n" + villain.getCharacterType() + " beat you!");
            hero.setLevel(0);
        }
    }

    public static void nextLevel() {
        hero.levelUP();
            loadMap();
    }
}
