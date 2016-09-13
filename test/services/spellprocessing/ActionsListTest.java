package services.spellprocessing;

import org.junit.Assert;
import org.junit.Test;
import services.microcommand.MicroCommand;
import services.microcommand.MicroCommandFactory;

import java.util.LinkedList;

/**
 * Created by Igor on 03.09.2016.
 */
public class ActionsListTest {

    private ActionsList actionsList;

    @Test
    public void shouldProperlyAddDelayedCommand() {
        actionsList = ActionsList.createActionList();
        MicroCommand microCommand = MicroCommandFactory.buildReduceHpCommand(1);

        int turnsThatBuffWorking = 10;
        actionsList.addDelayedCommand(microCommand, turnsThatBuffWorking);

        LinkedList<MicroCommand> actionsForTurn = actionsList.getActionsForTurn(turnsThatBuffWorking);
        Assert.assertTrue(actionsForTurn.contains(microCommand));
    }

    @Test
    public void shouldAddCommandForNextXTurns() {
        actionsList = ActionsList.createActionList();
        MicroCommand microCommand = MicroCommandFactory.buildReduceHpCommand(1);

        int turnsThatBuffShouldWork = 10;
        actionsList.pushMicroCommandForNextXTurns(microCommand, turnsThatBuffShouldWork);

        printBattlePlan();
        Assert.assertEquals(10, actionsList.getActionsListForBattle().size());
    }

    private void printBattlePlan() {
        System.out.println(actionsList.getActionsListForBattle());
    }

}