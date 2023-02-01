package com.r0r5chach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.r0r5chach.competitor.valorant.ValorantAgent;

public class ValorantAgentTest {
    @Test
    public void valorantAgentTestGetAgent() {
        ValorantAgent vA = ValorantAgent.HARBOR;
        assertEquals("Harbor", vA.getAgent());
    }
}
