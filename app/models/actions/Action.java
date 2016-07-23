package models.actions;

/**
 * Created by Igor on 23.07.2016.
 */

import models.personages.Person;
import services.FightContext;

/**
 * rename to Damage Action
 */
public interface Action {
    public abstract void cast(Person executor, Person target, FightContext fightContext);

}
