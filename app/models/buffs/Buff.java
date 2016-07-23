package models.buffs;

import models.actions.Action;
import models.personages.Person;
import services.FightContext;

/**
 * Created by Igor on 23.07.2016.
 */
public enum Buff implements Action{
    DOUBLE_PHYSICAL_DAMAGE {
        @Override
        public void cast(Person executor, Person target, FightContext fightContext) {

        }
    },
    DOUBLE_MANA_USAGE {
        @Override
        public void cast(Person executor, Person target, FightContext fightContext) {

        }
    },
    HALF_DAMAGE_TAKEN {
        @Override
        public void cast(Person executor, Person target, FightContext fightContext) {

        }
    };

}
