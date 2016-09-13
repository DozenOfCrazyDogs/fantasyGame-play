package services.spellprocessing.spells.impl;

import models.personages.Person;
import services.spellprocessing.spells.DamageType;
import services.spellprocessing.spells.Spell;
import services.spellprocessing.spells.elementary.AttackSpell;
import services.spellprocessing.spells.elementary.CompositeSpell;
import services.spellprocessing.spells.elementary.DebuffSpell;

/**
 * Created by Igor on 21.08.2016.
 */
public class FireballSpell extends CompositeSpell {
    private static final int BASE_DAMAGE = 100;


    private static AttackSpell fireAttack = new AttackSpell(DamageType.FIRE) {
        @Override
        public int calculateDamage(Person person) {
            return BASE_DAMAGE + person.magicalAttack / 2;
        }
    };

    //todo sequence is matters
    public FireballSpell() {
        setSpells(new Spell[]{fireAttack, new DebuffSpell("burning", 3, 2)});
    }

}
