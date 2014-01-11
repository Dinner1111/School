package me.Dinner1111.School.Students;

import me.Dinner1111.School.Grades.GradeUtils;
import me.Dinner1111.School.Schedule.ScheduleGenerator;
import me.Dinner1111.School.Utils.StringUtils;

public class StudentSetup {
	private String name;
	private String gradeAverage;
	private String[] grades = new String[5];
	private String[] schedule = new String[5];
	private String[] teachers = new String[5];
	/**
	 * Setup for the student's information
	 * @param name The name of the student
	 */
	public StudentSetup(String name) {
		this.name = name;
		this.generateGrades();
		this.generateAverage(grades);
		this.resolveSchedule();
	}
	/**
	 * Gets random grades to assign to the student
	 */
	private void generateGrades() {
		for (int index = 0; index <= 5; index++)
			this.grades[index] = GradeUtils.randomGrade();
	}
	/**
	 * Generates an average GPA based on the student's grades
	 * @param grades The students grades
	 */
	private void generateAverage(String[] grades) {
		double[] GPAs = new double[grades.length];
		for (int index = 0; index < grades.length; index++)
			GPAs[index] = GradeUtils.GPAFromGrade(grades[index]);
		this.gradeAverage = StringUtils.toString((Object) GradeUtils.calculateAverageGPA(GPAs));
	}
	/**
	 * Splits the schedule into teachers and periods
	 */
	private void resolveSchedule() {
		for (String splitter : ScheduleGenerator.generate())
			for (int index = 0; index <= 5; index++) {
				this.schedule[index] = splitter.split(",")[0];
				this.teachers[index] = splitter.split(",")[1];
			}
	}
	/**
	 * Gets the student's name
	 * @return The student's name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Gets the student's GPA
	 * @return The student's GPA
	 */
	public String getGradeAverage() {
		return this.gradeAverage;
	}
	/**
	 * Gets all of the student's grades
	 * @return An array of the student's grades
	 */
	public String[] getGrades() {
		return this.grades;
	}
	/**
	 * Gets the student's schedule in periods
	 * @return The student's schedule in periods
	 */
	public String[] getSchedule() {
		return this.schedule;
	}
	/**
	 * Gets the student's teachers
	 * @return The student's teachers
	 */
	public String[] getTeachers() {
		return this.teachers;
	}
} 