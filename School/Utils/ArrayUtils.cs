using System;

namespace School.Utils {
    class ArrayUtils {
        /**
         * Checks if there are duplicate objects in the same array
         * @param array The object array
         * @return If there are duplicates
         */
        public static bool checkDuplicates(Object[] array) {
            Object[] arrayCopy = (Object[]) array.Clone();
            for (int arrayIndex = 0; arrayIndex < array.Length; arrayIndex++)
                for (int copyIndex = 0; copyIndex < arrayCopy.Length; copyIndex++)
                    if (!array[arrayIndex].ToString().Equals(arrayCopy[copyIndex].ToString())) continue;
                    else return false;
            return true;
        }
    }
}
