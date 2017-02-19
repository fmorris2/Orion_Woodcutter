package org.mission;

import org.mission.data.enums.ChoppingLocation;
import org.mission.worker.OW_WorkerManager;
import org.osbot.rs07.api.ui.Message;
import org.osbot.rs07.api.ui.Skill;

import viking.api.skills.woodcutting.enums.AxeType;
import viking.api.skills.woodcutting.enums.LogType;
import viking.api.skills.woodcutting.enums.TreeType;
import viking.framework.command.CommandReceiver;
import viking.framework.goal.Goal;
import viking.framework.goal.GoalList;
import viking.framework.goal.impl.InfiniteGoal;
import viking.framework.goal.impl.SkillGoal;
import viking.framework.item_management.IMEntry;
import viking.framework.item_management.ItemManagement;
import viking.framework.mission.Mission;
import viking.framework.mule.MuleManagement;
import viking.framework.mule.MuleOrder;
import viking.framework.script.VikingScript;
import viking.framework.task.TaskManager;


public class OrionWoodcutter extends Mission implements CommandReceiver, ItemManagement, MuleManagement {

	public final OW_WorkerManager MANAGER = new OW_WorkerManager(this);
    private final TaskManager<OrionWoodcutter> TASK_MANAGER = new TaskManager<>(this);

    public TreeType currentTree;
    public ChoppingLocation currentLoc;
    public AxeType currentAxe;
    
    private CommandReceiver orion_main;
    private TreeType target;

    public OrionWoodcutter(VikingScript script, TreeType target, Goal... goals) {
        super(script);
        orion_main = script instanceof CommandReceiver ? (CommandReceiver) script : null;
        this.target = target;
        this.goals = new GoalList(goals);
    }

    @Override
    public boolean canEnd() {
        return goals.hasReachedGoals();
    }

    @Override
    public String getMissionName() {
        return "Orion Woodcutter";
    }

    @Override
    public String getCurrentTaskName() {
        return TASK_MANAGER.getStatus();
    }

    @Override
    public String getEndMessage() {
        return "Orion Woodcutter has ended";
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
    	if(currentTree == null)
    	{
    		if(updateTargetTree())
    			updateChoppingLoc();
    	}
    	else	
    		MANAGER.work();
        return 600;
    }

    @Override
    public void onMissionStart() {
        updateTargetTree();
        updateChoppingLoc();
        /*
        TASK_MANAGER.addTask(new OW_DepositItems(this), new GetAxe(this), new UpgradeAxe(this), 
        		new EquipAxe(this), new WalkToTreeLocation(this), new ChopTree(this),
        		new GetBronzeAxe(this));
        		*/
    }

    @Override
    public void resetPaint() {
    }

    private boolean updateTargetTree() {
    	script.log(this, false, "Updating target tree");
        TreeType old = currentTree;
        currentTree = woodcutting.getBestChoppableTreeType(false);
        if (target != null && currentTree != null && currentTree.ordinal() > target.ordinal())
            currentTree = target;

        return currentTree != null && old != currentTree;
    }

    public void updateChoppingLoc() {
    	if(currentTree == null)
    		return;
        script.log(this, false, "Updating chopping loc....");
        currentLoc = ChoppingLocation.W_PORT_SARIM_NORTH_4;
        //orion_main.receiveCommand("getLoc:wc:free:" + currentTree);
    }

    @Override
    public void receiveCommand(String command) {
    	script.log(this, false, "Received command: " + command);
        String[] parts = command.split(":");
        if (parts[0].equals("bestLoc")) {
            ChoppingLocation bestLoc = ChoppingLocation.valueOf(parts[1]);
            currentLoc = bestLoc;
            script.log(this, false, "New best location: " + bestLoc);
        }
    }

    @Override
    public void onMessage(Message m) {
        if (m.getMessage().contains("advanced a Woodcutting level") && updateTargetTree())
            updateChoppingLoc();
    }

	@Override
	public IMEntry[] itemsToBuy()
	{
		return new IMEntry[]
		{
			new IMEntry(this, AxeType.STEEL.getItemID(), 1, 500, "Steel axe", new SkillGoal(skills, Skill.WOODCUTTING, AxeType.STEEL.getWoodcuttingLevel())),
			new IMEntry(this, AxeType.MITHRIL.getItemID(), 1, 1000, "Mithril axe", new SkillGoal(skills, Skill.WOODCUTTING, AxeType.MITHRIL.getWoodcuttingLevel())),
			new IMEntry(this, AxeType.ADAMANT.getItemID(), 1, 3000, "Adamant axe", new SkillGoal(skills, Skill.WOODCUTTING, AxeType.ADAMANT.getWoodcuttingLevel())),
			new IMEntry(this, AxeType.RUNE.getItemID(), 1, 11000, "Rune axe", new SkillGoal(skills, Skill.WOODCUTTING, AxeType.RUNE.getWoodcuttingLevel())),
		};
	}

	@Override
	public int[] itemsToSell()
	{
		return ItemManagement.ORION_SELL_ITEMS;
	}

	@Override
	public MuleOrder getOrder()
	{
		return new MuleOrder(script, LogType.getItemIDs());
	}
}
