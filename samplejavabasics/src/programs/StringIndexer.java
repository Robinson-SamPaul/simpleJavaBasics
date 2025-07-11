package programs;

public class StringIndexer {
    public static int getIndex(String input) {
        if (input == null || input.length() != 3) {
            throw new IllegalArgumentException("Input must be a string of length 3");
        }

        int index = 0;

        // Calculate the index based on the pattern
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            index = index * 26 + (c - 'a');
        }

        return index + 1;
    }
    
    public static void printStringsUpTo(String input) {
        if (input == null || input.length() != 3) {
            throw new IllegalArgumentException("Input must be a string of length 3");
        }

        int index = 0;

        // Loop through all strings up to the input string
        while (true) {
            String currentString = getStringFromIndex(index);
            if (currentString.equals(input)) {
                System.out.println(index + " " + currentString);
                break;
            }
            System.out.println(index + " " + currentString);
            index++;
        }
    }

    private static String getStringFromIndex(int index) {
        StringBuilder sb = new StringBuilder();
        while (index > 0) {
            sb.insert(0, (char) ('a' + index % 26));
            index /= 26;
        }
        while (sb.length() < 3) {
            sb.insert(0, 'a');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getIndex("aiz") + " " + getIndex("afa"));
        // printStringsUpTo("ael");
    }
}