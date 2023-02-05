package com.r0r5chach;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.r0r5chach.competitor.r6.R6Defender;

public class R6DefenderTest {
    
    @Test
    public void r6AttackerGetAttackerTest() {
        R6Defender d = R6Defender.CASTLE;
        assertEquals("Castle", d.getDefender());
    }
}
