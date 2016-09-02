package services.spellprocessing.spells.impl;

import services.spellprocessing.spells.Spell;
import services.spellprocessing.spells.elementary.AttackSpell;
import services.spellprocessing.spells.elementary.CompositeSpell;
import services.spellprocessing.spells.elementary.DebuffSpell;

/**
 * Created by Igor on 21.08.2016.
 */
public class FireballSpell extends CompositeSpell {
    private static final int DAMAGE = 100;

//    private Spell[] spells;

    //todo sequence is matters
    public FireballSpell() {
        setSpells(new Spell[]{new AttackSpell(DAMAGE), new DebuffSpell(3,2)});
    }

}
