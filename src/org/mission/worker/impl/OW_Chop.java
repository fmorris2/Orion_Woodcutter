package org.mission.worker.impl;

import org.mission.OrionWoodcutter;
import org.mission.worker.OWWorker;

public class OW_Chop extends OWWorker
{

	public OW_Chop(OrionWoodcutter mission)
	{
		super(mission);
	}

	@Override
	public void work()
	{
		script.log(this, false, "Chop");
	}

}
