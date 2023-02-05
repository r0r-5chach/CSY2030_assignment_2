package com.r0r5chach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.r0r5chach.competitor.Name;
import com.r0r5chach.competitor.Rank;
import com.r0r5chach.competitor.r6.R6Attacker;
import com.r0r5chach.competitor.r6.R6Defender;
import com.r0r5chach.competitor.r6.R6Player;
/**
 * Class that defines the test for com.r0r5chach.competitor.r6.R6Player
 * @author r0r5chach
 */
public class R6PlayerTest {
    /**
     * Tests R6Player.getFullDetails()
     */
    @Test
    public void r6PlayerGetFullDetailsTest() {
        R6Player r6P = new R6Player(1, new Name("Joshua Perry"), Rank.BRONZE, R6Attacker.ACE, R6Defender.ALIBI, new int[]{5,5,5,5,5,5});
        assertEquals(R6Attacker.ACE, r6P.getFavoriteAttacker());
        assertEquals(R6Defender.ALIBI, r6P.getFavoriteDefender());
        r6P.setFavoriteAttacker(R6Attacker.AMARU);
        r6P.setFavoriteDefender(R6Defender.ARUNI);
        assertEquals("""
            Player Number: 1
            Name: Joshua Perry
            Player Level: Bronze
            Scores: 5, 5, 5, 5, 5, 5
            Overall Score: 5.0
            Favorite Attacker: Amaru
            Favorite Defender: Aruni""", r6P.getFullDetails());
    }
    /**
     * Tests R6Player.setFavoriteAttacker(R6Attacker)
     */
    @Test
    public void r6PlayerSetFavoriteAttacker() {
        //Already tested in r6PlayerGetFullDetailsTest()        
    }
    /**
     * Tests R6Player.setFavoriteDefender(R6Defender)
     */
    @Test
    public void r6PlayerSetFavoriteDefender() {
        //Already tested in r6PlayerGetFullDetailsTest()        
    }
    /**
     * Tests R6Player.getFavoriteAttacker()
     */
    @Test
    public void r6PlayerGetFavoriteAttacker() {
        //Already tested in r6PlayerGetFullDetailsTest()
    }
    /**
     * Tests R6Player.getFavoriteAttacker()
     */
    @Test
    public void r6PlayerGetFavoriteDefender() {
        //Already tested in r6PlayerGetFullDetailsTest()        
    }
    /**
     * Tests R6Player.R6Player(int, Name, Rank, R6Attacker, R6Defender, int[])
     */
    @Test
    public void r6PlayerTest() {
        //Already tested in r6PlayerGetFullDetailsTest()        
    }
}