package models.personages.enemies;

import models.actions.Action;
import models.actions.AttackAction;
import models.actions.FireballAction;
import services.FightContext;

import java.util.HashMap;

/**
 * Created by Igor on 23.07.2016.
 */
public class FireElemental extends Enemy {
    private FireElemental() {

    }

    public static FireElemental createFireElemental() {
        FireElemental fireElemental = new FireElemental();
        fireElemental.name = "FireElemental";

        fireElemental.maxHealth = 400;
        fireElemental.currentHealth = 400;
        fireElemental.maxMana = 100;
        fireElemental.currentMana = 400;

        fireElemental.physicalAttack = 0;
        fireElemental.physicalDefence = 0;

        setupSpells(fireElemental);
        return fireElemental;
    }

    private static void setupSpells(FireElemental fireElemental) {
        HashMap<String, Action> actions = new HashMap<>();
        actions.put("attack", new AttackAction());
        actions.put("fireball", new FireballAction());
        fireElemental.setActions(actions);
    }

    @Override
    public void doAITurn(FightContext fightContext) {
        Action action;
        if (fightContext.getHero().physicalAttack > 10)
            action = actions.get("attack");
        else
            action = actions.get("fireball");

        action.cast(fightContext.getEnemy(), fightContext.getHero(), fightContext);
    }
}
