package services.spellprocessing.statuseffects;

import services.spellprocessing.spells.DamageType;

/**
 * Created by Igor on 03.09.2016.
 */
public class ElementalWeaknessStatus implements StatusEffect {

    private String name;
    private DamageType weaknessType;
    private double weaknessValue;

    public ElementalWeaknessStatus(String name, DamageType weaknessType, double weaknessValue) {
        this.name = name;
        this.weaknessType = weaknessType;
        this.weaknessValue = weaknessValue;
    }


    public DamageType getWeaknessType() {
        return weaknessType;
    }

    public void setWeaknessType(DamageType weaknessType) {
        this.weaknessType = weaknessType;
    }

    public double getWeaknessValue() {
        return weaknessValue;
    }

    public void setWeaknessValue(double weaknessValue) {
        this.weaknessValue = weaknessValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
