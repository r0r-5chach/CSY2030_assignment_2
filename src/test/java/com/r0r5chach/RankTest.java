package com.r0r5chach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.r0r5chach.competitor.Rank;
/**
 * Class that defines the test for com.r0r5chach.competitor.Rank
 * @author r0r5chach
 */
public class RankTest {
    /**
     * Tests Rank.getRank()
     */
    @Test
    public void valorantRankGetRankTest() {
        Rank vR = Rank.BRONZE;
        assertEquals("Bronze", vR.getRank());
    }
}