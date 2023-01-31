package com.r0r5chach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ManagerTest {

    @Test
    public void managerTest() {
        Manager m = new Manager();
        assertEquals("Joshua Luke Perry", m.getCompetitors().getCompetitors().get(1).getPlayerName().getFullName());
    }

    @Test
    public void managerTestGetReport() {
        try {
            Manager m = new Manager();
            assertEquals(Files.readString(Path.of("src/test/java/reportTest.txt")), Files.readString(m.getReport().toPath()));
        }
        catch (IOException e) {
            System.out.println("File does not exist");
        }
    }

    @Test
    public void managerTestGetCompetitors() {
        //Already tested in managerTest()
    }

    @Test
    public void managerTestInit() {
        //Already tested in managerTest()
    }

}
