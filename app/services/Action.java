package services;

import models.FightState;

/**
 * Created by Igor on 23.07.2016.
 */
public abstract class Action {

    public String Name;

    public abstract void cast(FightState fightState);

}
