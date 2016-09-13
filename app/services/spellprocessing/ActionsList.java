package services.spellprocessing;

import services.microcommand.MicroCommand;

import java.util.LinkedList;

/**
 * Created by Igor on 03.09.2016.
 */
public class ActionsList {
    private static final int INITIAL_TURNS_SIZE = 5;

    private ActionsList() {
    }

    private LinkedList<LinkedList<MicroCommand>> actionsListForBattle;
    private LinkedList<MicroCommand> currentTurn;
    private int cursor;

    public static ActionsList createActionList() {
        ActionsList actionsList = new ActionsList();

        actionsList.actionsListForBattle = new LinkedList<>();
        for (int i = 0; i < INITIAL_TURNS_SIZE; i++) {
            actionsList.actionsListForBattle.add(new LinkedList<>());
        }
        actionsList.currentTurn = actionsList.actionsListForBattle.getFirst();
        actionsList.cursor = 0;
        return actionsList;
    }

    public LinkedList<MicroCommand> nextTurn() {
        cursor++;
        currentTurn = actionsListForBattle.get(cursor);
        return currentTurn;
    }

    public LinkedList<MicroCommand> getCurrentTurn() {
        return currentTurn;
    }

    public void addDelayedCommand(MicroCommand microCommand, int delay) {
        int futureTurn = cursor + delay;
        ensureCapacity(futureTurn + 1);
        LinkedList<MicroCommand> microCommands = actionsListForBattle.get(futureTurn);
        microCommands.add(microCommand);
    }

    public void pushMicroCommandForNextXTurns(MicroCommand microCommand, int turns) {
        int futureTurn = cursor + turns;
        ensureCapacity(futureTurn);
        for (int i = cursor; i < futureTurn; i++) {
            LinkedList<MicroCommand> microCommands = actionsListForBattle.get(i);
            microCommands.addFirst(microCommand);
        }
    }

    private void ensureCapacity(int futureTurn) {
        if (actionsListForBattle.size() < futureTurn) {
            int turnsShouldBeAdded = futureTurn - actionsListForBattle.size();
            for (int i = 0; i < turnsShouldBeAdded; i++) {
                actionsListForBattle.addLast(new LinkedList<>());
            }
        }
    }

    public LinkedList<LinkedList<MicroCommand>> getActionsListForBattle() {
        return actionsListForBattle;
    }

    public LinkedList<MicroCommand> getActionsForTurn(int turn) {
        return actionsListForBattle.get(turn);
    }

    public void setActionsListForBattle(LinkedList<LinkedList<MicroCommand>> actionsListForBattle) {
        this.actionsListForBattle = actionsListForBattle;
    }

    public void setCurrentTurn(LinkedList<MicroCommand> currentTurn) {
        this.currentTurn = currentTurn;
    }
}
