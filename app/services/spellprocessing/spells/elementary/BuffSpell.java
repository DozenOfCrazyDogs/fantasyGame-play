package services.spellprocessing.spells.elementary;

import services.FightContext;
import services.spellprocessing.spells.Spell;
import services.spellprocessing.visitor.SpellVisitor;

/**
 * Created by Igor on 21.08.2016.
 */
public class BuffSpell implements Spell {
    @Override
    public void accept(SpellVisitor visitor, FightContext fightContext) {
        visitor.visit(this,fightContext );

    }
}
