import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.r0r5chach.CompetitorList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CompetitorListTest {

    @Test
    public void competitorListTest() {
        try {
            CompetitorList cL = new CompetitorList(new File("src/main/resources/test.txt"));
            assertEquals(Files.readString(Path.of("src/main/resources/report.template")), cL.getReportContents());
            assertEquals(102,cL.getCompetitors().get(1).getPlayerNumber());
        }
        catch (IOException e) {
            System.out.println("File doesn't exist");
        }

    }

    @Test
    public void competitorListTestCreateReportFile() {
        try {
            CompetitorList cL = new CompetitorList(new File("src/main/resources/test.txt"));
            assertEquals(Files.readString(Path.of("src/test/java/reportTest.txt")), Files.readString(cL.createReportFile().toPath()));
        }
        catch (IOException e) {
            System.out.println("File doesn't exist");
        }
    }

    @Test
    public void competitorListTestCreateErrorLog() {
        assertEquals("java.io.IOException", CompetitorList.createErrorLog(new IOException(), "src/main/resources/log.txt"));
        assertEquals("Error", CompetitorList.createErrorLog(new IOException(), "src/main/java"));

    }

    @Test
    public void competitorListTestGenerateTable() {
        //Already tested in competitorListTestCreateReportFile
    }

    @Test
    public void competitorListTestGetHighScore() {
        //Already tested in competitorListTestCreateReportFile
    }

    @Test
    public void competitorListTestGenerateAverageScore() {
        //Already tested in competitorListTestCreateReportFile
    }

    @Test
    public void competitorListTestGenerateLevelFreqs() {
        //Already tested in competitorListTestCreateReportFile
    }

    @Test
    public void competitorListTestGenerateScoreFreqs() {
        //Already tested in competitorListTestCreateReportFile
    }

    @Test
    public void competitorListTestReplaceVar() {
        //Already tested in competitorListTestCreateReportFile
    }

    @Test
    public void competitorListTestReportTemplate() {
        //Already tested in competitorListTestCreateReportFile
    }

    @Test
    public void competitorListTestGenerateReportContents() {
        //Already tested in competitorListTestCreateReportFile
    }

    @Test
    public void competitorListTestParseScores() {
        //Already tested in competitorListTest
    }

    @Test
    public void competitorListTestParseRow() {
        //Already tested in competitorListTest
    }

    @Test
    public void competitorListTestReadCompetitors() {
        //Already tested in competitorListTest
    }

    @Test
    public void competitorListTestGetReportContents() {
        //Already tested in competitorListTest
    }

    @Test
    public void competitorListTestGetCompetitors() {
        //Already tested in competitorListTest
    }
}
