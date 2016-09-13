package services.microcommand;

import services.FightContext;
import services.spellprocessing.statuseffects.StatusEffect;

/**
 * Created by Igor on 03.09.2016.
 * <p>
 * Use {@link MicroCommandFactory} for creation
 */
class AddStatusEffectCommand implements MicroCommand {

    private StatusEffect statusEffect;

    AddStatusEffectCommand(StatusEffect statusEffect) {
        this.statusEffect = statusEffect;
    }

    @Override
    public void execute(FightContext fightContext) {
        fightContext.getEnemy().statusEffects.add(statusEffect);
    }

    public StatusEffect getStatusEffect() {
        return statusEffect;
    }

    public void setStatusEffect(StatusEffect statusEffect) {
        this.statusEffect = statusEffect;
    }
}
