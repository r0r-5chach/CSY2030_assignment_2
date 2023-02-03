package com.r0r5chach.competitor.r6;

import java.util.Locale;

public enum R6Attacker {
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
    
    public String getAttacker() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase(Locale.ROOT); //Capitalizes the first letter and makes sure the other letters are lowercase
    }
}
