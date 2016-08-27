package services.visitorThoughts.spells.elementary;

import services.visitorThoughts.spells.Spell;
import services.visitorThoughts.visitor.SpellVisitor;

/**
 * Created by Igor on 27.08.2016.
 */
public class CompositSpell implements Spell {
    private Spell[] spells;

    @Override
    public void accept(SpellVisitor visitor) {

    }
}
