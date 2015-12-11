package oo;

import static java.lang.String.format;

public class Person implements WearWeapon {
    private String name;
    private int blood;
    protected int damage;
    public Weapon weapon;
    public boolean stopattack;
    public int stopattacktime;
    public String beeninfluenced;
    public Person(String name, int blood, int damage) {
        this.name = name;
        this.blood = blood;
        this.damage = damage;
        this.stopattacktime=0;
        this.stopattack=false;
        this.beeninfluenced=null;
        this.weapon=NoWeapon.getInstance();
    }

    public String getName() {
        return name;
    }

    public int getBlood() {
        return blood;
    }

    public int getDamage() {
        return damage;
    }

    public String getRole() {
        return "普通人";
    }


    public String attack(Person victim,Weapon weapon) {
        return format("%s攻击了%s，%s\n", attackIdentify(), victim.beAttackedIdentify(), victim.beAttacked(damage,weapon));
    }


    private String beAttackedIdentify() {
        return format("%s%s", getRole(), name);
    }

    protected String attackIdentify() {
        return format("%s%s", getRole(), name);
    }



    private String beAttacked(int damageFromAttacker,Weapon weapon) {
        int bleed = bleed(damageFromAttacker);
        blood -= bleed;
        if (weapon.attribute.EtraInfluence==null) {
            return format("%s受到了%d点伤害，%s剩余生命：%d",
                    name, bleed, name, blood);
        }
        else if (weapon.attributeTrigger==true&&weapon.attributeTrigger==true){
            if (weapon.attribute.EtraInfluence=="晕"){
            stopattack=true;
            stopattacktime++;
            beeninfluenced=format("%s晕倒了，无法攻击，眩晕还剩%d轮",name,stopattacktime);
        }
            return format("%s受到了%d点伤害，%s中%s了，%s剩余生命：%d",
                    name, bleed,name,weapon.attribute.EtraInfluence, name, blood);
        }
            return format("%s受到了%d点伤害，%s剩余生命：%d",
                name, bleed, name, blood);
    }


    protected int bleed(int damageFromAttacker) {
        return damageFromAttacker;
    }

    public boolean isAlive() {
        return blood >= 0;
    }

    @Override
    public void wearWeapon(Weapon  weapon) throws Exception{
        this.weapon=new Weapon(null,0,null);

    }


}
