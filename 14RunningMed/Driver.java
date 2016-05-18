public class Driver{
    public static void main(String[]args){
	RunningMedian r1 = new RunningMedian();
	r1.add(3);
	System.out.println(r1.getMedian());
        r1.add(5);
	System.out.println(r1.getMedian());
	r1.add(6);
System.out.println(r1.getMedian());
    }
}
