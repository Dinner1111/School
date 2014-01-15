using System;

namespace School.Utils {
    class StringUtils {
        /**
         * Gets the string representation of an object
         * @param o The object
         * @return The object as a string
         */
        public static string toString(Object o) {
            return o.ToString();
        }
        /**
         * Generates a random name
         * @return The name
         */
        public static string generateName() {
            string[] names = {
                "Josh", "Chris", "Tim", "Alison", "Jessica", "Alex", "Austin",
                "Miles", "Andrew", "Anothony", "Kayla", "Kayle", "Brian", "Lucas",
                "Helen", "Katie", "Eric", "Adam", "Jared", "Elly", "Joan",
                "Juan", "David", "Carter", "Tess", "Cathrine", "Amanda", "Tony"
            };
            return names[new Random().Next(names.Length)];
        }
    }
}
