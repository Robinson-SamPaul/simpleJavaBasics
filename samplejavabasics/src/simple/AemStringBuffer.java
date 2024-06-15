package simple;

public class AemStringBuffer {
    
	public static void main(String[] args) {

		System.out.println("Refer " + AaoBufferAndBuilder.class);
		
		StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();

        Thread thread1 = new Thread(() -> {
        	for(int i=0; i<1000; i++) {
	            stringBuffer.append("A"); // Synchronized method
	            stringBuilder.append("A"); // Non-synchronized method
        	}
        });
        
        Thread thread2 = new Thread(() -> {
        	for(int i=0; i<1000; i++) {
	            stringBuffer.append("B"); // Synchronized method
	            stringBuilder.append("B"); // Non-synchronized method
        	}
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("StringBuffer result: \n" + stringBuffer);
        System.out.println("StringBuilder result: \n" + stringBuilder);
        System.out.println();

        System.out.println("StringBuffer length: " + stringBuffer.length());
        System.out.println("StringBuilder length: " + stringBuilder.length());
        System.out.println();
        
        for(int i=0; i<1000; i++) {
        	if(stringBuilder.charAt(i) != 'A' && stringBuilder.charAt(i) != 'B') {
        		System.out.println("H" + stringBuilder.charAt(i) + "i");
        		break;
        	}
        }
        System.out.println();

        System.out.println("StringBuffer result: " + stringBuffer.indexOf(" "));
        System.out.println("StringBuilder result: " + stringBuilder.indexOf(" "));
        
        /*
         * The ASCII value 0 (zero) corresponds to the NULL character, not to the character '0'. 
         * The NULL character has an ASCII value of 0. 
         * It is a control character often used to terminate strings in C-style languages 
         * but doesn't have a visual representation like other printable characters.
         */
        
        int asciiValue = 0; // ASCII value for NULL character
        char character = (char) asciiValue; // Cast ASCII value to char
        System.out.println("ASCII value: " + asciiValue);
        System.out.println("Character: " + character); // Output may vary, might not be visible
    }
}
