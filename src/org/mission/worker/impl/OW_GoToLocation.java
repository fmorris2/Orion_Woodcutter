package org.mission.worker.impl;

import org.mission.OrionWoodcutter;
import org.mission.data.OW_Vars;
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
		OW_Vars.get().needsReactionTime = false;
		walkUtils.walkToArea(mission.currentLoc.CENTER_AREA);
	}

}
