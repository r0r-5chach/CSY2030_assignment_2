package com.r0r5chach.valorant;

import java.util.Locale;

/**
 * All Characters a ValorantPlayer can play
 * @author r0r5chach
 */
public enum ValorantAgent {
    BRIMSTONE,
    VIPER,
    OMEN,
    KILLJOY,
    CYPHER,
    SOVA,
    SAGE,
    PHOENIX,
    JETT,
    REYNA,
    RAZE,
    BREACH,
    SKYE,
    YORU,
    ASTRA,
    KAYO,
    CHAMBER,
    NEON,
    FADE,
    HARBOR;
    /**
     * Get the name of the character
     * @return a formatted string containing the character name
     */
    public String getAgent() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase(Locale.ROOT); //Capitalizes the first letter and makes sure the other letters are lowercase
    }
}
