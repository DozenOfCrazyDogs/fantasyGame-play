package models;

import com.avaje.ebean.Model;

import java.util.HashMap;

/**
 * Created by Igor on 23.07.2016.
 */
public class Hero extends Model {

    public Integer health;
    public Integer mana;
    public Integer attackValue;
    public Integer DefenceValue;

    public HashMap<String, Spell> spells;
    public HashMap<String, Item> equipment;


}
