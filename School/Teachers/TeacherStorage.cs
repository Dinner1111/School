using System.Collections.Generic;

namespace School.Teachers {
    class TeacherStorage {
        private static Dictionary<string, Dictionary<string, string>> teachers = new Dictionary<string, Dictionary<string, string>>();
        private static Dictionary<string, Dictionary<string, string>> students = new Dictionary<string, Dictionary<string, string>>();
        /**
         * Gets the specified teacher's students and periods
         * @param teacher The teacher
         * @return The students and corresponding periods
         */
        public static string[] getTeacherInfo(string teacher) {
            Dictionary<string, string> schedule = teachers[teacher];
            string[] result = new string[schedule.Keys.Count - 1 * 2];
            result[0] = teacher;
            for (int index = 1; index < schedule.Keys.Count - 1; index++)
                foreach (string student in schedule.Keys) {
                    foreach (string period in schedule.Values)
                        result[++index] = period;
                    result[index] = student;
                }
            return result;
        }
        /**
         * Gets the specified student's teachers and periods
         * @param student The student
         * @return The teachers and corresponding periods
         */
        public static string[] getStudentInfo(string student) {
            Dictionary<string, string> schedule = students[student];
            string[] result = new string[schedule.Keys.Count - 1 * 2];
            result[0] = student;
            for (int index = 1; index < schedule.Keys.Count - 1; index++)
                foreach (string teacher in schedule.Keys) {
                    foreach (string period in schedule.Values)
                        result[++index] = period;
                    result[index] = teacher;
                }
            return result;
        }
        /**
         * Checks if the specified teacher exists
         * @param teacher The teacher
         * @return If the teacher exists
         */
        public static bool verifyTeacher(string teacher) {
            if (teachers.ContainsKey(teacher)) return true;
            return false;
        }
        /**
         * Checks if the specified student exists
         * @param student The student
         * @return If the student exists
         */
        public static bool verifyStudent(string student) {
            if (students.ContainsKey(student)) return true;
            return false;
        }
    }
}
