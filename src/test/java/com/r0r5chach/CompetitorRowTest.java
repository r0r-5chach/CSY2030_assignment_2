package com.r0r5chach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.r0r5chach.competitor.Name;
import com.r0r5chach.competitor.Rank;
import com.r0r5chach.competitor.valorant.ValorantAgent;
import com.r0r5chach.competitor.r6.R6Attacker;
import com.r0r5chach.competitor.r6.R6Defender;
/**
 * Class that defines the test for com.r0r5chach.CompetitorRow
 * @author r0r5chach
 */
public class CompetitorRowTest {
    /**
     * Tests CompetitorRow.CompetitorRow(int, Name, Rank, int[])
     */
    @Test
    public void competitorRowCompetitorTest() {
        CompetitorRow cR = new CompetitorRow(101, new Name("Joshua Perry"), Rank.GOLD, new int[]{5,5,5,5,5,5});
        assertEquals(101, cR.getPlayerNumber());
        assertEquals("Joshua Perry", cR.getPlayerName());
        assertEquals(Rank.GOLD, cR.getPlayerLevel());
        assertEquals("5, 5, 5, 5, 5, 5", cR.getScores());
    }
    /**
     * Tests CompetitorRow.CompetitorRow(int, Name, Rank, int[], ValorantAgent)
     */
    @Test
    public void competitorRowValorantPlayerTest() {
        CompetitorRow cR = new CompetitorRow(101, new Name("Joshua Perry"), Rank.GOLD, new int[]{5,5,5,5,5,5}, ValorantAgent.ASTRA);
        assertEquals(ValorantAgent.ASTRA.getAgent(), cR.getFavoriteAgent());
    }
    /**
     * Tests CompetitorRow.CompetitorRow(int, Name, Rank, int[], R6Attacker, R6Defender)
     */
    @Test
    public void competitorRowR6PlayerTest() {
        CompetitorRow cR = new CompetitorRow(101, new Name("Joshua Perry"), Rank.GOLD, new int[]{5,5,5,5,5,5}, R6Attacker.GLAZ, R6Defender.CASTLE);
        assertEquals(R6Attacker.GLAZ.getAttacker(), cR.getFavoriteAttacker());
        assertEquals(R6Defender.CASTLE.getDefender(), cR.getFavoriteDefender());
    }
    /**
     * Tests CompetitorRow.getPlayerNumber()
     */
    @Test
    public void competitorRowGetPlayerNumberTest() {
        //Already tested in competitorRowCompetitorTest()
    }
    /**
     * Tests CompetitorRow.getPlayerName()
     */
    @Test
    public void competitorRowGetPlayerNameTest() {
        //Already tested in competitorRowCompetitorTest()
    }
    /**
     * Tests CompetitorRow.getPlayerLevel()
     */
    @Test
    public void competitorRowGetPlayerLevelTest() {
        //Already tested in competitorRowCompetitorTest()
    }
    /**
     * Tests CompetitorRow.getScores()
     */
    @Test
    public void competitorRowGetScoresTest() {
        //Already tested in competitorRowCompetitorTest()
    }
    /**
     * Tests CompetitorRow.getFavoriteAgent()
     */
    @Test
    public void competitorRowGetFavoriteAgentTest() {
        //Already tested in competitorRowValorantPlayerTest()
    }
    /**
     * Tests CompetitorRow.getFavoriteAttacker()
     */
    @Test
    public void competitorRowGetFavoriteAttackerTest() {
        //Already tested in competitorRowR6PlayerTest()
    }
    /**
     * Tests CompetitorRow.getFavoriteDefender()
     */
    @Test
    public void competitorRowGetFavoriteDefenderTest() {
        //Already tested in competitorRowR6PlayerTest()
    }    
}