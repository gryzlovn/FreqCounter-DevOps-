//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        while(true) {
            System.out.println("Write 1-to start the frequency dictionary\nAnd another number to end program");
            Scanner in2 = new Scanner(System.in);
            switch (in2.nextLine()) {
                case "1":
                    Scanner in = new Scanner(System.in);
                    System.out.println("Enter the name of the file to input ");
                    String input = in.nextLine();
                    System.out.println("Enter the name of the file to output ");
                    String output = in.nextLine();
                    WordCounter n1 = new WordCounter(input, output);
                    n1.FrequencyDictionary();
                    break;
                default:
                    return;
            }
        }
    }
}
