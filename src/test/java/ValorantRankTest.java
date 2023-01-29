import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.r0r5chach.ValorantRank;


public class ValorantRankTest {
    @Test
    public void valorantRankTestGetRank() {
        ValorantRank vR = ValorantRank.IRON;
        assertEquals("Iron", vR.getRank());
    }
}
