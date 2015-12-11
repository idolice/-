package oo;

import java.util.Random;

import static java.lang.Math.random;
import static java.lang.String.format;

public class Weapon {
    public   int damage;
    public  String name;
    public Attribute attribute;
    public boolean attributeTrigger;
    public String size;

    public Weapon(String name, int damage,String size) {
        this.name = name;
        this.damage = damage;
        this.size=size;
        this.attribute=new Attribute(null);
        this.attributeTrigger=isTrigger();


    }

    public int getDamage() {
        return damage;
    }

    public boolean isTrigger()
    {
        Random rand=new Random();
        int i=rand.nextInt(9);
        if (i<5)
        {
            return false;
        }
        return true;

    }

    public void hasAttribute(Attribute attri) {
        if (attributeTrigger) {
            if (attri.tripledamage==true)
            this.damage =this.damage*3;
            else
            this.damage=this.damage+attri.Extradamage;
            this.attribute = attri;
        }
    }
    public String beUsed() {
        if(name!=null)return format("用%s", name);
        else return null;
    }



}
