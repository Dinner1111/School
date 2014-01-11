package me.Dinner1111.School.Utils;

public class ArrayUtils {
	/**
	 * Checks if there are duplicate objects in the same array
	 * @param array The object array
	 * @return If there are duplicates
	 */
	public static final boolean checkDuplicates(Object[] array) {
		Object[] arrayCopy = array.clone();
		for (int arrayIndex = 0; arrayIndex < array.length; arrayIndex++)
			for (int copyIndex = 0; copyIndex < arrayCopy.length; copyIndex++)
				if (!array[arrayIndex].toString().equals(arrayCopy[copyIndex].toString())) continue;
				else return false;
		return true;
	}
}