package org.r0r5chach;
import java.io.File;

import static org.r0r5chach.CompetitorList.createErrorLog;

public class Manager {

    private CompetitorList competitors;


    public Manager() {
        init();
    }

    public CompetitorList getCompetitors() {
        return competitors;
    }


    public File getReport() {
        File report;
        try {
            report = competitors.createReportFile();
        }
        catch (Exception e) {
                report = new File(createErrorLog(e, "src/main/resource/log.txt"));
        }
        return report;
    }

    private void init() {
        File sourceFile = new File("src/main/resources/test.txt");
        try {
            competitors = new CompetitorList(sourceFile);
        }
        catch (Exception e) {
            createErrorLog(e, "src/main/resources/log.txt");
        }
    }
}
