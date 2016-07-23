package services;

import controllers.dto.InboundAction;
import models.FightState;

/**
 * Created by Igor on 23.07.2016.
 */
public class FightProcessor {

    private FightState fightState;

    public FightProcessor(FightState fightState) {
        this.fightState = fightState;
    }


    public void doAction(InboundAction inboundAction) {
        String actionName = inboundAction.getActionName();
        Action action = fightState.hero.actions.get(actionName);
        action.cast(fightState);
    }

    public void onHeroAction() {

    }

    public void onBossAction() {

    }
}
