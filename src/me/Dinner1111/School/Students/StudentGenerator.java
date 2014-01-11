package me.Dinner1111.School.Students;

import java.util.Random;

import me.Dinner1111.School.Utils.StringUtils;

public class StudentGenerator {
    private static final Random random = new Random();
    /**
     * Creates a new instance of StudentSetup() to generate a new student
     */
    public static final void generate() {
        int studentNumber = generateStudents(15, 30);
        String studentName = StringUtils.generateName();
        while (studentNumber > 0)
            StudentStorage.addStudent(studentName, new StudentSetup(studentName));
    }
    /**
     * Generates a number of students inside a range
     * @param min The minimum amount of students generated
     * @param max The maximum amount of students generated
     * @return The amount of students generated
     */
    private static int generateStudents(int min, int max) {
        int amount = random.nextInt(max);
        while (amount < min)
            amount = random.nextInt(max);
        return amount;
    }
}