package org.example.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (y == 0) {
                throw new WrongInputPassedException("Some message");
            } else {
                System.out.println(x/y);
            }

//            File file = new File("fileName");
//            FileReader fileReader = new FileReader(file);
//            System.out.println("Line after filereader");
//            fileReader.read();
        } catch (ArithmeticException e) {
            System.out.println("Got ArithmeticException");
        } catch (WrongInputPassedException e) {
            System.out.println("Something went wrong");
        }
//        } catch (FileNotFoundException e) {
//            System.out.println("Got FileNotFoundException");
//        } catch (IOException e) {
//            System.out.println("Got IOException");
//        } catch (Exception e) {
//            System.out.println("Got General Exception");
//        }
        finally {
            System.out.println("Inside Finally block");
        }
        System.out.println("After all the Catch blocks");
    }
}
