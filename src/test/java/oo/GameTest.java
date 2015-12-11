package oo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.inOrder;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {
    private Game game;
    @Mock
    private ConsolePrinter consolePrinter;
    InOrder inOrder;

    @Before
    public void setUp() {
        inOrder = inOrder(consolePrinter);
        game = new Game(consolePrinter);
    }



    @Test
    public void shouldFirstPlayerLoseWhenSecondPlayerIsPowerful() throws Exception {
        Person firstPerson = new Person("张三", 10, 8);
        Person secondPerson = new Person("李四", 20, 9);
        Weapon weapon =new Weapon("木锤",5,"短");
        firstPerson.wearWeapon(weapon);
        game.fight(firstPerson, secondPerson);

        inOrder.verify(consolePrinter, times(1)).print("普通人张三攻击了普通人李四，李四受到了8点伤害，李四剩余生命：12\n\n");
        inOrder.verify(consolePrinter, times(1)).print("普通人李四攻击了普通人张三，张三受到了9点伤害，张三剩余生命：1\n\n");
        inOrder.verify(consolePrinter, times(1)).print("普通人张三攻击了普通人李四，李四受到了8点伤害，李四剩余生命：4\n\n");
        inOrder.verify(consolePrinter, times(1)).print("普通人李四攻击了普通人张三，张三受到了9点伤害，张三剩余生命：-8\n\n");
       // inOrder.verify(consolePrinter, times(1)).print("张三被打败了");
    }


    @Test
    public void shouldSoldierDefeatePerson() throws Exception
    {
      //given
      Soldier soldier=new Soldier("张三",20,5);
        Person person =new Person("李四",20,5);
        Weapon weapon =new Weapon("木剑",10,"长");
        soldier.wearWeapon(weapon);



      //when
        game.fight(soldier,person);

      //then
        inOrder.verify(consolePrinter, times(1)).print("战士张三用木剑攻击了普通人李四，李四受到了15点伤害，李四剩余生命：5\n\n");
        inOrder.verify(consolePrinter, times(1)).print("普通人李四攻击了战士张三，张三受到了5点伤害，张三剩余生命：15\n\n");
      //  inOrder.verify(consolePrinter, times(1)).print("战士张三攻击了普通人李四，李四受到了15点伤害，李四剩余生命：-10\n\n");

      }

    @Test
    public void shouldSoldierDefeatePersonwithAttribute() throws Exception
    {
      //given
        Soldier soldier=new Soldier("张三",20,5);
        Person person =new Person("李四",20,5);
        Weapon weapon =new Weapon("木剑",10,"长");
        Attribute attribute=new Attribute("毒");
        weapon.hasAttribute(attribute);
        soldier.wearWeapon(weapon);

      //when
      game.fight(soldier,person);

      //then
        if (weapon.attributeTrigger==true){
            inOrder.verify(consolePrinter, times(1)).print("战士张三用木剑攻击了普通人李四，李四受到了19点伤害，李四中毒了，李四剩余生命：1\n\n");
            inOrder.verify(consolePrinter, times(1)).print("普通人李四攻击了战士张三，张三受到了5点伤害，张三剩余生命：15\n\n");
        }
        else {
            inOrder.verify(consolePrinter, times(1)).print("战士张三用木剑攻击了普通人李四，李四受到了15点伤害，李四剩余生命：5\n\n");
            inOrder.verify(consolePrinter, times(1)).print("普通人李四攻击了战士张三，张三受到了5点伤害，张三剩余生命：15\n\n");
        }
      }

    @Test
    public void shouldStopAttackWhenInfluencedByAttribute() throws Exception
    {
      //given
        Soldier soldier=new Soldier("张三",20,5);
        Person person =new Person("李四",20,5);
        Weapon weapon =new Weapon("木剑",10,"长");
        Attribute attribute=new Attribute("晕");
        weapon.hasAttribute(attribute);
        soldier.wearWeapon(weapon);

      //when
        game.fight(soldier,person);

      //then
        if (weapon.attributeTrigger==true){
            inOrder.verify(consolePrinter, times(1)).print("战士张三用木剑攻击了普通人李四，李四受到了15点伤害，李四中晕了，李四剩余生命：5\n\n");
           //inOrder.verify(consolePrinter, times(1)).print("李四晕倒了，无法攻击，眩晕还剩1轮\n\n");
           // inOrder.verify(consolePrinter, times(1)).print("战士张三用木剑攻击了普通人李四，李四受到了15点伤害，李四中晕了，李四剩余生命：-10\n\n");
        }
        else {
            inOrder.verify(consolePrinter, times(1)).print("战士张三用木剑攻击了普通人李四，李四受到了15点伤害，李四剩余生命：5\n\n");
            inOrder.verify(consolePrinter, times(1)).print("普通人李四攻击了战士张三，张三受到了5点伤害，张三剩余生命：15\n\n");
        }
    }

}