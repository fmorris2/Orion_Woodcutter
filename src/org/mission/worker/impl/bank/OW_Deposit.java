package org.mission.worker.impl.bank;

import org.mission.OrionWoodcutter;
import org.mission.worker.OWWorker;

public class OW_Deposit extends OWWorker
{

	public OW_Deposit(OrionWoodcutter mission)
	{
		super(mission);
	}

	@Override
	public void work()
	{
		boolean DEPOSIT_BOX = !bankUtils.isInBank(false);
		
		script.log(this, false, "Deposit Items");
		
		if(bank.isOpen())
			bank.depositAllExcept(mission.currentAxe.getItemID());
		else if(depositBox.isOpen())
			depositBox.depositAllExcept(mission.currentAxe.getItemID());
		else if(DEPOSIT_BOX)
			depositBox.open();
		else
			bankUtils.open();
	}

}
