package oo;

import static java.lang.String.format;

public class Soldier extends Person implements WearWeapon {
    private Armor armor;
    //private Weapon weapon;

    public Soldier(String name, int blood, int damage) {
        super(name, blood, damage);
        this.armor = NoArmor.getInstance();
        this.weapon = NoWeapon.getInstance();
    }

    @Override
    public String getRole() {
        return "战士";
    }

    public void wearArmor(Armor armor) {
        this.armor = armor;
    }

    @Override
    protected int bleed(int damageFromAttacker) {
        return (damageFromAttacker > armor.getWeakenDamage()) ? damageFromAttacker - armor.getWeakenDamage() : 0;
    }


    @Override
    protected String attackIdentify() {
        return format("%s%s", super.attackIdentify(), weapon.beUsed());
    }

    @Override
    public void wearWeapon(Weapon weapon) throws Exception{
        this.weapon = weapon;
        this.damage += weapon.getDamage();
    }


}
