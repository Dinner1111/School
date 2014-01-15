using System;

namespace School.Students {
    class StudentGenerator {
        private static Random random = new Random();
        /**
         * Creates a new instance of StudentSetup() to generate a new student
         */
        public static void generate() {
            int studentNumber = generateStudents(15, 30);
            string studentName = Utils.StringUtils.generateName();
            while (studentNumber > 0) {
                StudentStorage.addStudent(studentName, new StudentSetup(studentName));
                studentNumber--;
            }
        }
        /**
         * Generates a number of students inside a range
         * @param min The minimum amount of students generated
         * @param max The maximum amount of students generated
         * @return The amount of students generated
         */
        private static int generateStudents(int min, int max) {
            int amount = random.Next(max);
            while (amount < min)
                amount = random.Next(max);
            return amount;
        }
    }
}
