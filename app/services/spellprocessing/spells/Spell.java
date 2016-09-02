package services.spellprocessing.spells;


import services.FightContext;
import services.spellprocessing.visitor.SpellVisitor;

/**
 * Created by Igor on 21.08.2016.
 */
public interface Spell {
    void accept(SpellVisitor visitor, FightContext fightContext);
}
