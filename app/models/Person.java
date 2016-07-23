package models;

/**
 * Created by Igor_Kravchenko on 4/5/16.
 */

import com.avaje.ebean.Model;
import services.Action;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashMap;

@Entity
public class Person extends Model {

    public static final Finder<Integer, Person> find = new Finder<>(Person.class);

    @Id
    public Integer id;
    public String name;
    public Integer health;
    public Integer mana;
    public Integer attackValue;
    public Integer DefenceValue;

    public HashMap<String, Action> actions;
    public HashMap<String, Buff> buffs;
}
