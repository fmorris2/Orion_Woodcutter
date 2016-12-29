package org.mission.data.enums;

import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;

/**
 * Created by Sphiinx on 12/28/2016.
 */
public enum Location {

    WEST_VARROCK(new Area(new Position[]{
            new Position(3171, 3424, 0),
            new Position(3172, 3373, 0),
            new Position(3157, 3373, 0),
            new Position(3153, 3397, 0),
            new Position(3160, 3408, 0),
            new Position(3156, 3417, 0)
    }));

    private final Area AREA;

    Location(Area area) {
        this.AREA = area;
    }

    public Area getArea() {
        return AREA;
    }

}
