package me.Dinner1111.School.Teachers;

import java.util.Random;

public class TeacherGenerator {
	private static final String[] teachers = {
		"Mr. Backmen", "Mrs. Birdsong", "Mr. Cameron", "Mrs. Dillon", "Mrs Vila",
		"Mrs. Tuttle", "Mr. Sperry", "Mrs. Schabarassi", "Mrs. Snow", "Mrs. Davis",
		"Mrs. Leal", "Mr. Hunter", "Mrs. Garcia", "Mrs. Anique", "Mr. Webster"
	};
	/**
	 * Gets a random teacher
	 * @return The random teacher
	 */
	public static final String getTeacher() {
		return teachers[new Random().nextInt(teachers.length)];
	}
	/**
	 * Gets all teachers
	 * @return All teachers
	 */
	public static final String[] getAvaliableTeachers() {
		return teachers;
	}
}