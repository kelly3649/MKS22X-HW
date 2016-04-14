public class Driver{
    public static void main(String[]args){
	BetterMaze b1 = new BetterMaze("data1.dat");
	BetterMaze b2 = new BetterMaze("data2.dat");
	BetterMaze b3 = new BetterMaze("data3.dat");
	BetterMaze b4 = new BetterMaze("data4.dat");
	//System.out.println(b1.getSRSC());
	//b2.setAnimate(true);
	//System.out.println(b2.solveDFS());
	//System.out.println(b3.solveDFS());
	//System.out.println(b4.solveDFS());
	//System.out.println(b1.solveBFS());
	System.out.println(b2.solveBFS());
	//System.out.println(b3.solveBFS());
	//System.out.println(b4.solveBFS());
	System.out.println("FINISHEd");
    }
}
