package oo;

public class Armor {
    private String name;
    private int weakenDamage;

    public Armor(String name, int weakDamage) {
        this.name = name;
        this.weakenDamage = weakDamage;
    }

    public int getWeakenDamage() {
        return weakenDamage;
    }
}
