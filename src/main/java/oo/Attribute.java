package oo;

import java.util.Random;

/**
 * Created by idolice on 15-12-3.
 */
public class Attribute {
    public int Extradamage;
    public String EtraInfluence;
    public boolean tripledamage=false;

    public Attribute(String property)
    {
        if (property=="晕")
        this.Extradamage=0;
        if (property=="冰冻")
            this.Extradamage=2;
        if (property=="毒")
            this.Extradamage=4;
        if (property=="全力一击") {
            this.Extradamage = 1;
            tripledamage = true;
        }
        this.EtraInfluence=property;

    }







}
