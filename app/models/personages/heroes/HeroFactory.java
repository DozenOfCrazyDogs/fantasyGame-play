package models.personages.heroes;

/**
 * Created by Igor on 02.09.2016.
 */
public class HeroFactory {

    public static Hero createMage(String name) {
        Mage mage = new Mage();
        mage.setupDefaultParameters();
        mage.name = name;
        return mage;
    }

    public static Hero createWarrior(String name) {
        Warrior warrior = new Warrior();
        warrior.setupDefaultParameters();
        warrior.name = name;
        return warrior;
    }

    public static Hero createGod(String name) {
        GodHero godHero = new GodHero();
        godHero.setupDefaultParameters();
        godHero.name = name;
        return godHero;
    }
}
