package controller;

import model.Artifact;
import model.Hero;
import model.Map;

import java.io.*;
import java.lang.reflect.AnnotatedType;
import java.util.List;

public class Methods {

    public static Hero hero;
    private static Map map;
    private static Game game;
    private static PrintWriter file;
    private static int count = 0;


    public static void createHero(String name, String character){
        hero = new Hero();
        hero.setHeroName(name);
        hero.setExperience(0);
        hero.setLevel(1);
        hero.setCharacterType(character);
        if (character.equals("superman")){
            hero.setAttack(85);
            hero.setDefence(200);
            hero.setStrikeAccuracy(35);
            hero.setEscape(25);
        } else {
            hero.setAttack(35);
            hero.setDefence(110);
            hero.setStrikeAccuracy(100);
            hero.setEscape(50);
        }
    }

    public static void saveHero(){
        String[] newLines;
        String artifactName;
        try {
            file = new PrintWriter(new File("Heros.txt"));
            List<Artifact> artifacts = hero.getArtifacts();
            file.print(hero.getHeroName()
                    + ":" + hero.getCharacterType()
                    + ":" + hero.getExperience()
                    + ":" + hero.getLevel()
                    + ":" + hero.getAttack(false)
                    + ":" + hero.getDefence(false)
                    + ":" + hero.getStrikeAccuracy()
                    + ":" + hero.getEscape(false));
            if(artifacts != null){
                file.print(":");
            for(Artifact artifact : artifacts){
                newLines = artifact.getName().split("\n");
                artifactName = "";
                for (String newLine : newLines) {
                    artifactName = artifactName.concat(newLine);
                    artifactName = artifactName.concat("~");
                }
                    file.print(artifactName
                            + "/" + artifact.getType()
                            + "/" + artifact.getWeapon()
                            + "/" + artifact.getArmor()
                            + "/" + artifact.getHelm()
                            + ";");
            }
            }
            file.print("\n");
            file.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void loadGame(){
        game = new Game();
    }

    public static void loadMap(){
        map = new Map();
    }

    public static Map getMap() {
        return map;
    }

    public static void loadHero() {
        String[] newLines;
        String artifactName;
        String buffer = "";
        try {
           BufferedReader file = new BufferedReader(new FileReader("Heros.txt"));
           buffer = file.readLine();

        } catch (Exception ignore) {
        }
        if (buffer != null) {
            hero = new Hero();
            String[] heroInfo = buffer.split(":");
            hero.setHeroName(heroInfo[0]);
            hero.setCharacterType(heroInfo[1]);
            hero.setExperience(Integer.parseInt(heroInfo[2]));
            hero.setLevel(Integer.parseInt(heroInfo[3]));
            hero.setAttack(Integer.parseInt(heroInfo[4]));
            hero.setDefence(Integer.parseInt(heroInfo[5]));
            hero.setStrikeAccuracy(Integer.parseInt(heroInfo[6]));
            hero.setEscape(Integer.parseInt(heroInfo[7]));
            if (heroInfo.length == 9){
                String[] artifacts = heroInfo[8].split(";");
                for(String artifact : artifacts){
                    String[] artifactInfo = artifact.split("/");
                    Artifact Artifact = new Artifact();
                    newLines = artifactInfo[0].split("~");
                    artifactName = "";
                    for (String newLine : newLines) {
                        artifactName = artifactName.concat(newLine);
                        artifactName = artifactName.concat("\n");
                    }
                    Artifact.setName(artifactName);
                    Artifact.setType(artifactInfo[1]);
                    Artifact.setWeapon(Integer.parseInt(artifactInfo[2]));
                    Artifact.setArmor(Integer.parseInt(artifactInfo[3]));
                    Artifact.setHelm(Integer.parseInt(artifactInfo[4]));
                    hero.addArtifact(Artifact);
                }
            }
        } else {
            hero = null;
        }
    }

    public static Hero getHero() {
        return hero;
    }

    public static void runCommand(view.Views view){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            switch (view.getCurrentScreen()) {
                case "start":
                switch (readOption(reader)) {
                    case 1:
                        view.updateGUI();
                        view.toGUI();
                        break;
                    case 2:
                        view.setView("createHero");
                        break;
                    case 3:
                        loadHero();
                        view.setView("existingHero");
                        break;
                    case 4:
                        System.exit(1);
                    default:
                        System.out.println("Please enter valid selection.");
                        runCommand(view);
                }
                break;
                case "createHero":
                    switch (readOption(reader)) {
                        case 1:
                            view.updateGUI();
                            view.toGUI();
                            break;
                        case 2:
                            System.out.println("Please enter hero's name:");
                            createHero(reader.readLine(), "superman");
                            loadMap();
                            loadGame();
                            view.setView("game");
                            break;
                        case 3:
                            System.out.println("Please enter hero's name:");
                            createHero(reader.readLine(), "spiderman");
                            loadMap();
                            loadGame();
                            view.setView("game");
                            break;
                        case 4:
                            view.setView("start");
                            break;
                        case 5:
                            System.exit(1);
                        default:
                            System.out.println("Please enter valid selection.");
                            runCommand(view);
                    }
                    break;
                case "existingHero":
                    if (hero != null) {
                    switch (readOption(reader)) {
                        case 1:
                            view.updateGUI();
                            view.toGUI();
                            break;
                        case 2:
                            loadMap();
                            loadGame();
                            view.setView("game");
                            break;
                        case 3:
                            view.setView("start");
                            break;
                        case 4:
                            System.exit(1);
                        default:
                            System.out.println("Please enter valid selection.");
                            runCommand(view);
                    }
                    } else {
                            switch (readOption(reader)) {
                                case 1:
                                    view.updateGUI();
                                    view.toGUI();
                                    break;
                                case 2:
                                    view.setView("start");
                                    break;
                                case 3:
                                    System.exit(1);
                                default:
                                    System.out.println("Please enter valid selection.");
                                    runCommand(view);
                        }
                    }
                    break;
                case "game":
                    switch (readOption(reader)) {
                        case 1:
                            view.updateGUI();
                            view.toGUI();
                            break;
                        case 2:
                            saveHero();
                            System.out.println("\nHero has been saved.");
                            view.setView("game");
                            break;
                        case 3:
                            view.setView("start");
                            break;
                        case 4:
                            System.exit(1);
                        default:
                            System.out.println("Please enter valid selection.");
                            runCommand(view);
                    }
                    break;
                }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    private static int readOption(BufferedReader reader) {
        try {
            return (Integer.parseInt(reader.readLine()));
        } catch (Exception e){
            System.out.println("Please enter valid number of selection.");
            return(readOption(reader));
        }
    }
}
