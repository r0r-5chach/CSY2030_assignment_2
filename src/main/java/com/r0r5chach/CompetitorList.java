package com.r0r5chach;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.r0r5chach.competitor.Competitor;
import com.r0r5chach.competitor.Name;
import com.r0r5chach.competitor.Rank;
import com.r0r5chach.competitor.r6.R6Attacker;
import com.r0r5chach.competitor.r6.R6Defender;
import com.r0r5chach.competitor.r6.R6Player;
import com.r0r5chach.competitor.valorant.ValorantAgent;
import com.r0r5chach.competitor.valorant.ValorantPlayer;
/**
 * Class that defines the various attributes and methods associated with a list of Competitors
 * @author r0r5chach
 */
public class CompetitorList {
     /**
     * Attribute that stores an Array of Competitors
     */
    private final ArrayList<Competitor> competitors;
    /**
     * Attribute that stores the report on the held Competitors
     */
    private String reportContents;
    /**
     * Constructs a CompetitorList Object by creating a new Array and defining the report as the stored template
     * @throws IOException if the template cannot be loaded
     */
    public CompetitorList() throws IOException {
        competitors = new ArrayList<>();
        reportContents = reportTemplate();
    }
    /**
     * Gets the Array of competitors
     * @return the Array of competitors
     */
    public ArrayList<Competitor> getCompetitors() {
        return competitors;
    }
    
    /**
     * Read the target file and add any competitors found into the Array
     * @param list the file to be read
     * @throws FileNotFoundException if the file cannot be found
     */
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
    /**
     * Create a text file containing a report on the currently held competitors at the specified path
     * @param pathString the absolute path of the folder the report should be made in
     * @return the text file
     * @throws IOException if the file cannot be made at that path
     */
    public File createReportFile(String pathString) throws IOException {
        boolean exists;
        int count = 0;
        Path path;
        FileWriter report = null;

        do {
            path = Path.of(pathString+"/report"+count+ ".txt");
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
    /**
     * Creates a text file containing a log of the last error
     * @param e the exception that has triggered
     * @param path the absolute path of the file that the log should be made in
     * @return The contents of the log file as a string
     */
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
    /**
     * Parses a line of text from a file to create a ValorantPlayer
     * @param row the line of text to be parsed
     * @return the ValorantPlayer created
     */
    private ValorantPlayer parseValorantPlayer(String[] row) {
        int playerNumber = Integer.parseInt(row[0]);
        Name playerName = new Name(row[1]);
        Rank playerLevel = Rank.valueOf(row[2]);
        ValorantAgent favoriteAgent = ValorantAgent.valueOf(row[3]);
        int[] scores = parseScores(row[4]);
        return new ValorantPlayer(playerNumber, playerName, playerLevel, favoriteAgent, scores);
    }
    /**
     * Parses a line of text from a file to create a R6Player
     * @param row the line of text to be parsed
     * @return the R6Player created
     */
    private R6Player parseR6Player(String[] row) {
        int playerNumber = Integer.parseInt(row[0]);
        Name playerName = new Name(row[1]);
        Rank playerLevel = Rank.valueOf(row[2]);
        R6Attacker favoriteAttacker = R6Attacker.valueOf(row[3]);
        R6Defender favoriteDefender = R6Defender.valueOf(row[4]);
        int[] scores = parseScores(row[5]);
        return new R6Player(playerNumber, playerName, playerLevel, favoriteAttacker, favoriteDefender, scores);
    }
    /**
     * Parse the scores stored in a row
     * @param list the list of scores to be parsed
     * @return an Array of the scores
     */
    private int[] parseScores(String list) {
        String[] scores = list.split(",");
        int[] parsedScores = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            parsedScores[i] = Integer.parseInt(scores[i]);
        }
        return parsedScores;
    }
    /**
     * Generate a string that represents a table of the competitors and their attributes
     * @return the string
     */
    private String generateTable() {
        StringBuilder table = new StringBuilder("Competitor               Level        Scores         Overall         Favorite Character(s)");
        Competitor best = null;
        double bestScore = 0;
        Rank bestRank = Rank.BRONZE;
        List<Rank> ranks = Arrays.asList(Rank.values());
        for (Competitor player: getCompetitors()) {
            if (player.getOverallScore() > bestScore) {
                best = player;
                bestScore = player.getOverallScore();
                bestRank = player.getPlayerLevel();
            }
            else if (player.getOverallScore() == bestScore) {
                if (ranks.indexOf(player.getPlayerLevel()) > ranks.indexOf(bestRank)) {
                    best = player;
                    bestScore = player.getOverallScore();
                    bestRank = player.getPlayerLevel();
                }
            }
            table.append("\n");
            table.append(player.getShortDetails()).append(" ");
        }
        table.append("\n\n").append(best.getFullDetails());
        return table.toString();
    }
    /**
     * Generate the frequency of each player level across all competitors
     * @return an Array of the frequencies
     */
    private int[] generateLevelFreqs() {
        int[] freqs = {0, 0, 0, 0};
        for (Competitor player: getCompetitors()) {
            switch (player.getPlayerLevel()) {
                case BRONZE -> freqs[0] += 1;
                case SILVER -> freqs[1] += 1;
                case GOLD -> freqs[2] += 1;
                case PLATINUM -> freqs[3] += 1;
                default -> throw new IllegalArgumentException("Unexpected value: " + player.getPlayerLevel());
            }
        }
        return freqs;
    }
    /**
     * Generate the frequency of achieved scores across all competitors
     * @return an Array of the frequencies
     */
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
    /**
     * Generate the average score across all competitors
     * @return the average scores
     */
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
    /**
     * Generate the highest score achieved across all competitors
     * @return the highest score
     */
    private double getHighScore() {
        double hS = 0;
        for (Competitor player: getCompetitors()) {
            if (player.getOverallScore() > hS) {
                hS = player.getOverallScore();
            }
        }

        return hS;
    }
    /**
     * Replace the specified target substring in the report and replace it with the replacement string
     * @param target the target substring
     * @param replacement the replacement string
     */
    private void replaceVar(String target, String replacement) {
        reportContents = reportContents.replace(target, replacement);
    }
    /**
     * Get the report template
     * @return the report template
     * @throws IOException if the file is not found
     */
    private String reportTemplate() throws IOException {
        return Files.readString(Path.of("src/main/resources/com/r0r5chach/report.template"));
        
    }
    /**
     * Generate the report contents
     */
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
