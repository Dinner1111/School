package me.Dinner1111.School;

import java.io.Console;

import me.Dinner1111.School.Executors.Executor;
import me.Dinner1111.School.Students.StudentGenerator;

public class Main {
    public static final Console SYSTEM_CONSOLE = System.console();
    private static Executor executor = new Executor();
    public static void main(String[] args) {
        System.out.println("Welcome to school. Please type a command or 'help' for a list of commands.\n>");
        StudentGenerator.generate();
        String input = SYSTEM_CONSOLE.readLine();
        String[] inputArgs = input.substring(input.split(" ")[0].length() + 1, input.length()).split(" ");
        System.out.println(executor.onCommand(input.split(" ")[0], inputArgs));
    }
}