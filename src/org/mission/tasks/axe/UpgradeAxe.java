package org.mission.tasks.axe;

import org.mission.OrionWoodcutter;
import org.mission.data.OW_Vars;

import viking.api.Timing;
import viking.api.skills.woodcutting.enums.AxeType;

/**
 * Created by Sphiinx on 12/28/2016.
 */
public class UpgradeAxe extends GetAxe {

    private AxeType appropriate_axe;
    private AxeType current_axe;

    public UpgradeAxe(OrionWoodcutter mission) {
        super(mission);
    }

    @Override
    public boolean validate() {
        if (!client.isLoggedIn() || OW_Vars.get().is_upgrading_axe)
            return false;
        
        appropriate_axe = woodcutting.currentAppropriateAxe();
        current_axe = woodcutting.getBestUsableAxe(false);
        
        if(current_axe == null || current_axe == appropriate_axe)
        	return false;
        
        if(hasUpgradeInCache(appropriate_axe, current_axe))
        {
        	script.log(this, false, "Has upgrade in bank, according to bank cache");
        	return true;
        }
        
        if (!bank.isOpen())
            return false;

        return bank.getItem(appropriate_axe.getItemID()) != null;

    }
    
    private boolean hasUpgradeInCache(AxeType appropriate, AxeType current)
    {
    	AxeType[] axes = AxeType.values();
    	for(int i = axes.length - 1; i >= 0; i--)
    		if(axes[i].ordinal() <= appropriate.ordinal() && axes[i].ordinal() > current.ordinal()
    				&& script.BANK_CACHE.get().containsKey(axes[i].getItemID()))
    			return true;
    		
    	return false;
    }

    @Override
    public void execute() {
        OW_Vars.get().is_upgrading_axe = true;

        super.execute();

        if (equipment.getItems().length > 0)
            if (bank.depositWornItems())
                Timing.waitCondition(() -> equipment.getItems().length <= 0, 150, random(2000, 2500));
    }

    @Override
    public String toString() {
        return "Upgrading axe";
    }

}

