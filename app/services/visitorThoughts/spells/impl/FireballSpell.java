package services.visitorThoughts.spells.impl;

import services.visitorThoughts.spells.elementary.AttackSpell;
import services.visitorThoughts.spells.elementary.DebuffSpell;
import services.visitorThoughts.spells.Spell;
import services.visitorThoughts.visitor.SpellVisitor;

/**
 * Created by Igor on 21.08.2016.
 */
public class FireballSpell extends AttackSpell {
    private static final int DAMAGE = 100;
    private Spell[] spells;

    public FireballSpell() {
        super(100);
        spells = new Spell[]{new AttackSpell(DAMAGE), new DebuffSpell()};
    }

    @Override
    public void accept(SpellVisitor visitor) {
        for (Spell spell : spells) {
            spell.accept(visitor);
        }

    }
}
