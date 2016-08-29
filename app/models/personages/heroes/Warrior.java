package models.personages.heroes;

import services.visitorThoughts.spells.Spell;
import services.visitorThoughts.spells.elementary.AttackSpell;

import java.util.HashMap;

/**
 * Created by Igor on 23.07.2016.
 */
public class Warrior extends Hero {
    private Warrior() {

    }

    @Override
    public Warrior getProfile() {
        Warrior warrior = new Warrior();
        warrior.health = 200;
        warrior.mana = 0;
        warrior.physicalAttack = 10;
        warrior.physicalDefence = 6;
        warrior.spells = new HashMap<String, Spell>() {{
            put("attack", new AttackSpell(10));
        }};
        return warrior;
    }

    public static Warrior createWarrior(String name) {
        Warrior warrior = new Warrior();
        warrior = warrior.getProfile();
        warrior.name = name;
        return warrior;
    }
}
