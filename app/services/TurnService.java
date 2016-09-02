package services;

import controllers.dto.InboundAction;

/**
 * Created by Igor on 02.09.2016.
 */
public interface TurnService {
    void doTurn(FightContext fightContext, InboundAction inboundAction);
}
