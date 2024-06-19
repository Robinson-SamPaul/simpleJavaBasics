package simple;

import simple.OuterClazz.StaticNestedClass;

class OuterClazz {
    private int outerField = 10;

    // Static nested class
    static class StaticNestedClass {
        private int nestedField;

        public StaticNestedClass(int nestedField) {
            this.nestedField = nestedField;
        }

        public void printNestedField() {
            System.out.println("Nested field: " + nestedField);
            // Can't access outerField because it's a static nested class
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating an instance of the static nested class
        StaticNestedClass nestedInstance = new StaticNestedClass(5);
        nestedInstance.printNestedField();
        System.out.println(OuterClass.class);
    }
}
