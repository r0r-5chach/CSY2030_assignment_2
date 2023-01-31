package com.r0r5chach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainTest {
    @Test
    public void mainTest() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ByteArrayOutputStream expected = new ByteArrayOutputStream();
        System.setOut(new PrintStream(expected));
        try {
            System.out.println(Files.readString(Path.of("src/test/java/reportTest.txt")));
        }
        catch (IOException e) {
            System.out.println("File doesn't exist");
        }
        System.setOut(new PrintStream(output));
        Main.main(new String[0]);
        assertEquals(expected.toString(), output.toString());
    }
}
