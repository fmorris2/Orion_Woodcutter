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
		script.log(this, false, "Deposit Items");
	}

}
