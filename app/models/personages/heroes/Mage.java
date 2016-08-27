package models.personages.heroes;

import models.actions.Action;
import models.actions.FireballAction;

import java.util.HashMap;

/**
 * Created by Igor on 19.08.2016.
 */
public class Mage extends Hero{
    private Mage() {

    }
    @Override
    public Mage getProfile() {
        Mage mage = new Mage();
        mage.health = 200;
        mage.mana = 0;
        mage.physicalAttack = 10;
        mage.physicalDefence = 6;
        mage.actions = new HashMap<String, Action>() {{
            put("fireball", new FireballAction());
        }};
        return mage;
    }

    public static Mage createMage(String name) {
        //todo HOW TO FIX UP
        Mage mage = new Mage();
        mage = mage.getProfile();
        mage.name = name;
        return mage;
    }

}
