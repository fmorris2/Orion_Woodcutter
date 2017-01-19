package org.mission.worker;

import org.mission.OrionWoodcutter;

import viking.framework.worker.Worker;

public abstract class OWWorker extends Worker<OrionWoodcutter>
{
	public OWWorker(OrionWoodcutter mission)
	{
		super(mission);
	}

	@Override
	public boolean needsRepeat()
	{
		return false;
	}
}
