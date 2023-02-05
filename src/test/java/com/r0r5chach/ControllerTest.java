package com.r0r5chach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.File;

import com.r0r5chach.controllers.Controller;
/**
 * Class that defines the test for com.r0r5chach.controllers.Controller
 * @author r0r5chach
 */
public class ControllerTest {
    /**
     * Tests Controller.setCompetitors(CompetitorList)
     */
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
    /**
     * Tests Controller.getCompetitors()
     */
    @Test
    public void controllerGetCompetitorsTest() {
        //Already tested in controllerSetCompetitorsTest()
    }
}
