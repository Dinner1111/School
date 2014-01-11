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
	public StudentSetup(String name) {
		this.name = name;
		this.generateGrades();
		this.generateAverage(grades);
		this.resolveSchedule();
	}
	private void generateGrades() {
		for (int index = 0; index <= 5; index++)
			this.grades[index] = GradeUtils.randomGrade();
	}
	private void generateAverage(String[] grades) {
		double[] GPAs = new double[grades.length];
		for (int index = 0; index < grades.length; index++)
			GPAs[index] = GradeUtils.GPAFromGrade(grades[index]);
		this.gradeAverage = StringUtils.toString((Object) GradeUtils.calculateAverageGPA(GPAs));
	}
	private void resolveSchedule() {
		for (String splitter : ScheduleGenerator.generate())
			for (int index = 0; index <= 5; index++) {
				this.schedule[index] = splitter.split(",")[0];
				this.teachers[index] = splitter.split(",")[1];
			}
	}
	public String getName() {
		return this.name;
	}
	public String getGradeAverage() {
		return this.gradeAverage;
	}
	public String[] getGrades() {
		return this.grades;
	}
	public String[] getSchedule() {
		return this.schedule;
	}
	public String[] getTeachers() {
		return this.teachers;
	}
} 