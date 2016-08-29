package models.personages.enemies;

import services.FightContext;
import services.visitorThoughts.spells.Spell;
import services.visitorThoughts.spells.elementary.AttackSpell;
import services.visitorThoughts.spells.impl.FireballSpell;

import java.util.HashMap;

/**
 * Created by Igor on 23.07.2016.
 */
public class FireElemental extends Enemy {
    private FireElemental() {
    }

    public static FireElemental createFireElemental() {
        FireElemental fireElemental = new FireElemental();
        fireElemental = fireElemental.getProfile();
        fireElemental.name = "FireElemental";
        return fireElemental;
    }

    @Override
    public FireElemental getProfile() {
        FireElemental fireElemental = new FireElemental();

        fireElemental.health = 400;
        fireElemental.mana = 100;

        fireElemental.physicalAttack = 0;
        fireElemental.physicalDefence = 0;

        setupSpells(fireElemental);
        return fireElemental;
    }

    private void setupSpells(FireElemental fireElemental) {
        HashMap<String, Spell> spells = new HashMap<>();
        spells.put("attack", new AttackSpell(10));
        spells.put("fireball", new FireballSpell());
        fireElemental.spells = spells;
    }

    @Override
    public void doAITurn(FightContext fightContext) {
        Spell spell;
        if (fightContext.getHero().physicalAttack > 10)
            spell = spells.get("attack");
        else
            spell = spells.get("fireball");

        fightContext.processSpell(spell);

    }
}
