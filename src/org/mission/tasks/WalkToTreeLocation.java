package org.mission.tasks;

import org.mission.OrionWoodcutter;
import org.mission.data.OW_Vars;
import org.osbot.rs07.api.model.RS2Object;

import viking.api.Timing;
import viking.framework.task.Task;

/**
 * Created by Sphiinx on 12/28/2016.
 */
public class WalkToTreeLocation extends Task<OrionWoodcutter> {


    public WalkToTreeLocation(OrionWoodcutter mission) {
        super(mission);
    }

    @Override
    public boolean validate() {
        if (OW_Vars.get().is_upgrading_axe)
            return false;

        return !OW_Vars.get().chopping_location.getArea().contains(myPosition()) 
        		 && !inventory.isFull() && woodcutting.getBestUsableAxe(false) != null;
    }

    @Override
    public void execute() {
        if (walkUtils.walkToArea(OW_Vars.get().chopping_location.getArea(), () -> {
            final RS2Object TREE = objects.closest(OW_Vars.get().chopping_location.getArea(), OW_Vars.get().tree_type.getTreeName());
            return TREE != null && TREE.isVisible();
        })) {
            Timing.waitCondition(() -> OW_Vars.get().chopping_location.getArea().contains(myPlayer()), 150, random(2000, 2500));
        }
    }

    @Override
    public String toString() {
        return "Walking to tree location";
    }
}

