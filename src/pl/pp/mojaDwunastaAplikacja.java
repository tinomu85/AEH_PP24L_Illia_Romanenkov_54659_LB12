package pl.pp;

import java.io.*;
import java.util.Scanner;

public class mojaDwunastaAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputFilePath;
        String outputFilePath;
        while (true) {
            System.out.print("Podaj ścieżkę do pliku wejściowego: ");
            inputFilePath = scanner.nextLine();

            File inputFile = new File(inputFilePath);
            if (inputFile.exists() && inputFile.isFile()) {
                break;
            } else {
                System.out.println("Plik nie istnieje. Proszę podać poprawną ścieżkę.");
            }
        }

        System.out.print("Podaj ścieżkę do pliku wyjściowego: ");
        outputFilePath = scanner.nextLine();


        int lineCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas czytania pliku: " + e.getMessage());
            return;
        }

        System.out.println("Liczba linii w pliku: " + lineCount);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            writer.write("Nazwa pliku: " + inputFilePath + "   /   ");
            writer.write("Liczba linii: " + lineCount + "\n");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisywania do pliku: " + e.getMessage());
        }

        scanner.close();
    }
}
