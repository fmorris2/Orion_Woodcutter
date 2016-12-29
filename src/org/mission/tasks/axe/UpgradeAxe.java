package org.mission.tasks.axe;

import org.mission.OrionWoodcutter;
import org.mission.data.vars.Vars;
import viking.api.Timing;
import viking.api.skills.woodcutting.enums.AxeType;

/**
 * Created by Sphiinx on 12/28/2016.
 */
public class UpgradeAxe extends GetAxe {

    private AxeType appropriate_pickaxe;
    private AxeType current_pickaxe;

    public UpgradeAxe(OrionWoodcutter mission) {
        super(mission);
    }

    @Override
    public boolean validate() {
        if (!client.isLoggedIn() || Vars.get().is_upgrading_axe)
            return false;

        if (!bank.isOpen())
            return false;

        appropriate_pickaxe = woodcutting.currentAppropriateAxe();
        current_pickaxe = woodcutting.getBestUsableAxe(false);

        return current_pickaxe != null && current_pickaxe != appropriate_pickaxe && bank.getItem(appropriate_pickaxe.getItemID()) != null;

    }

    @Override
    public void execute() {
        Vars.get().is_upgrading_axe = true;

        super.execute();

        if (equipment.getItems().length > 0)
            if (bank.depositWornItems())
                Timing.waitCondition(() -> equipment.getItems().length <= 0, 150, random(2000, 2500));
    }

    @Override
    public String toString() {
        return "Upgrading pickaxe";
    }

}

