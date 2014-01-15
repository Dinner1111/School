package me.Dinner1111.School;

import java.util.Scanner;

import me.Dinner1111.School.Executors.Executor;
import me.Dinner1111.School.Students.StudentGenerator;

public class Main {
    private static Executor executor = new Executor();
    public static void main(String[] args) {
        System.out.println("Welcome to school. Please type a command or 'help' for a list of commands.");
        StudentGenerator.generate();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        String[] inputArgs = new String[(input.split(" ").length - input.split(" ")[0].length())];
        if (input.contains(" ")) inputArgs = input.substring(input.split(" ")[0].length() + 1, input.length()).split(" ");
        System.out.println(executor.onCommand(input.split(" ")[0], inputArgs) + "\n\n");
    }
}