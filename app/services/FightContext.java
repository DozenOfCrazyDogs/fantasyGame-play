package services;

import controllers.dto.InboundAction;
import models.personages.Person;
import models.personages.enemies.Enemy;
import models.personages.heroes.Hero;
import services.microcommand.MicroCommand;
import services.visitorThoughts.spells.Spell;
import services.visitorThoughts.spells.impl.FireballSpell;
import services.visitorThoughts.visitor.CasterBuffProcessor;
import services.visitorThoughts.visitor.FinishSpellVisitor;

import java.util.LinkedList;

/**
 * Created by Igor on 23.07.2016.
 */
public class FightContext {

    private Enemy enemy;
    private Hero hero;

    private LinkedList<MicroCommand> actionStackForThisTurn = new LinkedList<>();
    private LinkedList<LinkedList<MicroCommand>> actionStackForBattle = new LinkedList<>();
    private CasterBuffProcessor casterBuffProcessor = new CasterBuffProcessor(this);
    private FinishSpellVisitor finishSpellProcessor = new FinishSpellVisitor(this);


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

    public void doTurn(InboundAction inboundAction) {
//        buffProcessingBeforeTurn();
        String actionName = inboundAction.getActionName();
        Spell spell = hero.spells.get(actionName);
        //todo somehow handle target
        Person target = ejectTarget(inboundAction);
        processSpell(spell);
//        action.cast(hero, enemy, this);
//        enemy.doAITurn(this);
//
//        buffProcessingAfterTurnDone();
    }

    public void processSpell(Spell spell) {
        spell.accept(casterBuffProcessor);
        spell.accept(finishSpellProcessor);
    }

    private Person ejectTarget(InboundAction inboundAction) {
        String targetName = inboundAction.getTarget();
        return hero.name.equals(targetName) ? hero : enemy;
    }

    private void buffProcessingBeforeTurn() {
        //todo execute buffs
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
