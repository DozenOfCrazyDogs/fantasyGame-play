package services.spellprocessing.visitor;

import services.FightContext;
import services.spellprocessing.spells.elementary.AttackSpell;
import services.spellprocessing.spells.elementary.BuffSpell;
import services.spellprocessing.spells.elementary.DebuffSpell;
import services.spellprocessing.spells.elementary.DefenceSpell;

/**
 * Created by Igor on 21.08.2016.
 */
public class CasterBuffProcessor implements SpellVisitor {

    @Override
    public void visit(AttackSpell attackSpell, FightContext fightContext) {

    }

    @Override
    public void visit(BuffSpell buffSpell, FightContext fightContext) {

    }

    @Override
    public void visit(DebuffSpell debuffSpell, FightContext fightContext) {

    }

    @Override
    public void visit(DefenceSpell defenceSpell, FightContext fightContext) {

    }
}
