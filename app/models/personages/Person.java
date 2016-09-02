package models.personages;

/**
 * Created by Igor_Kravchenko on 4/5/16.
 */

import com.avaje.ebean.Model;
import services.spellprocessing.spells.Spell;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashMap;

@Entity
public abstract class Person extends Model {

    public static final Finder<Integer, Person> find = new Finder<>(Person.class);

    @Id
    public Integer id;
    public String name;
    public int health;
    public int mana;
    public int physicalAttack;
    public int physicalDefence;
    public int magicalAttack;
    public int magicalDefence;

    public HashMap<String, Spell> spells;

    public abstract void setupDefaultParameters();

}
