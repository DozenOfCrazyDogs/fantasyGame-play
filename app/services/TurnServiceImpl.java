package services;

import controllers.dto.InboundAction;
import models.personages.Person;
import models.personages.enemies.Enemy;
import models.personages.heroes.Hero;
import services.microcommand.MicroCommand;
import services.spellprocessing.spells.Spell;
import services.spellprocessing.visitor.CasterBuffProcessor;
import services.spellprocessing.visitor.CasterDebuffProcessor;
import services.spellprocessing.visitor.FinishSpellVisitor;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.LinkedList;

/**
 * Created by Igor on 02.09.2016.
 */

@Singleton
public class TurnServiceImpl implements TurnService {

    private FightContext fightContext;

    @Inject
    private CasterBuffProcessor casterBuffProcessor = new CasterBuffProcessor();

    @Inject
    private CasterDebuffProcessor casterDebuffProcessor = new CasterDebuffProcessor();

    @Inject
    private FinishSpellVisitor finishSpellProcessor = new FinishSpellVisitor();

    @Override
    public void doTurn(FightContext fightContext, InboundAction inboundAction) {
        this.fightContext = fightContext;
        prepareActionLists();
        prepareHeroTurn(inboundAction);
//        prepareEnemyTurn(inboundAction);
        executeMicroCommandsForThisTurn();
        fightContext.getActionStackForBattle().removeFirst();
    }

    private void prepareActionLists() {
        LinkedList<LinkedList<MicroCommand>> actionStackForBattle = fightContext.getActionStackForBattle();
        if (actionStackForBattle.isEmpty()) {
            actionStackForBattle.addFirst(new LinkedList<>());
        }
        fightContext.setActionStackForThisTurn(actionStackForBattle.getFirst());
    }

    private void prepareHeroTurn(InboundAction inboundAction) {
        String actionName = inboundAction.getActionName();
        Hero hero = fightContext.getHero();
        Spell spell = hero.spells.get(actionName);
        //todo somehow handle target
        Person target = ejectTarget(inboundAction);
        processSpell(spell);
    }

    public void processSpell(Spell spell) {
        //todo probably build macroCommand every step
        spell.accept(casterBuffProcessor, fightContext);
        spell.accept(casterDebuffProcessor, fightContext);
//        spell.accept(enemyBuffProcessor);
//        spell.accept(enemyBuffProcessor);
        spell.accept(finishSpellProcessor, fightContext);
    }

    private Person ejectTarget(InboundAction inboundAction) {
        String targetName = inboundAction.getTarget();
        Hero hero = fightContext.getHero();
        Enemy enemy = fightContext.getEnemy();
        return hero.name.equals(targetName) ? hero : enemy;
    }

    private void executeMicroCommandsForThisTurn() {
        LinkedList<MicroCommand> actionStackForThisTurn = fightContext.getActionStackForThisTurn();
        for (MicroCommand microCommand : actionStackForThisTurn) {
            microCommand.execute(fightContext);
        }
    }

    public void setFightContext(FightContext fightContext) {
        this.fightContext = fightContext;
    }
}
