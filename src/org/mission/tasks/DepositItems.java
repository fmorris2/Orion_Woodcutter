package org.mission.tasks;

import viking.api.Timing;
import viking.api.banking.BankUtils;
import viking.api.skills.woodcutting.enums.AxeType;
import viking.framework.mission.Mission;
import viking.framework.task.Task;

/**
 * Created by Sphiinx on 12/27/2016.
 */
public class DepositItems extends Task {

    public DepositItems(Mission mission) {
        super(mission);
    }

    @Override
    public boolean validate() {
        return mission.inventory.isFull();
    }

    @Override
    public void execute() {
        if (mission.bank.isOpen()) {
            if (mission.bank.depositAllExcept(AxeType.getItemIDs()))
                Timing.waitCondition(() -> !mission.inventory.isFull(), 150, mission.random(2000, 2500));
        } else {
            if ()
        }
    }

    @Override
    public String toString() {
        return "Depositing items";
    }
}

