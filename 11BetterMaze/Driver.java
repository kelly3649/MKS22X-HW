public class Driver{
    public static void main(String[]args){
	BetterMaze b1 = new BetterMaze("data1.dat");
	BetterMaze b2 = new BetterMaze("data2.dat");
	//System.out.println(b1.getSRSC());
	b2.setAnimate(true);
	System.out.println(b2.solveDFS());
	//System.out.println(b1.solveDFS());
	System.out.println("FINISHEd");
    }
}
