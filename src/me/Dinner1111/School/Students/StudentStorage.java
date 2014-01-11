package me.Dinner1111.School.Students;

import java.util.HashMap;
import java.util.Map;

public class StudentStorage {
    private static final Map<String, StudentSetup> students = new HashMap<String, StudentSetup>();
    /**
     * Adds a student's instance to the students list, identified by the student's name
     * @param name The name of the student
     * @param instance The instance of the student
     */
    public static final void addStudent(String name, StudentSetup instance) {
        students.put(name, instance);
    }
    /**
     * Gets the instance of the student
     * @param name The name of the student
     * @return The student's instance
     */
    public static final StudentSetup getStudentInstance(String name) {
        return students.get(name);
    }
    /**
     * Gets all students' instances
     * @return The instances
     */
    public static final String[] getAllStudents() {
        return (String[]) students.keySet().toArray();
    }
    /**
     * Gets the GPA for every student
     * @return The GPAs
     */
    public static final String[] getAllGradeAverages() {
        String[] averages = new String[students.size() - 1];
        for (int index = 0; index < students.size() - 1; index++)
            for (String key : (String[]) students.keySet().toArray())
                averages[index] = students.get(key).getGradeAverage();
        return averages;
    }
    /**
     * Checks if the student is in the list
     * @param name The student's name to be checked
     * @return If the student is in the list
     */
    public static final boolean checkStudent(String name) {
        if (students.containsKey(name)) return true;
        return false;
    }
}