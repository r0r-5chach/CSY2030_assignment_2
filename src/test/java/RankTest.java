import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.r0r5chach.Rank;


public class RankTest {
    @Test
    public void valorantRankTestGetRank() {
        Rank vR = Rank.BRONZE;
        assertEquals("Bronze", vR.getRank());
    }
}
