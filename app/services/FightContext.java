package services;

import controllers.dto.InboundAction;
import models.actions.Action;
import models.buffs.Buff;
import models.personages.enemies.Enemy;
import models.personages.heroes.Hero;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Igor on 23.07.2016.
 */
public class FightContext {

    private Enemy enemy;
    private Hero hero;
    private LinkedList<List<Buff>> buffsSchedule = new LinkedList<>();


    public FightContext() {
    }

    public void setupPersonages(Hero hero, Enemy enemy) {
        //todo to remove doubling of current and max parameters use new WrappedPerson with composition and current states of same properties
        this.hero = hero;
        this.enemy = enemy;
    }

    public void setupFullHealthMana() {
        hero.currentHealth = hero.maxHealth;
        hero.currentMana = hero.maxMana;
        enemy.currentHealth = enemy.maxHealth;
        enemy.currentMana = enemy.maxMana;
    }

    public void doTurn(InboundAction inboundAction) {
        buffProcessingBeforeTurn();
        String actionName = inboundAction.getActionName();
        Action action = hero.getActions().get(actionName);
        action.cast(hero, enemy, this);
        enemy.doAITurn(this);

        buffProcessingAfterTurnDone();
    }

    private void buffProcessingBeforeTurn() {
        //todo execute buffs
    }

    private void buffProcessingAfterTurnDone() {
        resetStatsToDefault();
        if (!buffsSchedule.isEmpty())
            buffsSchedule.removeFirst();
    }

    private void resetStatsToDefault() {
        //todo reset stats to default should be called on wrapped object
    }

    public void onHeroAction() {

    }

    public void onBossAction() {

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
    public LinkedList<List<Buff>> getBuffsSchedule() {
        return buffsSchedule;
    }

    public void setBuffsSchedule(LinkedList<List<Buff>> buffsSchedule) {
        this.buffsSchedule = buffsSchedule;
    }

}
