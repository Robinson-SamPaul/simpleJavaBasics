package simple;

public class AhvSearchingAlgos {

	public static void main(String[] args) {

		linearSerachTrial();
		binarySearchTrial();
		jumpSearchTrial();
		interpolationSearchTrial();
	}

	public static int linearSearch(String[] list, String element) {
		System.out.print("\nSearching..." + element + ": ");
		for (int i = 0; i < list.length; i++) {
			System.out.print(i + " ");
			if (list[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}

	public static int binarySearch(String[] list, String element) {
		System.out.println("\nSearching..." + element + ": ");
		int low = 0;
		int high = list.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			System.out.println("Low: " + low + " High: " + high + " Mid: " + mid + " Mid element: " + list[mid]);
			if (list[mid].equals(element)) {
				return mid;
			} else if (list[mid].compareTo(element) < 0) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static int jumpSearch(String[] list, String element, int jumpLength) {
		System.out.println("\nSearching..." + element + ": ");
		int i = 0;
		while (list[i].compareTo(element) <= 0) {
			System.out.println("Element is greater than or equal to: " + list[i]);
			i = i + jumpLength;
			if (i >= list.length) {
				break;
			}
		}
		int startIndex = i - jumpLength;
		int endIndex = Math.min(i, list.length);
		System.out.println("Looking between: " + startIndex + " and: " + endIndex);
		for (int j = startIndex; j < endIndex; j++) {
			if (list[j].equals(element)) {
				return j;
			}
		}
		return -1;
	}

	public static int interpolationSearch(int[] list, int element) {
		System.out.println("\nSearching..." + element + ": ");
		int low = 0;
		int high = list.length - 1;
		while (low <= high) {
			int mid = low + ((element - list[low]) * (high - low)) / (list[high] - list[low]);
			System.out.println(
					"Low: " + low + " High: " + high + " Mid: " + mid + " Mid element: " + list[mid]);
			if (list[mid] == element) {
				return mid;
			} else if (list[mid] < element) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void interpolationSearchTrial() {

		int sortedList[] = new int[] { 10, 30, 40, 50, 60, 80, 90, 100, 110, 120, 130, 140, 160, 180 };

		System.out.println("\nElement index: " + interpolationSearch(sortedList, 80));
		System.out.println("\nElement index: " + interpolationSearch(sortedList, 90));
		System.out.println("\nElement index: " + interpolationSearch(sortedList, 130));
		System.out.println("\nElement index: " + interpolationSearch(sortedList, 122));
	}

	public static void jumpSearchTrial() {

		String sortedList[] = new String[] { "Alex", "Ben", "Carl", "Dora", "Elise", "Fiona", "Gerald", "Harry",
				"Irene", "Jeff", "Kris", "Lewis", "Mary", "Nora", "Ophelia", "Peter" };

		int jumpLength = 6;
		System.out.println("\nElement index: " + jumpSearch(sortedList, "Gerald", jumpLength));
		System.out.println("\nElement index: " + jumpSearch(sortedList, "Mary", jumpLength));
		System.out.println("\nElement index: " + jumpSearch(sortedList, "Ophelia", jumpLength));
		System.out.println("\nElement index: " + jumpSearch(sortedList, "Zoe", jumpLength));
	}

	public static void binarySearchTrial() {
		String sortedList[] = new String[] { "Alex", "Ben", "Carl", "Dora", "Elise", "Fiona", "Gerald", "Harry",
				"Irene", "Jeff", "Kris", "Lewis", "Mary", "Nora", "Ophelia", "Peter" };

		System.out.println("\nElement index: " + binarySearch(sortedList, "Harry"));
		System.out.println("\nElement index: " + binarySearch(sortedList, "Jeff"));
		System.out.println("\nElement index: " + binarySearch(sortedList, "Nora"));
		System.out.println("\nElement index: " + binarySearch(sortedList, "Zoe"));
	}

	public static void linearSerachTrial() {
		String unsortedList[] = new String[] { "Alex", "Dora", "Carl", "Ben", "Ophelia", "Elise", "Fiona", "Gerald",
				"Harry", "Peter", "Irene", "Jeff", "Kris", "Lewis", "Mary", "Nora" };

		System.out.println("\nElement index: " + linearSearch(unsortedList, "Harry"));
		System.out.println("\nElement index: " + linearSearch(unsortedList, "Jeff"));
		System.out.println("\nElement index: " + linearSearch(unsortedList, "Nora"));
		System.out.println("\nElement index: " + linearSearch(unsortedList, "Zoe"));
	}
}
