package models.actions.buffactions;

import models.actions.Action;
import models.buffs.Buff;
import models.personages.Person;
import services.FightContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor on 23.07.2016.
 */
public class PhysicalAttackBuffAction implements Action {
    public static int turns = 2;
    public static final Buff buff = Buff.DOUBLE_PHYSICAL_DAMAGE;

    @Override
    public void cast(Person executor, Person target, FightContext fightContext) {
        for(int i =0; i<turns; i++){
            List<Buff> buffs = fightContext.getBuffsSchedule().get(i + 1);
            if(buffs==null)
                buffs = new ArrayList<>();
            buffs.add(Buff.DOUBLE_PHYSICAL_DAMAGE);
        }
    }
}
