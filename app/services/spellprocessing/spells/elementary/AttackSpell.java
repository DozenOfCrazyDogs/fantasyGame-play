package services.spellprocessing.spells.elementary;

import services.FightContext;
import services.spellprocessing.spells.Spell;
import services.spellprocessing.visitor.SpellVisitor;

/**
 * Created by Igor on 21.08.2016.
 */
public class AttackSpell implements Spell {
    private int damage;

    public AttackSpell(int damage) {
        this.damage = damage;
    }

    @Override
    public void accept(SpellVisitor visitor, FightContext fightContext) {
        visitor.visit(this, fightContext);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
