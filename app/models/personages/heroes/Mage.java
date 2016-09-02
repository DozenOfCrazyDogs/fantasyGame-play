package models.personages.heroes;

import services.spellprocessing.spells.Spell;
import services.spellprocessing.spells.elementary.AttackSpell;
import services.spellprocessing.spells.impl.FireballSpell;

import java.util.HashMap;

/**
 * Created by Igor on 19.08.2016.
 */
public class Mage extends Hero {

    @Override
    public void setupDefaultParameters() {
        this.health = 200;
        this.mana = 0;
        this.physicalAttack = 10;
        this.physicalDefence = 6;
        this.spells = new HashMap<String, Spell>() {{
            put("attack", new AttackSpell(2));
            put("fireball", new FireballSpell());
        }};
    }
}
