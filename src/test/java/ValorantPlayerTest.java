import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.r0r5chach.Name;
import org.r0r5chach.ValorantAgent;
import org.r0r5chach.ValorantPlayer;
import org.r0r5chach.ValorantRank;
public class ValorantPlayerTest {
    @Test
    public void valorantPlayerTest() {
        int[] scores = {5,5,5,5,5,5};
        ValorantPlayer vP = new ValorantPlayer(2,new Name("Joshua Luke Perry"), ValorantRank.GOLD, ValorantAgent.FADE, scores);
        assertEquals(2, vP.getPlayerNumber());
        assertEquals("Joshua Luke Perry", vP.getPlayerName().getFullName());
        assertEquals("Gold", vP.getPlayerLevel().getRank());
        assertEquals("Fade", vP.getFavouriteAgent().getAgent());
        assertEquals(5, vP.getOverallScore());
    }

    @Test
    public void valorantPlayerTestSetPlayerNumber() {
        int[] scores = {5,5,5,5,5,5};
        ValorantPlayer vP = new ValorantPlayer(2,new Name("Joshua Luke Perry"), ValorantRank.GOLD, ValorantAgent.FADE, scores);

        vP.setPlayerNumber(5);
        assertEquals(5, vP.getPlayerNumber());
    }

    @Test
    public void valorantPlayerTestSetPlayerName() {
        int[] scores = {5,5,5,5,5,5};
        ValorantPlayer vP = new ValorantPlayer(2,new Name("Joshua Luke Perry"), ValorantRank.GOLD, ValorantAgent.FADE, scores);

        vP.setPlayerName(new Name("Bradley Gordon-Taylor"));
        assertEquals("Bradley Gordon-Taylor", vP.getPlayerName().getFullName());
    }

    @Test
    public void valorantPlayerTestSetPlayerLevel() {
        int[] scores = {5,5,5,5,5,5};
        ValorantPlayer vP = new ValorantPlayer(2,new Name("Joshua Luke Perry"), ValorantRank.GOLD, ValorantAgent.FADE, scores);

        vP.setPlayerLevel(ValorantRank.BRONZE);
        assertEquals("Bronze", vP.getPlayerLevel().getRank());
    }

    @Test
    public void valorantPlayerTestSetFavouriteAgent() {
        int[] scores = {5,5,5,5,5,5};
        ValorantPlayer vP = new ValorantPlayer(2,new Name("Joshua Luke Perry"), ValorantRank.GOLD, ValorantAgent.FADE, scores);

        vP.setFavouriteAgent(ValorantAgent.VIPER);
        assertEquals("Viper", vP.getFavouriteAgent().getAgent());
    }

    @Test
    public void valorantPlayerTestSetScores() {
        int[] scores = {5,5,5,5,5,5};
        ValorantPlayer vP = new ValorantPlayer(2,new Name("Joshua Luke Perry"), ValorantRank.GOLD, ValorantAgent.FADE, scores);

        vP.setScores(new int[]{0, 0, 0, 0, 0, 0});
        assertEquals(0, vP.getOverallScore());
    }

    @Test
    public void valorantPlayerTestGetOverallScore() {
        int[] scores = {5,5,5,5,5,5};
        ValorantPlayer vP = new ValorantPlayer(2,new Name("Joshua Luke Perry"), ValorantRank.GOLD, ValorantAgent.FADE, scores);
        assertEquals(5, vP.getOverallScore());
    }

    @Test
    public void valorantPlayerTestGetFullDetails() {
        int[] scores = {5,5,5,5,5,5};
        ValorantPlayer vP = new ValorantPlayer(2,new Name("Joshua Luke Perry"), ValorantRank.GOLD, ValorantAgent.FADE, scores);

        assertEquals("""
                Player Number: 2
                Name: Joshua Luke Perry
                Player Level: Gold
                Favourite Agent: Fade
                Scores: 5, 5, 5, 5, 5, 5
                Overall Score: 5.0""", vP.getFullDetails());
    }

    @Test
    public void valorantPlayerTestGetShortDetails() {
        int[] scores = {5,5,5,5,5,5};
        ValorantPlayer vP = new ValorantPlayer(2,new Name("Joshua Luke Perry"), ValorantRank.GOLD, ValorantAgent.FADE, scores);

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
    public void valorantPlayerTestGetFavouriteAgent() {
        //Already tested in valorantPlayerTest()
    }
}
