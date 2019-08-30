package view.console;

import controller.Methods;
import model.Map;
import view.Views;

import java.io.BufferedReader;
import java.nio.Buffer;

import static controller.Methods.hero;
import static controller.Methods.runCommand;

public class ViewConsoleMain {

    private view.Views view;

    public ViewConsoleMain(view.Views viewMain)
    {
        view = viewMain;
        view.setCurrentScreen("start");
    }

    public void displayConsole()
    {
        String display = "";

        if (view.getCurrentScreen().equals("start")){
            display = display + "\nPlease enter the number of the desired operation:\n"
            + "\n1. Switch to GUI display"
            + "\n2. Create New Hero"
            + "\n3. Select Existing Hero"
            + "\n4. Exit";
        } else if (view.getCurrentScreen().equals("createHero")){
            display = display + "\nSuperman\n"
                    + "\nIt's a bird! It's a plane! No it's superman!"
                    + "\nAttack: 70"
                    + "\nDefence: 200"
                    + "\nStrike Accurancy: 25%"
                    + "\nEscape Probability: 25%\n"
                    + "\nSpiderman\n"
                    + "\nWith great power, comes great responsibility."
                    + "\nAttack: 25"
                    + "\nDefence: 110"
                    + "\nStrike Accurancy: 100%"
                    + "\nEscape Probability: 50%"
                    + "\nPlease enter the number of the desired operation:\n"
                    + "\n1. Switch to GUI display"
                    + "\n2. Create Superman Hero"
                    + "\n3. Create Spiderman Hero"
                    + "\n4. Return to Main Menu"
                    + "\n5. Exit";
        } else if (view.getCurrentScreen().equals("existingHero")){
            if (hero != null){
                display = display + "\nSaved Hero:\n\n" + hero.getHeroInfo()
                        + "\n\nPlease enter the number of the desired operation:\n"
                        + "\n1. Switch to GUI display"
                        + "\n2. Select Saved Hero"
                        + "\n3. Return to Main Menu"
                        + "\n4. Exit";
            } else {
                display = display + "\nThere are no previously saved heros."
                        + "\n\nPlease enter the number of the desired operation:\n"
                        + "\n1. Switch to GUI display"
                        + "\n2. Return to Main Menu"
                        + "\n3. Exit";
            }
        } else if (view.getCurrentScreen().equals("game")){
            display = display + "\nMap:\n\n" + Methods.getMap().getString()
                    + "\n\nHero Specs:\n\n" + hero.getHeroInfo()
                    + "\n\nPlease enter the number of the desired operation:\n"
                    + "\n1. Switch to GUI display"
                    + "\n2. Save Game"
                    + "\n3. Return to Main Menu"
                    + "\n4. Exit";
        }
        System.out.println(display);
        runCommand(view);
    }
}
