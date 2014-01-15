using System;

namespace School {
    class ScheduleGenerator {
        private static string[] classes = { 
            "Geometry", "Biology", "English I", "World History", "Computer Science", 
            "French", "Spanish", "Japanese", "Civics", "Chemistry",  
            "Business", "Algebra", "Calculus", "English II", "Physical Education" 
        };
        /**
         * Generates a random schedule
         * @return A random schedule
         */
        public static string[] generate() {
            string[] schedule = new string[5];
            while (true) {
                for (int index = 0; index < 5; index++)
                    schedule[index] = classes[new Random().Next(classes.Length)] + "," + Teachers.TeacherGenerator.getTeacher();
                if (Utils.ArrayUtils.checkDuplicates((Object[]) schedule)) break;
            }
            return schedule;
        }
    }
}
