package com.r0r5chach.competitor.r6;

import java.util.Locale;
/**  All Attackers an R6Player can play
* @author r0r5chach
*/
public enum R6Attacker {
    /**
     * For ChoiceBoxes so selection is not null
     */
    NONE,
    GRIM,
    SENS,
    OSA,
    FLORES,
    ZERO,
    ACE,
    IANA,
    KALI,
    AMARU,
    NOKK,
    GRIDLOCK,
    NOMAD,
    MAVERICK,
    LION,
    FINKA,
    DOKKAEBI,
    ZOFIA,
    YING,
    JACKAL,
    HIBANA,
    CAPITAO,
    BLACKBEARD,
    BUCK,
    SLEDGE,
    THATCHER,
    ASH,
    THERMITE,
    MONTAGNE,
    TWITCH,
    BLITZ,
    IQ,
    FUZE,
    GLAZ;
    /**
     * Get the name of the attacker
     * @return the name of the attacker as a formatted string
     */
    public String getAttacker() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase(Locale.ROOT); //Capitalizes the first letter and makes sure the other letters are lowercase
    }
}