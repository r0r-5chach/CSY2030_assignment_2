package com.r0r5chach.competitor.r6;

import java.util.Locale;
/** All Defenders an R6Player can play
* @author r0r5chach
*/
public enum R6Defender {
    /**
     * For ChoiceBoxes so selection is not null
     */
    NONE,
    SOLIS,
    AZAMI,
    THORN,
    THUNDERBIRD,
    ARUNI,
    MELUSI,
    ORYX,
    WAMAI,
    GOYO,
    WARDEN,
    MOZZIE,
    KAID,
    CLASH,
    MAESTRO,
    ALIBI,
    VIGIL,
    ELA,
    LESION,
    MIRA,
    ECHO,
    CAVEIRA,
    VALKYRIE,
    FROST,
    MUTE,
    SMOKE,
    CASTLE,
    PULSE,
    DOC,
    ROOK,
    JAGER,
    BANDIT,
    TACHANKA,
    KAPKAN;
    /**
     * Get the name of the defender
     * @return the name of the defender as a formatted string
     */
    public String getDefender() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase(Locale.ROOT); //Capitalizes the first letter and makes sure the other letters are lowercase
    }
}