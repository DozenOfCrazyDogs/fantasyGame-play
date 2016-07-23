package models.personages.enemies;

import models.personages.Person;
import services.FightContext;

/**
 * Created by Igor on 23.07.2016.
 */
public abstract class Enemy extends Person {
    public abstract void doAITurn(FightContext fightContext);
}
