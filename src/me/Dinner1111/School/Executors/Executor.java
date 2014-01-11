package me.Dinner1111.School.Executors;

import me.Dinner1111.School.Students.StudentSetup;
import me.Dinner1111.School.Students.StudentStorage;
import me.Dinner1111.School.Teachers.TeacherGenerator;
import me.Dinner1111.School.Teachers.TeacherStorage;

public class Executor {
	/**
	 * Method called when a command is run
	 * @param command The command run
	 * @param args The arguments of the command
	 * @return The information to display 
	 */
	public String onCommand(String command, String[] args) {
		if (command.equalsIgnoreCase("help"))
			if (args.length == 0) return "Avaliable commands:"
					+ "\nHelp - Displays all commands.\n\tHelp [command] - Displays the command's description."
					+ "\nGrades - Displays average grades of all students in the class.\n\tGrades [student] - Display a student's grades."
					+ "\nTeacher [teacher] - Displays teacher information."
					+ "\nStudent [student] - Displays student information.";
			else if (args.length == 1)
				if (args[0].equalsIgnoreCase("grades")) {
					return "Help - Grades:"
							+ "\nThis command displays the average class grade, as well as a teacher grade based on the students opinions."
							+ "\n\nYou may also lookup a specific student's grades by using their name.";
				} else if (args[0].equalsIgnoreCase("teachers")) {
					return "Help - Teacher:"
							+ "\nThis command displays the teacher's grade, based on student opinion. It will also display the lesson plans for the week.";
				} else if (args[0].equalsIgnoreCase("student")) {
					return "Help - Student:"
							+ "\nThis command displays the student's grades, teacher and schedule.";
				} else return "Invalid help subject.";
			else return "Too many arguments.";
		if (command.equalsIgnoreCase("grades"))
			if (args.length == 0) {
				String format = "All student grade averages:\n";
				String[] students = StudentStorage.getAllStudents();
				String[] grades = StudentStorage.getAllGradeAverages();
				for (int index = 0; index < students.length; index++)
					format += students[index] + "'s GPA: " + grades[index] + "\n";
				return format.substring(0, format.length() - 2);
			} else return "Too many arguments.";
		if (command.equalsIgnoreCase("teacher"))
			if (args.length == 0) {
				String format = "Avaliable Teachers:";
				String[] teachers = TeacherGenerator.getAvaliableTeachers();
				for (String teacher : teachers)
					format += "\n  - " + teacher;
				return format;
			} else if (args.length == 1) {
				if (!TeacherStorage.verifyTeacher(args[0])) return "Invalid teacher.";
				String[] teacherInfo = TeacherStorage.getTeacherInfo(args[0]);
				String format = "Teacher Info - " + teacherInfo[0] + ":";
				for (int index = 1; index < teacherInfo.length - 1; index++) 
					format += "\n  - " + teacherInfo[index] + ": " + teacherInfo[++index];
				return format;
			} else return "Too many arguments.";
		if (command.equalsIgnoreCase("student"))
			if (args.length == 0) {
				String format = "All Students (" + StudentStorage.getAllStudents().length + "):";
				for (String student : StudentStorage.getAllStudents())
					format += student + "\n";
				return format.substring(0, format.length() - 2);
			} else if (args.length < 1) return "Too many arguments";
			else if (!StudentStorage.checkStudent(args[0])) return "Invalid student.";
			else {
				StudentSetup instance = StudentStorage.getStudentInstance(args[0]);
				String format = "Student Report - " + args[0] + ":";
				format += "\nSchedule:";
				for (int index = 0; index <= 5; index++)
					format += "\n  - " + instance.getSchedule()[index] + ": " + instance.getTeachers()[index];
				format += "\nGrades:";
				for (int index = 0; index <= 5; index++)
					format += "\n  - " + instance.getSchedule()[index] + ": " + instance.getGrades()[index];
				format += "\nGPA: " + instance.getGradeAverage();
				return format;
			}
		return "Invalid command.";
	}
}