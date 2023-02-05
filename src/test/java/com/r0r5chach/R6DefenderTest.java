package com.r0r5chach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.r0r5chach.competitor.r6.R6Defender;
/**
 * Class that defines the test for com.r0r5chach.competitor.r6.R6Defender
 * @author r0r5chach
 */
public class R6DefenderTest {
    /**
     * Tests R6Defender.getDefender()
     */
    @Test
    public void r6AttackerGetDefenderTest() {
        R6Defender d = R6Defender.CASTLE;
        assertEquals("Castle", d.getDefender());
    }
}