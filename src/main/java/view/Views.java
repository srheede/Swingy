package view;

import controller.Methods;
import view.console.ViewConsoleMain;
import view.gui.ViewGUIMain;

import static controller.Methods.loadMap;

public class Views {

    private boolean GUIView;
    private ViewGUIMain viewGUIMain;
    private ViewConsoleMain viewConsoleMain;
    private String currentScreen;

    public Views(){
        viewGUIMain = new ViewGUIMain(this);
        viewConsoleMain = new ViewConsoleMain(this);
    }

    public void toConsole(){
        GUIView = false;
        viewGUIMain.frame.setVisible(false);
        viewConsoleMain.displayConsole();
    }

    public void toGUI(){
        GUIView = true;
        viewGUIMain.frame.setVisible(true);
    }

    public void setView(String view){
        currentScreen = view;
        viewGUIMain.panelStart.setVisible(view.equals("start"));
        viewGUIMain.panelCreateHero.setVisible(view.equals("createHero"));
        viewGUIMain.panelExistingHero.setVisible(view.equals("existingHero"));
        viewGUIMain.panelGame.setVisible(view.equals("game"));
        if (!GUIView) {
            viewConsoleMain.displayConsole();
        }
    }

    public void updateGUI() {
        viewGUIMain.setTextAreaSpecs();
    }

    public String getCurrentScreen() {
        return currentScreen;
    }

    public void setCurrentScreen(String currentScreen) {
        this.currentScreen = currentScreen;
    }
}
