package models.personages;

/**
 * Created by Igor_Kravchenko on 4/5/16.
 */

import com.avaje.ebean.Model;
import models.buffs.Buff;
import models.actions.Action;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashMap;

@Entity
public abstract class Person extends Model {

    public static final Finder<Integer, Person> find = new Finder<>(Person.class);

    @Id
    public Integer id;
    public String name;
    public int maxHealth;
    public int currentHealth;
    public int maxMana;
    public int currentMana;
    public int physicalAttack;
    public int physicalDefence;
    public int magicalAttack;
    public int magicalDefence;

    protected HashMap<String, Action> actions;
    protected HashMap<String, Buff> buffs;

    public HashMap<String, Action> getActions() {
        return actions;
    }

    public void setActions(HashMap<String, Action> actions) {
        this.actions = actions;
    }

    public HashMap<String, Buff> getBuffs() {
        return buffs;
    }

    public void setBuffs(HashMap<String, Buff> buffs) {
        this.buffs = buffs;
    }
}
