package com.r0r5chach;

import com.r0r5chach.r6.R6Attacker;
import com.r0r5chach.r6.R6Defender;
import com.r0r5chach.r6.R6Player;
import com.r0r5chach.valorant.ValorantAgent;
import com.r0r5chach.valorant.ValorantPlayer;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class EditPage {
    public static void loadPlayer(Competitor player, TextField[] textFields, ChoiceBox<Rank> level) {
        textFields[0].setText(String.valueOf(player.getPlayerNumber()));
        textFields[1].setText(player.getPlayerName().getFullName());
        level.getSelectionModel().select(player.getPlayerLevel());;
        textFields[2].setText(String.valueOf(player.getOverallScore()));
    }

    public static void loadFavoriteCharacters(Competitor player, ChoiceBox<R6Attacker> attacker, ChoiceBox<R6Defender> defender, ChoiceBox<ValorantAgent> agent, Text field) {
        if (player instanceof R6Player) {
            attacker.getSelectionModel().select(((R6Player) player).getFavoriteAttacker());
            defender.getSelectionModel().select((((R6Player) player).getFavoriteDefender()));
            agent.visibleProperty().set(false);
            attacker.visibleProperty().set(true);
            defender.visibleProperty().set(true);
            field.setText("Favorite Operators");
        }
        else if (player instanceof ValorantPlayer) {
            agent.getSelectionModel().select(((ValorantPlayer) player).getFavoriteAgent());
            agent.visibleProperty().set(true);
            attacker.visibleProperty().set(false);
            defender.visibleProperty().set(false);
            field.setText("Favorite Agent");
        }
    }

    public static void loadScores(Competitor player, TextField[] fields) {
        int[] playerScores = player.getScores();
        for (int i = 0; i < playerScores.length; i++) {
            fields[i].setText(String.valueOf(playerScores[i]));
        }
    }

    public static void updatePlayer(Competitor player, TextField[] fields, ChoiceBox<Rank> level) {
        player.setPlayerNumber(Integer.parseInt(fields[0].getText()));
        player.setPlayerName(new Name(fields[1].getText()));
        player.setPlayerLevel(level.getValue());
    }

    public static void updateFavoriteCharacters(Competitor player, ChoiceBox<R6Attacker> attacker, ChoiceBox<R6Defender> defender, ChoiceBox<ValorantAgent> agent) {
        if (player instanceof R6Player) {
            ((R6Player) player).setFavoriteAttacker(attacker.getValue());
            ((R6Player) player).setFavoriteDefender(defender.getValue());
        }
        else if (player instanceof ValorantPlayer) {
            ((ValorantPlayer) player).setFavoriteAgent(agent.getValue());
        }
    }

    public static void updateScores(Competitor player, TextField[] fields) {
        int[] newScores = new int[6];
        for (int i = 0; i < newScores.length; i++) {
            newScores[i] = Integer.parseInt(fields[i].getText());
        }
        player.setScores(newScores);
    }

}
