package services.microcommand;

/**
 * Created by Igor on 02.09.2016.
 */
public class MicroCommandFactory {

    public static MicroCommand buildReduceHpCommand(int damage) {
        ReduceHpCommand microCommand = new ReduceHpCommand();
        microCommand.setDamage(damage);
        return microCommand;
    }
}
