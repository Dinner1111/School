package me.Dinner1111.School.Utils;

public class ArrayUtils {
	public static final boolean compareAgainstList(Object[] indexedArray, Object[] indexerArray) {
		boolean[] results = new boolean[indexedArray.length];
		for (int indexed = 0; indexed < indexedArray.length; indexed++)
			for (int indexer = 0; indexer < indexerArray.length; indexer++)
				if (!indexedArray[indexed].toString().equals(indexerArray[indexer].toString())) results[indexed] = false;
				else results[indexed] = true;
		for (int index = 0; index < results.length; index++)
			if (results[index]) return false;
		return true;
	}
	public static final boolean checkDuplicates(Object[] array) {
		Object[] arrayCopy = array.clone();
		for (int arrayIndex = 0; arrayIndex < array.length; arrayIndex++)
			for (int copyIndex = 0; copyIndex < arrayCopy.length; copyIndex++)
				if (!array[arrayIndex].toString().equals(arrayCopy[copyIndex].toString())) continue;
				else return false;
		return true;
	}
}