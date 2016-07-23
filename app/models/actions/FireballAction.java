package models.actions;

import models.personages.Person;
import services.FightContext;

/**
 * Created by Igor on 23.07.2016.
 */
public class FireballAction implements Action {

    @Override
    public void cast(Person executor, Person target, FightContext fightContext) {
        int damage = new Double(executor.magicalAttack * 1.5).intValue();
        damage -= target.magicalDefence;
        if (damage > 0)
            target.currentHealth -= damage;
    }
}
