package services.spellprocessing.spells.elementary;

import services.FightContext;
import services.spellprocessing.spells.DamageType;
import services.spellprocessing.spells.Spell;
import services.spellprocessing.visitor.SpellVisitor;

/**
 * Created by Igor on 21.08.2016.
 */
public class DebuffSpell implements Spell {

    private String name;
    private int turns;
    private int damageEveryTurn;
    private DamageType createWeakness;
    private double weaknessValue;

    public DebuffSpell(String name, int turns) {
        this.turns = turns;
        this.name = name;
    }

    public DebuffSpell(String name, int turns, int damageEveryTurn) {
        this.name = name;
        this.turns = turns;
        this.damageEveryTurn = damageEveryTurn;
    }

    public DebuffSpell(String name, int turns, DamageType createWeakness, double weaknessValue) {
        this.name = name;
        this.turns = turns;
        this.createWeakness = createWeakness;
        this.weaknessValue = weaknessValue;
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

    public DamageType getCreateWeakness() {
        return createWeakness;
    }

    public void setCreateWeakness(DamageType createWeakness) {
        this.createWeakness = createWeakness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeaknessValue() {
        return weaknessValue;
    }

    public void setWeaknessValue(double weaknessValue) {
        this.weaknessValue = weaknessValue;
    }
}
