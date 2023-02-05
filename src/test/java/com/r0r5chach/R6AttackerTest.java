package com.r0r5chach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.r0r5chach.competitor.r6.R6Attacker;
/**
 * Class that defines the test for com.r0r5chach.competitor.r6.R6Attacker
 * @author r0r5chach
 */
public class R6AttackerTest {
    /**
     * Tests R6Attacker.getAttacker()
     */
    @Test
    public void r6AttackerGetAttackerTest() {
        R6Attacker a = R6Attacker.GLAZ;
        assertEquals("Glaz", a.getAttacker());
    }
}