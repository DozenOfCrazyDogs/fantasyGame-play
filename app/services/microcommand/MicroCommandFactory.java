package services.microcommand;

import services.spellprocessing.statuseffects.StatusEffect;

/**
 * Created by Igor on 02.09.2016.
 */
public class MicroCommandFactory {

    public static MicroCommand buildReduceHpCommand(int damage) {
        return new ReduceHpCommand(damage);
    }

    public static MicroCommand buildAddStatusEffectCommand(StatusEffect statusEffect) {
        return new AddStatusEffectCommand(statusEffect);
    }

    public static MicroCommand buildRemoveStatusEffectCommand(StatusEffect statusEffect) {
        return new AddStatusEffectCommand(statusEffect);
    }
}
