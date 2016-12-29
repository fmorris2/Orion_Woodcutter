package org.mission.tasks.axe;

import org.mission.OrionWoodcutter;
import org.mission.data.vars.Vars;
import org.osbot.rs07.api.model.Item;
import org.osbot.rs07.api.ui.EquipmentSlot;
import viking.api.Timing;
import viking.api.skills.woodcutting.enums.AxeType;
import viking.framework.task.Task;

/**
 * Created by Sphiinx on 12/28/2016.
 */
public class GetAxe extends Task<OrionWoodcutter> {

    public GetAxe(OrionWoodcutter mission) {
        super(mission);
    }

    @Override
    public boolean validate() {
        if (!client.isLoggedIn() || Vars.get().is_upgrading_axe)
            return false;

        return !equipment.isWearingItem(EquipmentSlot.WEAPON) && woodcutting.getBestUsableAxe(false) == null;
    }

    @Override
    public void execute() {
        if (bank.isOpen()) {
            final Item[] INVENTORY_CACHE = inventory.getItems();
            if (!inventory.isEmpty())
                if (bank.depositAll())
                    Timing.waitCondition(() -> INVENTORY_CACHE.length != inventory.getItems().length, 150, random(2000, 2500));

            final AxeType best_usable_axe = woodcutting.getBestUsableAxe(true);
            if (best_usable_axe == null)
                return;

            if (bank.withdraw(best_usable_axe.getItemID(), 1))
                if (Timing.waitCondition(() -> inventory.getItems().length > 0, 150, random(2000, 2500)))
                    if (woodcutting.getBestUsableAxe(false) == best_usable_axe)
                        Vars.get().is_upgrading_axe = false;
        } else {
            if (bankUtils.isInBank()) {
                if (bankUtils.open())
                    Timing.waitCondition(() -> bank.isOpen(), 150, random(2000, 2500));
            } else {
                if (walkUtils.walkToArea(bankUtils.getClosest()))
                    Timing.waitCondition(() -> bankUtils.isInBank(), 150, random(2000, 2500));
            }
        }

    }

    @Override
    public String toString() {
        return "Getting axe";
    }

}

