package services.visitorThoughts.spells.elementary;

import services.visitorThoughts.spells.Spell;
import services.visitorThoughts.visitor.SpellVisitor;

/**
 * Created by Igor on 21.08.2016.
 */
public class AttackSpell implements Spell {
    private int damage;

    public AttackSpell(int damage) {
        this.damage = damage;
    }

    @Override
    public void accept(SpellVisitor visitor) {
        visitor.visit(this);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
