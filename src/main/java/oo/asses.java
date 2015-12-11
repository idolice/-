package oo;

/**
 * Created by idolice on 15-12-1.
 */
public class asses extends Soldier
{
    public boolean rightweapon=true;

   public asses(String name, int blood, int damage)
   {
       super(name,blood,damage);

   }

    @Override
    public String getRole() {
        return "刺客";
    }

    @Override
    public void wearWeapon(Weapon weapon) throws Exception {
      super.wearWeapon(weapon);
        if (weapon.size=="长")
        {
            rightweapon=false;
            throw new Exception("刺客不能装备长武器！");
        }
        if (weapon.size!="短"){
            weapon.attributeTrigger=false;
        }
    }


}
