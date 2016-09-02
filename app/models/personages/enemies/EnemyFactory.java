package models.personages.enemies;

/**
 * Created by Igor on 02.09.2016.
 */
public class EnemyFactory {

    public static FireElemental createFireElemental() {
        FireElemental fireElemental = new FireElemental();
        fireElemental.setupDefaultParameters();
        fireElemental.name = "FireElemental";
        return fireElemental;
    }
}
