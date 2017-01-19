package org.mission.worker.impl;

import org.mission.OrionWoodcutter;
import org.mission.worker.OWWorker;

public class OW_GetBronzeAxe extends OWWorker
{

	public OW_GetBronzeAxe(OrionWoodcutter mission)
	{
		super(mission);
	}

	@Override
	public void work()
	{
		script.log(this, false, "Get bronze axe");
	}

}
