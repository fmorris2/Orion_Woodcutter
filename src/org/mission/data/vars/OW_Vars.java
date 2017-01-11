package org.mission.data.vars;

import org.mission.data.enums.ChoppingLocation;
import viking.api.skills.woodcutting.enums.TreeType;

/**
 * Created by Sphiinx on 12/28/2016.
 */
public class OW_Vars {

    public static OW_Vars vars;

    public static OW_Vars get() {
        return vars == null ? vars = new OW_Vars() : vars;
    }

    public static void reset() {
        vars = null;
    }

    public boolean is_upgrading_axe, needsBronzeAxe;

    public ChoppingLocation chopping_location;
    public TreeType tree_type;

}

