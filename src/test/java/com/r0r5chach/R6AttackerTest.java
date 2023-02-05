package com.r0r5chach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.r0r5chach.competitor.r6.R6Attacker;


public class R6AttackerTest {
    @Test
    public void r6AttackerGetAttackerTest() {
        R6Attacker a = R6Attacker.GLAZ;
        assertEquals("Glaz", a.getAttacker());
    }
}
