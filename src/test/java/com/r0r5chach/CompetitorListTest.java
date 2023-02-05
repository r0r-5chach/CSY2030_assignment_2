package com.r0r5chach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 * Class that defines the test for com.r0r5chach.CompetitorList
 * @author r0r5chach
 */
public class CompetitorListTest {
    /**
     * Attribute that stores the path to the test resources directory
     */
    private String testPath = "src/test/resources";
    /**
     * Tests CompetitorList.createReportFile(String)
     */
    @Test
    public void competitorListCreateReportFileTest() {
        char[] output = new char[10];
        try {
            CompetitorList cL = new CompetitorList();
            cL.readCompetitors(new File(testPath+"/valorantPlayers.txt"));
            FileReader r = new FileReader(cL.createReportFile(testPath));
            r.read(output);
        }
        catch (IOException e) {
            System.out.println("File not found");
        }
        assertEquals("Competitor", String.valueOf(output));
    }
    /**
     * Tests CompetitorList.createErrorLog(Exception, String)
     */
    @Test
    public void CompetitorListCreateErrorLogTest() {
        String output = CompetitorList.createErrorLog(new IOException(), testPath+"/log.txt");
        assertEquals("java.io.IOException", output);
    }
    /**
     * Tests CompetitorList.readCompetitors()
     */
    @Test
    public void competitorListReadCompetitorsTest() {
        //Already tested in competitorListCreateReportFileTest()
    }
    /**
     * Tests CompetitorList.getCompetitors()
     */
    @Test
    public void competitorListGetCompetitorsTest() {
        //Already tested in competitorListCreateReportFileTest()
    }
    /**
     * Tests CompetitorList.CompetitorList()
     */
    @Test
    public void competitorListTest() {
        //Already tested in competitorListCreateReportFileTest()
    }
}