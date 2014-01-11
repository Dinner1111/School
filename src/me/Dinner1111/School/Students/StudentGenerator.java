package me.Dinner1111.School.Students;

import java.util.Random;

import me.Dinner1111.School.Utils.StringUtils;

public class StudentGenerator {
	private static final Random random = new Random();
	public static final void generate() {
		int studentNumber = generateStudents(15, 30);
		String studentName = StringUtils.generateName();
		while (studentNumber > 0)
			StudentStorage.addStudent(studentName, new StudentSetup(studentName));
	}
	private static int generateStudents(int min, int max) {
		int amount = random.nextInt(max);
		while (amount < min)
			amount = random.nextInt(max);
		return amount;
	}
}