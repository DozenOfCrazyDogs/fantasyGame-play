package services.microcommand;

import services.FightContext;

/**
 * Created by Igor on 19.08.2016.
 * Use {@link MicroCommandFactory} for creation
 */
class ReduceHpCommand implements MicroCommand {
    private int damage;

    ReduceHpCommand(int damage) {
        this.damage = damage;
    }

    @Override
    public void execute(FightContext fightContext) {
        fightContext.getEnemy().health -= damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
