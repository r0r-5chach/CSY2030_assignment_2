package org.r0r5chach;

import java.util.Locale;

/**
 * All levels a ValorantPlayer can be
 * @author r0r5chach
 */
public enum ValorantRank {
    /**
     * First Level
     */
    IRON,
    /**
     * Second Level
     */
    BRONZE,
    /**
     * Third Level
     */
    SILVER,
    /**
     * Four Level
     */
    GOLD;
    /**
     * Get the name of a level
     * @return a formatted string containing the level name
     */
    public String getRank() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase(Locale.ROOT); //Capitalises the first letter and makes sure the other letters are lowercase
    }
}
