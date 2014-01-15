using System;

namespace School.Teachers{
    class TeacherGenerator {
        private static string[] teachers = {
            "Mr. Backmen", "Mrs. Birdsong", "Mr. Cameron", "Mrs. Dillon", "Mrs Vila",
            "Mrs. Tuttle", "Mr. Sperry", "Mrs. Schabarassi", "Mrs. Snow", "Mrs. Davis",
            "Mrs. Leal", "Mr. Hunter", "Mrs. Garcia", "Mrs. Anique", "Mr. Webster"
        };
        /**
         * Gets a random teacher
         * @return The random teacher
         */
        public static string getTeacher() {
            return teachers[new Random().Next(teachers.Length)];
        }
        /**
         * Gets all teachers
         * @return All teachers
         */
        public static string[] getAvaliableTeachers() {
            return teachers;
        }
    }
}
