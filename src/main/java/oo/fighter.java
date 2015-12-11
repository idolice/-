package oo;

/**
 * Created by idolice on 15-12-1.
 */
public class fighter extends Soldier {
    public fighter(String name, int blood, int damage)
    {
        super(name,blood,damage);

    }

    @Override
    public String getRole() {
        return "战士";
    }

    @Override
    public void wearWeapon(Weapon weapon) throws Exception {
        super.wearWeapon(weapon);
        if (weapon.size!="中")
        {
            throw new Exception("战士只能装备中型武器！");
        }
        if (weapon.size!="中"){
            weapon.attributeTrigger=false;
        }
    }
}
