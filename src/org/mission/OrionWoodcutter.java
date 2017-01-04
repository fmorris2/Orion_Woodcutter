package org.mission;

import org.mission.tasks.ChopTree;
import org.mission.tasks.DepositItems;
import org.mission.tasks.WalkToTreeLocation;
import org.mission.tasks.axe.EquipAxe;
import org.mission.tasks.axe.GetAxe;
import org.mission.tasks.axe.UpgradeAxe;
import viking.api.skills.woodcutting.enums.LogType;
import viking.framework.command.CommandReceiver;
import viking.framework.command.CommandSender;
import viking.framework.goal.GoalList;
import viking.framework.goal.impl.InfiniteGoal;
import viking.framework.mission.Mission;
import viking.framework.script.VikingScript;
import viking.framework.task.TaskManager;

public class OrionWoodcutter extends Mission implements CommandSender {

    private final TaskManager<OrionWoodcutter> TASK_MANAGER = new TaskManager<>(this);

    private CommandReceiver orion_main;

    public OrionWoodcutter(VikingScript script, LogType target_type) {
        super(script);
        orion_main = script instanceof CommandReceiver ? (CommandReceiver)script : null;
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
        return 150;
    }

    @Override
    public void onMissionStart() {
        TASK_MANAGER.addTask(new DepositItems(this), new GetAxe(this), new UpgradeAxe(this), new EquipAxe(this), new WalkToTreeLocation(this), new ChopTree(this));
    }

    @Override
    public void resetPaint() {
    }

    @Override
    public void sendCommand(String command) {
    }

}
