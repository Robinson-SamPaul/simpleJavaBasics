package simple;

public class Main2 {

    public static void main(String[] args) throws Exception {
        
    	System.out.println(fn_toLong(""));
    }
    
    public static Long fn_toLong(Object o1) throws Exception {
        if (o1 == null) return null;
        String value = String.valueOf(o1).trim().toLowerCase();
        System.out.println("Value = " + value + ".");
        if (!(value.isEmpty()) && !("null".equals(value))) {
                    return Long.parseLong(value);
            }
            return null;
    }

}
