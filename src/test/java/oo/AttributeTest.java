package oo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by idolice on 15-12-3.
 */
public class AttributeTest {
    private Soldier soldier;
    private Person person;
    private Weapon weapon;
    private Attribute attribute;

    @Before
    public void setUp() {
        this.soldier = new Soldier("张三", 100, 10);
        this.person = new Person("李四", 100, 10);
        weapon = new Weapon("屠龙刀", 10,"长");
        attribute=new Attribute("毒");
    }
    @Test
    public void shouldPrintSoldierUseWeaponAndTheAttributeAttackedPersonWhenSoldierWoreWeapon() throws Exception {
        weapon.hasAttribute(attribute);
        soldier.wearWeapon(weapon);
        person.wearWeapon(weapon);
        if (weapon.isTrigger())
        assertThat(soldier.attack(person,soldier.weapon), is("战士张三用屠龙刀攻击了普通人李四，李四受到了24点伤害，李四中毒了，李四剩余生命：76\n"));
        else assertThat(soldier.attack(person,soldier.weapon), is("战士张三用屠龙刀攻击了普通人李四，李四受到了20点伤害，李四剩余生命：80\n"));
    }


}
