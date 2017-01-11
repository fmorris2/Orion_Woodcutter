package org.mission;

import org.mission.data.OW_Vars;
import org.mission.data.enums.ChoppingLocation;
import org.mission.tasks.ChopTree;
import org.mission.tasks.OW_DepositItems;
import org.mission.tasks.WalkToTreeLocation;
import org.mission.tasks.axe.EquipAxe;
import org.mission.tasks.axe.GetAxe;
import org.mission.tasks.axe.GetBronzeAxe;
import org.mission.tasks.axe.UpgradeAxe;
import org.osbot.rs07.api.ui.Message;

import viking.api.skills.woodcutting.enums.TreeType;
import viking.framework.command.CommandReceiver;
import viking.framework.goal.GoalList;
import viking.framework.goal.impl.InfiniteGoal;
import viking.framework.mission.Mission;
import viking.framework.script.VikingScript;
import viking.framework.task.TaskManager;


public class OrionWoodcutter extends Mission implements CommandReceiver{

    private final TaskManager<OrionWoodcutter> TASK_MANAGER = new TaskManager<>(this);

    private CommandReceiver orion_main;
    private TreeType target;

    public OrionWoodcutter(VikingScript script, TreeType target_type) {
        super(script);
        orion_main = script instanceof CommandReceiver ? (CommandReceiver) script : null;
        target = target_type;
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
        return TASK_MANAGER.getStatus();
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
        TASK_MANAGER.loop();
        return 150;
    }

    @SuppressWarnings("unchecked")
	@Override
    public void onMissionStart() {
        updateTargetTree();
        updateChoppingLoc();
        TASK_MANAGER.addTask(new OW_DepositItems(this), new GetAxe(this), new UpgradeAxe(this), 
        		new EquipAxe(this), new WalkToTreeLocation(this), new ChopTree(this),
        		new GetBronzeAxe(this));
    }

    @Override
    public void resetPaint() {
    }

    private boolean updateTargetTree() {
    	script.log(this, false, "Updating target tree");
        TreeType old = OW_Vars.get().tree_type;
        OW_Vars.get().tree_type = woodcutting.getBestChoppableTreeType(false);
        if (OW_Vars.get().tree_type.ordinal() > target.ordinal())
            OW_Vars.get().tree_type = target;

        return old != OW_Vars.get().tree_type;
    }

    public void updateChoppingLoc() {
        script.log(this, false, "Updating chopping loc....");
        orion_main.receiveCommand("getLoc:wc:free:" + OW_Vars.get().tree_type);
    }

    @Override
    public void receiveCommand(String command) {
    	script.log(this, false, "Received command: " + command);
        String[] parts = command.split(":");
        if (parts[0].equals("bestLoc")) {
            ChoppingLocation bestLoc = ChoppingLocation.valueOf(parts[1]);
            OW_Vars.get().chopping_location = bestLoc;
            script.log(this, false, "New best location: " + bestLoc);
        }
    }

    @Override
    public void onMessage(Message m) {
        if (m.getMessage().contains("advanced a Woodcutting level") && updateTargetTree())
            updateChoppingLoc();
    }
}
