package model;

import java.util.Arrays;
import java.util.Random;

import static controller.Methods.hero;

public class Map {
    private static int size;
    public static char[][] map;
    private static char[][] hiddenMap;
    private String string = "";


    public Map(){
        setSize();
        fillMap();
        fillHiddenMap();
        placePlayer();
    }

    public static void refreshMap() {
        fillHiddenMap();
        placePlayer();
    }

    public String getString(){
        if (hero.getLevel() == 4) {
            string = "You win!";
        } else if (hero.getLevel() == 0) {
            string = "You lost the game..";
        } else {
            string = "";
            for (char[] row : hiddenMap) {
                string = string + Arrays.toString(row) + "\n";
            }
        }
        return (string);
    }

    public static int getSize() {
        return size;
    }

    public void setSize() {
        size =  ((hero.getLevel()-1)*5)+10-(hero.getLevel()%2);
    }

    public void fillMap() {
        int j;
        int k;
        int percentage = (size * size)/3;
        Random rand = new Random();
        map = new char[size][size];
        for (char[] row : map) {
            Arrays.fill(row, 'O');
        }
        for (int i = 0; i < percentage; i++){
            j = rand.nextInt(size);
            k = rand.nextInt(size);
            if (map[j][k] == 'X'){
                i--;
            }
            map[j][k] = 'X';
        }
        map[size/2][size/2] = 'H';
        hero.setCoordinates(size/2);
    }

    public static void fillHiddenMap() {
        hiddenMap = new char[size][size];
        for (char[] row : hiddenMap) {
            Arrays.fill(row, 'O');
        }
    }

    public static void placePlayer() {
        hiddenMap[hero.i][hero.j] = 'H';
    }
}
