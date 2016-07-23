package models.personages.heroes;

import models.actions.Action;
import models.actions.AttackAction;

import java.util.HashMap;

/**
 * Created by Igor on 23.07.2016.
 */
public class Warrior extends Hero {
    private Warrior() {

    }

    public static Warrior createWarrior(String name) {
        Warrior warrior = new Warrior();
        warrior.name = name;
        warrior.maxHealth = 200;
        warrior.maxMana = 0;
        warrior.physicalAttack = 10;
        warrior.physicalDefence = 6;
        HashMap<String, Action> actions = new HashMap<String, Action>() {{
            put("attack", new AttackAction());
        }};
        warrior.setActions(actions);
        return warrior;
    }

}
