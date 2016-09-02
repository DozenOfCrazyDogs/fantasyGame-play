package models.personages.heroes;

import services.spellprocessing.spells.Spell;
import services.spellprocessing.spells.elementary.AttackSpell;

import java.util.HashMap;

/**
 * Created by Igor on 23.07.2016.
 */
public class Warrior extends Hero {

    public void setupDefaultParameters() {
        this.health = 200;
        this.mana = 0;
        this.physicalAttack = 10;
        this.physicalDefence = 6;
        this.spells = new HashMap<String, Spell>() {{
            put("attack", new AttackSpell(10));
        }};
    }
}