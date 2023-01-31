package org.r0r5chach;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import org.r0r5chach.r6.R6Attacker;
import org.r0r5chach.r6.R6Defender;
import org.r0r5chach.r6.R6Player;
import org.r0r5chach.valorant.ValorantAgent;
import org.r0r5chach.valorant.ValorantPlayer;


public class CompetitorList {
    private final ArrayList<Competitor> competitors;
    private String reportContents;


    public CompetitorList() throws IOException {
        competitors = new ArrayList<>();
        reportContents = reportTemplate();
    }

    public String getReportContents() {
        return reportContents;
    }

    public ArrayList<Competitor> getCompetitors() {
        return competitors;
    }

    public void readCompetitors(File list) throws FileNotFoundException {
        Scanner reader = new Scanner(list);
        
        while (reader.hasNextLine()) {
            String[] row = reader.nextLine().split("%");
            switch (list.getName()) {
                case "valorantPlayers.txt" -> competitors.add(parseValorantPlayer(row));
                case "r6Players.txt" -> competitors.add(parseR6Player(row));
            }
        }
        reader.close();
    }

    private ValorantPlayer parseValorantPlayer(String[] row) {
        int playerNumber = Integer.parseInt(row[0]);
        Name playerName = new Name(row[1]);
        Rank playerLevel = Rank.valueOf(row[2]);
        ValorantAgent favoriteAgent = ValorantAgent.valueOf(row[3]);
        int[] scores = parseScores(row[4]);
        return new ValorantPlayer(playerNumber, playerName, playerLevel, favoriteAgent, scores);
    }

    private R6Player parseR6Player(String[] row) {
        int playerNumber = Integer.parseInt(row[0]);
        Name playerName = new Name(row[1]);
        Rank playerLevel = Rank.valueOf(row[2]);
        R6Attacker favoriteAttacker = R6Attacker.valueOf(row[3]);
        R6Defender favoriteDefender = R6Defender.valueOf(row[4]);
        int[] scores = parseScores(row[5]);
        return new R6Player(playerNumber, playerName, playerLevel, favoriteAttacker, favoriteDefender, scores);
    }

    private int[] parseScores(String row) {
        String[] scores = row.split(",");
        int[] parsedScores = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            parsedScores[i] = Integer.parseInt(scores[i]);
        }
        return parsedScores;
    }

    private String generateTable() {
        StringBuilder table = new StringBuilder("Competitor               Level        Scores         Overall         Favorite Character(s)");
        for (Competitor player: getCompetitors()) {
            table.append("\n");
            for (String detail: player.getFullDetails().split("\n")) {
                String[] detailParts = detail.split(": ");
                if (detailParts[0].equals("Player Number")) {
                    table.append(detailParts[1]).append(" ");
                }
                else if (detailParts[0].equals("Favorite Agent") || detailParts[0].equals("Favorite Attacker") || detailParts[0].equals("Favorite Defender")) {
                    table.append(detailParts[0] + ": " + detailParts[1]).append(" ");
                }
                else {
                    table.append(detailParts[1]).append("     ");
                }
            }
        }
        return table.toString();
    }

    private int[] generateLevelFreqs() {
        int[] freqs = {0, 0, 0, 0};
        for (Competitor player: getCompetitors()) {
            switch (player.getPlayerLevel()) {
                case BRONZE -> freqs[0] += 1;
                case SILVER -> freqs[1] += 1;
                case GOLD -> freqs[2] += 1;
                case PLATINUM -> freqs[3] += 1;
            }
        }
        return freqs;
    }

    private int[] generateScoreFreqs() {
        int[] freqs = {0, 0, 0, 0, 0, 0};
        for (Competitor player: getCompetitors()) {
            for (int score: player.getScores()) {
                switch (score) {
                    case 0 -> freqs[0] += 1;
                    case 1 -> freqs[1] += 1;
                    case 2 -> freqs[2] += 1;
                    case 3 -> freqs[3] += 1;
                    case 4 -> freqs[4] += 1;
                    case 5 -> freqs[5] += 1;
                }
            }
        }
        return freqs;
    }

    private double generateAverageScore() {
        double avg = 0;
        int totalScores = 0;
        for (Competitor player: getCompetitors()) {
            for (int score: player.getScores()) {
                totalScores += 1;
                avg += score;
            }
        }
        avg /= totalScores;
        return avg;
    }

    private double getHighScore() {
        double hS = 0;
        for (Competitor player: getCompetitors()) {
            if (player.getOverallScore() > hS) {
                hS = player.getOverallScore();
            }
        }

        return hS;
    }

    public File createReportFile() throws IOException {
        boolean exists;
        int count = 0;
        Path path;
        FileWriter report = null;

        do {
            path = Path.of("src/main/resources/report"+count+ ".txt");
            exists = Files.exists(path);

            if(exists) {
                count += 1;
            }
            else {
                Files.createFile(path);
                report = new FileWriter(String.valueOf(path));
            }
        }while (exists);

        generateReportContents();
        report.append(reportContents);
        report.close();
        reportContents = reportTemplate();
        return new File(path.toUri());
    }

    public static String createErrorLog(Exception e, String path) {
        try {
            FileWriter log = new FileWriter(path);
            log.append(String.valueOf(e));
            log.close();
            return Files.readString(Path.of(path));
        }
        catch (IOException ie) {
            return "Error";
        }

    }

    private void replaceVar(String target, String replacement) {
        reportContents = reportContents.replace(target, replacement);
    }

    private String reportTemplate() throws IOException {
        return Files.readString(Path.of("src/main/resources/report.template"));
        
    }

    private void generateReportContents() {
        replaceVar("%TABLE%", generateTable());
        replaceVar( "%HIGH-SCORE%", String.valueOf(getHighScore()));
        replaceVar( "%AVG-SCORE%", String.valueOf(generateAverageScore()));

        int[] freqs = generateLevelFreqs();
        for (int i = 0; i < freqs.length; i++) {
            replaceVar( "%LEVEL"+i+"%", Rank.values()[i].getRank());
            replaceVar( "%VALUE"+i+"%", String.valueOf(freqs[i]));
        }

        freqs = generateScoreFreqs();
        for (int i = 0; i < freqs.length; i++) {
            replaceVar( "%SCORE"+i+"%", String.valueOf(freqs[i]));
        }
    }
}
