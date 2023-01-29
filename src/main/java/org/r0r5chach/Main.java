package org.r0r5chach;


import java.io.IOException;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        try {
            System.out.println(Files.readString(manager.getReport().toPath()));
        }
        catch (IOException e) {
            System.out.println("reading error");
        }
    }
}