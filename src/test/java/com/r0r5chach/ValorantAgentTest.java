package com.r0r5chach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.r0r5chach.competitor.valorant.ValorantAgent;
/**
 * Class that defines the test for com.r0r5chach.competitor.valorant.ValorantAgent
 * @author r0r5chach
 */
public class ValorantAgentTest {
    /**
     * Tests ValorantAgent.getAgent()
     */
    @Test
    public void valorantAgentGetAgentTest() {
        ValorantAgent vA = ValorantAgent.HARBOR;
        assertEquals("Harbor", vA.getAgent());
    }
}