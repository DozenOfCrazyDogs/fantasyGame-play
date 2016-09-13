package models.personages.heroes;

import services.spellprocessing.spells.Spell;
import services.spellprocessing.spells.elementary.AttackSpell;
import services.spellprocessing.spells.impl.FireballSpell;
import services.spellprocessing.spells.impl.OilDebuff;
import services.spellprocessing.spells.impl.PhysicAttackSpell;

import java.util.HashMap;

/**
 * Created by Igor on 03.09.2016.
 */
public class GodHero extends Hero {
    @Override
    public void setupDefaultParameters() {
        this.health = 2000;
        this.mana = 2000;
        this.physicalAttack = 100;
        this.physicalDefence = 60;
        this.spells = new HashMap<String, Spell>() {{
            put("attack", new PhysicAttackSpell());
            put("fireball", new FireballSpell());
            put("oil", new OilDebuff(2));
        }};
    }
}
