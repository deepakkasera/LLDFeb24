package org.example.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        System.out.println(x/y);
        System.out.println("After division");

        readFileContent("abc.txt");
    }

    public static void readFileContent(String fileName) throws FileNotFoundException, IOException {
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        fileReader.read();
    }
}
