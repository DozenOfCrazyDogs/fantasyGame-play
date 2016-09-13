package services.spellprocessing.visitor;

import services.FightContext;
import services.microcommand.MicroCommand;
import services.microcommand.MicroCommandFactory;
import services.spellprocessing.spells.DamageType;
import services.spellprocessing.spells.elementary.AttackSpell;
import services.spellprocessing.spells.elementary.BuffSpell;
import services.spellprocessing.spells.elementary.DebuffSpell;
import services.spellprocessing.spells.elementary.DefenceSpell;
import services.spellprocessing.statuseffects.ElementalWeaknessStatus;

/**
 * Created by Igor on 26.08.2016.
 */
public class FinishSpellVisitor implements SpellVisitor {

    @Override
    public void visit(AttackSpell attackSpell, FightContext fightContext) {
        MicroCommand microCommand = MicroCommandFactory.buildReduceHpCommand(attackSpell.calculateDamage(fightContext.getHero()));
        fightContext.getActionsList().getCurrentTurn().addFirst(microCommand);
    }

    @Override
    public void visit(BuffSpell buffSpell, FightContext fightContext) {

    }

    @Override
    public void visit(DebuffSpell debuffSpell, FightContext fightContext) {
        createEveryTurnDamage(debuffSpell, fightContext);
        createWeaknesses(debuffSpell, fightContext);
    }

    private void createWeaknesses(DebuffSpell debuffSpell, FightContext fightContext) {
        ElementalWeaknessStatus elementalWeaknessStatus = extractElementalWeaknessFromDebuffSpell(debuffSpell);

        MicroCommand microCommand = MicroCommandFactory.buildAddStatusEffectCommand(elementalWeaknessStatus);
        fightContext.getActionsList().getCurrentTurn().add(microCommand);

        microCommand = MicroCommandFactory.buildRemoveStatusEffectCommand(elementalWeaknessStatus);
        fightContext.getActionsList().addDelayedCommand(microCommand, debuffSpell.getTurns());
    }

    private ElementalWeaknessStatus extractElementalWeaknessFromDebuffSpell(DebuffSpell debuffSpell) {
        DamageType createWeakness = debuffSpell.getCreateWeakness();
        String name = debuffSpell.getName();
        return new ElementalWeaknessStatus(name, createWeakness, debuffSpell.getWeaknessValue());
    }

    private void createEveryTurnDamage(DebuffSpell debuffSpell, FightContext fightContext) {
        int turns = debuffSpell.getTurns();
        int damageEveryTurn = debuffSpell.getDamageEveryTurn();
        if (damageEveryTurn > 0) {
            MicroCommand microCommand = MicroCommandFactory.buildReduceHpCommand(damageEveryTurn);
            fightContext.getActionsList().pushMicroCommandForNextXTurns(microCommand, turns);
        }
    }


    @Override
    public void visit(DefenceSpell defenceSpell, FightContext fightContext) {

    }


}
