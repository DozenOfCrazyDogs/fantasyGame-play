package services.spellprocessing.spells.impl;

import services.spellprocessing.spells.DamageType;
import services.spellprocessing.spells.elementary.DebuffSpell;

/**
 * Created by Igor on 03.09.2016.
 */
public class OilDebuff extends DebuffSpell {
    private static final DamageType WEAKNESS = DamageType.FIRE;
    private static final String NAME = "oil";
    private static final double WEAKNESS_VALUE = 0.5;

    public OilDebuff(int turns) {
        super(NAME, turns, WEAKNESS, WEAKNESS_VALUE);
    }

}
