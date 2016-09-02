package services;

import models.personages.enemies.Enemy;
import models.personages.heroes.Hero;
import services.microcommand.MicroCommand;

import java.util.LinkedList;

/**
 * Created by Igor on 23.07.2016.
 */
//todo test singleton for saving sever state instead of cache
//@Singleton
public class FightContext {

    private Enemy enemy;
    private Hero hero;

    private LinkedList<MicroCommand> actionStackForThisTurn = new LinkedList<>();
    private LinkedList<LinkedList<MicroCommand>> actionStackForBattle = new LinkedList<>();


    public FightContext() {
    }

    public void setupPersonages(Hero hero, Enemy enemy) {
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

    public LinkedList<MicroCommand> getActionStackForThisTurn() {
        return actionStackForThisTurn;
    }

    public void setActionStackForThisTurn(LinkedList<MicroCommand> actionStackForThisTurn) {
        this.actionStackForThisTurn = actionStackForThisTurn;
    }

    public LinkedList<LinkedList<MicroCommand>> getActionStackForBattle() {
        return actionStackForBattle;
    }

    public void setActionStackForBattle(LinkedList<LinkedList<MicroCommand>> actionStackForBattle) {
        this.actionStackForBattle = actionStackForBattle;
    }
}
