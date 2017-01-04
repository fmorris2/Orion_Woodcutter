package org.mission.tasks;

import org.mission.OrionWoodcutter;

import viking.api.Timing;
import viking.api.skills.woodcutting.enums.AxeType;
import viking.framework.task.Task;

/**
 * Created by Sphiinx on 12/27/2016.
 */
public class OW_DepositItems extends Task<OrionWoodcutter> {

    public OW_DepositItems(OrionWoodcutter mission) {
        super(mission);
    }

    public boolean validate() {
        return inventory.isFull();
    }

    public void execute() {
        if (bank.isOpen()) {
            if (bank.depositAllExcept(AxeType.getItemIDs()))
                Timing.waitCondition(() -> !inventory.isFull(), 150, random(2000, 2500));
        } else {
            if (bankUtils.isInBank()) {
                if (bankUtils.open())
                    Timing.waitCondition(conditions.BANK_OPEN, 150, random(2000, 2500));
            } else {
                if (walkUtils.walkToArea(bankUtils.getClosest()))
                    Timing.waitCondition(() -> bankUtils.isInBank(), 150, random(2000, 2500));
            }
        }
    }

    @Override
    public String toString() {
        return "Depositing items";
    }
}

