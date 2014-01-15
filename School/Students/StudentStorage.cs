using System.Collections.Generic;

namespace School.Students {
    class StudentStorage {
        private static Dictionary<string, StudentSetup> students = new Dictionary<string, StudentSetup>();
        /**
         * Adds a student's instance to the students list, identified by the student's name
         * @param name The name of the student
         * @param instance The instance of the student
         */
        public static void addStudent(string name, StudentSetup instance) {
            students.Add(name, instance);
        }
        /**
         * Gets the instance of the student
         * @param name The name of the student
         * @return The student's instance
         */
        public static StudentSetup getStudentInstance(string name) {
            return students[name];
        }
        /**
         * Gets all students' instances
         * @return The instances
         */
        public static string[] getAllStudents() {
            string[] result = new string[students.Keys.Count];
            for (int index = 0; index < result.Length; index++)
                foreach (string key in students.Keys)
                    result[index] = key;
            return result;
        }
        /**
         * Gets the GPA for every student
         * @return The GPAs
         */
        public static string[] getAllGradeAverages() {
            string[] averages = new string[students.Count - 1];
            for (int index = 0; index < students.Count - 1; index++)
                foreach (string key in students.Keys)
                    averages[index] = students[key].getGradeAverage();
            return averages;
        }
        /**
         * Checks if the student is in the list
         * @param name The student's name to be checked
         * @return If the student is in the list
         */
        public static bool checkStudent(string name) {
            if (students.ContainsKey(name)) return true;
            return false;
        }
    }
}
