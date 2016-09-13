package services.microcommand;

import services.FightContext;
import services.spellprocessing.statuseffects.StatusEffect;

/**
 * Created by Igor on 03.09.2016.
 * Use {@link MicroCommandFactory} for creation
 */
class RemoveStatusEffectCommand implements MicroCommand {
    private StatusEffect statusEffect;

    RemoveStatusEffectCommand(StatusEffect statusEffect) {
        this.statusEffect = statusEffect;
    }

    @Override
    public void execute(FightContext fightContext) {
        fightContext.getEnemy().statusEffects.remove(statusEffect);
    }

    public StatusEffect getStatusEffect() {
        return statusEffect;
    }

    public void setStatusEffect(StatusEffect statusEffect) {
        this.statusEffect = statusEffect;
    }
}
