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
            + "\n1. Switch to GUI display\n"
            + "2. Create New Hero\n"
            + "3. Select Existing Hero\n"
            + "4. Exit";
        } else if (view.getCurrentScreen().equals("createHero")){
            display = display + "\nPlease enter the number of the desired operation:\n"
                    + "\n1. Switch to GUI display\n"
                    + "2. Create Superman Hero\n"
                    + "3. Create Spiderman Hero\n"
                    + "4. Return to Main Menu\n"
                    + "5. Exit";
        } else if (view.getCurrentScreen().equals("existingHero")){
            if (hero != null){
                display = display + "\nSaved Hero:\n\n" + hero.getHeroInfo()
                        + "\n\nPlease enter the number of the desired operation:\n"
                        + "\n1. Switch to GUI display\n"
                        + "2. Select Saved Hero\n"
                        + "3. Return to Main Menu\n"
                        + "4. Exit";
            } else {
                display = display + "\n There are no previously saved heros."
                        + "\n\nPlease enter the number of the desired operation:\n"
                        + "\n1. Switch to GUI display\n"
                        + "2. Return to Main Menu\n"
                        + "3. Exit";
            }
        } else if (view.getCurrentScreen().equals("game")){
            display = display + "\nMap:\n\n" + Methods.getMap().getString()
                    + "\n\nHero Specs:\n\n" + hero.getHeroInfo()
                    + "\n\nPlease enter the number of the desired operation:\n"
                    + "\n1. Switch to GUI display\n"
                    + "2. Save Game\n"
                    + "3. Return to Main Menu\n"
                    + "4. Exit";
        }
        System.out.println(display);
        runCommand(view);
    }
}
