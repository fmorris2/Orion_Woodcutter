package org.mission.tasks;

import org.mission.OrionWoodcutter;
import org.mission.data.vars.Vars;
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
        if (Vars.get().is_upgrading_axe)
            return false;

        final RS2Object TREE = objects.closest(Vars.get().location.getArea(), Vars.get().tree_type.getTreeName());
        return TREE == null && !inventory.isFull() && woodcutting.getBestUsableAxe(false) != null;
    }

    @Override
    public void execute() {
        if (walkUtils.walkToArea(Vars.get().location.getArea()))
            Timing.waitCondition(() -> Vars.get().location.getArea().contains(myPlayer()), 150, random(2000, 2500));
    }

    @Override
    public String toString() {
        return "Walking to tree location";
    }
}

