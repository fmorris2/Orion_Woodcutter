package org.mission.worker.impl;

import org.mission.OrionWoodcutter;
import org.mission.worker.OWWorker;

public class OW_GoToLocation extends OWWorker
{

	public OW_GoToLocation(OrionWoodcutter mission)
	{
		super(mission);
	}

	@Override
	public void work()
	{
		script.log(this, false, "Go to location");
	}

}
