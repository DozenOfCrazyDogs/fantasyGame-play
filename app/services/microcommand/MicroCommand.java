package services.microcommand;

import services.FightContext;

/**
 * Created by Igor on 19.08.2016.
 */
public interface MicroCommand {
    void execute(FightContext fightContext);
}
