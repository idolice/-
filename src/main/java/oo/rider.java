package oo;

/**
 * Created by idolice on 15-12-1.
 */
public class rider extends Soldier {
    public rider(String name, int blood, int damage)
    {
        super(name,blood,damage);

    }

    @Override
    public String getRole() {
        return "骑士";
    }

    @Override
    public void wearWeapon(Weapon weapon) throws Exception {
        super.wearWeapon(weapon);
        if (weapon.size=="短")
        {
            throw new Exception("骑士不能装备短武器！");
        }
        if (weapon.size!="长"){
            weapon.attributeTrigger=false;
        }
    }
}
