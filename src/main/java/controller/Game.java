package controller;

import model.Map;
import view.gui.ViewGUIMain;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static controller.Methods.hero;
import static controller.Methods.loadMap;

public class Game {

    public Game() {
    }

    public static void conflict() {
        System.out.println("conflict");
    }

    public static void nextLevel() {
        hero.levelUP();
            loadMap();
    }
}
