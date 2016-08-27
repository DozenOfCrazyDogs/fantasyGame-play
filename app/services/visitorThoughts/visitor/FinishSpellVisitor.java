package services.visitorThoughts.visitor;

import services.FightContext;
import services.microcommand.ReduceHpCommand;
import services.visitorThoughts.spells.elementary.AttackSpell;
import services.visitorThoughts.spells.elementary.BuffSpell;
import services.visitorThoughts.spells.elementary.DebuffSpell;
import services.visitorThoughts.spells.elementary.DefenceSpell;

/**
 * Created by Igor on 26.08.2016.
 */
public class FinishSpellVisitor implements SpellVisitor {
    private FightContext fightContext;

    public FinishSpellVisitor(FightContext fightContext) {
        this.fightContext = fightContext;
    }

    @Override
    public void visit(AttackSpell attackSpell) {
        ReduceHpCommand microCommand = new ReduceHpCommand();
        microCommand.setDamage(attackSpell.getDamage());
        fightContext.getActionStackForThisTurn().push(microCommand);
    }

    @Override
    public void visit(BuffSpell buffSpell) {

    }

    @Override
    public void visit(DebuffSpell debuffSpell) {

    }

    @Override
    public void visit(DefenceSpell defenceSpell) {

    }


}
