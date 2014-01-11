package me.Dinner1111.School.Utils;

import java.util.Random;

public class StringUtils {
	public static final String toString(Object o) {
		return o.toString();
	}
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