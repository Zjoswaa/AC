package main;

import gui.Gui;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        // Check if there exists a directory named "ACsaves" in the directory where the jar was ran, if not, this directory is created
        if (!Files.exists(Path.of(System.getProperty("user.dir") + "/ACsaves"))) {
            new File(System.getProperty("user.dir") + "/ACsaves").mkdir();
        }
        new Gui();
    }
}
