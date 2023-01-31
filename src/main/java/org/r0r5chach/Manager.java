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
        File valorantPlayers = new File("src/main/resources/valorantPlayers.txt");
        File r6Players = new File("src/main/resources/r6Players.txt");
        try {
            competitors = new CompetitorList();
            competitors.readCompetitors(valorantPlayers);
            competitors.readCompetitors(r6Players);
        }
        catch (Exception e) {
            createErrorLog(e, "src/main/resources/log.txt");
        }
    }
}
