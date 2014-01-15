using System;

namespace School.Students{
    class StudentSetup {
        private string name;
        private string gradeAverage;
        private string[] grades = new string[5];
        private string[] schedule = new string[5];
        private string[] teachers = new string[5];
        /**
         * Setup for the student's information
         * @param name The name of the student
         */
        public StudentSetup(string name) {
            this.name = name;
            this.generateGrades();
            this.generateAverage(grades);
            this.resolveSchedule();
        }
        /**
         * Gets random grades to assign to the student
         */
        private void generateGrades() {
            for (int index = 0; index < 5; index++)
                this.grades[index] = GradeUtils.randomGrade();
        }
        /**
         * Generates an average GPA based on the student's grades
         * @param grades The student's grades
         */
        private void generateAverage(string[] grades) {
            double[] GPAs = new double[grades.Length];
            for (int index = 0; index < grades.Length; index++)
                GPAs[index] = GradeUtils.GPAFromGrade(grades[index]);
            this.gradeAverage = Utils.StringUtils.toString((Object)GradeUtils.calculateAverageGPA(GPAs));
        }
        /**
         * Splits the schedule into teachers and periods
         */
        private void resolveSchedule() {
            foreach (string splitter in ScheduleGenerator.generate())
                for (int index = 0; index <= 5; index++) {
                    this.schedule[index] = splitter.Split(',')[0];
                    this.teachers[index] = splitter.Split(',')[1];
                }
        }
        /**
         * Gets the student's name
         * @return The student's name
         */
        public string getName() {
            return this.name;
        }
        /**
         * Gets the student's GPA
         * @return The student's GPA
         */
        public string getGradeAverage() {
            return this.gradeAverage;
        }
        /**
         * Gets all of the student's grades
         * @return An array of the student's grades
         */
        public string[] getGrades() {
            return this.grades;
        }
        /**
         * Gets the student's schedule in periods
         * @return The student's schedule in periods
         */
        public string[] getSchedule() {
            return this.schedule;
        }
        /**
         * Gets the student's teachers
         * @return The student's teachers
         */
        public string[] getTeachers() {
            return this.teachers;
        }
    }
}
