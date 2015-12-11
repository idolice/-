package oo;

public class NoWeapon extends Weapon {
    private static NoWeapon INSTANCE = new NoWeapon("", 0,"");

    private NoWeapon(String name, int damage,String size) {
        super(name, damage,size);
    }

    @Override
    public String beUsed() {
        return "";
    }

    public static NoWeapon getInstance() {
        return INSTANCE;
    }
}
