package org.mission.worker.impl;

import org.mission.OrionWoodcutter;
import org.mission.worker.OWWorker;
import org.osbot.rs07.api.map.Position;

public class OW_GetBronzeAxe extends OWWorker
{
	private static final Position TUTOR_POS = new Position(3228, 3245, 0);
	private static final int DIST_THRESH = 7;
	
	public OW_GetBronzeAxe(OrionWoodcutter mission)
	{
		super(mission);
	}

	@Override
	public void work()
	{
		script.log(this, false, "Get bronze axe");
		if(myPosition().distance(TUTOR_POS) > DIST_THRESH)
			walkUtils.walkTo(TUTOR_POS);
		else if(iFact.dialogue("Talk-to", "Woodsman tutor", 15, 1).execute() && inventory.contains("Bronze axe"))
			script.log(this, false, "Successfully received bronze axe");
	}

}
