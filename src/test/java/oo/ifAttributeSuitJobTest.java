package oo;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by idolice on 15-12-3.
 */
public class ifAttributeSuitJobTest {
    private asses ass;
    private Person person;
    private fighter fight;
    private rider  ride;
    private Weapon weapon,weapon2,weapon3;
    private Attribute attribute;

    @Rule
    public ExpectedException exp=ExpectedException.none();

    @Before
    public void setUp() {
        this.ass = new asses("张三", 100, 10);
        this.fight=new fighter("王五",100,10);
        this.ride=new rider("李六",100,10);
        this.person = new Person("李四", 100, 10);
        weapon = new Weapon("屠龙刀", 10,"中");
        weapon2 =new Weapon("峨嵋刺",9,"长");
        weapon3 =new Weapon("木锤",11,"短");
        attribute=new Attribute("毒");

    }


    @Test(expected = Exception.class)
    public void asses_should_not_wear_long_weapon() throws Exception {

        ass.wearWeapon(weapon2);
    }
}
