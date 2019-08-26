package controller;

import module.Artifact;
import module.Hero;
import view.gui.ViewGUIMain;

import java.io.*;
import java.util.List;

public class Methods {

    public static Hero hero;
    private static PrintWriter file;

    public static void createHero(String name, String character){
        hero = new Hero();
        hero.setHeroName(name);
        hero.setExperience(0);
        hero.setLevel(1);
        hero.setCharacterType(character);
        if (character.equals("superman")){
            hero.setAttack(70);
            hero.setDefence(200);
            hero.setStrikeAccuracy(1);
            hero.setEscape(1);
        } else {
            hero.setAttack(25);
            hero.setDefence(110);
            hero.setStrikeAccuracy(4);
            hero.setEscape(2);
        }
    }

    public static void saveHero(){
        try {
            file = new PrintWriter(new File("Heros.txt"));
            List<Artifact> artifacts = hero.getArtifacts();
            file.print(hero.getHeroName()
                    + " " + hero.getCharacterType()
                    + " " + hero.getExperience()
                    + " " + hero.getLevel()
                    + " " + hero.getAttack()
                    + " " + hero.getDefence()
                    + " " + hero.getStrikeAccuracy()
                    + " " + hero.getEscape());
            if(artifacts != null){
                file.print(" ");
            for(Artifact artifact : artifacts){
                    file.print("-" + artifact.getName()
                            + "_" + artifact.getWeapon()
                            + "_" + artifact.getArmor()
                            + "_" + artifact.getHelm());
            }
            }
            file.print("\n");
            file.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void loadHero() {
        String buffer = null;
        try {
           BufferedReader file = new BufferedReader(new FileReader("Heros.txt"));
           buffer = file.readLine();
        } catch (Exception e) {
            System.out.println(e);
        }
        hero = new Hero();
        if (buffer != null) {
            String[] heroInfo = buffer.split(" ");
            hero.setHeroName(heroInfo[0]);
            hero.setCharacterType(heroInfo[1]);
            hero.setExperience(Integer.parseInt(heroInfo[2]));
            hero.setLevel(Integer.parseInt(heroInfo[3]));
            hero.setAttack(Integer.parseInt(heroInfo[4]));
            hero.setDefence(Integer.parseInt(heroInfo[5]));
            hero.setStrikeAccuracy(Integer.parseInt(heroInfo[6]));
            hero.setEscape(Integer.parseInt(heroInfo[7]));
            if (heroInfo.length == 9){
                String[] artifacts = heroInfo[8].split("-");
                for(String artifact : artifacts){
                    String[] artifactInfo = artifact.split("_");
                    Artifact Artifact = new Artifact();
                    Artifact.setName(artifactInfo[0]);
                    Artifact.setWeapon(Integer.parseInt(artifactInfo[1]));
                    Artifact.setArmor(Integer.parseInt(artifactInfo[2]));
                    Artifact.setHelm(Integer.parseInt(artifactInfo[3]));
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
            int option = Integer.parseInt(reader.readLine());
            switch (option) {
                case 1:
                    view.updateGUI();
                    view.toGUI();
                    break;
                case 2:
                    view.setView("createHero");
                    break;
                case 3:
                    view.setView("existingHero");
                    break;
                case 4:
                    System.out.println("Please enter hero's name:");
                    createHero(reader.readLine(), "superman" );
                    view.setView("game");
                    break;
                case 5:
                    System.out.println("Please enter hero's name:");
                    createHero(reader.readLine(), "spiderman" );
                    view.setView("game");
                    break;
                case 6:
                    view.setView("start");
                    break;
                case 7:
                    view.setView("game");
                    break;
                case 8:
                    saveHero();
                    System.out.println("\nHero has been saved.");
                    view.setView("game");
                    break;
                default:
                    System.out.println("Please enter valid selection.");
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}