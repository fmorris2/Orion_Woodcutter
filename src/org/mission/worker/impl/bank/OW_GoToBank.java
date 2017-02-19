package org.mission.worker.impl.bank;

import org.mission.OrionWoodcutter;
import org.mission.data.OW_Vars;
import org.mission.worker.OWWorker;

import viking.framework.antiban.reaction.ReactionEvents;

public class OW_GoToBank extends OWWorker
{
	private final boolean ACCEPT_DEPOSIT_BOX;
	
	public OW_GoToBank(OrionWoodcutter mission, boolean depositBox)
	{
		super(mission);
		ACCEPT_DEPOSIT_BOX = depositBox;
	}

	@Override
	public void work()
	{
		script.log(this, false, "Go to bank");
		
		if(OW_Vars.get().needsReactionTime)
		{
			int reactionTime = ReactionEvents.getReactionTime(mission.currentTree.getTreeName());
			script.log(this, false, "Reaction time: " + reactionTime + "ms");
			waitMs(reactionTime);
			OW_Vars.get().needsReactionTime = false;
		}
		if(!ACCEPT_DEPOSIT_BOX)
			walking.webWalk(bankUtils.getAllBanks(false, false));
		else
			walkUtils.walkToArea(mission.currentLoc.BANK_AREA);
	}

}
