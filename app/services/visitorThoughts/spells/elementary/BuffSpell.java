package services.visitorThoughts.spells.elementary;

import services.visitorThoughts.spells.Spell;
import services.visitorThoughts.visitor.SpellVisitor;

/**
 * Created by Igor on 21.08.2016.
 */
public class BuffSpell implements Spell {
    @Override
    public void accept(SpellVisitor visitor) {
        visitor.visit(this);

    }
}
