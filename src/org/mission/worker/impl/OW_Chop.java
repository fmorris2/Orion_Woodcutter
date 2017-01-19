package org.mission.worker.impl;

import org.mission.OrionWoodcutter;
import org.mission.worker.OWWorker;
import org.osbot.rs07.api.filter.AreaFilter;
import org.osbot.rs07.api.filter.Filter;
import org.osbot.rs07.api.filter.NameFilter;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.api.model.RS2Object;

import viking.api.Timing;
import viking.api.filter.VFilters;
import viking.api.skills.woodcutting.enums.TreeType;

public class OW_Chop extends OWWorker
{
	private static final int FALLBACK_AREA_RAD = 2;
	
	private RS2Object currentTree, targetTree;
	
	public OW_Chop(OrionWoodcutter mission)
	{
		super(mission);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void work()
	{
		script.log(this, false, "Chop");
		
		TreeType tree = mission.currentTree;
		Area area = mission.currentLoc.getArea();
		Filter<RS2Object> filter = VFilters.and(new NameFilter<RS2Object>(tree.getTreeName()), new AreaFilter<RS2Object>(area));
		
		targetTree = objects.closest(filter); //get the tree we should be chopping
		
		if(myPlayer().isAnimating() && currentTree != null && currentTree.exists())
			script.log(this, false, "Chopping...");
		else if(targetTree != null && iFact.clickObject("Chop down", targetTree, getFallBackPos(targetTree)).execute())
		{
			script.log(this, false, "Successfully clicked tree");
			if(Timing.waitCondition(() -> myPlayer().isAnimating() || !targetTree.exists(), 5000))
			{
				if(targetTree.exists())
				{
					script.log(this, false, "Successfully started chopping tree!");
					currentTree = targetTree;
				}
				else
					script.log(this, false, "Tree has been stolen");
			}
		}
		else
			script.log(this, false, "Waiting for trees to spawn...");
	}
	
	private Position getFallBackPos(RS2Object tree)
	{
		return tree.getArea(FALLBACK_AREA_RAD).getRandomPosition();
	}

}
