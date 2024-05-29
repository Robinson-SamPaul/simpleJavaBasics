package simple;
  
import java.util.Iterator;  
import java.util.ArrayList;  
  
  
//creating FailFastIterator2.java class   
public class Main {  
      
    //main() method starts  
    public static void main(String[] args)   
    {  
        //creating ArrayList  
        ArrayList<String> students = new ArrayList<String>();   
        students.add("Emma");   
        students.add("Paul");   
        students.add("Walker");  
        students.add("Elanie");  
        students.add("Amara");  
          
          
        //creating an instance of the Iterator class  
        Iterator<String> itr = students.iterator();  
         
        try {
        //iterating ArrayList using Iterator   
        while (itr.hasNext()) {
    		System.out.println("kq sc");
        	String a = itr.next();
            if (a.equals("Paul")) { 
            	try {
            		students.remove("Amara");
            	} catch (Exception e) {
            		System.out.println("kn cs");
            		System.out.println(e);
				}
            }
        }  
        }catch (Exception e) {
			// TODO: handle exception
		}
          
        System.out.println(students);  
          
        itr = students.iterator();   
          
        //iterating ArrayList using Iterator   
        while (itr.hasNext()) {  
//            if ((String)itr.next() == "Walker")   
//                // It will throw an exception on next call of next() method  
//                students.remove("Walker");  
        }  
    }   
}  