package model;

public class Artifact {
    private String name;
    private String type;
    private int weapon;
    private int armor;
    private int helm;

    public Artifact(){

    }

    public Artifact(int n){
        weapon = 0;
        armor = 0;
        helm = 0;
        switch (n){
            case 0:
                name = "Gas\nWeapon +2";
                type = "Weapon";
                weapon = 2;
                break;
            case 1:
                name = "Katana\nWeapon +10";
                type = "Weapon";
                weapon = 10;
                break ;
            case 2:
                name = "Tiger Claw\nWeapon +25";
                type = "Weapon";
                weapon = 25;
                break;
            case 3:
                name = "AK47\nWeapon +50";
                type = "Weapon";
                weapon = 50;
                break;
            case 4:
                name = "Machine Gun\nWeapon +100";
                type = "Weapon";
                weapon = 100;
                break;
            case 5:
                name = "Zanpakuto\nWeapon +200 Armor +20";
                type = "Weapon";
                weapon = 200;
                armor = 20;
                break;
            case 6:
                name = "Rain Coat\nArmor +1";
                type = "Armor";
                armor = 1;
                break;
            case 7:
                name = "Titanium Armor\nArmor +30";
                type = "Armor";
                armor = 30;
                break;
            case 8:
                name = "Bullet Proof Vest\nArmor +50";
                type = "Armor";
                armor = 50;
                break;
            case 9:
                name = "Batsuit\nArmor +100 Weapon +20";
                type = "Armor";
                armor = 100;
                weapon = 20;
                break;
            case 10:
                name = "Iron Man's Armor\nArmor +150 Weapon +120";
                type = "Armor";
                armor = 150;
                weapon = 120;
                break;
            case 11:
                name = "Cloak of Invisibility\nHelm +15%";
                type = "Helm";
                helm = 15;
                break;
            case 12:
                name = "One Ring\nHelm +30%";
                type = "Helm";
                helm = 30;
                break;
            case 13:
                name = "Spiderman Webshooter\nHelm +55% Weapon +40";
                type = "Helm";
                helm = 55;
                weapon = 20;
                break;
            case 14:
                name = "Easter Egg\n Helm +100% Weapon +100 Armor +100";
                type = "Helm";
                helm = 100;
                weapon = 100;
                armor = 100;
                break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getHelm() {
        return helm;
    }

    public void setHelm(int helm) {
        this.helm = helm;
    }
}
