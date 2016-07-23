package models.actions;

import models.personages.Person;
import services.FightContext;

/**
 * Created by Igor on 23.07.2016.
 */
public class AttackAction implements Action {


    @Override
    public void cast(Person executor, Person target, FightContext fightContext) {
        int damage = executor.physicalAttack - target.physicalDefence;
        if (damage > 0)
            target.currentHealth -= damage;
    }
}
