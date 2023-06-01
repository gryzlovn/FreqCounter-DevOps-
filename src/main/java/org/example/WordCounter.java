//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class WordCounter {
    private final String inFile;
    private final String outFile;
    int[] mainmas = new int[1000];

    public WordCounter(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }

    public void TableFill(int rawSymbol) {
        char symbol = (char)rawSymbol;
        if (symbol >= 'A' && symbol <= 'Z' || symbol >= 'a' && symbol <= 'z') {
            int var10003 = this.mainmas[symbol]++;
        }

    }

    public void FrequencyDictionary() {
        try {
            if (!this.inFile.endsWith(".txt") || !this.outFile.endsWith(".txt")) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException var14) {
            System.out.println("File names must have .txt in the end ");
            return;
        }

        Path inputfilepath = Path.of(this.inFile);

        try {
            BufferedReader reader = Files.newBufferedReader(inputfilepath);

            try {
                System.out.println("Read from : " + this.inFile);

                while(true) {
                    int rawSymbol;
                    if ((rawSymbol = reader.read()) == -1) {
                        reader.close();
                        Path inputfilepath2 = Path.of(this.outFile);

                        try {
                            BufferedReader reader2 = Files.newBufferedReader(inputfilepath2);

                            try {
                                reader2.close();
                                System.out.println("Such file is exists.Writing to it..");
                            } catch (Throwable var10) {
                                if (reader2 != null) {
                                    try {
                                        reader2.close();
                                    } catch (Throwable var9) {
                                        var10.addSuppressed(var9);
                                    }
                                }

                                throw var10;
                            }

                            if (reader2 != null) {
                                reader2.close();
                            }
                        } catch (NoSuchFileException var11) {
                            System.out.println("There is no such file.Creating new one..");
                        }

                        BufferedWriter writer = new BufferedWriter(new FileWriter(this.outFile));
                        System.out.println("Write to : " + this.outFile);

                        for(int i = 0; i < this.mainmas.length; ++i) {
                            if (this.mainmas[i] != 0) {
                                writer.write((char)i + " " + this.mainmas[i] + "\n");
                            }
                        }

                        writer.close();
                        break;
                    }

                    this.TableFill(rawSymbol);
                }
            } catch (Throwable var12) {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Throwable var8) {
                        var12.addSuppressed(var8);
                    }
                }

                throw var12;
            }

            if (reader != null) {
                reader.close();
            }
        } catch (IOException var13) {
            System.out.println("Check the name of the input file. Perhaps it is missing");
        }

    }
}
