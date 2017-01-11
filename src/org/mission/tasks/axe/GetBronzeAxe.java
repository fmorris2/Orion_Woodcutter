package org.mission.tasks.axe;

import org.mission.OrionWoodcutter;
import org.mission.data.vars.OW_Vars;
import org.osbot.rs07.api.map.Position;

import viking.framework.task.Task;

public class GetBronzeAxe extends Task<OrionWoodcutter>
{
	private static final Position TUTOR_POS = new Position(3228, 3245, 0);
	private static final int DIST_THRESH = 7;
	
	public GetBronzeAxe(OrionWoodcutter mission)
	{
		super(mission);
	}

	@Override
	public boolean validate()
	{
		return OW_Vars.get().needsBronzeAxe;
	}

	@Override
	public void execute()
	{
		script.log(this, false, "Get Bronze Axe");
		if(myPosition().distance(TUTOR_POS) > DIST_THRESH)
			walkUtils.walkTo(TUTOR_POS);
		else if(iFact.dialogue("Talk-to", "Woodsman tutor", 15, 1).execute() && inventory.contains("Bronze axe"))
			OW_Vars.get().needsBronzeAxe = false;
		
	}

}
