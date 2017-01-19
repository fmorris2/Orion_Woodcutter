package org.mission.worker.impl;

import org.mission.OrionWoodcutter;
import org.mission.worker.OWWorker;
import org.osbot.rs07.api.ui.Skill;

public class OW_WieldAxe extends OWWorker
{

	public OW_WieldAxe(OrionWoodcutter mission)
	{
		super(mission);
	}

	@Override
	public void work()
	{
		script.log(this, false, "Wield axe");
		if(bank.isOpen())
			bank.close();
		else if(grandExchange.isOpen())
			grandExchange.close();
		else
			itemUtils.wield(mission.currentAxe.getItemID());
	}
	
	public boolean needsToWieldAxe()
	{
		int id = mission.currentAxe.getItemID();
		int req = mission.currentAxe.getAttackLevel();
		
		return skills.getStatic(Skill.ATTACK) >= req && 
				!equipment.contains(id) && inventory.contains(id);
	}

}
