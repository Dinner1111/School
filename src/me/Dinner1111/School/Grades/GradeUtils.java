package me.Dinner1111.School.Grades;

import java.util.Random;

public class GradeUtils {
	/**
	 * Generates a random letter grade
	 * @return A random letter grade
	 */
	public static final String randomGrade() {
		switch (new Random().nextInt(5)) {
			case 1: return "A";
			case 2: return "B";
			case 3: return "C";
			case 4: return "D";
			case 5: return "F";
		}
		return "F";
	}
	/**
	 * Calculates a GPA from a letter grade
	 * @param grade The letter grade
	 * @return The GPA
	 */
	public static final double GPAFromGrade(String grade) {
		double[] range = new double[1];
		switch (grade) {
			case "A": 
				range[0] = 3.5;
				range[1] = 4;
				break;
			case "B":
				range[0] = 3;
				range[1] = 3.49;
				break;
			case "C":
				range[0] = 2.5;
				range[1] = 2.99;
				break;
			case "D":
				range[0] = 2;
				range[1] = 2.49;
				break;
			case "F":
				range[0] = 0;
				range[1] = 1.99;
				break;
		}
		double GPA = (new Random().nextInt(100) / 100) + (new Random().nextInt((int) Math.ceil(range[1])));
		while (GPA < range[0] || GPA > range[1])
			GPA = (new Random().nextInt(100) / 100) + (new Random().nextInt((int) Math.ceil(range[1])));
		return GPA;
	}
	/**
	 * Gets a letter grade from a GPA
	 * @param GPA The GPA used to find the letter grade
	 * @return The letter grade
	 */
	public static final String gradeFromGPA(double GPA) {
		if (GPA > 3.5) return "A";
		if (GPA > 3 && GPA < 3.49) return "B";
		if (GPA > 2.5 && GPA < 2.99) return "C";
		if (GPA > 1 && GPA < 2.49) return "D";
		else return "F";
	}
	/**
	 * Calculates the average GPA from an array of letter grades
	 * @param grades An array of letter grades
	 * @return The average GPA
	 */
	public static final double calculateAverageGPA(double[] grades) {
		double total = 0;
		for (double GPA : grades)
			total += GPA;
		return total / grades.length;
	}
}