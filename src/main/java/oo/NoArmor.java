package oo;

public class NoArmor extends Armor {
    private static NoArmor INSTANCE = new NoArmor("", 0);

    private NoArmor(String name, int weakDamage) {
        super(name, weakDamage);
    }

    public static NoArmor getInstance() {
        return INSTANCE;
    }
}
