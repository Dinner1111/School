package me.Dinner1111.School.Teachers;

import java.util.HashMap;
import java.util.Map;

public class TeacherStorage {
	private static final Map<String, Map<String, String>> teachers = new HashMap<String, Map<String, String>>();
	private static final Map<String, Map<String, String>> students = new HashMap<String, Map<String, String>>();
	public static final String[] getTeacherInfo(String teacher) {
		Map<String, String> schedule = teachers.get(teacher);
		String[] result = new String[schedule.keySet().size() - 1 * 2];
		result[0] = teacher;
		for (int index = 1; index < schedule.keySet().size() - 1; index++)
			for (String student : schedule.keySet()) {
				for (String period : schedule.values())
					result[++index] = period;
				result[index] = student;
			}
		return result;
	}
	public static final String[] getStudentInfo(String student) {
		Map<String, String> schedule = students.get(student);
		String[] result = new String[schedule.keySet().size() - 1 * 2];
		result[0] = student;
		for (int index = 1; index < schedule.keySet().size() - 1; index++)
			for (String teacher : schedule.keySet()) {
				for (String period : schedule.values())
					result[++index] = period;
				result[index] = teacher;
			}
		return result;
	}
	public static final boolean verifyTeacher(String teacher) {
		if (teachers.containsKey(teacher)) return true;
		return false;
	}
	public static final boolean verifyStudent(String student) {
		if (students.containsKey(student)) return true;
		return false;
	}
}