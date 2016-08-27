package services.visitorThoughts.visitor;

import services.visitorThoughts.spells.elementary.AttackSpell;
import services.visitorThoughts.spells.elementary.BuffSpell;
import services.visitorThoughts.spells.elementary.DebuffSpell;
import services.visitorThoughts.spells.elementary.DefenceSpell;

/**
 * Created by Igor on 21.08.2016.
 */
public interface SpellVisitor {

    void visit(AttackSpell attackSpell);

    void visit(BuffSpell buffSpell);

    void visit(DebuffSpell debuffSpell);

    void visit(DefenceSpell defenceSpell);

}
