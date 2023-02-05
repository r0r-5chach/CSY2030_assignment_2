package com.r0r5chach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.r0r5chach.competitor.Name;
import com.r0r5chach.competitor.Rank;
import com.r0r5chach.competitor.valorant.ValorantAgent;
import com.r0r5chach.competitor.valorant.ValorantPlayer;
public class ValorantPlayerTest {
    @Test
    public void valorantPlayerTest() {
        int[] scores = {5,5,5,5,5,5};
        ValorantPlayer vP = new ValorantPlayer(2,new Name("Joshua Luke Perry"), Rank.GOLD, ValorantAgent.FADE, scores);
        assertEquals(2, vP.getPlayerNumber());
        assertEquals("Joshua Luke Perry", vP.getPlayerName().getFullName());
        assertEquals("Gold", vP.getPlayerLevel().getRank());
        assertEquals("Fade", vP.getFavoriteAgent().getAgent());
        assertEquals(5, vP.getOverallScore());
    }

    @Test
    public void valorantPlayerTestSetPlayerNumber() {
        int[] scores = {5,5,5,5,5,5};
        ValorantPlayer vP = new ValorantPlayer(2,new Name("Joshua Luke Perry"), Rank.GOLD, ValorantAgent.FADE, scores);

        vP.setPlayerNumber(5);
        assertEquals(5, vP.getPlayerNumber());
    }

    @Test
    public void valorantPlayerTestSetPlayerName() {
        int[] scores = {5,5,5,5,5,5};
        ValorantPlayer vP = new ValorantPlayer(2,new Name("Joshua Luke Perry"), Rank.GOLD, ValorantAgent.FADE, scores);

        vP.setPlayerName(new Name("Bradley Gordon-Taylor"));
        assertEquals("Bradley Gordon-Taylor", vP.getPlayerName().getFullName());
    }

    @Test
    public void valorantPlayerTestSetPlayerLevel() {
        int[] scores = {5,5,5,5,5,5};
        ValorantPlayer vP = new ValorantPlayer(2,new Name("Joshua Luke Perry"), Rank.GOLD, ValorantAgent.FADE, scores);

        vP.setPlayerLevel(Rank.BRONZE);
        assertEquals("Bronze", vP.getPlayerLevel().getRank());
    }

    @Test
    public void valorantPlayerTestSetFavoriteAgent() {
        int[] scores = {5,5,5,5,5,5};
        ValorantPlayer vP = new ValorantPlayer(2,new Name("Joshua Luke Perry"), Rank.GOLD, ValorantAgent.FADE, scores);

        vP.setFavoriteAgent(ValorantAgent.VIPER);
        assertEquals("Viper", vP.getFavoriteAgent().getAgent());
    }

    @Test
    public void valorantPlayerTestSetScores() {
        int[] scores = {5,5,5,5,5,5};
        ValorantPlayer vP = new ValorantPlayer(2,new Name("Joshua Luke Perry"), Rank.GOLD, ValorantAgent.FADE, scores);

        vP.setScores(new int[]{0, 0, 0, 0, 0, 0});
        assertEquals(0, vP.getOverallScore());
    }

    @Test
    public void valorantPlayerTestGetOverallScore() {
        int[] scores = {5,5,5,5,5,5};
        ValorantPlayer vP = new ValorantPlayer(2,new Name("Joshua Luke Perry"), Rank.GOLD, ValorantAgent.FADE, scores);
        assertEquals(5, vP.getOverallScore());
    }

    @Test
    public void valorantPlayerTestGetFullDetails() {
        int[] scores = {5,5,5,5,5,5};
        ValorantPlayer vP = new ValorantPlayer(2,new Name("Joshua Luke Perry"), Rank.GOLD, ValorantAgent.FADE, scores);

        assertEquals("""
                Player Number: 2
                Name: Joshua Luke Perry
                Player Level: Gold
                Scores: 5, 5, 5, 5, 5, 5
                Overall Score: 5.0
                Favorite Agent: Fade""", vP.getFullDetails());
    }

    @Test
    public void valorantPlayerTestGetShortDetails() {
        int[] scores = {5,5,5,5,5,5};
        ValorantPlayer vP = new ValorantPlayer(2,new Name("Joshua Luke Perry"), Rank.GOLD, ValorantAgent.FADE, scores);

        assertEquals("CN 2 (JLP) has overall score 5.0", vP.getShortDetails());
    }


    @Test
    public void valorantPlayerTestGetPlayerNumber() {
        //Already tested in valorantPlayerTest()
    }

    @Test
    public void valorantPlayerTestGetPlayerName() {
        //Already tested in valorantPlayerTest()
    }

    @Test
    public void valorantPlayerTestGetPlayerLevel() {
        //Already tested in valorantPlayerTest()
    }

    @Test
    public void valorantPlayerTestGetFavoriteAgent() {
        //Already tested in valorantPlayerTest()
    }
}
