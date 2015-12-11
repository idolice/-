package oo;

import static java.lang.String.format;

public class Game {
    private ConsolePrinter consolePrinter;

    public Game(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    public void fight(Person firstPerson, Person secondPerson) {
        Person attacker = firstPerson;
        Person victim = secondPerson;
        Person loser = victim;

        while (victim.isAlive()) {
            consolePrinter.print(format("%s\n", attacker.attack(victim,attacker.weapon)));
           if (victim.stopattacktime==0) {
                loser = victim;
                victim = attacker;
                attacker = loser;
            }
            else {
               consolePrinter.print(victim.beeninfluenced);
               victim.stopattacktime--;
           }


        }

        consolePrinter.print(format("%s被打败了", loser.getName()));
    }
}
