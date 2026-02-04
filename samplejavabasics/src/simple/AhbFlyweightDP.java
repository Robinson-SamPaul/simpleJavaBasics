package simple;

import java.util.HashMap;

public class AhbFlyweightDP {

	public static void main(String[] args) {
		Aletter obj1 = (Aletter) CharLetterFactory.getChar("Apple");
		System.out.println(obj1 + " " + obj1.hashCode());
		Aletter obj2 = (Aletter) CharLetterFactory.getChar("Apple");
		System.out.println(obj2 + " " + obj2.hashCode());
		Aletter obj3 = (Aletter) CharLetterFactory.getChar("Banana");
		System.out.println(obj3 + " " + obj3.hashCode());
	}
}

interface CharLetter {
	void display();
}
class Aletter implements CharLetter {
	
	private String word;
	
	public Aletter(String words) {
		this.word = words;
	}

	@Override
	public void display() {
		System.out.println("A for " + word);	
	}

	@Override
	public String toString() {
		return word;	
	}
}
class CharLetterFactory {
	private static final HashMap<String, CharLetter> charMap = new HashMap<>();

    public static CharLetter getChar(String character) {
        CharLetter letterObj = charMap.get(character);

        if(letterObj == null) {
           letterObj = new Aletter(character);
           charMap.put(character, letterObj);
        }
        return letterObj;
    }
}
