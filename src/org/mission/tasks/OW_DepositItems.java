package org.mission.tasks;

import org.mission.OrionWoodcutter;
import org.mission.data.OW_Vars;

import viking.api.Timing;
import viking.framework.task.Task;

/**
 * Created by Sphiinx on 12/27/2016.
 */
public class OW_DepositItems extends Task<OrionWoodcutter> {

	private boolean hasCheckedNormalBank;
	
    public OW_DepositItems(OrionWoodcutter mission) {
        super(mission);
    }

    public boolean validate() {
        return inventory.isFull();
    }

    public void execute() {
        if (hasCheckedNormalBank && OW_Vars.get().chopping_location.shouldUseDepositBox()) {
            if (depositBox.isOpen()) {
                if (depositBox.depositAllExcept(woodcutting.getBestUsableAxe(false).getItemID()))
                    Timing.waitCondition(() -> !inventory.isFull(), 150, random(2000, 2500));
            } else {
                if (bankUtils.isInBank()) {
                    if (depositBox.open())
                        Timing.waitCondition(() -> depositBox.isOpen(), 150, random(2000, 2500));
                } else {
                    if (getWalking().webWalk(bankUtils.getAllBanks(false, true)))
                        Timing.waitCondition(() -> bankUtils.isInBank(), 150, random(2000, 2500));
                }
            }
        } else {
            if (bank.isOpen()) {
                if (bank.depositAllExcept(woodcutting.getBestUsableAxe(false).getItemID()) && Timing.waitCondition(() -> !inventory.isFull(), 150, random(2000, 2500)))
                	hasCheckedNormalBank = true;
            } else {
                if (bankUtils.isInBank()) {
                    if (bankUtils.open())
                        Timing.waitCondition(conditions.BANK_OPEN, 150, random(2000, 2500));
                } else {
                    if (getWalking().webWalk(bankUtils.getAllBanks(false, false)))
                        Timing.waitCondition(() -> bankUtils.isInBank(), 150, random(2000, 2500));
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Depositing items";
    }
}

