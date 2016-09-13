package services.spellprocessing.spells.impl;

import models.personages.Person;
import services.spellprocessing.spells.DamageType;
import services.spellprocessing.spells.elementary.AttackSpell;

/**
 * Created by Igor on 03.09.2016.
 */
public class PhysicAttackSpell extends AttackSpell {
    private static final DamageType DAMAGE_TYPE = DamageType.PHYSIC;

    public PhysicAttackSpell() {
        super(DAMAGE_TYPE);
    }

    @Override
    public int calculateDamage(Person person) {
        return person.physicalAttack;
    }
}
