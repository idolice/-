package oo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void shouldCreatePlayerSuccessfully() {
        Person person = new Person("王二麻子", 100, 10);

        assertThat(person.getName(), is("王二麻子"));
        assertThat(person.getBlood(), is(100));
        assertThat(person.getDamage(), is(10));
    }

    @Test
    public void shouldCanAttackOtherPlayer() {
        Person attacker = new Person("张三", 100, 10);
        Person victim = new Person("李四", 80, 20);

        attacker.attack(victim,NoWeapon.getInstance());

        assertThat(victim.getBlood(), is(80 - attacker.getDamage()));
    }

    @Test
    public void shouldReturnWhoAttackVictimAndHowMuchVictimBleedAndHowMuchBloodLeft() {
        Person attacker = new Person("张三", 100, 10);
        Person victim = new Person("李四", 80, 20);

        assertThat(attacker.attack(victim,NoWeapon.getInstance()), is("普通人张三攻击了普通人李四，李四受到了10点伤害，李四剩余生命：70"));
    }

    @Test
    public void shouldReturnPersonAttackSoldierAndHowMuchSoldierBleedAndHowMuchBloodLeft() {
        Person person = new Person("张三", 100, 10);
        Soldier soldier = new Soldier("李四", 80, 20);

        assertThat(person.attack(soldier,NoWeapon.getInstance()), is("普通人张三攻击了战士李四，李四受到了10点伤害，李四剩余生命：70"));
    }

    @Test
    public void shouldBleedIsPersonDamageMinusSoldierArmorWeakenDamage() {
        Person person = new Person("张三", 100, 10);
        Soldier soldier = new Soldier("李四", 80, 20);
        Armor armor = new Armor("金丝软甲", 5);
        soldier.wearArmor(armor);

        assertThat(person.attack(soldier,NoWeapon.getInstance()), is("普通人张三攻击了战士李四，李四受到了5点伤害，李四剩余生命：75"));
    }

    @Test
    public void shouldAliveWhenBloodIs0() {
        Person survivor = new Person("王二麻子", 0, 0);

        assertThat(survivor.isAlive(), is(true));
    }

    @Test
    public void shouldAliveWhenBloodGreatThan0() {
        Person survivor = new Person("王二麻子", 1, 0);

        assertThat(survivor.isAlive(), is(true));
    }

    @Test
    public void shouldDeadWhenBloodLessThan0() {
        Person dead = new Person("王二麻子", -1, 0);

        assertThat(dead.isAlive(), is(false));
    }
}