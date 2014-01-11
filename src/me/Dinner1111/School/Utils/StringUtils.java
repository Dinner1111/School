package me.Dinner1111.School.Utils;

import java.util.Random;

public class StringUtils {
	/**
	 * Gets the string representation of an object
	 * @param o The object
	 * @return The object as a string
	 */
	public static final String toString(Object o) {
		return o.toString();
	}
	/**
	 * Generates a random name
	 * @return The name
	 */
	public static final String generateName() {
		String[] names = {
				"Josh", "Chris", "Tim", "Alison", "Jessica", "Alex", "Austin",
				"Miles", "Andrew", "Anothony", "Kayla", "Kayle", "Brian", "Lucas",
				"Helen", "Katie", "Eric", "Adam", "Jared", "Elly", "Joan",
				"Juan", "David", "Carter", "Tess", "Cathrine", "Amanda", "Tony"
			};
		return names[new Random().nextInt(names.length)];
	}
}