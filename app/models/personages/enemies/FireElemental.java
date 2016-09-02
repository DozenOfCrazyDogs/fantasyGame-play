package models.personages.enemies;

import services.FightContext;
import services.spellprocessing.spells.Spell;
import services.spellprocessing.spells.elementary.AttackSpell;
import services.spellprocessing.spells.impl.FireballSpell;

import java.util.HashMap;

/**
 * Created by Igor on 23.07.2016.
 */
public class FireElemental extends Enemy {


    public void setupDefaultParameters() {

        this.health = 400;
        this.mana = 100;

        this.physicalAttack = 0;
        this.physicalDefence = 0;
        HashMap<String, Spell> spells = new HashMap<>();
        spells.put("attack", new AttackSpell(10));
        spells.put("fireball", new FireballSpell());
        this.spells = spells;
    }

    @Override
    public void doAITurn(FightContext fightContext) {
        Spell spell;
        if (fightContext.getHero().physicalAttack > 10)
            spell = spells.get("attack");
        else
            spell = spells.get("fireball");

//        fightContext.processSpell(spell);

    }
}
