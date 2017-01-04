package org.mission.data.vars;

import org.mission.data.enums.ChoppingLocation;
import viking.api.skills.woodcutting.enums.TreeType;

/**
 * Created by Sphiinx on 12/28/2016.
 */
public class Vars {

    public static Vars vars;

    public static Vars get() {
        return vars == null ? vars = new Vars() : vars;
    }

    public static void reset() {
        vars = null;
    }

    public boolean is_upgrading_axe;

    public ChoppingLocation chopping_location;
    public TreeType tree_type;

}

