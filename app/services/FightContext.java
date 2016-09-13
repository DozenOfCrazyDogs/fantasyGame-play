package services;

import models.personages.enemies.Enemy;
import models.personages.heroes.Hero;
import services.spellprocessing.ActionsList;

import java.util.LinkedList;

/**
 * Created by Igor on 23.07.2016.
 */
//todo test singleton for saving server state instead of cache
//@Singleton
public class FightContext {

    private Enemy enemy;
    private Hero hero;
    private ActionsList actionsList;


    public FightContext() {
    }


    public void startFight(Hero hero, Enemy enemy) {
        this.actionsList = ActionsList.createActionList();
        this.hero = hero;
        this.enemy = enemy;
    }

    public void setupFullHealthMana() {
        hero.health = 100;
        hero.mana = 100;
    }


    private void resetStatsToDefault() {
        //todo reset stats to default should be called on wrapped object
    }


    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public ActionsList getActionsList() {
        return actionsList;
    }

    public void setActionsList(ActionsList actionsList) {
        this.actionsList = actionsList;
    }
}
