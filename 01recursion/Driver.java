public class Driver{
    public static void main(String[]args){
	Recursion r1 = new Recursion();
       	System.out.println(r1.sqrt(1.0));
	System.out.println(r1.sqrt(2.0));
	System.out.println(r1.sqrt(100.0));
	System.out.println(r1.sqrt(0.0000001));
	System.out.println("Start:" + r1.name());
	try{System.out.println(r1.sqrt(-1.0));
	}catch(IllegalArgumentException e){
	    System.out.println("oops! Argument cannot be negative!");
	}
    }
}
	
