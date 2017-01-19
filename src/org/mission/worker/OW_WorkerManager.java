package org.mission.worker;

import java.util.Map;

import org.mission.OrionWoodcutter;
import org.mission.data.enums.ChoppingLocation;
import org.mission.worker.impl.OW_Chop;
import org.mission.worker.impl.OW_GetBronzeAxe;
import org.mission.worker.impl.OW_GoToLocation;
import org.mission.worker.impl.OW_WieldAxe;
import org.mission.worker.impl.bank.OW_Deposit;
import org.mission.worker.impl.bank.OW_GetAxeUpgrade;
import org.mission.worker.impl.bank.OW_GoToBank;

import viking.framework.worker.Worker;
import viking.framework.worker.WorkerManager;

public class OW_WorkerManager extends WorkerManager<OrionWoodcutter>
{
	public final OWWorker DEPOSIT_ITEMS, GO_TO_NORMAL_BANK, GO_TO_ANY_BANK, CHOP, GET_BRONZE_AXE,
			GO_TO_LOCATION;
	
	public final OW_GetAxeUpgrade GET_AXE_UPGRADE;
	public final OW_WieldAxe WIELD_AXE;
	
	public OW_WorkerManager(OrionWoodcutter mission)
	{
		super(mission);
		DEPOSIT_ITEMS = new OW_Deposit(mission);
		GO_TO_ANY_BANK = new OW_GoToBank(mission, true);
		GO_TO_NORMAL_BANK = new OW_GoToBank(mission, false);
		GET_AXE_UPGRADE = new OW_GetAxeUpgrade(mission);
		CHOP = new OW_Chop(mission);
		GET_BRONZE_AXE = new OW_GetBronzeAxe(mission);
		GO_TO_LOCATION = new OW_GoToLocation(mission);
		WIELD_AXE = new OW_WieldAxe(mission);
	}

	@Override
	public Worker<OrionWoodcutter> decide()
	{
		final Map<Integer, Integer> BANK_CACHE = mission.getScript().BANK_CACHE.get();
		final boolean IN_NORMAL_BANK = mission.bankUtils.isInBank(false);
		final boolean IN_ANY_BANK = mission.bankUtils.isInBank(true);
		
		//set best current axe on character
		mission.currentAxe = mission.woodcutting.getBestUsableAxe(false);
		
		if(mission.currentAxe == null) //we dont have an axe at the moment
		{
			debug("Doesn't have an axe currently");
			return noAxeChecks(BANK_CACHE, IN_NORMAL_BANK);
		}
		
		if(GET_AXE_UPGRADE.hasUpgradeInBank()) //if we have an axe upgrade in the bank
		{
			debug("Has axe upgrade in bank");
			return IN_NORMAL_BANK ? GET_AXE_UPGRADE : GO_TO_NORMAL_BANK;
		}
		
		if(IN_ANY_BANK && hasErroneousItems()) //if we're in a bank and have erroneous items
		{
			debug("Deposit erroneous items...");
			return DEPOSIT_ITEMS;
		}
		
		if(WIELD_AXE.needsToWieldAxe()) //check to wield axe
		{
			debug("Needs to wield axe...");
			return WIELD_AXE;
		}
		
		//loc checks
		return locChecks();
	}
	
	private Worker<OrionWoodcutter> locChecks()
	{
		final ChoppingLocation LOC = mission.currentLoc;
	
		if(!LOC.getArea().contains(myPosition())) //not in loc
		{
			debug("Needs to go to location...");
			return GO_TO_LOCATION;
		}
		
		//in location
		debug("Needs to chop...");
		return CHOP;
	}
	
	private Worker<OrionWoodcutter> noAxeChecks(Map<Integer, Integer> BANK_CACHE, final boolean IN_NORMAL_BANK)
	{
		//check bank cache
		if(BANK_CACHE.isEmpty())
		{
			debug("Going to fill bank cache...");
			return IN_NORMAL_BANK ? DEPOSIT_ITEMS : GO_TO_NORMAL_BANK;
		}
		else if(GET_AXE_UPGRADE.hasUpgradeInBank())
		{
			debug("Has axe in bank.... going to get it");
			return IN_NORMAL_BANK ? GET_AXE_UPGRADE : GO_TO_NORMAL_BANK;
		}
		else //account doesn't have any axes on it
		{
			debug("Has no axes on account... Needs to go get bronze axe");
			return GET_BRONZE_AXE;
		}
	}
	
	private boolean hasErroneousItems()
	{
		return !mission.inventory.onlyContains(mission.currentAxe.getItemID());
	}
	
	private void debug(String s)
	{
		mission.getScript().log(this, false, s);
	}

}
