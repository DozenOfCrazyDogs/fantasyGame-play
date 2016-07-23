package models;

/**
 * Created by Igor_Kravchenko on 4/5/16.
 */

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person extends Model {

    public static final Finder<Integer, Person> find = new Finder<>(Person.class);

    @Id
    public Integer id;

    public String name;
}
