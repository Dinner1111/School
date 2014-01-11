package me.Dinner1111.School.Students;

import java.util.HashMap;
import java.util.Map;

public class StudentStorage {
	private static final Map<String, StudentSetup> students = new HashMap<String, StudentSetup>();
	public static final void addStudent(String name, StudentSetup instance) {
		students.put(name, instance);
	}
	public static final StudentSetup getStudentInstance(String name) {
		return students.get(name);
	}
	public static final String[] getAllStudents() {
		return (String[]) students.keySet().toArray();
	}
	public static final String[] getAllGradeAverages() {
		String[] averages = new String[students.size() - 1];
		for (int index = 0; index < students.size() - 1; index++)
			for (String key : (String[]) students.keySet().toArray())
				averages[index] = students.get(key).getGradeAverage();
		return averages;
	}
	public static final boolean checkStudent(String name) {
		if (students.containsKey(name)) return true;
		return false;
	}
}