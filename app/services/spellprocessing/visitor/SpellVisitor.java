package services.spellprocessing.visitor;

import services.FightContext;
import services.spellprocessing.spells.elementary.AttackSpell;
import services.spellprocessing.spells.elementary.BuffSpell;
import services.spellprocessing.spells.elementary.DebuffSpell;
import services.spellprocessing.spells.elementary.DefenceSpell;

/**
 * Created by Igor on 21.08.2016.
 */
public interface SpellVisitor {

    void visit(AttackSpell attackSpell, FightContext fightContext);

    void visit(BuffSpell buffSpell, FightContext fightContext);

    void visit(DebuffSpell debuffSpell, FightContext fightContext);

    void visit(DefenceSpell defenceSpell, FightContext fightContext);

}
