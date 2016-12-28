package org.mission;

import org.mission.tasks.DepositItems;
import viking.framework.goal.GoalList;
import viking.framework.goal.impl.InfiniteGoal;
import viking.framework.mission.Mission;
import viking.framework.script.VikingScript;
import viking.framework.task.TaskManager;

public class OrionWoodcutter extends Mission {

    private final TaskManager<OrionWoodcutter> TASK_MANAGER = new TaskManager<>(this);

    public OrionWoodcutter(VikingScript script) {
        super(script);
    }

    @Override
    public boolean canEnd() {
        return false;
    }

    @Override
    public String getMissionName() {
        return null;
    }

    @Override
    public String getCurrentTaskName() {
        return null;
    }

    @Override
    public String getEndMessage() {
        return null;
    }

    @Override
    public GoalList getGoals() {
        return new GoalList(new InfiniteGoal());
    }

    @Override
    public String[] getMissionPaint() {
        return null;
    }

    @Override
    public int execute() {
        TASK_MANAGER.loop(150, 200);
        return 0;
    }

    @Override
    public void onMissionStart() {
        TASK_MANAGER.addTask(new DepositItems(this));
    }

    @Override
    public void resetPaint() {
    }

}
