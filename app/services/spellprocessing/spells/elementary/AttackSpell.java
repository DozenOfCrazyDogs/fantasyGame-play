package services.spellprocessing.spells.elementary;

import models.personages.Person;
import models.personages.heroes.Hero;
import services.FightContext;
import services.spellprocessing.spells.DamageType;
import services.spellprocessing.spells.Spell;
import services.spellprocessing.visitor.SpellVisitor;

/**
 * Created by Igor on 21.08.2016.
 */
public abstract class AttackSpell implements Spell {

    private DamageType damageType;


    public AttackSpell(DamageType damageType) {
        this.damageType = damageType;
    }

    public abstract int calculateDamage(Person hero);

    @Override
    public void accept(SpellVisitor visitor, FightContext fightContext) {
        visitor.visit(this, fightContext);
    }


    public DamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }
}
