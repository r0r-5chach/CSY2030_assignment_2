package com.r0r5chach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.r0r5chach.competitor.Rank;


public class RankTest {
    @Test
    public void valorantRankTestGetRank() {
        Rank vR = Rank.BRONZE;
        assertEquals("Bronze", vR.getRank());
    }
}
