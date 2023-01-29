import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.r0r5chach.ValorantAgent;

public class ValorantAgentTest {
    @Test
    public void valorantAgentTestGetAgent() {
        ValorantAgent vA = ValorantAgent.HARBOR;
        assertEquals("Harbor", vA.getAgent());
    }
}
