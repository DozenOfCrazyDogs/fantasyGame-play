package services.spellprocessing.visitor;

import services.FightContext;
import services.microcommand.MicroCommand;
import services.microcommand.MicroCommandFactory;
import services.spellprocessing.spells.elementary.AttackSpell;
import services.spellprocessing.spells.elementary.BuffSpell;
import services.spellprocessing.spells.elementary.DebuffSpell;
import services.spellprocessing.spells.elementary.DefenceSpell;

import java.util.LinkedList;

/**
 * Created by Igor on 26.08.2016.
 */
public class FinishSpellVisitor implements SpellVisitor {

    @Override
    public void visit(AttackSpell attackSpell, FightContext fightContext) {
        MicroCommand microCommand = MicroCommandFactory.buildReduceHpCommand(attackSpell.getDamage());
        fightContext.getActionStackForThisTurn().addFirst(microCommand);
    }

    @Override
    public void visit(BuffSpell buffSpell, FightContext fightContext) {

    }

    @Override
    public void visit(DebuffSpell debuffSpell, FightContext fightContext) {
        int damageEveryTurn = debuffSpell.getDamageEveryTurn();
        int turns = debuffSpell.getTurns();
        MicroCommand microCommand = MicroCommandFactory.buildReduceHpCommand(damageEveryTurn);
        if (damageEveryTurn > 0) {
            pushMicroCommandForNextXTurns(turns, microCommand,fightContext);
        }
    }

    private void pushMicroCommandForNextXTurns(int turns, MicroCommand microCommand, FightContext fightContext) {
        LinkedList<LinkedList<MicroCommand>> actionStackForBattle = fightContext.getActionStackForBattle();
        for (int i = 0; i < turns; i++) {
            if (actionStackForBattle.size() <= i)
                actionStackForBattle.addLast(new LinkedList<>());
            LinkedList<MicroCommand> microCommands = actionStackForBattle.get(i);
            microCommands.addFirst(microCommand);
        }
    }

    @Override
    public void visit(DefenceSpell defenceSpell, FightContext fightContext) {

    }


}
