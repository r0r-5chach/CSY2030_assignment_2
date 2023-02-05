package com.r0r5chach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CompetitorListTest {
    private String testPath = "src/test/resources";
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

    @Test
    public void CompetitorListCreateErrorLogTest() {
        String output = CompetitorList.createErrorLog(new IOException(), testPath+"/log.txt");
        assertEquals("java.io.IOException", output);
    }

    @Test
    public void competitorListReadCompetitorsTest() {
        //Already tested in competitorListCreateReportFileTest()
    }

    @Test
    public void competitorListGetCompetitorsTest() {
        //Already tested in competitorListCreateReportFileTest()
    }

    @Test
    public void competitorListTest() {
        //Already tested in competitorListCreateReportFileTest()
    }
}