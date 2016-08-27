package services.microcommand;

import services.FightContext;

/**
 * Created by Igor on 19.08.2016.
 */
public class ReduceHpCommand implements MicroCommand {
    private int damage;

    @Override
    public void execute(FightContext fightContext) {
        //todo need target here
        fightContext.getEnemy().health -= damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
