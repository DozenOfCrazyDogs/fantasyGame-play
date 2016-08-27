package services.visitorThoughts.spells;


import services.visitorThoughts.visitor.SpellVisitor;

/**
 * Created by Igor on 21.08.2016.
 */
public interface Spell {
    void accept(SpellVisitor visitor);
}
