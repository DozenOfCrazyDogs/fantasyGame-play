package services.spellprocessing.spells.elementary;

import services.FightContext;
import services.spellprocessing.spells.Spell;
import services.spellprocessing.visitor.SpellVisitor;

/**
 * Created by Igor on 27.08.2016.
 */
public abstract class CompositeSpell implements Spell {
    private Spell[] spells;

    @Override
    public void accept(SpellVisitor visitor, FightContext fightContext) {
        for (Spell spell : spells) {
            spell.accept(visitor,fightContext );
        }
    }

    public void setSpells(Spell[] spells) {
        this.spells = spells;
    }

    public Spell[] getSpells() {
        return spells;
    }
}
