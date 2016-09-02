package services.spellprocessing.spells.elementary;

import services.FightContext;
import services.spellprocessing.spells.Spell;
import services.spellprocessing.visitor.SpellVisitor;

/**
 * Created by Igor on 21.08.2016.
 */
public class DebuffSpell implements Spell {
    private int turns;
    private int damageEveryTurn;

    public DebuffSpell(int turns) {
        this.turns = turns;
    }

    public DebuffSpell(int turns, int damageEveryTurn) {
        this.turns = turns;
        this.damageEveryTurn = damageEveryTurn;
    }

    @Override
    public void accept(SpellVisitor visitor, FightContext fightContext) {
        visitor.visit(this, fightContext);

    }

    public int getDamageEveryTurn() {
        return damageEveryTurn;
    }

    public void setDamageEveryTurn(int damageEveryTurn) {
        this.damageEveryTurn = damageEveryTurn;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }
}
