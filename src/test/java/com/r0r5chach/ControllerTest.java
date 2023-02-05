package com.r0r5chach;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.Test;

import com.r0r5chach.controllers.Controller;

public class ControllerTest {
    
    @Test
    public void controllerSetCompetitorsTest() {
        Controller c = new Controller();
        CompetitorList cL = null;
        try {
            cL = new CompetitorList();
            cL.readCompetitors(new File("src/test/resources/valorantPlayers.txt"));
        }
        catch (Exception e) {

        }
        c.setCompetitors(cL);
        assertEquals(101, c.getCompetitors().getCompetitors().get(0).getPlayerNumber());
    }

    @Test
    public void controllerGetCompetitorsTest() {
        //Already tested in controllerSetCompetitorsTest()
    }
}
