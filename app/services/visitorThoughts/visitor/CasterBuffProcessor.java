package services.visitorThoughts.visitor;

import services.FightContext;
import services.visitorThoughts.spells.elementary.AttackSpell;
import services.visitorThoughts.spells.elementary.BuffSpell;
import services.visitorThoughts.spells.elementary.DebuffSpell;
import services.visitorThoughts.spells.elementary.DefenceSpell;

/**
 * Created by Igor on 21.08.2016.
 */
public class CasterBuffProcessor implements SpellVisitor {
    private final FightContext fightContext;

    public CasterBuffProcessor(FightContext fightContext) {
        this.fightContext = fightContext;
    }

    @Override
    public void visit(AttackSpell attackSpell) {

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
