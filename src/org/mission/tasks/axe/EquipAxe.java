package org.mission.tasks.axe;

import org.mission.OrionWoodcutter;
import org.osbot.rs07.api.model.Item;
import org.osbot.rs07.api.ui.Skill;
import viking.api.Timing;
import viking.api.skills.woodcutting.enums.AxeType;
import viking.framework.task.Task;

/**
 * Created by Sphiinx on 12/28/2016.
 */
public class EquipAxe extends Task<OrionWoodcutter> {

    private AxeType best_usable_axe;

    public EquipAxe(OrionWoodcutter mission) {
        super(mission);
    }

    @Override
    public boolean validate() {
        best_usable_axe = woodcutting.getBestUsableAxe(false);
        return best_usable_axe != null && !equipment.isWieldingWeapon(best_usable_axe.getItemID()) && skills.getStatic(Skill.ATTACK) >= best_usable_axe.getAttackLevel();
    }

    @Override
    public void execute() {
        if (bank.isOpen())
            if (bank.close())
                Timing.waitCondition(() -> !bank.isOpen(), 150, random(2000, 2500));

        final Item item_to_equip = inventory.getItem(AxeType.getItemIDs());
        if (item_to_equip == null)
            return;

        if (item_to_equip.interact("Wield"))
            Timing.waitCondition(() -> equipment.isWieldingWeapon(best_usable_axe.getItemID()), 150, random(2000, 2500));
    }

    @Override
    public String toString() {
        return "Equipping axe";
    }

}

