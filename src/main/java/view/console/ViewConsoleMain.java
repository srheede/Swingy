package view.console;

import view.Views;

import java.io.BufferedReader;
import java.nio.Buffer;

import static controller.Methods.hero;
import static controller.Methods.runCommand;

public class ViewConsoleMain {

    public String currentScreen;
    private view.Views view;

    public ViewConsoleMain(view.Views viewMain)
    {
        view = viewMain;
        currentScreen = "start";
    }

    public void displayConsole()
    {
        String display = "";

        if (currentScreen.equals("start")){
            display = display + "\nPlease enter the number of the desired operation:\n"
            + "\n1. Switch to GUI display\n"
            + "2. Create New Hero\n"
            + "3. Select Existing Hero\n";
        } else if (currentScreen.equals("createHero")){
            display = display + "\nPlease enter the number of the desired operation:\n"
                    + "\n1. Switch to GUI display\n"
                    + "4. Create Superman Hero\n"
                    + "5. Create Spiderman Hero\n"
                    + "6. Return to Main Menu\n";
        } else if (currentScreen.equals("existingHero")){
            display = display + "\nSaved Hero:\n\n" + hero.getHeroInfo()
                    + "\n\nPlease enter the number of the desired operation:\n"
                    + "\n1. Switch to GUI display\n"
                    + "7. Select Saved Hero\n"
                    + "6. Return to Main Menu\n";
        } else if (currentScreen.equals("game")){
            display = display + "\nHero Specs:\n\n" + hero.getHeroInfo()
                    + "\n\nPlease enter the number of the desired operation:\n"
                    + "\n1. Switch to GUI display\n"
                    + "8. Save Game\n"
                    + "6. Return to Main Menu\n";
        }
        System.out.println(display);
        runCommand(view);
    }
}
